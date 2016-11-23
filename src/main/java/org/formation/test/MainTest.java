package org.formation.test;

import java.util.List;

import org.formation.jsf.model.Student;
import org.formation.jsf.service.StudentService;

public class MainTest {

	public static void main(String[] args) throws Exception {

		StudentService stdserv = new StudentService();
		
//		Student s = new Student();
//		s.setFirstName("Plutot");
//		s.setLastName("Mouse");
//		
//		stdserv.addStudent(s);
		
		stdserv.deleteStudent(6);
		
		List<Student> ls = stdserv.getStudents();
		
		System.out.println(ls);
		
//		Student s = stdserv.getStudent(3);
//		
//		s.setEmail("truc@chose.com");
//		
//		stdserv.updateStudent(s);
//		s = stdserv.getStudent(3);
//		
//		System.out.println(s);
		
//		stdserv.addStudent(s);

	}

}
