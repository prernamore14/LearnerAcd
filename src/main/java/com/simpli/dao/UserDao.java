package com.simpli.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simpli.dbutils.DbUtil;
import com.simpli.entity.User;



public class UserDao {
	DbUtil dbconn=new DbUtil();
	Session session=dbconn.dbConn();
	
	public String adduser(User user) {
		Transaction trans=session.beginTransaction();
		User newuser=new User();
		newuser.setUser(user.getUser());
		newuser.setPassword(user.getPassword());
		String value=(String) session.save(newuser);
		trans.commit();
		
		return value;
	}
	
	public void addDefaultUser() {
		User user = new User();
		user.setUser("root");
		user.setPassword("user");
		if( validateuser(user) == null)
			adduser(user);
		
	}
	
	
	public User validateuser(User user) {
		
		Transaction trans=session.beginTransaction();
		User newuser= (User) session.get(User.class, user.getUser());
		trans.commit();
		
		return newuser;
		
	}

}
