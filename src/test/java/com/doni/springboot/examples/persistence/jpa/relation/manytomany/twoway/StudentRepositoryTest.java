package com.doni.springboot.examples.persistence.jpa.relation.manytomany.twoway;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired
	LectureRepository lectureRepository;
	
	Lecture lecture;
	Student student;

	@Before
	public void setup() {
		
		lecture = new Lecture();
		lecture.setLectureId("2");
		lecture.setLectureTitle("Math");
		
		student = new Student();
		student.setStudentId("2");
		student.setStudentName("doni");

		List<Lecture> lectures = new ArrayList<Lecture>();
		lectures.add(lecture);
		student.setLectures(lectures);
		
	}
	
	@Test
	public void save() {
		lectureRepository.save(lecture);
		studentRepository.save(student);
	}

}
