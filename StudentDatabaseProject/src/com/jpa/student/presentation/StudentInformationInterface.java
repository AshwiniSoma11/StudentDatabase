package com.jpa.student.presentation;

import java.sql.SQLException;

public interface StudentInformationInterface {
	
	public String inputStudentProfile() throws SQLException;
	public void updateDetails()throws SQLException;
	public void deleteDetails();
	public void displayByRollno();
	public void displayResult();
	public void displayAll();
	public void displayList();
	
}
