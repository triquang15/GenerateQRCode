package com.triquang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triquang.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
