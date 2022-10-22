package com.firstwebapp.data.repository;

import com.firstwebapp.data.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
