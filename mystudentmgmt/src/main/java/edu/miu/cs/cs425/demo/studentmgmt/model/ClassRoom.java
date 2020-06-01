package edu.miu.cs.cs425.demo.studentmgmt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;


public class ClassRoom { 
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long classroomId;
	
	@Column(nullable=true)
	private String buildingName;
	
	@Column(nullable=true)
	private String roomNumber;
	
	@ManyToMany(mappedBy = "classroomList")
	private List<Student> studentList;

	public ClassRoom() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ClassRoom(@NotEmpty(message = "Building name must not be empty") String buildingName,
			@NotEmpty(message = "Room number must not be empty") String roomNumber, List<Student> studentList) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.studentList = studentList;
	}
	public ClassRoom(@NotEmpty(message = "Building name must not be empty") String buildingName,
			@NotEmpty(message = "Room number must not be empty") String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}
	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "ClassRoom [classroomId=" + classroomId + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber
				+ ", studentList=" + studentList + "]";
	}

}
