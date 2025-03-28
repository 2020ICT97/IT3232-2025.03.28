package me.neranjana.spring.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.neranjana.spring.app.model.Student;


@RestController
@RequestMapping("/students")
public class StudentController {
    Student st1 = new Student("2020ICT97", "Neranjana", 24, "IT", 3.40);
    Student st2 = new Student("2020ICT65", "Chamodi", 23, "IT", 3.72);
    Student st3 = new Student("2020ICT24", "Piumal", 26, "IT", 2.86);

    private static List<Student> students = new ArrayList<Student>();

    StudentController(){
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }

    @GetMapping("/")
    public List<Student> getStudent() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getMethodName(@PathVariable("id") String id) {
        for(Student student : students){
            if(student.getRegNo().equals(id)){
                return student;
            }
        }

        return null;
    }
    
}
