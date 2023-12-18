package com.ijse.demo.service.impl;

import com.ijse.demo.dto.UserPasswordDto;
import com.ijse.demo.entity.User;
import com.ijse.demo.repository.UserRepository;
import com.ijse.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User changePassword(Long id, UserPasswordDto userPasswordDto) {
        User user = userRepository.findById(id).orElse(null);
        if (user!=null){
            user.setPassword(userPasswordDto.getPassword());
            return userRepository.save(user);
        }
        return null;
    }
}
