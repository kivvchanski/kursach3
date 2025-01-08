package com.example.kursaaach.controller;

import com.example.kursaaach.model.User;
import com.example.kursaaach.service.Session;
import com.example.kursaaach.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/save_user")
    public String saveUser(@RequestBody User user) {
        service.saveUser(user);
        return "User successfully saved";
    }
    @GetMapping()
    public List<User> getUsers() {
            List<User> allUsers = service.findAllUser();
            return allUsers;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String role, HttpSession httpSession) {
        Session session = new Session(username, role);
        httpSession.setAttribute("session", session);
        return "User logged in: " + username + " with role: " + role;
    }

    @GetMapping("/profile")
    public User getProfile(HttpSession httpSession) {
        Session session = (Session) httpSession.getAttribute("session");
        if (session == null || !session.isAuthenticated()) {
            throw new IllegalStateException("No active session or user not authenticated.");
        }
        String username = session.getUsername();
        User user = service.findByEmail(username);
        if (user == null) {
            throw new IllegalStateException("User not found.");
        }

        return user;
    }
    @GetMapping("/viewProfile/{id}")
    public User getProfile(@PathVariable Long id) {
        User user = service.findByID(id);
        if (user.getDateOfBirth() == null) {user.setDateOfBirth(LocalDate.parse("2000-01-01"));}
        if (user.getFirstName() == null) {user.setFirstName("Unknown");}
        if (user.getLastName() == null) {user.setLastName("Unknown");}
        return user;


    }
    @GetMapping("/viewEProfile/{email}")
    public Long getEProfile(@PathVariable String email) {
        User user = service.findByEmail(email);
        if (user.getDateOfBirth() == null) {
            user.setDateOfBirth(LocalDate.parse("2000-01-01"));
        }
        if (user.getFirstName() == null) {
            user.setFirstName("Unknown");
        }
        if (user.getLastName() == null) {
            user.setLastName("Unknown");
        }
        return user.getId();
    }
    @PostMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "User logged out.";
    }
}
