package com.example.kursaaach.controller;

import com.example.kursaaach.model.Task;
import com.example.kursaaach.model.User;
import com.example.kursaaach.service.Session;
import com.example.kursaaach.service.SessionManager;
import com.example.kursaaach.service.TaskService;
import com.example.kursaaach.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/userTasks")
    public List<Task> getTaskByUserTask(HttpSession httpSession) {
        List<Task> alltasks = taskService.getTasks();
        List<Task> mytasks = new ArrayList<Task>();
        Session session = (Session) httpSession.getAttribute("session");
        User curUser = userService.findByEmail(session.getUsername());
        for (Task task : alltasks) {
            if (task.getE_Boss() == null) {
                task.setE_Boss("Unknown user");
            }
            if (task.getE_Worker() == null) {
                continue;
            }
            if (task.getE_Boss().equals(curUser.getEmail()) || task.getE_Worker().equals(curUser.getEmail())) {
                mytasks.add(task);
            }
        }
        return mytasks;
    }


    @PostMapping
    public String addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return "Task successfully added.";
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.getTask(id);
        if (existingTask == null) {
            return "Task not found.";
        }
        task.setId(id);
        taskService.updateTask(task);
        return "Task successfully updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task existingTask = taskService.getTask(id);
        if (existingTask == null) {
            return "Task not found.";
        }
        taskService.deleteTask(id);
        return "Task successfully deleted.";
    }

    @GetMapping("/available")
    public List<Task> getAvailableTasks() {
        return taskService.getTasks().stream()
                .filter(task -> task.getE_Worker() == null)
                .toList();
    }

    @PutMapping("/take/{id}")
    public String takeTask(@PathVariable Long id, HttpSession session) {
        Session userSession = (Session) session.getAttribute("session");

        if (userSession == null || !userSession.isAuthenticated()) {
            return "You need to be logged in to take a task.";
        }

        Task existingTask = taskService.getTask(id);
        if (existingTask == null || existingTask.getE_Worker() != null) {
            return "Task not available or already taken.";
        }

        User curUser = userService.findByEmail(userSession.getUsername());
        existingTask.setE_Worker(curUser.getEmail());
        taskService.updateTask(existingTask);

        return "Task successfully taken by " + curUser.getEmail();
    }

    @PutMapping("/discard/{id}")
    public String discardTask(@PathVariable Long id, HttpSession session) {
        Session userSession = (Session) session.getAttribute("session");
        if (userSession == null || !userSession.isAuthenticated()) {
            return "You need to be logged in to discard task.";
        }
        Task existingTask = taskService.getTask(id);
        if (existingTask == null || existingTask.getE_Worker() == null) {
            return "Task not available or already discarded task.";
        }
        existingTask.setE_Worker(null);
        taskService.updateTask(existingTask);
        return "Task successfully discarded task.";
    }
}
