//Assignment: do the IntegerPair activity for following types
//float, String, double, char, class Song{title,artist,album,year}
public class SwapTest2 {
	public static void main(String[] args) {
		IntegerPair intPair = new IntegerPair(10, 20);
		intPair.print();
		intPair.swap();
		intPair.print();
	}
	
}
class IntegerPair
{
	int x;	int y;
	
	IntegerPair(int x, int y) {
		this.x = x;	this.y = y;
	}
	public void swap() {
		System.out.println("Swapping....");
		int temp = x;	x = y; y = temp;
		System.out.println("Swapped....");
	}
	public void print() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);	
	}
}
