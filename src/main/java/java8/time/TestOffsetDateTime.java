package java8.time;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestOffsetDateTime {
	public static void main(String[] args) {

		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		ZoneOffset zoneOffset = offsetDateTime.getOffset();
		System.out.println("Extracted zone offset:" + zoneOffset);
		System.out.println("Current  offset  date-time: " + offsetDateTime);

		OffsetTime ot1 = OffsetTime.now();
		System.out.println("Current  offset  time: " + ot1);

		// a zone offset +01:30
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		System.out.println(offset.getId());
		offset.getAvailableZoneIds().stream().forEach(System.out::print);
		OffsetTime offsetTime = OffsetTime.of(16, 40, 28, 0, offset);
		System.out.println(offsetTime);

		ZonedDateTime zdt = ZonedDateTime.of(2019, 8, 20, 7, 0, 0, 90, ZoneId.of("Europe/London"));
		System.out.println(zdt);

		ZonedDateTime zdt1 = ZonedDateTime.of(2018, 11, 20, 7, 0, 0, 90, ZoneId.of("Europe/London"));
		System.out.println(zdt1);

	}
	
	public static String HighAndLow(String numbers) {
	    IntSummaryStatistics summary = Arrays
	      .stream(numbers.split(" "))
	      .collect(Collectors.summarizingInt(n -> Integer.parseInt(n)));
	    return String.format("%d %d", summary.getMax(), summary.getMin());
	  }

	public static String highAndLow(String numbers) {
		int big = 0, small = 0;
		Scanner ss = new Scanner(numbers);
		ss.useDelimiter(Pattern.compile("\\s"));
		if (ss.hasNext())
			big = small = ss.nextInt();
		while (ss.hasNext()) {
			int tmp = ss.nextInt();
			if (tmp > big)
				big = tmp;
			if (tmp < small)
				small = tmp;
		}
		return big + " " + small;
	}
}
