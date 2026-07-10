package com.example.moattravel2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel2.entity.House;
import com.example.moattravel2.entity.Review;
import com.example.moattravel2.entity.User;
import com.example.moattravel2.form.ReviewForm;
import com.example.moattravel2.repository.HouseRepository;
import com.example.moattravel2.repository.ReviewRepository;
import com.example.moattravel2.repository.UserRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HouseRepository houseRepository;
    private final UserRepository userRepository;

    public ReviewService(
            ReviewRepository reviewRepository,
            HouseRepository houseRepository,
            UserRepository userRepository) {

        this.reviewRepository = reviewRepository;
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void create(
            Integer houseId,
            Integer userId,
            ReviewForm reviewForm) {

        boolean alreadyReviewed =
                reviewRepository.existsByHouseIdAndUserId(
                        houseId,
                        userId);

        if (alreadyReviewed) {
            throw new IllegalStateException(
                    "この民宿にはすでにレビューを投稿しています。");
        }

        House house =
                houseRepository.getReferenceById(houseId);

        User user =
                userRepository.getReferenceById(userId);

        Review review = new Review();

        review.setHouse(house);
        review.setUser(user);
        review.setScore(reviewForm.getScore());
        review.setComment(reviewForm.getComment());

        reviewRepository.save(review);
    }
}
