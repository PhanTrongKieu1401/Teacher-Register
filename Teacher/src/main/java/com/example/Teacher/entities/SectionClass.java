package com.example.Teacher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "sectionclass")
@AllArgsConstructor
@NoArgsConstructor
public class SectionClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "maxcapacity")
    private int maxCapacity;

    @Column(name ="actualcapacity")
    private int actualCapacity;

//    @ManyToOne
//    @JoinColumn(name = "pickedsecionclass_id")
//    private PickedSectionClass pickedSectionClass;

    @OneToOne(mappedBy = "sectionClass")
    private PickedSectionClass pickedSectionClass;


    @ManyToOne
    @JoinColumn(name = "subjectOfSemester_id")
    private SubjectOfSemester subjectOfSemester;

    @JsonIgnore
    @OneToMany(mappedBy = "sectionClass")
    private List<Schedule> schedules;
}
