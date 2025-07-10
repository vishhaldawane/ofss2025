package com.vishal.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.demo.entity.SavingsAccount;
import com.vishal.demo.repository.SavingsAccountRepository;

@SpringBootTest
class RestfulServiceApplicationTests {

	@Autowired
	SavingsAccountRepository accountRepo;
	
	@Test
	void insertTest() {
		SavingsAccount sa = new SavingsAccount();
		sa.setAccountNumber(103);
		sa.setAccountHolder("Julie");
		sa.setAccountBalance(70000);
		
		accountRepo.save(sa);
	}
	
	@Test
	void updateTest() {
		SavingsAccount sa = new SavingsAccount();
		sa.setAccountNumber(105); //<-- existing id
		sa.setAccountHolder("BILL GATES");
		sa.setAccountBalance(99999);	
		accountRepo.save(sa); //if the id already exists, it will update ie merge
	}
	
	@Test
	void deleteTest() {
		accountRepo.deleteById(101); //if the id already exists, it will update ie merge
	}
	
	@Test
	void selectTest() {
		Optional<SavingsAccount> savAccObjBox=accountRepo.findById(101);
		Assertions.assertNotNull(savAccObjBox);
		SavingsAccount savAccObj = savAccObjBox.get();
		Assertions.assertNotNull(savAccObj);
		System.out.println("Acno : "+savAccObj.getAccountNumber());
		System.out.println("Name : "+savAccObj.getAccountHolder());
		System.out.println("Bal  : "+savAccObj.getAccountBalance());	
	}
	
	@Test
	void selectAllTest() {
		List<SavingsAccount> savAccList=accountRepo.findAll();
		Assertions.assertNotNull(savAccList);
		System.out.println("Got the List");
		Assertions.assertTrue(savAccList.size() > 0);
		System.out.println("List is not empty");
		for(SavingsAccount savAccObj : savAccList) {
			System.out.println("Acno : "+savAccObj.getAccountNumber());
			System.out.println("Name : "+savAccObj.getAccountHolder());
			System.out.println("Bal  : "+savAccObj.getAccountBalance());	
		}
	}
	

}
