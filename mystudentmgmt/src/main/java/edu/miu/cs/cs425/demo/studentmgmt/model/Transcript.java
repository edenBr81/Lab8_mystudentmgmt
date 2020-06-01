package edu.miu.cs.cs425.demo.studentmgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

public class Transcript {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long transcript;
	
	@Column(name="degreeTitle", nullable = false)
	@NotEmpty(message = "Degree title can't be empty")
	private String degreeTitle;
	
	
	@OneToOne(mappedBy="transcript" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public Student student;


	public Transcript() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Transcript(@NotEmpty(message = "Degree title can't be empty") String degreeTitle) {
		super();
		this.degreeTitle = degreeTitle;
	}
	
	public long getTranscript() {
		return transcript;
	}

	public void setTranscript(long transcript) {
		this.transcript = transcript;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	@Override
	public String toString() {
		return "Transcript [transcript=" + transcript + ", degreeTitle=" + degreeTitle + ", student=" + student + "]";
	}

}
