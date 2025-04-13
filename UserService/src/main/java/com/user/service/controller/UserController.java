package com.user.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/user")
public class UserController {

    private int retryCount=1 ;

    @Autowired
     private  UserServices userServices;

    private static final Logger logger = LoggerFactory.getLogger(UserServices.class);
     @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody User user)
{
    User saved= userServices.saveUser(user);
   return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}    



@GetMapping("/get/{userId}")
// @CircuitBreaker(name = "RATING-HOTEL",fallbackMethod ="ratingHotelFault" )
@Retry(name = "ratingHotel", fallbackMethod = "ratingHotelFault")
public ResponseEntity<Optional< User>> getUser(@PathVariable long userId){
    logger.info("retry cound :{}",retryCount );
    retryCount++;
    return ResponseEntity.ok(userServices.getUser(userId));

}

//fall back method for circuit breaker 
public ResponseEntity<Optional<User>> ratingHotelFault(long userId ,Exception ex) {
    logger.info("Fallback executed for userId: {}", ex.getMessage());
   
    User user = User.builder()
        .email("dummy@gmail.com")
        .name("fault")
        .about("This is an error due to some service down")
        .userId(3434L)
        .build();

    return ResponseEntity.ok(Optional.of(user));
}


@GetMapping("/all")
@RateLimiter(name = "rateLimitter",fallbackMethod = "ratelimiter" )
public ResponseEntity<List<User>> allUser(){
    return ResponseEntity.ok(userServices.getAllUser());
}


public ResponseEntity<List<User>> ratelimiter(Exception ex){
    List<User> list= new ArrayList<>();
    System.out.println(ex.getMessage());
    //this for optional to show if failure occured
    User user = User.builder()
    .email("dummy@gmail.com")
    .name("fault")
    .about("This is an error due to some service down")
    .userId(3434L)
    .build();

    list.add(user);
    return ResponseEntity.ok(list);
}



}
