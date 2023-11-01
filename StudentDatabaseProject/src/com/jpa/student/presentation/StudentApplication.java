
package com.jpa.student.presentation;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentApplication {

	public static void main(String[] args) throws SQLException {
	
		StudentInterfaceImplement si=new StudentInterfaceImplement();
		Scanner scanner=new Scanner(System.in);
		Integer option;
		
		do
		{
			System.out.println("Please Enter valid option \n "
					+ "1.Insert Student Records \n "
					+ "2.Update Student Name Records\n "
					+ "3.Delete Student Records \n "
					+ "4.Display Student Record By RollNo\n "
					+ "5.Display All Student Records\n"
					+ "6.Display Result\n "
					+ "7.Display Top 3 Students Records\n "
					+ "8.Exit ");
			option=scanner.nextInt();
			
			switch(option)
			{
				case 1:	si.inputStudentProfile();
						break;
				case 2:	si.updateDetails();
						break;
				case 3: si.deleteDetails();
						break;
				case 4:	si.displayByRollno();
						break;
				case 5:	si.displayAll();
						break;
				case 6:	si.displayResult();
						break;
				case 7: si.displayList();
						break;
				case 8:	System.out.println("User Quit");
						System.exit(0);
				default:System.out.println("Please Enter valid Input.....");
		}
		}while(option!=8);
		scanner.close();

	}

}
