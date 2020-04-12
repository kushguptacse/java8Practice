package java8Practice;

import java.util.stream.IntStream;

import java8Practice.model.Employee;
import java8Practice.model.Student;

/**
 * Lambda Expression can be replaced by method reference.
 * The argument must match to be able to invoke method reference.
 * You can assign method reference to Functional interface reference variable only.
 * 
 * @f:off
 * 
 * Method Reference - 
 * instance::methodName
 * 
 * Static Method Reference - 
 * ClassName::methodName
 * 
 * Constructor Reference -
 * ClassName::new
 * 
 * @f:on
 * 
 * @author G521885
 */
public class MethodReferenceTesting {
	public static void main(String[] args) {

		Runnable runnable = MethodReferenceTesting::print;
		new Thread(runnable).start();

		MethodReferenceTesting t = new MethodReferenceTesting();
		Runnable r2 = () -> t.second();// above line can be replaced with method reference.
		runnable = t::second;// it just check that second method argument must match run method. return type,
								// access modifier does not matter
		new Thread(runnable).start();
		System.out.println();

		// must be a functional interface.
		StudentDefault e = Student::new;
		System.out.println("Testing Student Constructor reference");
		// constructor will get invoked after calling below method.
		Student student = e.getInstance();// getInstance must have same number of arguments as inside constructor which
											// we wanted to invoke
		System.out.println(student);

		EmployeeInf e1 = Employee::new;
		System.out.println("Testing Employee Constructor reference");
		// since we wanted to call Constructor of Employee. so we matched arguments of
		// get method of interface with constructor
		Employee employee = e1.get("kush", 300, "ghaziabad", "sse");
		System.out.println(employee);

	}

	private Integer second() {
		System.out.println("Inside second method");
		return 0;
	}

	private static void print() {
		IntStream.range(0, 5).forEach(System.out::print);
		System.out.println();
	}

}

interface EmployeeInf {
	Employee get(String name, double salary, String city, String designation);
}

interface StudentDefault {
	Student getInstance();
}