package com.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long userId;

    private String name;
    private String email;
    private String about;
    
    @Transient
    private List<Rating> rating=new ArrayList<>();
    
}
