package com.hotel.services;

import java.util.List;
import java.util.Optional;

import com.hotel.entities.Hotel;

public interface HotelService {

    //create hotel
    Hotel postHotel(Hotel hotel);

    //get hotel
    Optional<Hotel> getHotwl(long hotelId);

    //get all hotel
    List<Hotel> getAllHotel();
    
}
