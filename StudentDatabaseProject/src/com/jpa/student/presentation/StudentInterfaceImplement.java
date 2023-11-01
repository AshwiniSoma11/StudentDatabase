package com.jpa.student.presentation;

import java.sql.SQLException;
import com.jpa.student.dao.StudentDaoImplement;
import com.jpa.student.validation.StudentDataValidation;
import java.util.*;
import com.jpa.student.model.Student;
import com.jpa.student.service.StudentServiceImplement;
import com.jpa.student.service.StudentServiceInterface;

public class StudentInterfaceImplement implements StudentInformationInterface
{
	private Integer rollNo;
	private String name;
	private String address;
	private String parentNo;
	private String doa;
	private Integer marathi;
	private Integer hindi;
	private Integer english;
	private Integer science;
	private Integer maths;
	private Integer total;
	private Float percentage;

	Scanner scanner=new Scanner(System.in);
	private Student s=new Student();
	private StudentServiceInterface sService=new StudentServiceImplement();
	private StudentDaoImplement sdao=new StudentDaoImplement();
	private StudentDataValidation svalidation=new StudentDataValidation();
	@Override
	public String inputStudentProfile(){
		
		
		
		boolean frollno=true,fname=true ,fpn=true ,fdoa=true ,fmarathi=true ,fhindi=true ,fenglish=true ,fscience=true ,fmaths=true;	
		
		while(frollno==true)
		{
		System.out.print("Enter Roll no:");
		rollNo=scanner.nextInt();
		if(!sdao.existRecord(rollNo))
		{
			frollno=false;
			scanner.nextLine();
			while(fname==true)
			{
				
				System.out.print("Enter Name:");
				name=scanner.nextLine();
				if(svalidation.validateName(name))
				{
					fname=false;
					
				System.out.print("Enter Address:");
				address=scanner.nextLine();
				while(fpn==true)
				{
					System.out.print("Enter Parent Contact NO:");
					parentNo=scanner.next();
					if(svalidation.validatePhone(parentNo))
					{
						fpn=false;
						while(fdoa==true)
						{
							System.out.print("Enter Date of Admission in yyyy-dd-mm format:");
							doa=scanner.next();
							if(svalidation.validateDoa(doa))
							{
								fdoa=false;
								while(fmarathi==true)
								{
									System.out.print("Enter Marathi marks:");
									marathi=scanner.nextInt();
									if(svalidation.subjectMarksValidation(marathi))
									{
										fmarathi=false;
										while(fhindi==true)
										{
												System.out.print("Enter Hindi marks:");
												hindi=scanner.nextInt();
												if(svalidation.subjectMarksValidation(hindi))
												{
													fhindi=false;
													while(fenglish==true)
													{
														System.out.print("Enter English marks:");
														english=scanner.nextInt();
														if(svalidation.subjectMarksValidation(english))
														{
															fenglish=false;
															while(fscience==true)
															{
															System.out.print("Enter Science marks:");
															science=scanner.nextInt();
															if(svalidation.subjectMarksValidation(science))
															{
																fscience=false;
																while(fmaths==true)
																{
																	System.out.print("Enter Maths marks:");
																	maths=scanner.nextInt();
																	if(svalidation.subjectMarksValidation(maths))
																	{
																		fmaths=false;
																	}
																	else
																	{
																		System.out.println("Marks should be in 0-100 for maths subject");
																	}
																}//while fmaths close
															 }
															 else
															 {
																System.out.println("Marks should be in 0-100 for Science subject");
															 }
															}//while fscience close
														}
														else
														{
															System.out.println("Marks should be in 0-100 for english subject");
														}
													}//while fenglish close
												}
												else
												{
													System.out.println("Marks should be in 0-100 for hindi subject");
												}
										}//while fhindi close
									}
									else
									{
										System.out.println("Marks should be in 0-100 for marathi subject");
									}
								}//while fmarathi close
							}
							else
							{
								System.out.println("Incorrect Date of Admission");
							}
						}//while fdoa close
					}
					else
					{
						System.out.println("Incorrect phone number must be 10 digit");
					}
				}//while fpn close
				}
				else
				{
					System.out.println("Incorrect name must be alphabet value");
				}
			}//while fname close
		/*}
		else
		{
			System.out.println("Student already exsit.....");
		}
		}//while frollno close
			*/				
									
		total=marathi+hindi+english+science+maths;
		percentage=(float)(total*100/500);
		
		s.setRollNo(rollNo);
		s.setName(name);
		s.setAddress(address);
		s.setParentNo(parentNo);
		s.setDoa(doa);
		s.setMarathi(marathi);
		s.setHindi(hindi);
		s.setEnglish(english);
		s.setScience(science);
		s.setMaths(maths);
		s.setTotal(total);
		s.setPercentage(percentage);
	
		System.out.println(sService.addRecord(s));
		}//if close
		else
		{
			System.out.println("Record already exist............");
		
		}
		}//while frollno close
		
		
		
		return null;
	}

