package java8.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class TestTimeClasses {
	public static void main(String[] args) {
		Date a = null;
		if (a instanceof java.util.Date) {
			System.out.println("Yes");
		}
		System.out.println("No");
		LocalDateTime dt1 = LocalDateTime.of(2019, 8, 13, 23, 59, 59, 100);
		LocalDateTime dt2 = LocalDateTime.of(2019, 8, 14, 0, 0, 1, 998);
		LocalTime t1 = LocalTime.of(23, 59, 59, 100);
		LocalTime t2 = LocalTime.of(0, 0, 1, 100);

		System.out
				.println("Initial Epoch (TimeInMillis): " + dt1.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());

		ZonedDateTime zdt1 = ZonedDateTime.of(dt1, ZoneId.of("America/Chicago"));
		ZonedDateTime zdt2 = ZonedDateTime.of(dt1, ZoneId.of("Asia/Kolkata"));
		System.out.println(" " + Duration.between(zdt1, zdt2));

		System.out.println(Duration.between(t1, t2));
		System.out.println(Duration.between(t2, t1));
		System.out.println(Duration.between(dt1, dt2));
		System.out.println(Duration.between(dt2, dt1));
	}
}
