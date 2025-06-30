
public class FinalMethodTest {
	public static void main(String[] args) {
		
		Doctor x = new Doctor();
		x.diagnose();
		
		System.out.println("-------");
		
		Surgeon y = new Surgeon();
		y.diagnose();
		y.doSurgery();
		
		System.out.println("-------");

		HeartSurgeon z = new HeartSurgeon();
		z.diagnose();
		z.doSurgery();
		
		System.out.println("========now see this==============");
		//a super class reference can point to 
		//any child object
		Doctor doctorRef = new Doctor();
		doctorRef.diagnose();
		
		doctorRef = new Surgeon();
		doctorRef.diagnose(); //overriding
//		doctorRef.doSurgery();
		
		doctorRef = new HeartSurgeon();
		doctorRef.diagnose(); // overriding
//		doctorRef.doSurgery();
		
		
	}
}
