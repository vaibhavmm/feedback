package com.vaibhav.feedback.repo;

import com.vaibhav.feedback.model.ProductWiseRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<ProductWiseRating, Long> {

    List<ProductWiseRating> findByItemIdAndUserId(long itemId, long userId);

    @Transactional
    void deleteByItemIdAndUserId(long itemId, long userId);

    @Query("select AVG(rating) from ProductWiseRating p where p.itemId = ?1")
    long findAverageRating(long itemId);

    @Query("select count(*) from ProductWiseRating p where p.itemId = ?1 and p.rating = ?2")
    long findCountOfRating(long itemId, int rating);

    @Query("select count(*) from ProductWiseRating p where p.itemId = ?1")
    long findCountTotalRating(long itemId);


}
