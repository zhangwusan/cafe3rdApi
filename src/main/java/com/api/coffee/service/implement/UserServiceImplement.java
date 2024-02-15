package com.api.coffee.service.implement;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.coffee.models.Product;
import com.api.coffee.models.User;
import com.api.coffee.repository.UserRepository;
import com.api.coffee.service.ProductService;
import com.api.coffee.service.UserService;

import lombok.NonNull;

@Component
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;


    public List<User> getAllDataUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(@NonNull Long id) {
        return userRepository.findById(id).get();
    }
    
    public List<User> findUserByRole(Role role) {
        return userRepository.findByRole(role);
    }

    public List<User> findUsersByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }




    public User setDataUser(@NonNull User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(@NonNull Long id, User user) {
        User userExist = userRepository.findById(id).get();
        userExist.setFirstName(user.getFirstName());
        userExist.setLastName(user.getLastName());
        userExist.setEmail(user.getEmail());
        userExist.setPassword(user.getPassword());
        return userRepository.save(userExist);
    }

    @Override
    public String deleteUserById(@NonNull Long id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    public User insertProductToUser(@NonNull Long id, Product product){
        User userExist = userRepository.findById(id).get();
        Long productId = product.getId();
        if (productId == null){
            product = productService.createProduct(product);
        }else{
            product = productService.updateProduct(productId, product);
        }
        userExist.addProduct(product);
        return userRepository.save(userExist);
    }

    public User removeProductFromUser(@NonNull Long id, Long productId){
        User userExist = userRepository.findById(id).get();
        Product product = productService.getProductById(productId);
        userExist.removeProduct(product);
        return userRepository.save(userExist);
    }

    @SuppressWarnings("unchecked")
    public User insertAllProduct (@NonNull Long id, List<Product> products){
        User userExist = userRepository.findById(id).get();
        userExist.setProducts((java.util.Set<Product>) products);
        return userRepository.save(userExist);
    }

   

}
