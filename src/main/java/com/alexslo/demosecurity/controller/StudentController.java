package com.alexslo.demosecurity.controller;

import com.alexslo.demosecurity.student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  private static final List<Student> STUDENTS;

  static {
    STUDENTS = StudentsInitUtil.initStudents();
  }

  @GetMapping(path = "{studentId}")
  public ResponseEntity<Student> getStudent(@PathVariable Integer studentId) {
    Student result = STUDENTS.stream()
        .filter(student -> student.getStudentId().equals(studentId))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {
    return new ResponseEntity<>(STUDENTS, HttpStatus.OK);
  }
}
