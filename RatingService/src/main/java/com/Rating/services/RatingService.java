package com.Rating.services;

import java.util.List;

import com.Rating.entities.Rating;

public interface RatingService {

    //create rating
    Rating postRating(Rating rating);

    //get rating
     List< Rating> getAllRating();

    //get all by user
     List<Rating> getAllRatingByUser(long userId);

    //get all by hotel
    List<Rating> getAllRatingByHotel(long hotelId);
    
}
