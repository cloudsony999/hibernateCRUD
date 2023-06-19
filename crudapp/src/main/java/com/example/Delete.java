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
public class Delete {
	public static void main(String[] args) {

		try (SessionFactory sf = HibernateUtil.getSessionFactory(); Session s = sf.openSession()) {
			Transaction tr = s.beginTransaction();
			Student ss = (Student) s.get(Student.class, 2);

			s.remove(ss);
			System.out.println("deleted from DB...........");
			tr.commit();
		} catch (HibernateException e) {
			System.out.println("hibernate error " + e);

		} catch (Exception e) {
			System.out.println("general error " + e);

		}

	}
}
