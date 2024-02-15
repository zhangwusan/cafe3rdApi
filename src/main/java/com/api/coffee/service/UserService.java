package com.api.coffee.service;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.stereotype.Service;

import com.api.coffee.models.Product;
import com.api.coffee.models.User;

import lombok.NonNull;

@Service
public interface UserService {
    List<User> getAllDataUsers();
    User getUserById(Long id);

    User setDataUser(User user);

    User updateUserById(Long id, User user);

    String deleteUserById(Long id);

    List<User> findUserByRole(Role role);
    List<User> findUsersByEmail(String name);

    User insertProductToUser(@NonNull Long id, Product product);

    User removeProductFromUser(@NonNull Long id, Long productID);
    User insertAllProduct (@NonNull Long id, List<Product> products);
}
