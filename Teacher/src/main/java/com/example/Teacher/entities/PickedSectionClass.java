package com.example.Teacher.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
@Data
@Entity
@Table(name ="pickedsectionclass")
@AllArgsConstructor
@NoArgsConstructor
public class PickedSectionClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIME)
    @Column(name = "pickedTime")
    private Date pickedTime;

    @Column(name = "isPicked")
    private int isPicked;

    @Column(name = "review")
    private int review;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name="idSectionClass" , referencedColumnName = "id")
    private SectionClass sectionClass;


}
