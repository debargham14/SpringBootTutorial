package io.caringhopes.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//class declared to write the business logic
@Service
public class StudentService {
	private List <Student> students = new ArrayList<> (Arrays.asList(
			new Student ("67", "debargha", "CSE"),
			new Student ("22", "Jackson", "MME"),
			new Student ("32", "Parker", "ME")
			));
	
	public List<Student> getAllStudents () {
		return students;
	}
	
	public Student getStudentById (String id) {
		return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
	}
	
	public void addStudent (Student s) {
		students.add(s);
	}
}
