package com.triquang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triquang.model.Student;
import com.triquang.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student findById(Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
	}
}
