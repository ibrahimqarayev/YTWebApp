package com.webapp.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "course")
public class Course {

    @Id
@Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_description")
    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;


}
