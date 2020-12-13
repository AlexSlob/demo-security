package com.alexslo.demosecurity.controller.admin;

import com.alexslo.demosecurity.controller.StudentsInitUtil;
import com.alexslo.demosecurity.student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
@RequestMapping("admin/api/v1/students")
public class AdminStudentController {

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

  @PostMapping
  @PreAuthorize("hasAuthority('student::write')")
  public void registerNewStudent(@RequestBody Student student) {
    System.out.println("Registration of student:");
    System.out.println(student);
    System.out.println();
  }

  @DeleteMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student::write')")
  public void deleteStudent(@PathVariable Integer studentId) {
    System.out.println("Deleting student with id: " + studentId);
    System.out.println();
  }

  @PutMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student::write')")
  public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
    System.out.println("Updating student with id: " + studentId + " Student" + student);
    System.out.println();
  }
}
