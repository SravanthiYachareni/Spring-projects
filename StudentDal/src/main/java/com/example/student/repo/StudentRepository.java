package com.example.student.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.student.model.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
