package edu.miu.cs.cs425.demo.mystudentmgmtapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.demo.mystudentmgmt.repository.ClassRoomRepository;
import edu.miu.cs.cs425.demo.mystudentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.demo.mystudentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.demo.studentmgmt.model.ClassRoom;
import edu.miu.cs.cs425.demo.studentmgmt.model.Student;
import edu.miu.cs.cs425.demo.studentmgmt.model.Transcript;

@SpringBootApplication
public class MystudentmgmtApplication implements CommandLineRunner {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	public TranscriptRepository transcriptRepository;
	
	@Autowired
	public ClassRoomRepository classRoomRepository;

	public static void main(String[] args) {
		SpringApplication.run(MystudentmgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to StudentManagmentApp version 1.0");
		Student student=new Student("000-61-0002","Anna","Lynn","Smith",3.45,LocalDate.now());
		Transcript transcript= new Transcript("BS Computer Science");
		ClassRoom classRoom=new ClassRoom("McLaughlin building","M105");
		System.out.println(saveStudent(student));
		List<ClassRoom> classRoomList= new ArrayList<>();
		classRoomList.add(classRoom);
		student.setClassroomList(classRoomList);
		student.setTranscript(transcript);
		System.out.println(saveClassRoom(classRoom));
		System.out.println(saveTranscript(transcript));
		System.out.println(saveStudent(student));
		
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Transcript saveTranscript(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}
	
	public ClassRoom saveClassRoom(ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}

}
