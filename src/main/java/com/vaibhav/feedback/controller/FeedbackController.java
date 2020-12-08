package com.vaibhav.feedback.controller;

import com.vaibhav.feedback.dao.Rating;
import com.vaibhav.feedback.model.ProductWiseRating;
import com.vaibhav.feedback.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/vaibhav/feedback")
public class FeedbackController {

    public static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);
    private final HttpServletRequest request;

    @Autowired
    private FeedbackService service;


    public FeedbackController(HttpServletRequest request) {
        this.request = request;
    }

    @PostMapping
    public ResponseEntity<ProductWiseRating> addRating(@RequestParam long userid, @RequestParam long itemid, @RequestParam int rating){
        LOGGER.info("AddRating " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")){
            try{
                return new ResponseEntity<ProductWiseRating>(service.addRating(userid, itemid, rating,false), HttpStatus.OK);
            }catch (Exception e){
                LOGGER.error("Couldn't serialize response for content type application/json",e);
                return new ResponseEntity<ProductWiseRating>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ProductWiseRating>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductWiseRating> updateRating(@RequestParam long userid, @RequestParam long itemid, @RequestParam int rating){
        LOGGER.info("AddRating " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")){
            try{
                return new ResponseEntity<ProductWiseRating>(service.addRating(userid, itemid, rating,true), HttpStatus.OK);
            }catch (Exception e){
                LOGGER.error("Couldn't serialize response for content type application/json",e);
                return new ResponseEntity<ProductWiseRating>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ProductWiseRating>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<Rating> getRating(@RequestParam long itemid){
        LOGGER.info("GetRating " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")){
            try{
                return new ResponseEntity<Rating>(service.getRating(itemid), HttpStatus.OK);
            }catch (Exception e){
                LOGGER.error("Couldn't serialize response for content type application/json",e);
                return new ResponseEntity<Rating>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Rating>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
