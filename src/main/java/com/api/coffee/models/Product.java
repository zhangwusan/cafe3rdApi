package com.api.coffee.models;

import java.time.LocalDateTime;
import java.util.HashSet;

import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Double price;
    private Double discount;
    private boolean available;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private Set<User> users = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createTimeProduct;
    @UpdateTimestamp
    private LocalDateTime updateTimeProduct;
}
