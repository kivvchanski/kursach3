package com.example.kursaaach.repository;

import com.example.kursaaach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByEmail(String email);
    User findUserByEmail(String email);
    User findUserById(Long id);
}
