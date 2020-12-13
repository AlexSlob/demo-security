package com.alexslo.demosecurity.controller;

import com.alexslo.demosecurity.student.Student;

import java.util.Arrays;
import java.util.List;

public abstract class StudentsInitUtil {

  public static List<Student> initStudents() {
    return Arrays.asList(
        new Student(1, "Jeremy Clarkson"),
        new Student(2, "Richard Hammond"),
        new Student(3, "James May")
    );
  }
}
