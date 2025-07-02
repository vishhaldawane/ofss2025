
public class MethodChaniningTest {
	public static void main(String[] args) {
		Cow cow = new Cow();
		Milk milk = cow.milkACow();
		Curd curd = milk.coagulate();
		Butter butter = curd.churn();
		ClarifiedButter clarifiedButter = butter.boil();
		clarifiedButter.fun();
		System.out.println("----");
		ClarifiedButter cl1 = new Cow().milkACow().coagulate().churn().boil();
		cl1.fun();
		System.out.println("----");

		new Cow().milkACow().coagulate().churn().boil().fun();
		System.out.println("----");

		new Cow().milkACow().makeMilkShake("mango").drink();
	}
}

class Cow
{
	Milk milkACow() {
		return new Milk();
	}
}
class Milk
{
	Curd coagulate() {
		return new Curd();
	}
	MilkShake makeMilkShake(String fruit) {
		return new MilkShake(fruit);
	}
}
class MilkShake
{
	String fruit;
	MilkShake(String fruit) {
		this.fruit=fruit;
	}
	void drink() {
		System.out.println("Having "+fruit+" milkshake");
	}
}
class Curd
{
	Butter churn() {
		return new Butter();
	}
}
class Butter
{
	ClarifiedButter boil() {
		return new ClarifiedButter();
	}
}
class ClarifiedButter
{
	void fun() {
		System.out.println("Its good to eat clarified butter....");
	}
}
