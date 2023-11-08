package edu.wgu.d387_sample_code.i18n;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class TimeConversions {

    public String[] convertTime() {
        String[] TimeZones = new String[3];
        ZoneId EasternZone = ZoneId.of("America/New_York");
        ZoneId MountainZone = ZoneId.of("America/Denver");
        ZoneId UniversalZone = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local time " + localDateTime.toString());
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeUniversal = zonedDateTime.withZoneSameInstant(UniversalZone);
        LocalDateTime localDateTimeUniversal = zonedDateTimeUniversal.toLocalDateTime();
         DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm:ss a");
         TimeZones[0] = ((localDateTimeUniversal.format(formatter1)) + " UCT");
        //TimeZones[0] = localDateTimeUniversal.toString();
         //LocalDateTime parsedDate = LocalDateTime.parse(TimeZones[0], formatter);

        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(EasternZone);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh:mm:ss a");
        TimeZones[1] = ((localDateTimeEastern.format(formatter2)) + " EST");
        //TimeZones[1] = localDateTimeEastern.toString();

        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(MountainZone);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("hh:mm:ss a");
        TimeZones[2] = ((localDateTimeMountain.format(formatter3)) + " MT");
        //TimeZones[2] = localDateTimeMountain.toString();

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss z");
        //TimeZones[0] = localDateTimeUniversal.format(formatter);
        //TimeZones[1] = localDateTimeEastern.format(formatter);
        //TimeZones[2] = localDateTimeMountain.format(formatter);
        return TimeZones;
    }
}
