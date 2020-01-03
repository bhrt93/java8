package java8.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TestLocalDateTime {
	public void testLocalDateTime() {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		System.out.println("Month: " + month + "day: " + day + "seconds: " + seconds);
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);
		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);
		// 22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
		// parse a string
		LocalTime date5 = LocalTime.parse("23:59:30");
		LocalTime date6 = LocalTime.parse("00:05:30");
		LocalTime now = LocalTime.now();
		System.out.println("duration="+Duration.between(date6, date5));
		System.out.println("duration="+Duration.between(date5, date6));
		System.out.println("now: " + now);
	}
	public static void main(String[] args) {
		TestLocalDateTime t = new TestLocalDateTime();
		t.testLocalDateTime();
	}
}
