package com.example.basicjpademo.dao;

import java.util.List;

import com.example.basicjpademo.entity.Student;

public interface StudentDAO {
	
	void save(Student student);

	Student retrieveStudent(int id);

	List<Student> findAll();

	void update(Student student1);

	void deleteStudent(int studentId);
}
