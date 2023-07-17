package com.example.basicjpademo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.basicjpademo.dao.StudentDAO;
import com.example.basicjpademo.entity.Student;

@SpringBootApplication
public class BasicJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicJpaDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO jpaDAO) {
		return runner -> {
			insertStudent(jpaDAO);
			readStudent(jpaDAO);
			queryForStudents(jpaDAO);
			updateStudent(jpaDAO);
			deleteStudent(jpaDAO);
		};
	}

	private void insertStudent(StudentDAO jpaDAO) {
		Student student1 = new Student("Vamshi", "Maripudi", "vamshi@fmr.com");
		Student student2 = new Student("Uday", "Paturi", "uday@fmr.com");
		jpaDAO.save(student1);
		jpaDAO.save(student2);
		System.out.println("student saved succesfully");
	}
	
	private void readStudent(StudentDAO jpaDAO) {
		int id = 1;
		Student retrievedStudent = jpaDAO.retrieveStudent(id);
		System.out.println("id of retrieved student : " +retrievedStudent.getId());
	}
	
	private void queryForStudents(StudentDAO jpaDAO) {
		List<Student> students = jpaDAO.findAll();
		
		for (Student student : students) {
			System.out.println(student);
		}
		
	}
	
	private void updateStudent(StudentDAO jpaDAO) {
		int studentId =1;
		Student student1 = jpaDAO.retrieveStudent(studentId);
		student1.setLastName("Marripudi");
		jpaDAO.update(student1);
		System.out.println("student updated successfully");
	}
	
	private void deleteStudent(StudentDAO jpaDAO) {
		int studentId = 2;
		jpaDAO.deleteStudent(studentId);
		System.out.println("student deleted successfully");
	}

}
