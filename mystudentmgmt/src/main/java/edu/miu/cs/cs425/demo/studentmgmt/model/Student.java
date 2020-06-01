package edu.miu.cs.cs425.demo.studentmgmt.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique= true, nullable=false)
	@NotEmpty(message= "Student Number can not")
	private String studentNumber;
	
	@Column(nullable = false)
	@NotEmpty(message = "First name should not be empty!")
	private String firstName;
	
	@Column(nullable = true)
	private String middleName;
	
	@Column(nullable = false)
	@NotEmpty(message = "Last name should not be empty!")
	private String lastName;

	@Column(nullable = true)
	private Double cgpa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfEnrollment;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="transcript", nullable=false)
	public Transcript transcript;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Student_Class", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "classroom_id") }
    )
	private List<ClassRoom> classroomList;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(@NotEmpty(message ="Student Number can not") String studentNumber,
			@NotEmpty(message = "First name should not be empty!") String firstName, String middleName,
			@NotEmpty(message = "Last name should not be empty!") String lastName, double cgpa,
			LocalDate dateOfEnrollment) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
	
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public Transcript getTranscript() {
		return transcript;
	}


	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}


	public List<ClassRoom> getClassroomList() {
		return classroomList;
	}


	public void setClassroomList(List<ClassRoom> classroomList) {
		this.classroomList = classroomList;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNumber=" + studentNumber + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", dateOfEnrollment=" + dateOfEnrollment
				+ ", transcript=" + transcript + "]";
	}
}
