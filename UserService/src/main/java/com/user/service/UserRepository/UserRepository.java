package com.user.service.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
} 
