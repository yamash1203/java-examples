package me.examples;

import java.time.OffsetDateTime;
import java.time.ZoneId;

public class DateTimeExample {
    public static void main(String[] args) {
        System.out.println("System Default ZoneId=" + ZoneId.systemDefault());

        var zoneId = ZoneId.of("Asia/Tokyo");
        System.out.println("ZoneId=" + zoneId);

        var offsetDateTime = OffsetDateTime.parse("2021-01-27T16:16:28Z");
        System.out.println("OffsetDateTime(UTC)=" + offsetDateTime);

        var zonedDateTime = offsetDateTime.atZoneSameInstant(zoneId);
        System.out.println("ZonedDateTime(" + zoneId + ")=" + zonedDateTime);

        var localDateTime = offsetDateTime.toLocalDateTime();
        System.out.println("LocalDateTime=" + localDateTime);
    }
}