	@Override
	public void updateDetails(){
		boolean fname=true;
		System.out.print("Enter Rollno:");
		rollNo=scanner.nextInt();
		if(sdao.existRecord(rollNo))
		{
		scanner.nextLine();
		while(fname==true)
		{
			System.out.print("Enter name :");
			name=scanner.nextLine();
			if(svalidation.validateName(name))
			{
				fname=false;
			}
		}
		s.setRollNo(rollNo);
		s.setName(name);
		System.out.println(sService.updateNameRecord(s));
		}
		else
		{
			System.out.println("Record does not exist..........");
		}
	}

	@Override
	public void deleteDetails() {
		System.out.print("Enter Rollno:");
		rollNo=scanner.nextInt();
		if(sdao.existRecord(rollNo))
		{
			System.out.println(sService.deleteRecord(rollNo));
		}
		else
		{
			System.out.println("Record not exist.......");
		}
		
	}

	
	@Override
	public void displayByRollno() {
		System.out.print("Enter rollNo:");
		rollNo=scanner.nextInt();
		Student s=sService.findRecordById(rollNo);
		if(s!=null)
		{
			System.out.println("Student   Details");
			System.out.println("-----------------------------");
			System.out.println("Rollno\t\t : "+s.getRollNo()+"\nName\t\t : "+s.getName()+"\nAddress\t\t : "+s.getAddress()+"\nParent Contact No: "+s.getParentNo()+"\nDate of Admission: "+s.getDoa()+"\n\n");
			
		}
		else
		{
			System.out.println("Student not exist.........");
		}
		
	}

	@Override
	public void displayResult() {
		System.out.print("Enter Rollno:");
		rollNo=scanner.nextInt();
		Student s=sService.displayMarksheet(rollNo);
		
		if(s!=null)
		{
			
	
		System.out.println("\t\tStudent Marksheet\t\t");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Student RollNO: "+s.getRollNo()+"       Student Name: "+s.getName());
		System.out.println("-------------------------------------------------------------");

		System.out.println("Subject Name\t\tMarks");
		System.out.println("Marathi\t\t\t"+s.getMarathi()+"\nHindi \t\t\t"+s.getHindi()+"\nEnglish\t\t\t"+s.getEnglish()+"\nScience\t\t\t"+s.getScience()+"\nMaths\t\t\t"+s.getMaths());
		System.out.println("-------------------------------------------------------------");
		System.out.println("\t\tTotal = "+s.getTotal());
		System.out.println("\t   Percentage = "+s.getPercentage()+"%");
		System.out.println("-------------------------------------------------------------\n");

		}
		else
		{
			System.out.println("Does not exist data for this roll no.....");
		}

	}

	@Override
	public void displayAll() {
	
		List<Student> list=sService.displayAllRecord();
		Iterator<Student> itr=list.iterator();
		System.out.println("RollNo\tName\t\t\tAddress\t\t\tParentNo\t\tDate of Admission\tMarathi\tHindi\tEnglish\tScience\tMaths\tTotal\tPercentage");
		while(itr.hasNext())
		{
			Student s=itr.next();
			System.out.println(s.getRollNo()+"\t"+s.getName()+"\t\t"+s.getAddress()+"\t\t"+s.getParentNo()+"\t\t"+
			"\t"+s.getDoa()+"\t"+s.getMarathi()+"\t"+s.getHindi()+"\t"+s.getEnglish()+"\t"+s.getScience()+"\t"+
					s.getMaths()+"\t"+s.getTotal()+"\t"+s.getPercentage());
		}
	}

	@Override
	public void displayList() {
		
		List<Student> l=sService.displayTopRecords();
		Iterator<Student> itr=l.iterator();
		System.out.println("RollNo\tName\t\t\tAddress\t\t\tParentNo\t\tDate of Admission\tMarathi\tHindi\tEnglish\tScience\tMaths\tTotal\tPercentage");
		while(itr.hasNext())
		{
			Student s=itr.next();
			System.out.println(s.getRollNo()+"\t"+s.getName()+"\t\t"+s.getAddress()+"\t\t"+s.getParentNo()+"\t\t"+
			"\t"+s.getDoa()+"\t"+s.getMarathi()+"\t"+s.getHindi()+"\t"+s.getEnglish()+"\t"+s.getScience()+"\t"+
					s.getMaths()+"\t"+s.getTotal()+"\t"+s.getPercentage());
		}
		
		
	}


}
