package com.wartinder.user.service;

import com.wartinder.user.entity.User;
import com.wartinder.user.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);

    }
    public List<User> listUser() {
       return userRepository.findAll();
    }
}
