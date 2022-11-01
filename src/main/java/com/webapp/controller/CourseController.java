package com.webapp.controller;

import com.webapp.data.entity.Course;
import com.webapp.data.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //http://localhost:8080/student/index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String getAllCourses(Model model) {
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "list";
    }


}
