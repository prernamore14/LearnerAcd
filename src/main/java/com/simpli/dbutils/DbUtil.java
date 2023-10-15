package com.simpli.dbutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

		public class DbUtil {
			StandardServiceRegistry ssr=null;
			Metadata md=null;
			SessionFactory sf=null;
			Session session=null;
			
			public Session dbConn() {
			
				ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				
				md=new MetadataSources(ssr).getMetadataBuilder().build();
				
				sf=md.getSessionFactoryBuilder().build();
				
				session=sf.openSession();
				return session;
			}
		}
	