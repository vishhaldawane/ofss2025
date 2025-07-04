package com.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SelectTest {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("emf :"+emf);
		
		EntityManager em = emf.createEntityManager();
		System.out.println("em  :"+em);

		Department deptObj = em.find( Department.class, 10);
		System.out.println("DEPTNO : "+deptObj.getDepartmentNumber());
		System.out.println("DNAME  : "+deptObj.getDepartmentName());
		System.out.println("LOC    : "+deptObj.getDepartmentLocation());
		
	}
}
