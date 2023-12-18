package com.ijse.demo.service;

import com.ijse.demo.dto.UserPasswordDto;
import com.ijse.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
    User changePassword(Long id, UserPasswordDto userPasswordDto);
}
