package com.vishal.demo.contoller;

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

import com.vishal.demo.entity.SavingsAccount;

class User
{
	String id;
	String name;
	String email;
	HomeAddress address = new HomeAddress();
	String phone;
	String website;
	CompanyDetails company = new CompanyDetails();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public HomeAddress getAddress() {
		return address;
	}
	public void setAddress(HomeAddress address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public CompanyDetails getCompany() {
		return company;
	}
	public void setCompany(CompanyDetails company) {
		this.company = company;
	}
	
}
class HomeAddress {
	String area; String street;
	String suite; String city;
	String zip;
	GeoLocation geo = new GeoLocation();
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public GeoLocation getGeo() {
		return geo;
	}
	public void setGeo(GeoLocation geo) {
		this.geo = geo;
	}
	
	
}
class GeoLocation {
	String lat; String lng;


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getLng() {
		return lng;
	}


	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
}
class CompanyDetails {
	String name; String catchPhrase; String bs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}
	
}

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
	
	@GetMapping("/users")
	List<User> getAllUsers() {
	
		List<User> userList = new ArrayList<User>();
		
		User user1 = new User();
		user1.setId("1"); user1.setName("Jack");
		user1.setEmail("jack@gmail.com");
		user1.setWebsite("www.work.com");
		user1.setPhone("123123");
		
		HomeAddress address = new HomeAddress();
		address.setArea("West Avennue");
		address.setStreet("Veer Sawarkar Marg");
		address.setSuite("Happy Home");
		address.setCity("Mumbai");
		address.setZip("123123:");
		
		GeoLocation myGeo = new GeoLocation();
		myGeo.setLat("-37.89");
		myGeo.setLng("81");
		
		
		user1.setAddress(address);
		user1.address.setGeo(myGeo);
		
		CompanyDetails comp = new CompanyDetails();
		comp.setName("Oracle");
		comp.setCatchPhrase("Live Life KingSize");
		comp.setCatchPhrase("Just checking..");
		comp.setBs("hey");
		
		user1.setCompany(comp);
		
		userList.add(user1);
		
		return userList;
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

				return new ResponseEntity(HttpStatus.ACCEPTED).ok(response);
				
			}
		}
		MyResponse response2 = 
				new MyResponse(savAccToUpdate, "Savings Account Object Not Found..."+savAccToUpdate.getAccountNumber());

		return new ResponseEntity(HttpStatus.NOT_FOUND).ok(response2);
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
