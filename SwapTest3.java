//Assignment: do the IntegerPair activity for following types
//float, String, double, char, class Song{title,artist,album,year}
public class SwapTest3 {
	public static void main(String[] args) {
		AnyPair<Integer> intPair = new AnyPair<Integer>(10, 20);
		intPair.print();
		intPair.swap();
		intPair.print();
		
		System.out.println("----------");
		
		AnyPair<Float> floatPair = new AnyPair<Float>(10.5f, 20.5f);
		floatPair.print();
		floatPair.swap();
		floatPair.print();
		
		System.out.println("----------");
		
		AnyPair<String> stringPair = new AnyPair<String>("Robert","Julia");
		stringPair.print();
		stringPair.swap();
		stringPair.print();
		
		System.out.println("----------");
		
		AnyPair<Character> charPair = new AnyPair<Character>('Y', 'N');
		charPair.print();
		charPair.swap();
		charPair.print();
		System.out.println("----------");

		Song s1 = new Song("My Heart Will Go On", "Celine D", "Titanic", 1996);
		Song s2 = new Song("Kolavari", "Dhanush", "3", 2014);
		
		AnyPair<Song> songPair = new AnyPair<Song>(s1,s2);
		songPair.print();
		songPair.swap();
		songPair.print();
		
		
		
		
	}
	
}
//In C++ it is known as Template class
//In java it is known as Generic class

class AnyPair<T>
{
	T x;	T y;
	
	AnyPair(T x, T y) {
		this.x = x;	this.y = y;
	}
	public void swap() {
		System.out.println("Swapping....");
		T temp = x;	x = y; y = temp;
		System.out.println("Swapped....");
	}
	public void print() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);	
	}
}

