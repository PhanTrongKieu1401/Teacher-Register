package com.example.Teacher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="classroom")
@AllArgsConstructor
@NoArgsConstructor
public class classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "capacity")
    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List <Schedule> schedules;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private building building;
}
