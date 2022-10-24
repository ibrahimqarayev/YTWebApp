package com.webapp.data.repository;

import com.webapp.data.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name);

@Query(value = "select * from student where student_surname=?1",nativeQuery = true)
    List<Student> getStudentBySurname(String surname);

}
