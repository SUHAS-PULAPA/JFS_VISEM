package com.example.main;

import java.util.ArrayList;

import org.hibernate.Session;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.util.HibernateUtil;

public class MainApp {
	public static void main(String args[]) {
		Session session = HibernateUtil.getFactory().openSession();
		Department dept = new Department();
		dept.setName("CSE");
		Employee e1 = new Employee();
		e1.setName("Suhas");
		Employee e2 = new Employee();
		e2.setName("Sai");
		e1.setDepartment(dept);
		e2.setDepartment(dept);
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		emplist.add(e1);
		emplist.add(e2);
		dept.setEmployees(emplist);
		session.beginTransaction();
		session.persist(dept);
		session.getTransaction().commit();
		session.close();
	}
}
