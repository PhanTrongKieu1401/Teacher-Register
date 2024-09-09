package com.example.Teacher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="day")
@AllArgsConstructor
@NoArgsConstructor
public class day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "day")
    private List<Schedule> schedules;
}
