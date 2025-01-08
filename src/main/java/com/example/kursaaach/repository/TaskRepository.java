package com.example.kursaaach.repository;

import com.example.kursaaach.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteById(Long id);
}
