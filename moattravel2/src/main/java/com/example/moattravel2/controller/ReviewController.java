package com.example.moattravel2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.moattravel2.form.ReviewForm;
import com.example.moattravel2.security.UserDetailsImpl;
import com.example.moattravel2.service.ReviewService;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/houses/{houseId}/reviews/create")
    public String create(
            @PathVariable(name = "houseId") Integer houseId,
            @ModelAttribute @Validated ReviewForm reviewForm,
            BindingResult bindingResult,
            @AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
            RedirectAttributes redirectAttributes) {

        if (userDetailsImpl == null) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.reviewForm",
                    bindingResult);

            redirectAttributes.addFlashAttribute(
                    "reviewForm",
                    reviewForm);

            return "redirect:/houses/" + houseId;
        }

        Integer userId =
                userDetailsImpl.getUser().getId();

        try {
            reviewService.create(
                    houseId,
                    userId,
                    reviewForm);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "レビューを投稿しました。");

        } catch (IllegalStateException exception) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    exception.getMessage());
        }

        return "redirect:/houses/" + houseId;
    }
}