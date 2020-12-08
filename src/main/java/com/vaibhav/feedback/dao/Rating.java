package com.vaibhav.feedback.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private long itemId;
    private long totalRating;
    private long fiveRatings;
    private long fourRatings;
    private long threeRatings;
    private long twoRatings;
    private long oneRatings;
    private float averageRating;
}
