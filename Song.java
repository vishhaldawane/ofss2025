
public class Song implements Comparable<Song>{

	String title;
	String artist;
	String album;
	int year;
	
	/*@Override
	public int compareTo(Song anotherSong) {
		System.out.println("Comparing "+title+ " with "+anotherSong.title);
		return title.compareTo(anotherSong.title);
	}*/
	
	@Override
	public int compareTo(Song anotherSong) {
		System.out.println("Comparing "+year+ " with "+anotherSong.year);
		return Integer.compare(year, anotherSong.year);
	}
	
	
	public Song(String title, String artist, String album, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + "]";
	}


	
}
