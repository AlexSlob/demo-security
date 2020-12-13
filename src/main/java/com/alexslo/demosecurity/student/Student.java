package com.alexslo.demosecurity.student;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Student {
  private final Integer studentId;
  private final String studentName;
}
