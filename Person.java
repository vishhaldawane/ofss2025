class Person implements Reactive {
	char gender;	String name;	int age;
	
	public Person(char gender, String name, int age) {
		super();
		this.gender = gender;		this.name = name;		this.age = age;
	}
	void showPerson() {
		System.out.println("Gender : "+gender);
		System.out.println("Name   : "+name);
		System.out.println("Age    : "+age);
	}
	
	public void react() {
		System.out.println("Person is reacting....");
	}
}