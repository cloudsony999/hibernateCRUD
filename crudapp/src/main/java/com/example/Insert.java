package com.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.config.HibernateUtil;
import com.example.entity.Student;

/**
 * hibernate with full java no XML
 *
 */
public class Insert {
	public static void main(String[] args) {

		try (SessionFactory sf = HibernateUtil.getSessionFactory(); Session s = sf.openSession()) {
			Transaction tr = s.beginTransaction();
			Student student = new Student();
			student.setName("chandrani");
			student.setAddress("kolkata");
			student.setEmail("cloudsamsung999@gmail.com");
			s.save(student);
			tr.commit();
			System.out.println("--------student inserted----------");

		} catch (HibernateException e) {
			System.out.println("hibernate error " + e);

		} catch (Exception e) {
			System.out.println("general error " + e);

		}

	}
}
