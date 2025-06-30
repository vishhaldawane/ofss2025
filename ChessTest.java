
public class ChessTest {
	public static void main(String[] args) {
		
	//	Chess chess = new ChessWithKid();
	//	chess.moveMyKnight();
		
		final float PI=3.14f;//local final value 
		
		
	}
}

final class Chess
{
	public final void moveKnight() {
		System.out.println("Moving the knight in L shape 2.5 steps...");
	}
}

class ChessWithKid //extends Chess
{
	//Cannot override the final method from Chess
	public void moveMyKnight() {
		System.out.println("Moving the knight in S+L shape 2.5 steps...");
	}
}








