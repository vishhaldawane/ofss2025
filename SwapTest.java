
public class SwapTest {
	public static void main(String[] args) {
		int x=10;
		int y=20;
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		
		swap(x,y); //call by value
		System.out.println("-- after swap --");
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		
	}
	public static void swap(int a, int b) {
		System.out.println("Swapping....");
		int temp = a;
		a = b;
		b = temp;
		System.out.println("Swapped....");

	}
}
