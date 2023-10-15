package com.simpli.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simpli.dbutils.DbUtil;
import com.simpli.entity.Subject;


public class SubjectDao {

	DbUtil dbconn=new DbUtil();
	Session session=dbconn.dbConn();
	
	public int addSubject(Subject subject) {
		Transaction trans=session.beginTransaction();
		int value=(Integer) session.save(subject);
		trans.commit();
		
		return value;
	}
	
	public String editSubject(Subject subject) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(subject);
		transaction.commit();
		
		return "updated";
	}
	
	public Subject retrieve(int id) {
		Transaction trans=session.beginTransaction();
		Subject subject = (Subject) session.get(Subject.class, id);
		trans.commit();
		
		return subject;
	}
	
	public List<Subject> display(){
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Subject");
		List<Subject> list=query.list();
		trans.commit();
		
		return list;
	}
	
}
