package com.Learning.Event.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int studId;
	public String studName;
	public String studDept;
	public String studCountry;
	
	public Student() {
		
	}
	
	public Student(String studName, String studDept, String studCountry) {
		super();
		this.studName = studName;
		this.studDept = studDept;
		this.studCountry = studCountry;
	}
	
	public int getStudId() {
		return studId;
	}
	
	public void setStudId(int studId) {
		this.studId = studId;
	}
	
	public String getStudName() {
		return studName;
	}
	
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public String getStudDept() {
		return studDept;
	}
	
	public void setStudDept(String studDept) {
		this.studDept = studDept;
	}
	
	public String getStudCountry() {
		return studCountry;
	}
	
	public void setStudCountry(String studCountry) {
		this.studCountry = studCountry;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studDept=" + studDept + ", studCountry="
				+ studCountry + "]";
	}
}
