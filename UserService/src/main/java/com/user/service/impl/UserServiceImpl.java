package com.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.service.UserRepository.UserRepository;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.services.UserServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserServices{

    private final UserRepository userRepository;

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
           return Optional.of(opt.get());
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }
    
  }
    

