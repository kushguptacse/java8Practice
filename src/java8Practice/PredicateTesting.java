package java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import java8Practice.model.Employee;

/**
 * interface Predicate<T>{ boolean test(T t); }
 * @author G521885
 *
 */
public class PredicateTesting {

	public static void main(String[] args) {
		Predicate<String> testWelcome = Predicate.isEqual("welcome");
		System.out.println(testWelcome.test("welcome"));
		System.out.println(testWelcome.test("hello"));

		List<Employee> list = prepareEmployeeData();
		employeePredicateTest(list);
	}

	private static List<Employee> prepareEmployeeData() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("kush", 20000, "ghaziabad", "developer"));
		list.add(new Employee("luv", 30000, "ghaziabad", "lead"));
		list.add(new Employee("nikhil", 40000, "noida", "manager"));
		list.add(new Employee("paras", 10000, "noida", "developer"));
		list.add(new Employee("narender", 100000, "banglore", "ceo"));
		return list;
	}

	private static void employeePredicateTest(List<Employee> list) {

		Predicate<Employee> developerTest = e -> "developer".equals(e.getDesignation());
		System.out.println("Employee with developer designation is : ");
		display(list, developerTest);

		Predicate<Employee> locationGhaziabadTest = e -> "ghaziabad".equals(e.getCity());
		System.out.println("Employee with Location ghaziabad is : ");
		display(list, locationGhaziabadTest);
		System.out.println("Employee not developer are : ");
		display(list, developerTest.negate());
		System.out.println("Employee location ghaziabad and role developer : ");
		display(list, developerTest.and(locationGhaziabadTest));
		System.out.println("Employee location ghaziabad or role developer : ");
		display(list, developerTest.or(locationGhaziabadTest));

		// equal testing
		Predicate<Employee> ceoPredicate = Predicate.isEqual(new Employee("narender", 100000, "banglore", "ceo"));
		Employee e1 = new Employee("paras", 10000, "noida", "developer");
		// if e1 is same as employee ceo
		System.out.println("Is " + e1 + " ceo of company : " + ceoPredicate.test(e1));
		System.out.println("Employee who's designation is ceo ");
		display(list, ceoPredicate);
	}

	private static void display(List<Employee> list, Predicate<Employee> p) {
		for (Employee e : list) {
			if (p.test(e)) {
				System.out.println(e);
			}
		}
	}

}
