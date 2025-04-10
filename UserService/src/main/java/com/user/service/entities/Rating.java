package com.user.service.entities;

import lombok.Data;

@Data
public class Rating {
    private String ratingId;
    private long userId;
    private long hotelId;
    private int rating;
    private  String feedback;
    
    private Hotel hotel;


}
