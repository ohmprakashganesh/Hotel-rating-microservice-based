package com.Rating.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Rating.entities.Rating;
import com.Rating.repository.RatingRepository;
import com.Rating.services.RatingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{

    private final RatingRepository ratingRepository;

    @Override
    public Rating postRating(Rating rating) {
        return ratingRepository.save(rating);

      
    }

    @Override
    public List<Rating> getAllRating() {
    return ratingRepository.findAll();
   
    }

    @Override
    public List<Rating> getAllRatingByUser(long userId) {
        return ratingRepository.findByUserId(userId);
      }

    @Override
    public List<Rating> getAllRatingByHotel(long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
      }
    
}
