package com.example.basicjpademo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.basicjpademo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student retrieveStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		List<Student> students = theQuery.getResultList();
		return students;
	}

	@Override
	@Transactional
	public void update(Student student1) {
		entityManager.merge(student1);
	}

	@Override
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		entityManager.remove(student);
	}
	
	

}
