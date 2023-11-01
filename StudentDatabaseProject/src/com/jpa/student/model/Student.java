package com.jpa.student.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentDetails")
public class Student {

	@Id
	private Integer rollNo;
	@Column(length=10)
	private String name;
	@Column(length=10)
	private String address;
	@Column(length=10)
	private String parentNo;
	@Column(length=10)
	private String doa;
	private Integer marathi;
	private Integer hindi;
	private Integer english;
	private Integer science;
	private Integer maths;
	private Integer total;
	private Float percentage;
	
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public Integer getMarathi() {
		return marathi;
	}
	public void setMarathi(Integer marathi) {
		this.marathi = marathi;
	}
	public Integer getHindi() {
		return hindi;
	}
	public void setHindi(Integer hindi) {
		this.hindi = hindi;
	}
	public Integer getEnglish() {
		return english;
	}
	public void setEnglish(Integer english) {
		this.english = english;
	}
	public Integer getScience() {
		return science;
	}
	public void setScience(Integer science) {
		this.science = science;
	}
	public Integer getMaths() {
		return maths;
	}
	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	
	
	
	
	
	
	
}
