package java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import java8Practice.model.Employee;

public class ConsumerTesting {

	public static void main(String[] args) {
		List<Employee> list = prepareEmployeeData();
		// function predicate to get total salary of employee
		Function<List<Employee>, Double> totalSalary = inputs -> {
			double res = 0d;
			for (Employee employee : inputs) {
				res += employee.getSalary();
			}
			return res;
		};

		Double total = totalSalary.apply(list);
		System.out.println("Total Salary of employees :" + total);

		// chaining andthen example
		Function<String, String> trimFunction = s -> s.substring(0, 5);
		Function<String, String> upperCaseFunction = s -> s.toUpperCase();
		String result = trimFunction.andThen(upperCaseFunction).apply("JavaPractice");
		System.out.println("output after andthen- " + result);
		System.out.println("output after compose- " + trimFunction.compose(upperCaseFunction).apply("JavaPractice"));
		Function<Employee, Double> sum = e -> e.getSalary() + e.getSalary();
		Function<Double, Double> square = d -> d * d;
		Double res = sum.andThen(square).apply(new Employee("test", 2, "noida", "QA"));
		System.out.println(res);

		//difference between sum and square
		Function<Integer,Integer> sum1 = i->i+i;
		Function<Integer,Integer> square1 = i->i*i;
		System.out.println(sum1.andThen(square1).apply(2));
		System.out.println(sum1.compose(square1).apply(2));
		
		// in identity method <T,R> both must be same as it return same value bak as passed
		Function<Employee,Employee> function = Function.identity();
		Employee e = function.apply(new Employee("test", 2, "noida", "QA"));
		System.out.println(e);
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

}
