package java8Practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		Stream<Integer> s = list.stream();
		List<Integer> l2 = s.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l2);

		List<Integer> l3 = list.stream().map(i -> i * 2).collect(Collectors.toList());
		System.out.println(l3);

	}

}
