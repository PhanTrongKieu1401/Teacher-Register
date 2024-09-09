package com.example.Teacher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
