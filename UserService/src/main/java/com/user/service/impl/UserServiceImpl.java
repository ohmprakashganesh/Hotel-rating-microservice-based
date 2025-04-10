package com.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.UserRepository.UserRepository;
import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.services.UserServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserServices{

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
      return  userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
       
    }

    @Override
    public Optional<User> getUser(long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isPresent()) {
            //fetch rating of the user
            Rating[] forObject  = restTemplate.getForObject("http://localhost:8081/rating/allByUserId/"+id,Rating[] .class);

            List<Rating> ratings= Arrays.stream(forObject).toList();
          

            List<Rating> ratingList=ratings.stream().map(rating->{
                ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://localhost:8082/hotel/single/"+ rating.getHotelId(), Hotel.class);
                Hotel hotel= forEntity.getBody();
                System.out.println(hotel.toString());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

            User user=opt.get();
            user.setRating(ratingList);
           return Optional.ofNullable(user);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }
    
  }
    

