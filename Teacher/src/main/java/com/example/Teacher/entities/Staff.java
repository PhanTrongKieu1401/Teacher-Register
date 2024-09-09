package com.example.Teacher.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Staff {
    @Id
    private int idMenber;

    @Column(name = "posittion")
    private String position;

    @OneToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "member_id", nullable = false )
    private Member member;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "staff")
    private Teacher teacher;
}
