package com.Rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String>{

    List<Rating> findByUserId(long userId);
    List<Rating> findByHotelId(long hotelId);

    
}
