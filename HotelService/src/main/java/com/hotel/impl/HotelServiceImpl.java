package com.hotel.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.repository.HotelRepository;
import com.hotel.services.HotelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel postHotel(Hotel hotel) {
       return hotelRepository.save(hotel);



    }

    @Override
    public Optional<Hotel> getHotwl(long hotelId) {
        return hotelRepository.findById(hotelId);

    }

    @Override
    public List<Hotel> getAllHotel() {
     return hotelRepository.findAll();
    }
    
}
