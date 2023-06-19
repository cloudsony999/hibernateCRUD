package com.example.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.example.entity.Student;

public class HibernateUtil {
	public static SessionFactory factory = null;
	static {
		Configuration cfg = new Configuration();
		Properties props = new Properties();
		props.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:XE");
		props.put(Environment.USER, "c##scott");
		props.put(Environment.PASS, "tiger");
		props.put(Environment.SHOW_SQL, true);
		props.put(Environment.FORMAT_SQL, true);
		props.put(Environment.HBM2DDL_AUTO, "update");

		cfg.setProperties(props);

		cfg.addAnnotatedClass(Student.class);
		factory = cfg.buildSessionFactory();
		System.out.println("-----------ALL CONFIGURATION DONE and SessionFactory Ready-------");

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

}
