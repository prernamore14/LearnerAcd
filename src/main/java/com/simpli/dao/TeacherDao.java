package com.simpli.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simpli.dbutils.DbUtil;
import com.simpli.entity.Teacher;




public class TeacherDao {

	DbUtil dbconn=new DbUtil();
	Session session=dbconn.dbConn();
	
	public int addTeacher(Teacher teacher) {
		Transaction trans=session.beginTransaction();
		int value=(Integer) session.save(teacher);
		trans.commit();
		
		return value;
	}
	

	public Teacher retrieve(int id) {
		Transaction trans=session.beginTransaction();
		Teacher tecacher = (Teacher) session.get(Teacher.class, id);
		trans.commit();
		
		return tecacher;
	}
	
	public List<Teacher> display(){
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Teacher");
		List<Teacher> list=query.list();
		trans.commit();
		
		return list;
	}
	
}