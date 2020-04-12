package java8Practice.model;

public class Student {
	private String name;
	private int marks;

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public Student() {
		System.out.println("Student default constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
