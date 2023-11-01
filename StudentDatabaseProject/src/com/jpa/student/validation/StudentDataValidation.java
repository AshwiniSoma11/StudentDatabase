package com.jpa.student.validation;

import java.util.regex.Pattern;

public class StudentDataValidation {
	public boolean validateName(String s_name)
	{
		String nameRegex = "^[A-Za-z]+$";
		Pattern pattern=Pattern.compile(nameRegex);
		return pattern.matcher(s_name).matches();
	}
	public boolean validatePhone(String parent_no)
	{
		String phoneRegex = "(0/91)?[7-9][0-9]{9}";
		Pattern pattern=Pattern.compile(phoneRegex);
		return pattern.matcher(parent_no).matches();
		
	}
	public  boolean subjectMarksValidation(Integer sub_name)
	{
		if(sub_name>=0&&sub_name<=100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean validateDoa(String doa)
	{
		return true;
	}


}
