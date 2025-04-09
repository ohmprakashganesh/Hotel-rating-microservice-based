package com.user.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserServices;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserServices userServices;

     @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody User user)
{
   
    User saved= userServices.saveUser(user);
   return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}    

@GetMapping("/get/{userId}")
public ResponseEntity<Optional< User>> getUser(@PathVariable long userId){
    return ResponseEntity.ok(userServices.getUser(userId));

}

@GetMapping("/all")
public ResponseEntity<List<User>> allUser(){
    return ResponseEntity.ok(userServices.getAllUser());
}
}
