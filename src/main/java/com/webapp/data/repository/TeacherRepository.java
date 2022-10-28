package com.webapp.data.repository;

import com.webapp.data.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Integer> {
}
