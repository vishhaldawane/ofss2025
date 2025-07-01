
public class Student extends Person {
	int rollNumber;
	String collegeName;String stream;
	double totalMarks;	char grade;

	public Student(char gender, String name, int age, 
			int rollNumber, String collegeName, String stream,double totalMarks){
		super(gender, name, age); //<== invoke super class ctor
		this.rollNumber = rollNumber;
		this.collegeName = collegeName;
		this.stream = stream;
		this.totalMarks = totalMarks;
		if(this.totalMarks >=90 && this.totalMarks<=100)      this.grade='A';
		else if(this.totalMarks >=75 && this.totalMarks<90)   this.grade='B';
		else if(this.totalMarks >=60 && this.totalMarks<75)   this.grade='C';
		else if(this.totalMarks >=45 && this.totalMarks<60)   this.grade='D';
		else if(this.totalMarks >=35 && this.totalMarks<45)   this.grade='E';
		else if(this.totalMarks >=0 && this.totalMarks<35)    this.grade='F';
	}
	void showStudent() {
		super.showPerson(); //<== resuse the super class function
		System.out.println("RollNo : "+rollNumber);
		System.out.println("-------------------------");
		System.out.println("College: "+collegeName);System.out.println("Stream : "+stream);
		System.out.println("-------------------------");
		System.out.println("Marks  : "+totalMarks);System.out.println("Grade  : "+grade);
		System.out.println("-------------------------");
	}
	
}
