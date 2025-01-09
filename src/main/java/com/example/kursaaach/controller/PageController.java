package com.example.kursaaach.controller;

import com.example.kursaaach.service.Session;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userplace")
public class PageController {
    @GetMapping("/register")
    public String registerPage() {
        return "registerForm";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/tasks")
    public String tasksPage() {return "myTasks";}
    @GetMapping("/available-tasks")
    public String availableTasksPage() {
        return "taskList";
    }
    @GetMapping("/view-profile/{id}")
    public String viewProfilePage(@PathVariable Long id, Model model) {
        Long message = id;
        model.addAttribute("id", message);
        return "viewProfile";
    }
    @GetMapping("/adminPlace")
    public String adminPlacePage() {

        return "adminPage";
    }
}

