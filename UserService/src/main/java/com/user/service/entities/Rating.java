package com.user.service.entities;

import lombok.Data;

@Data
public class Rating {
    private long ratingId;
    private long userId;
    private String hotelId;
    private int rationg;
    private  String feedback;


}
