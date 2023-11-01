package com.jpa.student.service;

import java.util.Iterator;
import java.util.List;

import com.jpa.student.dao.StudentDaoImplement;
import com.jpa.student.dao.StudentDaoInterface;
import com.jpa.student.model.Student;

public class StudentServiceImplement implements StudentServiceInterface
{

	private StudentDaoInterface si=new StudentDaoImplement();
	@Override
	public String addRecord(Student s) {
		
		return si.addRecord(s);
	}

	@Override
	public String updateNameRecord(Student s) {
		
		return si.updateNameRecord(s);
	}

	@Override
	public String deleteRecord(Integer rollNo) {
		
		return si.deleteRecord(rollNo);
	}


	@Override
	public Student findRecordById(Integer rollNo) {
		
		return si.findRecordById(rollNo);
	}

	@Override
	public Student displayMarksheet(Integer rollNo) {
		return si.displayMarksheet(rollNo);

		
	}

	@Override
	public List<Student> displayAllRecord() {
	
		return si.displayAllRecord();
	}

	@Override
	public List<Student> displayTopRecords() {
		return si.displayTopRecords();
		
	}
	
}
