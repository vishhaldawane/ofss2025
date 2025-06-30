//Cannot override the final method from Doctor

//The type Surgeon cannot subclass the final class Doctor
public class Surgeon extends Doctor {
	void diagnose() { //overridden
		System.out.println("Surgeon is diagnosing...with CTScan/Xray..");
	}
	void doSurgery() {
		System.out.println("Surgeon is doing surgery...ß");
	}
}
