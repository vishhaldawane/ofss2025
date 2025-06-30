public class FinalFieldTest {
	public static void main(String[] args) {
		final float PI=3.14f; //local variable
		Circle circle1 = new Circle(15.3f); // radius=15.3 + PI=3.14
		Circle circle2 = new Circle(24.2f); // radius=24.2 + PI=3.14
		Circle circle3 = new Circle(53.6f); // radius=53.6 + PI=3.14
		circle1.showCircle(); circle1.calculateArea();
		circle2.showCircle(); circle2.calculateArea();
		circle3.showCircle(); circle3.calculateArea();
	}
}
class Circle //Car
{
	float radius;
	private final float PI=3.14f; //field numberPlate
	
	Circle(float r) {
		radius = r;
		//PI=3.18f;
	}
	void showCircle()
	{
		System.out.println("Circle radius : "+radius);
	}
	void calculateArea() {
		float area = PI * radius * radius;
		System.out.println("Area of circle : "+area);
	}
}
