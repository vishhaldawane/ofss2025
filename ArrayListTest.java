import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		

		Song s1 = new Song("My Heart Will Go On", "Celine D", "Titanic", 1996);
		Song s2 = new Song("Kolavari", "Dhanush", "3", 2014);
		Song s3 = new Song("I want it that way","Backstreet Boys", "Backstreet Boys", 1998);
		Song s4 = new Song("Kolavari", "Dhanush", "3", 2014);
		Song s5 = new Song("Lungi Dance", "Honey Singh","Chennai Express", 2019);
		System.out.println("x : content is ready....");

		ArrayList<Song> jukeBox = new ArrayList<Song>();
		System.out.println("y: container is ready...");
		
		jukeBox.add(s1);
		jukeBox.add(s2);
		jukeBox.add(s3);
		jukeBox.add(s4);
		jukeBox.add(s5);
		System.out.println("contents are added to the container");
		
		//1. forEach
		//jukeBox.forEach( (theSong)-> { System.out.println(theSong); }  );
		
		//2. stream().forEach()
		//jukeBox.stream().forEach(  (theSong)->System.out.println(theSong) );
		
		//3. 
		/*Iterator<Song> songIterator = jukeBox.iterator();
		while(songIterator.hasNext()) {
			Song theSong = songIterator.next();
			System.out.println("The Song : "+theSong);
		}*/
		
		//4. forEach
	//	for (Song theSong : jukeBox) {
	//		System.out.println(theSong);
	//	}
		
		//5. for loop
	//	for (int i = 0; i < jukeBox.size(); i++) {
	//		Song theSong = jukeBox.get(i);
	//		System.out.println(theSong);
	//	}
		
		//6.
		for (Iterator<Song> iterator = jukeBox.iterator(); iterator.hasNext();  ) {
			Song theSong = (Song) iterator.next();
			System.out.println(theSong);
		}
		
	}
}
