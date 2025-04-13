package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    //save hotel

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.postHotel(hotel));
    }

    //get hotel
    @GetMapping("/single/{hotelId}")
    public ResponseEntity<Optional<Hotel>> getHotel(@PathVariable long hotelId){
        return ResponseEntity.ok(hotelService.getHotwl(hotelId));
    }


    //get all hotel
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getHotels(){
        return ResponseEntity.ok(hotelService.getAllHotel());

    }
    
}
