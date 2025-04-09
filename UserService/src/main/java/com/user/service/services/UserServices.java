package com.user.service.services;

import java.util.List;
import java.util.Optional;

import com.user.service.entities.User;

public interface UserServices {
    User saveUser(User user);

    List<User> getAllUser();

    Optional<User> getUser(long id);
    
}
