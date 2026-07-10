package com.example.moattravel2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moattravel2.entity.House;
import com.example.moattravel2.entity.Review;
import com.example.moattravel2.form.ReservationInputForm;
import com.example.moattravel2.form.ReviewForm;
import com.example.moattravel2.repository.HouseRepository;
import com.example.moattravel2.repository.ReviewRepository;

@Controller
@RequestMapping("/houses")
public class HouseController {

    private final HouseRepository houseRepository;
    private final ReviewRepository reviewRepository;

    public HouseController(
            HouseRepository houseRepository,
            ReviewRepository reviewRepository) {

        this.houseRepository = houseRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public String index(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "area", required = false) String area,
            @RequestParam(name = "price", required = false) Integer price,
            @RequestParam(name = "order", required = false) String order,
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Direction.ASC) Pageable pageable,
            Model model) {

        Page<House> housePage;

        if (keyword != null && !keyword.isEmpty()) {
            if ("priceAsc".equals(order)) {
                housePage =
                        houseRepository.findByNameLikeOrAddressLikeOrderByPriceAsc(
                                "%" + keyword + "%",
                                "%" + keyword + "%",
                                pageable);
            } else {
                housePage =
                        houseRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc(
                                "%" + keyword + "%",
                                "%" + keyword + "%",
                                pageable);
            }
        } else if (area != null && !area.isEmpty()) {
            if ("priceAsc".equals(order)) {
                housePage =
                        houseRepository.findByAddressLikeOrderByPriceAsc(
                                "%" + area + "%",
                                pageable);
            } else {
                housePage =
                        houseRepository.findByAddressLikeOrderByCreatedAtDesc(
                                "%" + area + "%",
                                pageable);
            }
        } else if (price != null) {
            if ("priceAsc".equals(order)) {
                housePage =
                        houseRepository.findByPriceLessThanEqualOrderByPriceAsc(
                                price,
                                pageable);
            } else {
                housePage =
                        houseRepository.findByPriceLessThanEqualOrderByCreatedAtDesc(
                                price,
                                pageable);
            }
        } else {
            if ("priceAsc".equals(order)) {
                housePage =
                        houseRepository.findAllByOrderByPriceAsc(pageable);
            } else {
                housePage =
                        houseRepository.findAllByOrderByCreatedAtDesc(pageable);
            }
        }
        Map<Integer, Double> averageScoreMap = new HashMap<>();
        Map<Integer, Long> reviewCountMap = new HashMap<>();

        for (House house : housePage.getContent()) {
            Double averageScore =
                    reviewRepository.findAverageScoreByHouseId(house.getId());

            if (averageScore == null) {
                averageScore = 0.0;
            }

            long reviewCount =
                    reviewRepository.countByHouseId(house.getId());

            averageScoreMap.put(house.getId(), averageScore);
            reviewCountMap.put(house.getId(), reviewCount);
        }

        model.addAttribute("averageScoreMap", averageScoreMap);
        model.addAttribute("reviewCountMap", reviewCountMap);
        model.addAttribute("housePage", housePage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("area", area);
        model.addAttribute("price", price);
        model.addAttribute("order", order);

        return "houses/index";
    }

    @GetMapping("/{id}")
    public String show(
            @PathVariable(name = "id") Integer id,
            @PageableDefault(page = 0, size = 5) Pageable pageable,
            Model model) {

        House house =
                houseRepository.getReferenceById(id);

        Page<Review> reviewPage =
                reviewRepository.findByHouseIdOrderByCreatedAtDesc(
                        id,
                        pageable);

        Double averageScore =
                reviewRepository.findAverageScoreByHouseId(id);

        if (averageScore == null) {
            averageScore = 0.0;
        }

        long reviewCount =
                reviewRepository.countByHouseId(id);

        model.addAttribute("house", house);
        model.addAttribute(
                "reservationInputForm",
                new ReservationInputForm());

        model.addAttribute("reviewPage", reviewPage);
        model.addAttribute("averageScore", averageScore);
        model.addAttribute(
                "roundedAverageScore",
                Math.round(averageScore));

        model.addAttribute("reviewCount", reviewCount);

        if (!model.containsAttribute("reviewForm")) {
            model.addAttribute(
                    "reviewForm",
                    new ReviewForm());
        }

        return "houses/show";
    }
}