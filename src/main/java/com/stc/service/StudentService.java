package com.stc.service;

import java.util.List;

import com.stc.dto.Student;

public interface StudentService {
   public Student getStudInfo(Integer id);
   public List<Student> getAllStuds();
   public Student modifyStudent(Student st);
}
