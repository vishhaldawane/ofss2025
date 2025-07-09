package com.vishal.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	ArrayList<SavingsAccount> list
	   = new ArrayList<SavingsAccount>();
	
	BankController() { //ctor
		SavingsAccount sa1 = new SavingsAccount(101,"Jack",50000);
		SavingsAccount sa2 = new SavingsAccount(102,"Jane",60000);
		SavingsAccount sa3 = new SavingsAccount(103,"Janet",70000);
		SavingsAccount sa4 = new SavingsAccount(104,"Julie",80000);
		SavingsAccount sa5 = new SavingsAccount(105,"Julia",90000);
		list.add(sa1);list.add(sa2);list.add(sa3);list.add(sa4);list.add(sa5);
	}
	
	@GetMapping("/all") // http://localhost:8090/bank/all
	List<SavingsAccount> getAllAccount() {
		return list;
	}
	
	@GetMapping("/{id}") // http://localhost:8090/bank/101
	ResponseEntity<?> getSingleAccount(@PathVariable("id") int accno) {
		for(SavingsAccount savAcc : list) {
			if(savAcc.getAccountNumber() == accno) {
				return new ResponseEntity(HttpStatus.FOUND).ok(savAcc);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND).ok("SavingsAccount not found");
	}
	
	@PostMapping("/add") // http://localhost:8090/bank/add
	ResponseEntity<?> addSingleAccount(@RequestBody SavingsAccount newSavAcc) {
		for(SavingsAccount savAcc : list) {
			if(savAcc.getAccountNumber() == newSavAcc.getAccountNumber()) {
				return new ResponseEntity(HttpStatus.NOT_FOUND).ok("SavingsAccount Already Exists : "+newSavAcc.getAccountNumber());
			}
		}
		list.add(newSavAcc);
		MyResponse response = 
				new MyResponse(newSavAcc, "Savings Account Object Created...");
		return new ResponseEntity(HttpStatus.CREATED).ok(response);
			
	}
	
	@PutMapping("/update") // http://localhost:8090/bank/update
	ResponseEntity<?> updateSingleAccount(@RequestBody SavingsAccount savAccToUpdate) {
		for(SavingsAccount savAcc : list) {
			if(savAcc.getAccountNumber() == savAccToUpdate.getAccountNumber()) {
				list.remove(savAcc);
				list.add(savAccToUpdate);
				MyResponse response = 
						new MyResponse(savAccToUpdate, "Savings Account Object Modified...");

				return new ResponseEntity(HttpStatus.ACCEPTED).ok("SavingsAccount modified");
				
			}
		}
		MyResponse response = 
				new MyResponse(savAccToUpdate, "Savings Account Object Not Found...");

		return new ResponseEntity(HttpStatus.NOT_FOUND).ok("SavingsAccount Does Not Exists : "+savAccToUpdate.getAccountNumber());
	}
	
	@GetMapping("/") // localhost:8090/bank/
	public String home() {
		return "<!doctype html>\n"
				+ "<html>\n"
				+ "  <head>\n"
				+ "    <title>My Bank</title>\n"
				+ "  </head>\n"
				+ "  <body>\n"
				+ "    <h2>This is My Bank. The world of <strong>banking</strong> is easy with us, just connect with <strong>us</strong> to know more.</h2>\n"
				+ "  </body>\n"
				+ "</html>";
	}
	@GetMapping("/greet") // localhost:8090/bank/
	public String greetTheUser() {
		return "<h3>Welcome User</h3>";
	}
	
	
	
}
