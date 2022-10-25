package com.webapp.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
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
    @Positive(message = "Musbet eded daxil edin")
    @NotNull(message = "Id bos ola bilmez")
    private Integer id;

    @Column(name = "student_name")
    @Size(min = 3,max = 30,message = "Ad minimim 3 max 30 simvol ola biler")
    @NotBlank(message = "Ad bos ola bilmez")
    private String name;

    @Size(min = 5,max = 30,message = "Soyad minimim 5 max 30 simvol ola biler")
    @NotBlank(message = "Soyad bos ola bilmez")
    @Column(name = "student_surname")
    private String surname;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

}
