package com.api.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.coffee.models.Product;
import com.api.coffee.models.User;
import com.api.coffee.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllDataUsers();
    }
    @GetMapping("{email}")
    public List<User> getUserByEmail(@PathVariable String email) {
        return userService.findUsersByEmail(email);
    }
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    

    @PostMapping
    public ResponseEntity<User> setUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.setDataUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserById(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @PostMapping("/{id}/product")
    public ResponseEntity<User> insertProductToUser(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(userService.insertProductToUser(id, product));
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<User> insertAllProduct (@PathVariable Long id, @RequestBody List<Product> products) {
        return ResponseEntity.ok(userService.insertAllProduct(id, products));
    }
    @DeleteMapping("/{id}/product/{productId}")
    public ResponseEntity<User> removeProductFromUser(@PathVariable Long id, @PathVariable Long productId) {
        return ResponseEntity.ok(userService.removeProductFromUser(id, productId));
    }


    

    @GetMapping("/test")
    public String getTest() {
        return "testing";
    }
}
