package com.example.kursaaach.service;



import com.example.kursaaach.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User saveUser(User user);
    User findByEmail(String email);
    User updateUser(User user);
    void deleteUser(String email);
    User findByID(Long id);
}
