//Assignment: do the IntegerPair activity for following types
//float, String, double, char, class Song{title,artist,album,year}
public class SwapTest2 {
	public static void main(String[] args) {
		IntegerPair intPair = new IntegerPair(10, 20);
		intPair.print();
		intPair.swap();
		intPair.print();
		
		System.out.println("----------");
		
		FloatPair floatPair = new FloatPair(10.5f, 20.5f);
		floatPair.print();
		floatPair.swap();
		floatPair.print();
		
		System.out.println("----------");
		
		StringPair stringPair = new StringPair("Robert","Julia");
		stringPair.print();
		stringPair.swap();
		stringPair.print();
		
		System.out.println("----------");
		
		CharacterPair charPair = new CharacterPair('Y', 'N');
		charPair.print();
		charPair.swap();
		charPair.print();
		System.out.println("----------");

		Song s1 = new Song("My Heart Will Go On", "Celine D", "Titanic", 1996);
		Song s2 = new Song("Kolavari", "Dhanush", "3", 2014);
		
		SongPair songPair = new SongPair(s1,s2);
		songPair.print();
		songPair.swap();
		songPair.print();
		
		
		
		
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

class SongPair
{
	Song x;	Song y;
	
	SongPair(Song x, Song y) {
		this.x = x;	this.y = y;
	}
	public void swap() {
		System.out.println("Swapping....");
		Song temp = x;	x = y; y = temp;
		System.out.println("Swapped....");
	}
	public void print() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);	
	}
}

class FloatPair
{
	float x;	float y;
	
	FloatPair(float x, float y) {
		this.x = x;	this.y = y;
	}
	public void swap() {
		System.out.println("Swapping....");
		float temp = x;	x = y; y = temp;
		System.out.println("Swapped....");
	}
	public void print() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);	
	}
}

class StringPair
{
	String x;	String y;
	
	StringPair(String x, String y) {
		this.x = x;	this.y = y;
	}
	public void swap() {
		System.out.println("Swapping....");
		String temp = x;	x = y; y = temp;
		System.out.println("Swapped....");
	}
	public void print() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);	
	}
}



class CharacterPair
{
	char x;	char y;
	
	CharacterPair(char x, char y) {
		this.x = x;	this.y = y;
	}
	public void swap() {
		System.out.println("Swapping....");
		char temp = x;	x = y; y = temp;
		System.out.println("Swapped....");
	}
	public void print() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);	
	}
}


//Song s3 = new Song("I want it that way","Backstreet Boys", "Backstreet Boys", 1998);
//Song s4 = new Song("Kolavari", "Dhanush", "3", 2014);
//Song s5 = new Song("Lungi Dance", "Honey Singh","Chennai Express", 2019);

