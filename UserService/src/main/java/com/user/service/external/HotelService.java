package com.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotel/single/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") long hotelId);


    
}
