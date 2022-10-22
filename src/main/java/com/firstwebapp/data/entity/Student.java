package com.firstwebapp.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "student")
public class Student {

    @Id
@Column(name = "student_id")
    private Integer id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_surname")
    private String surname;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "course_id"))
   private List<Course> courses;

}
