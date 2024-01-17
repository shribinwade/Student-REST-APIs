package com.student.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ID")
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // not using auto genarated value Giving UUID for security
    private String studentId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

}
