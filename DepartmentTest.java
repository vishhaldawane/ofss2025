package com.jpa;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class DepartmentTest {

	EntityManager em; //global handle for all the test cases
	
	@BeforeEach
	void init() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("emf :"+emf);
		
		em = emf.createEntityManager();
		System.out.println("em  :"+em);
	}
	
	@Test
	public void testSelectSingleDepartment() {
		
		Department deptObj = em.find( Department.class, 10);
		System.out.println("DEPTNO : "+deptObj.getDepartmentNumber());
		System.out.println("DNAME  : "+deptObj.getDepartmentName());
		System.out.println("LOC    : "+deptObj.getDepartmentLocation());
		
	}
	//typing tutor
	
	@Test
	public void testInsertDepartment() {
			
		//transient object [ it is in the memory ]
		Department deptObj = new Department();
		deptObj.setDepartmentNumber(60);
		deptObj.setDepartmentName("TRAINING");
		deptObj.setDepartmentLocation("Mumbai");
		
		EntityTransaction et = em.getTransaction();
		System.out.println("Transaction  :"+et);

		et.begin();
			em.persist(deptObj); //persisted object
		et.commit();
		System.out.println("Object persisted....");
	}
	
	@Test
	public void testUpdateDepartment() {
		
		EntityTransaction et = em.getTransaction();
		System.out.println("Transaction  :"+et);

		et.begin();
			//attached object
			Department dept = em.find(Department.class,60);
			dept.setDepartmentName("Development");
			dept.setDepartmentLocation("Bengaluru");
			
			em.merge(dept);
		et.commit();
		System.out.println("Object modified....");
	}
	
	@Test
	public void testDeleteDepartment() {
		
		EntityTransaction et = em.getTransaction();
		System.out.println("Transaction  :"+et);

		et.begin();
			//attached object 
			Department dept = em.find(Department.class,60);
			em.remove(dept);
		et.commit();
		System.out.println("Object removed....");
	}
	
	@Test
	public void testSelectAllDepartments() {
		TypedQuery<Department> query = em.createQuery("from Department",Department.class); // JPQL
		List<Department> listOfDepts = query.getResultList();
		for (Department deptObj : listOfDepts) {
			System.out.println("DEPTNO : "+deptObj.getDepartmentNumber());
			System.out.println("DNAME  : "+deptObj.getDepartmentName());
			System.out.println("LOC    : "+deptObj.getDepartmentLocation());
			System.out.println("------------");
		}
		
	}
}
