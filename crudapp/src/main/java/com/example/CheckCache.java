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
public class CheckCache {
	public static void main(String[] args) {

		try (SessionFactory sf = HibernateUtil.getSessionFactory(); Session s = sf.openSession()) {
			// Transaction tr = s.beginTransaction();
//			Student student = new Student();
//			student.setName("chandrani");
//			student.setAddress("kolkata");
//			student.setEmail("cloudsamsung999@gmail.com");
//			s.save(student);
			Student ss = (Student) s.get(Student.class, 3);

			System.out.println("student is " + ss.getId() + " " + ss.getName() + " " + ss.getAddress());
			Thread.sleep(5000);
			System.out.println("in cache or not " + s.contains(ss));
			Student ss2 = (Student) s.get(Student.class, 3);

			System.out.println("student is " + ss2.getId() + " " + ss2.getName() + " " + ss2.getAddress());

			// tr.commit();
			s.evict(ss2);// specific cache
			// s.clear();//all cache
			System.out.println("------------after clearing cache!!!------------");
			Student ss3 = (Student) s.get(Student.class, 3);

			System.out.println("student is " + ss2.getId() + " " + ss2.getName() + " " + ss2.getAddress());

			// System.out.println("--------student inserted----------");

		} catch (HibernateException e) {
			System.out.println("hibernate error " + e);

		} catch (Exception e) {
			System.out.println("general error " + e);

		}

	}
}
