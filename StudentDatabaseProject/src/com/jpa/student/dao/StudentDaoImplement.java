package com.jpa.student.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jpa.student.model.Student;

public class StudentDaoImplement implements StudentDaoInterface{

	private static Student s=new Student();
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;
	static
	{
		emf =Persistence.createEntityManagerFactory("ashwini");
		em=emf.createEntityManager();
		et=em.getTransaction();
	}
	
	@Override
	public String addRecord(Student s) 
	{
			et.begin();
				em.persist(s);
			et.commit();
			em.clear();
	
			return "record added";
	}

	@Override
	public String updateNameRecord(Student s) {
		Student s1=em.find(Student.class , s.getRollNo());
		if(s1!=null)
		{
		et.begin();
			s1.setRollNo(s.getRollNo());
			s1.setName(s.getName());
		et.commit();
		em.clear();
		return "record Updated";
		}
		else
		{
			return "Record Not Found";
		}
	}

	@Override
	public String deleteRecord(Integer rollNo) {
		s=em.find(Student.class,rollNo);
		if(s!=null)
		{
			et.begin();
				em.remove(s);
			et.commit();
			return "Record Deleted";
		}
		else
		{
			return "Record Not Found";
		}
		
	}
	
	@Override
	public Student findRecordById(Integer rollNo) {
		et.begin();
				s = em.find(Student.class, rollNo);
	     et.commit();
	     em.clear();
		return s; 
	}

	public boolean existRecord(Integer rollNo)  {
		et.begin();
			s= em.find(Student.class, rollNo);

	     et.commit();
	     em.clear();
	     if(s!=null)
	     {
	    	 return true;
	     }
	     else {
	    	 return false;
	     }
	}

	@Override
	public List<Student> displayAllRecord() {
		Query query=em.createQuery("Select s from Student s");
		List<Student> list=query.getResultList();
		return list;
	}

	@Override
	public List<Student> displayTopRecords() {

			//Query query=em.createQuery("Select s from Student s order by s.percentage desc ");
			//query.setMaxResults(3);
		Query query=em.createQuery("Select s from Student s order by s.percentage desc ",Student.class).setMaxResults(3);
			List<Student> list=query.getResultList();
			return list;
	}
	
	
	public Student displayMarksheet(Integer rollNo)
	{
		et.begin();
			s = em.find(Student.class, rollNo);
		et.commit();
		em.clear();
		return s;
		
	}
}
