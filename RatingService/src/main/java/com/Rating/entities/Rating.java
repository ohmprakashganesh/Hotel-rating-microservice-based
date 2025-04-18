package com.Rating.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("user_ratings")
public class Rating {
    @Id
    private String ratingId;
    private long userId;
    private long hotelId;
    private int rating;
    private String feedback;
    
    
}
