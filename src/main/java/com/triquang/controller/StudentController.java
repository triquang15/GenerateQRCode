package com.triquang.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.triquang.model.Student;
import com.triquang.service.StudentService;
import com.triquang.utils.QRCodeGenerator;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() throws WriterException, IOException {
		List<Student> students = studentService.getStudents();
		if (students.size() != 0) {
			for (Student student : students) {
				QRCodeGenerator.generateQRCode(student);
			}
		}
		return ResponseEntity.ok(studentService.getStudents());
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/{id}")
	public Student findById(@PathVariable Long id) {
		return studentService.findById(id);
	}
}
