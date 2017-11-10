package com.reactiveworks.learning.timeanddateapi;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LocalDateAndTime {
	static Logger logger=Logger.getLogger(LocalDateTime.class);
public void testLocalDateAndTime(){
	LocalDateTime currentDateTime=LocalDateTime.now();
	logger.debug("currentDateTime---> "+currentDateTime);
	LocalDate date1=currentDateTime.toLocalDate();
	logger.debug("date1---> "+date1);
	Month month=currentDateTime.getMonth();
	int day=currentDateTime.getDayOfMonth();
	int seconds=currentDateTime.getSecond();
	logger.debug("month: "+month+", day: "+day+", seconds: "+seconds);
	LocalDateTime date2=currentDateTime.withDayOfMonth(10).withYear(2009).withDayOfMonth(12);
	logger.debug("date2: "+date2);
	LocalDate localDateCurrent=LocalDate.now();
	logger.debug("localDateCurrent---> "+localDateCurrent);
	int year=localDateCurrent.get(ChronoField.YEAR);
	logger.debug("year:: "+year);
	LocalTime localTime=LocalTime.of(13,45,30);
	logger.debug("localTime:: "+localTime);
	LocalTime currentLocalTime=LocalTime.now();
	logger.debug("currentLocalTime:: "+currentLocalTime);
	
	/*int dayInstant=Instant.now().get(ChronoField.DAY_OF_MONTH);---> Throw Exception java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
	logger.debug("dayInstant----> "+dayInstant);*/
}

public void testDateAndTimeZone(){
	LocalDateTime currentDateTime=LocalDateTime.now();
	logger.debug("currentDateTime---> "+currentDateTime);
	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String currentFormatDateTime=currentDateTime.format(dateTimeFormatter);
	logger.debug("currentFormatDateTime----> "+currentFormatDateTime);
    ZoneId zoneIdParis=ZoneId.of("Europe/Paris");
    logger.debug("zoneIdParis:: "+zoneIdParis);
    ZoneId currentZoneId=ZoneId.systemDefault();
    logger.debug("currentZoneId---> "+currentZoneId);
    LocalDateTime currentDateTimeForParis=LocalDateTime.now(zoneIdParis);
    String currentFormatDateTimeParis=currentDateTimeForParis.format(dateTimeFormatter);
    logger.debug("currentDateTimeForParis---> "+currentDateTimeForParis);
    MonthDay monthDay=MonthDay.now();
    logger.debug("monthDay:: "+monthDay);
    LocalDate atYear = monthDay.atYear(19992);
    logger.debug("atYear:: "+atYear);
   
	
	
}
public void testDurationAndTime(){
	Period periodOfdays=Period.between(LocalDate.of(1993,12,12),LocalDate.of(2017,10,26));
	logger.debug("periodOfdays----> "+periodOfdays);
	
	//Creating Duration and Periods
	Duration threeMinutes=Duration.ofMinutes(3);
	logger.debug("threeMinutes---> "+threeMinutes);
	Period twoYearsSixMonthsOneDay=Period.of(2,6,1);
	logger.debug("twoYearsSixMonthsOneDay---> "+twoYearsSixMonthsOneDay);
}
public void testOffSetTime(){
	OffsetTime offsetTime=OffsetTime.now();
	logger.debug("offsetTime:: "+offsetTime);
	int offsetHour = offsetTime.get(ChronoField.HOUR_OF_DAY);
	logger.debug("offsetHour:: "+offsetHour);
	int minutesOfDay = offsetTime.get(ChronoField.MINUTE_OF_DAY);
	logger.debug("minutesOfDay:: "+minutesOfDay);
	int minutesOfHour = offsetTime.get(ChronoField.MINUTE_OF_HOUR);
	logger.debug("minutesOfHour:: "+minutesOfHour);
	int secondsOfDay = offsetTime.get(ChronoField.SECOND_OF_DAY);
	logger.debug("secondsOfDay:: "+secondsOfDay);
	
	OffsetDateTime offsetDateTime=OffsetDateTime.now();
	logger.debug("offsetDateTime:: "+offsetDateTime);
	int dayOfMonth = offsetDateTime.get(ChronoField.DAY_OF_MONTH);
	logger.debug("dayOfMonth:: "+dayOfMonth);
	OffsetDateTime plusDays = offsetDateTime.plusDays(240);
	logger.debug("plusDays:: "+plusDays);
}
public void testClock(){
	Clock clock=Clock.systemUTC();
	logger.debug("clock:::: "+clock.instant());
}
public void testZoneDateTime(){
	ZonedDateTime zonedDateTime=ZonedDateTime.now();
	logger.debug("zonedDateTime:: "+zonedDateTime);
	ZonedDateTime p=zonedDateTime.plus(Period.ofDays(126));
	logger.debug("p:: "+p);
}
public void testZoneId(){
	ZoneId.getAvailableZoneIds().forEach(zi->logger.debug("ZoneId:: "+zi));
	ZonedDateTime zonedDateTime=ZonedDateTime.now(Clock.systemUTC());
	logger.debug("Date Time In UTC:: "+zonedDateTime);
	
}
public void testZoneOffset(){
	ZoneOffset zoneOffset=ZoneOffset.UTC;
    Temporal temp=zoneOffset.adjustInto(ZonedDateTime.now());
    logger.debug("temp:: "+temp);

}
public static void main(String[] args) {
	LocalDateAndTime localDateAndTime=new LocalDateAndTime();
	localDateAndTime.testLocalDateAndTime();
	localDateAndTime.testDateAndTimeZone();
	localDateAndTime.testDurationAndTime();
	localDateAndTime.testOffSetTime();
	localDateAndTime.testClock();
	localDateAndTime.testZoneDateTime();
	localDateAndTime.testZoneId();
	localDateAndTime.testZoneOffset();
	
}
}
