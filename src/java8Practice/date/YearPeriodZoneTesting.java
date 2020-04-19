package java8Practice.date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class YearPeriodZoneTesting {
	public static void main(String[] args) { 
		Year year = Year.of(2024);
		System.out.println(year.isLeap());
		System.out.println(year.isBefore(Year.now()));
		Period period = Period.between(LocalDate.of(1989, Month.DECEMBER, 14), LocalDate.now());
		System.out.println(
				period.getYears() + ", " + period.getMonths() + ", " + period.getDays() + " ," + period.getUnits());

		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		System.out.println("-------------------------");
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		ZoneId zoneId = ZoneId.of("America/Los_Angeles");
		ZonedDateTime america = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), zoneId);
		System.out.println(america);
	}
}
