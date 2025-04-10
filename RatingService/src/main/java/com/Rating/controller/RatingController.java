package com.Rating.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Rating.entities.Rating;
import com.Rating.services.RatingService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping("/post")
    public ResponseEntity<Rating> postRating(@RequestBody Rating rating) {
     return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.postRating(rating));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Rating>> allRatings() {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/allByUserId/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable long userId) {
        return ResponseEntity.ok(ratingService.getAllRatingByUser(userId));
    }
    
    @GetMapping("/allByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable long hotelId) {
        return ResponseEntity.ok(ratingService.getAllRatingByUser(hotelId));
    }
    
    
    
}
