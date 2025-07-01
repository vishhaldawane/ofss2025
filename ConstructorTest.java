//create Employee (basic,hra gross, pf, net)  as a child of Student, 
//create Executive(da) as a child of Employee
//create Manager (ta)   as a child of Executive
//create Director(profit and loss)  as a child of Manager

//hra = house rent allowance, da = dearness , ta = travel

public class ConstructorTest {
	public static void main(String[] args) {
		Person person = new Person('F',"Sheela",19);
		person.showPerson();	
		System.out.println("===========================");
		Student student  = new Student('M',"Jack",20,535,"Vidyalankar","BE-IT",92);
		student.showStudent();
	}
}
