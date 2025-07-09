package com.vishal.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
