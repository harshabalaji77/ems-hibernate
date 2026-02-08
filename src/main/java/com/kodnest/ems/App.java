package com.kodnest.ems;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");
        while (true) {
	        System.out.println("Press 1 -> AddEmployee");
	        System.out.println("Press 2 -> GetEmployee");
	        System.out.println("Press 3 -> DeleteEmployee");
	        System.out.println("Press 4 -> UpdateEmployee");
	        System.out.println("Press other -> Exit");
	        
	        int ch = sc.nextInt();
	        
	        switch(ch) {
		        case 1 -> addEmployee();
		        case 2 -> getEmployee();
		        case 3 -> deleteEmployee();
		        case 4 -> updateEmployee();
		        default -> {
		        	System.out.println("Thank you using EMS..");
		        	factory.close();
		        	sc.close();
		        	return;
		        }
	        }
        }
    }
    
    public static void addEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter Employee name, salary and email");
    	
    	Employee employee = new Employee(sc.next(), sc.nextInt(), sc.next());
    	session.persist(employee);
    	System.out.println("Employee added successfully");
    	
    	transaction.commit();
    	session.close();
    }
    
    public static void getEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter Employee id");
    	int id = sc.nextInt();
    	
    	Employee obj = session.find(Employee.class, id);
    	if (obj != null) {
    		System.out.println(obj);
    	}
    	else {
    		System.out.println("Employee doesn't exist with id -> " + id);
    	}
    	
    	transaction.commit();
    	session.close();
    }
    
    public static void deleteEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter Employee id to delete");
    	int id = sc.nextInt();
    	
    	Employee obj = session.find(Employee.class, id);
    	if (obj != null) {
    		session.remove(obj);
    		System.out.println("Employee with id -> " + id + " deleted successfully");
    	}
    	else {
    		System.out.println("Employee doesn't exist with id -> " + id);
    	}
    	
    	transaction.commit();
    	session.close();
    }
    
    public static void updateEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter Employee id");
    	int id = sc.nextInt();
    	
    	Employee obj = session.find(Employee.class, id);
    	if (obj != null) {
    		System.out.println("Enter New Employee name, salary and email");
    		obj.setName(sc.next());
    		obj.setSalary(sc.nextInt());
    		obj.setEmail(sc.next());
    		session.merge(obj);
    		System.out.println("Employee updated successfully");
    	}
    	else {
    		System.out.println("Employee doesn't exist with id -> " + id);
    	}
    	
    	transaction.commit();
    	session.close();
    }
    
}