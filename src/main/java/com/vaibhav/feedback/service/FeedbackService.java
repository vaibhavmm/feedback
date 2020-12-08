package com.vaibhav.feedback.service;

import com.vaibhav.feedback.dao.Rating;
import com.vaibhav.feedback.model.ProductWiseRating;
import com.vaibhav.feedback.repo.FeedbackRepository;
import com.vaibhav.feedback.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;
    @Autowired
    private ItemRepository itemRepository;



    public ProductWiseRating addRating(long userid, long itemid, int rating,boolean isUpdate) throws ParseException {

        if(!itemRepository.existsById(itemid)){
            throw new RuntimeException("Item with itemid " +itemid + " not present");
        }else if(!(rating > 0 && rating < 6)) {
            throw new RuntimeException("Invalid Rating " + rating) ;
        }
        if(!repository.findByItemIdAndUserId(itemid,userid).isEmpty()){
            if(isUpdate) {
                repository.deleteByItemIdAndUserId(itemid,userid);
            }else{
                throw new RuntimeException("Rating for item " + itemid + " is already present");
            }
        }else{
            if(isUpdate) throw new RuntimeException("No Rating Available to update");
        }
        return repository.saveAndFlush(new ProductWiseRating(itemid,userid,rating));
    }

    public Rating getRating(long itemid) {
        if(!itemRepository.existsById(itemid)){
            throw new RuntimeException("Item with itemid " +itemid + " not present");
        }else{
            Rating rating = new Rating();
            rating.setItemId(itemid);
            rating.setTotalRating(repository.findCountTotalRating(itemid));
            rating.setFiveRatings(repository.findCountOfRating(itemid,5));
            rating.setFourRatings(repository.findCountOfRating(itemid,4));
            rating.setThreeRatings(repository.findCountOfRating(itemid,3));
            rating.setTwoRatings(repository.findCountOfRating(itemid,2));
            rating.setOneRatings(repository.findCountOfRating(itemid,1));
            rating.setAverageRating(repository.findAverageRating(itemid));

            return rating;
//            System.out.println("Average is " + repository.findAverageRating(itemid));
        }
    }
}
