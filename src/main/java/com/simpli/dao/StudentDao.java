package com.simpli.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simpli.dbutils.DbUtil;
import com.simpli.entity.Student;

public class StudentDao {

	DbUtil dbconn=new DbUtil();
	Session session=dbconn.dbConn();
	
	public int addStudent(Student student) {
		
		Transaction trans=session.beginTransaction();

		int value=(Integer) session.save(student);
		trans.commit();
		
		return value;
	}
	

	public Student retrieve(int id) {
		
		Transaction trans=session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		trans.commit();
		
		return student;
	}
	
	public List<Student> display(){
		
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Student");
		List<Student> list=query.list();
		trans.commit();
		
		return list;
	}
	
}