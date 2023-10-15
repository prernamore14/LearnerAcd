package com.simpli.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simpli.dbutils.DbUtil;
import com.simpli.entity.Class;



public class ClassDao {

	DbUtil dbconn=new DbUtil();
	Session session=dbconn.dbConn();
	
	public int addClasse(Class classe) {		
		Transaction trans=session.beginTransaction();
		int value=(Integer) session.save(classe);
		trans.commit();
		
		return value;
	}
	
	public String editClass(Class classe) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(classe);
		transaction.commit();
		
		return "updated";
	}
	
		

	public Class retrieve(int id) {
		Transaction trans=session.beginTransaction();
		Class classe = (Class) session.get(Class.class, id);
		trans.commit();
		
		return classe;
	}
	
	public List<Class> display(){
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Class");
		List<Class> list=query.list();
		trans.commit();
		
		return list;
	}
	
}
