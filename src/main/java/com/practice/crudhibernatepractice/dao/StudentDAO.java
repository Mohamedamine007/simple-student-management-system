package com.practice.crudhibernatepractice.dao;

import com.practice.crudhibernatepractice.entity.Student;

import java.util.List;

public interface StudentDAO {

    void add(Student student);
    Student findById(Integer id);
    List<Student> findByLastName(String lastName);
    List<Student> findAll();
    void update(Student student);
    void delete(Integer id);
}
