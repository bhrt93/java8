package java8.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

public class TestClock {

	private void printClockTimeOptions() {

		// create a base Clock with systemUTC() method
		Clock utcClock = Clock.systemUTC();
		Clock systemClock = Clock.systemDefaultZone();

		System.out.println("UTC=                    " + ZonedDateTime.now(utcClock));
		System.out.println("System=                 " + ZonedDateTime.now(systemClock));

		System.out
				.println(ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).distinct().collect(Collectors.toList()));

		ZoneId zoneBerlin = ZoneId.of("Europe/Berlin");
		Clock clockBerlin = Clock.system(zoneBerlin);
		System.out.println("clockBerlin instant= " + clockBerlin.instant());

		Clock fixedClock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("America/Chicago"));
		System.out.println("fixedClock=             " + fixedClock);

		Clock offsetClock = Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(72));
		System.out.println("offset(+72H)=           " + offsetClock.instant());

		// result clock will be same as baseClock
		offsetClock = Clock.offset(Clock.systemDefaultZone(), Duration.ZERO);

	}

	public static void main(String[] args) {
		TestClock testClock = new TestClock();
		testClock.printClockTimeOptions();
		System.out.println("END");
	}
}
