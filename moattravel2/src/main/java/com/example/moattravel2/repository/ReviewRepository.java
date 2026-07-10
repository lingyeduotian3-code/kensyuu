package com.example.moattravel2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.moattravel2.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Page<Review> findByHouseIdOrderByCreatedAtDesc(
            Integer houseId,
            Pageable pageable);

    boolean existsByHouseIdAndUserId(
            Integer houseId,
            Integer userId);

    long countByHouseId(Integer houseId);

    @Query("""
        SELECT AVG(review.score)
        FROM Review review
        WHERE review.house.id = :houseId
        """)
    Double findAverageScoreByHouseId(
            @Param("houseId") Integer houseId);
}