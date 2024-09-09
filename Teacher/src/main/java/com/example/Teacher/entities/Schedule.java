package com.example.Teacher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "sectionclass_id")
    private SectionClass sectionClass;

    @ManyToOne
    @JoinColumn(name ="period_id")
    private Period period;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private day day;

    @ManyToOne
    @JoinColumn(name = "week_id")
    private Week week;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private  classroom classroom;
}
