package com.webapp.controller;

import com.webapp.data.entity.Course;
import com.webapp.data.entity.Student;
import com.webapp.data.repository.CourseRepository;
import com.webapp.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping(value = "/student")
public class WebController {

    @Autowired //dependency injection
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    //http://localhost:8080/student/index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //http://localhost:8080/student/list
    @GetMapping("/list")
    public String getAllStudent(Model model) {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list";
    }

    //http://localhost:8080/student/new
    @GetMapping("/new")
    public String newPage(Model model) {
        model.addAttribute("student", new Student());
       Iterable<Course> courses= courseRepository.findAll();
       model.addAttribute("allCourses",courses);
        return "add";
    }

    //http://localhost:8080/student/save
    @PostMapping("/save")
    public String addStudent(Student student, Model model) {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        studentRepository.save(student);
        return "list";
    }

    @GetMapping("/update")
    public String goToUpdate(Model model, @RequestParam Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            model.addAttribute("student", student);
        }

        Iterable<Course> courses= courseRepository.findAll();
        model.addAttribute("allCourses",courses);

        return "update";
    }

    @GetMapping("/delete")
    public String goToDelete(Model model, @RequestParam Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            model.addAttribute("student", student);
        }

        Iterable<Course> courses= courseRepository.findAll();
        model.addAttribute("allCourses",courses);


        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Model model, Student student) {
        studentRepository.delete(student);
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list";
    }

}
