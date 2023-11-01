package com.jpa.student.dao;



import java.util.List;

import com.jpa.student.model.Student;

public interface StudentDaoInterface {
	public String addRecord(Student s);
	public String updateNameRecord(Student s);
	public String deleteRecord(Integer rollNo);
	public Student findRecordById(Integer rollNo);
	public List<Student> displayAllRecord();
	public List<Student> displayTopRecords();
	public Student displayMarksheet(Integer rollNo);
	
	

}
