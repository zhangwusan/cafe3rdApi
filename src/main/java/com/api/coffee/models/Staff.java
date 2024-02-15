package com.api.coffee.models;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staff")
@Setter
@Getter
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String dateOfBirth;
    private String gender;
    private Role role;
    private String timeWork;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    @CreationTimestamp
    private LocalDateTime createTimeProduct;
    @UpdateTimestamp
    private LocalDateTime updateTimeProduct;
}
