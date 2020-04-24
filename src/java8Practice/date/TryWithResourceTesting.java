package java8Practice.date;

import java.util.Scanner;

public class TryWithResourceTesting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (Scanner sc1 = sc) {
			System.out.println("Enter something to echo :");
			String s = sc.nextLine();
			System.out.println(s);
		}
	}
}
