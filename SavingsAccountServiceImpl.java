package com.vishal.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vishal.demo.entity.SavingsAccount;
import com.vishal.demo.repository.SavingsAccountRepository;
@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	@Autowired
	SavingsAccountRepository savingsAccountRepo;
	
	@Override
	public SavingsAccount create(SavingsAccount newSavAccObject) {
		Optional<SavingsAccount> savAccBox = savingsAccountRepo
				.findById(newSavAccObject.getAccountNumber());
		if(savAccBox.isPresent()) {
			throw new SavingsAccountAlreadyExistsException("This"
			+ " account number already present : "+newSavAccObject.getAccountNumber());
			
		}
		else {	
			savingsAccountRepo.save(newSavAccObject);
		}
		return newSavAccObject;
	}

	@Override
	public SavingsAccount read(int accountNumber) {
		Optional<SavingsAccount> savAccBox = savingsAccountRepo
				.findById(accountNumber);
		if(savAccBox.isPresent()) {
			return savAccBox.get();
		}
		else {
			throw new SavingsAccountNotExistsException("This Savings"
					+ " Account does not exists: "+accountNumber);
		}
	}

	@Override
	public List<SavingsAccount> readAll() {
		return savingsAccountRepo.findAll();
	}

	@Override
	public SavingsAccount update(SavingsAccount savAccObjToUpdate) {
		Optional<SavingsAccount> savAccBox = savingsAccountRepo
				.findById(savAccObjToUpdate.getAccountNumber());
		if(savAccBox.isPresent()) {
			savingsAccountRepo.save(savAccObjToUpdate);
		}
		else {
			throw new SavingsAccountNotExistsException("This savigns account does not exists : "+savAccObjToUpdate.getAccountNumber());
		}
		return savAccObjToUpdate;
	}

	@Override
	public void delete(int accountNumber) {
		Optional<SavingsAccount> savAccBox = savingsAccountRepo
				.findById(accountNumber);
		if(savAccBox.isPresent()) {
			savingsAccountRepo.deleteById(accountNumber);
		}
		else {
			throw new SavingsAccountNotExistsException("This savigns account does not exists : "+accountNumber);
		}
	}

}
