package java8Practice.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeTesting {

	private static String startTime;
	private static String endTime;
	private static String startDate = "01/04/2020";
	private static String endDate = "01/04/2020";
	private static String DEFAULT_START_TIME = "00:00:00";
	private static String DEFAULT_END_TIME = "00:59:59";
	private static boolean sliceNeeded = true;

	public static void main(String[] args) {
		if (sliceNeeded) {
			long days = getDaysBetweenDates(startDate, endDate);
			String initialStartDate = startDate;
			endTime = "00:59:59";
			for (long j = 0; j <= days; j++) {
				startDate = addDaysAndGet(initialStartDate, j);
				endDate = startDate;
				for (int i = 0; i < 24; i++) {
					StringBuilder sb = new StringBuilder();
					int val = Integer.valueOf(DEFAULT_START_TIME.split(":")[0]) + i;
					sb.append(val < 10 ? "0" + val : val);
					startTime = sb.toString() + ":00:00";
					endTime = sb.toString() + ":59:59";
					processRecords();
				}
			}
		} else {
			startTime = DEFAULT_START_TIME;
			endTime = DEFAULT_END_TIME;
			processRecords();
		}

	}

	private static void processRecords() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(startDate, dtf);
		LocalDate date2 = LocalDate.parse(endDate, dtf);
		System.out.println("Record processed from " + startDate + " " + startTime + " to " + endDate + " " + endTime);
	}

	public static String addDaysAndGet(String initialStartDate, long j) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(initialStartDate, dtf);
		return date1.plusDays(j).format(dtf);
	}

	public static long getDaysBetweenDates(String startDate, String endDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(startDate, dtf);
		LocalDate date2 = LocalDate.parse(endDate, dtf);
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		return daysBetween;
	}

}
