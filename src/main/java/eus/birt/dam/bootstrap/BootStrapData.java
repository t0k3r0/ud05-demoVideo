package eus.birt.dam.bootstrap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.University;
import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.UniversityRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UniversityRepository universityRepository;
	
	@Transactional
	@Override 
	public void run(String... arg0) throws Exception{
		
		Student student1 =new Student("Jill","Murray","jmurray@mail.com");
		University university1 = new University ("EHU");
		
		student1.setUniversity(university1);
		university1.getStudents().add(student1);
		
		
		universityRepository.save(university1);
		studentRepository.save(student1);
	}
}
