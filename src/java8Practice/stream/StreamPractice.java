package java8Practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(14, 2, 3, 4, 5, 6);
		System.out.println(reverse(1534236469));
		Stream<Integer> s = list.stream();
		List<Integer> l2 = s.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l2);

		List<Integer> l3 = list.stream().map(i -> i * 3).collect(Collectors.toList());
		System.out.println(l3);

		List<Integer> l1 = l3.stream().sorted().collect(Collectors.toList());
		System.out.println(l1);
		System.out.println(l1.stream().filter(i -> i % 2 == 0).count());
		System.out.println(l1.stream().mapToInt(i -> i).min().getAsInt());
		System.out.println(l1.stream().min((i1, i2) -> i1.compareTo(i2)).get());
		System.out.println(l1.stream().max((i1, i2) -> i1.compareTo(i2)).orElseThrow(() -> new RuntimeException()));
		int[] op = l1.stream().mapToInt(i1 -> i1).toArray();
		System.out.println(Arrays.toString(op));
		// interface IntFunction<R> { R apply(int i);}
		IntFunction<Integer[]> i = Integer[]::new;
		Integer[] ar = l1.stream().toArray(i);
		System.out.println(Arrays.toString(ar));
		IntStream.of(1, 2, 3, 4).forEach(System.out::println);
		System.out.println(Stream.of(ar).map(w -> w * 3).collect(Collectors.toList()));
	}

	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			int num = x % 10;
			res = res * 10 + num;
			x = x / 10;
			if (res > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return (int) res;
	}

}
