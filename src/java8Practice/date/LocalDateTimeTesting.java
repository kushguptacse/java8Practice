package java8Practice.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTesting {

	public static void main(String[] args) {
		System.out.println("LocalDate -------------------");
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getMonth());
		System.out.println(date.getMonthValue());
		System.out.println(date.getYear());
		System.out.println(date.getEra());
		System.out.println("LocalTime -------------------");
		LocalTime time = LocalTime.now();
		System.out.println(time);
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
		System.out.println(time.getNano());
		System.out.println("LocalDateTime -------------------");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getMonth());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getYear());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
		System.out.println(ldt.getNano());
		System.out.println("custom -------------------");
		LocalDate ld = LocalDate.of(2020, Month.MAY, 1);
		LocalTime lt = LocalTime.of(11, 55, 20);
		LocalDateTime dateOf = LocalDateTime.of(ld, lt);
		System.out.println(dateOf);
		System.out.println(ld.plusMonths(4));
		System.out.println(ld.plusDays(3));
		System.out.println(dateOf.plusHours(3));
	}
}
