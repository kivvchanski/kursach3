package com.example.kursaaach.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Long price;
    private String e_Boss;
    private String e_Worker;
}
