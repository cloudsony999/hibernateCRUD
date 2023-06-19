package com.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.config.HibernateUtil;
import com.example.entity.Student;

/**
 * hibernate with full java no XML
 *
 */
public class Select {
	public static void main(String[] args) {

		try (SessionFactory sf = HibernateUtil.getSessionFactory(); Session s = sf.openSession()) {
			// Transaction tr = s.beginTransaction();
			Student ss = (Student) s.get(Student.class, 2);
			// tr.commit();
			System.out.println("student is " + ss.getId() + " " + ss.getName() + " " + ss.getAddress());

		} catch (HibernateException e) {
			System.out.println("hibernate error " + e);

		} catch (Exception e) {
			System.out.println("general error " + e);

		}

	}
}
