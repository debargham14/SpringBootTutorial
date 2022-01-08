package io.caringhopes.student;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping (method=RequestMethod.GET, value="/")
	public StringBuilder landingPage () {
		StringBuilder sb = new StringBuilder ();
		sb.append("<h1>Hi There Welcome to Spring Boot with Java MVC</h1>");
		return sb;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/students")
	public List<Student> getAllStudents () {
		return studentRepository.findAll();
	}
	
	@RequestMapping (method=RequestMethod.POST, value="/add-student")
	public ResponseEntity<String> addStudent (@RequestBody Student s) throws Exception{
		java.util.Optional<Student> student = studentRepository.findById (s.getId());
		if (student.isPresent()) {
			return new ResponseEntity<>("Student with the following id already exists", HttpStatus.BAD_REQUEST);
		}
		else {
			studentRepository.save(s);
			return new ResponseEntity<> ("Student Record Addition successful !", HttpStatus.ACCEPTED);
		}
	}
}
