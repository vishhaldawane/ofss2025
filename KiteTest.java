
public class KiteTest {
	public static void main(String[] args) {
		
		//Kite.kiteCount=9;
		
		//how many objects are there
		Kite.showKiteCount();
		
		Kite kite1 = new Kite("Red","100m","Harshil",true);
		Kite kite2 = new Kite("Green","200m","Akshay",true);
		Kite kite3 = new Kite("Yellow","300m","Naman",true);
		
		Kite.showKiteCount();

		kite1.showKite();
		kite2.showKite();
		kite3.showKite();
		
		kite1.kiteFight(kite2);
		Kite.showKiteCount();

		//Kite.kiteCount=80;
		

		
	}
}

class Kite
{
	String color;
	String length;
	String owner;
	boolean flying;
	
	private static int kiteCount;
	
	public static void showKiteCount()
	{
		System.out.println("How many kites? "+Kite.kiteCount);

	}
	
	void kiteFight(Kite x) {
		System.out.println(owner +" started kite fight "+x.owner);
		double val = Math.random()%10;
		System.out.println("val : "+val);
		if(val > 0.98) {
			kiteCount--;
			flying=false;
			System.out.println(owner+"'s kite is down...");
		}
		else if(val < 0.021) {
			kiteCount--;
			x.flying=false;
			System.out.println(x.owner+"'s kite is down...");

		}
		else if (val > 0.50 && val < 0.51) {
			kiteCount-=2;
			flying=false;
			x.flying=false;
			System.out.println("Both "+owner+"'s and "+x.owner+" Kites are down...");

		}
	}
	
	public Kite(String color, String length, String owner, boolean flying) {
		super();
		this.color = color;
		this.length = length;
		this.owner = owner;
		this.flying = flying;
		kiteCount++;
	}
	
	void showKite()
	{
		System.out.println(owner +" is flying a "+color+" color kite of length "+length);
	}
	
	
	
}
