package com.example.kursaaach.service;



import com.example.kursaaach.model.Task;

import java.util.List;

public interface TaskService {
    Task getTask(Long id);
    List<Task> getTasks();
    void addTask(Task task);
    void deleteTask(Long id);
    void updateTask(Task task);

}
