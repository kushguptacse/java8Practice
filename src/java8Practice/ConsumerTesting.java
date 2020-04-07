package java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java8Practice.model.Movie;
import java8Practice.model.Student;

/**
 * interface Consumer<T>{ void accept(T t); }
 * 
 * @author G521885
 *
 */
public class ConsumerTesting {

	public static void main(String[] args) {
		List<Movie> list = prepareMovieData();
		Consumer<Movie> con = c -> System.out
				.println("Movie name: " + c.getName() + " , Result:" + c.getResult() + " , Hero:" + c.getHero());
		Predicate<Movie> p = m -> "hit".equals(m.getResult());
		for (Movie movie : list) {
			if (p.test(movie)) {
				con.accept(movie);
			}
		}
		System.out.println("--------------------------------------");
		List<Student> students = populateStudent();
		testPredicateFunctionConsumer(students);
		System.out.println("---------");
		// consumer chaining
		Consumer<Movie> c1 = m -> System.out.println("Movie " + m.getName() + " is ready to release");
		Consumer<Movie> c2 = m -> System.out
				.println("Movie released with name " + m.getName() + " is " + m.getResult());
		c1.andThen(c2).accept(list.get(0));
	}

	private static void testPredicateFunctionConsumer(List<Student> students) {
		// print records including grades for student whose marks>=60
		Predicate<Student> marksCheck = s -> s.getMarks() > 60;
		Function<Student, String> gradeCheck = s -> {
			if (s.getMarks() >= 80) {
				return "A";
			} else if (s.getMarks() >= 70) {
				return "B";
			} else if (s.getMarks() >= 60) {
				return "C";
			} else {
				return "D";
			}
		};
		Consumer<Student> print = s -> System.out
				.println("Student Name:" + s.getName() + ",Marks:" + s.getMarks() + ",Grade:" + gradeCheck.apply(s));
		for (Student s : students) {
			if (marksCheck.test(s)) {
				print.accept(s);
			}
		}
	}

	private static List<Student> populateStudent() {
		List<Student> l = new ArrayList<>();
		l.add(new Student("Sunny", 100));
		l.add(new Student("Bunny", 65));
		l.add(new Student("Chinny", 55));
		l.add(new Student("Vinny", 45));
		l.add(new Student("Pinny", 25));
		return l;
	}

	private static List<Movie> prepareMovieData() {
		List<Movie> list = new ArrayList<>();
		list.add(new Movie("bahubali", "hit", "prabhas"));
		list.add(new Movie("3 idiots", "hit", "aamir"));
		list.add(new Movie("rock on", "hit", "farhan"));
		list.add(new Movie("Spyder", "flop", "mahesh"));
		return list;
	}

}
