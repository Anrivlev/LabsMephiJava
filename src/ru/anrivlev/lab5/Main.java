package ru.anrivlev.lab5;

import java.io.*;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void taskArrayIndexOutOfBoundsException() {
        int[] myArray = new int[10];
        try {
            int a = myArray[11];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskFileNotFoundException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskNullPointerException() {
        try {
            Object a = null;
            System.out.println(a.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskIOException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String a = reader.readLine();
            System.out.println(a);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskClassCastException() {
        int a = 1;
        Object c = "line";
        try {
            a = a + (int) c;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskArithmeticException() {
        int a = 17;
        int b = 0;
        try {
            a = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void infiniteObjects() {
        Object[] objects = new Object[Integer.MAX_VALUE];
        infiniteObjects();
    }

    public static void taskOutOfMemoryError() {
        try {
            infiniteObjects();
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void infiniteLoop() {
        infiniteLoop();
    }

    public static void taskStackOverflowError() {
        try {
            infiniteLoop();
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskLincoln() {
        LocalDate birthDate = LocalDate.of(1809, 2, 12);
        LocalDate deathDate = LocalDate.of(1855, 4, 15);
        System.out.println("Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855");
        System.out.println("How old was he when he died?");
        System.out.println(ChronoUnit.YEARS.between(birthDate, deathDate));
        System.out.println("How many days did he live?");
        System.out.println(ChronoUnit.DAYS.between(birthDate, deathDate));
    }

    public static void taskCumberbatch() {
        LocalDate birthDate = LocalDate.of(1976, 7, 19);
        LocalDate today = LocalDate.now();
        System.out.println("Bennedict Cumberbatch, July 19, 1976");
        System.out.println("Born in a leap year?");
        System.out.println(birthDate.isLeapYear());
        System.out.println("How many days in the year he was born?");
        System.out.println(Year.of(birthDate.getYear()).length());
        System.out.println("How many decades old is he?");
        System.out.println(ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("What was the day of the week on his 21st birthday?");
        System.out.println(birthDate.plusYears(21).getDayOfWeek());
    }

    public static void taskTrain() {
        LocalTime departure = LocalTime.of(13, 45);
        LocalTime arrival = LocalTime.of(19, 25);
        System.out.println("Train departs Boston at 1:45PM and arrives New York 7:25PM");
        System.out.println("How many minutes long is the train ride?");
        System.out.println(ChronoUnit.MINUTES.between(departure, arrival));
        System.out.println("If the train was delayed 1 hour 19 minutes, what is the actual arrival time?");
        System.out.println(arrival.plusHours(1).plusMinutes(19));
    }
    public static void taskFlight() {
        LocalDateTime departure = LocalDateTime.of(LocalDate.of(LocalDate.now().getYear(), 3, 24), LocalTime.of(21, 15));
        LocalDateTime arrival = departure.plusHours(4).plusMinutes(15);
        System.out.println("Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes");
        System.out.println("When does it arrive in Miami?");
        System.out.println(arrival);
        System.out.println("When does it arrive if the flight is delays 4 hours 27 minutes?");
        System.out.println(arrival.plusHours(4).plusMinutes(27));

    }
    public static void taskSchool() {
        LocalDate today = LocalDate.now();
        LocalDate semesterStart = LocalDate.of(today.getYear(), 9, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
        LocalDate vacationStart = LocalDate.of(today.plusYears(1).getYear(), 6, 25);
        LocalDate lastTuesday = vacationStart.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
        long weeksBetween = ChronoUnit.WEEKS.between(semesterStart, lastTuesday);
        long summerExtraDays = ChronoUnit.DAYS.between(lastTuesday, vacationStart);
        System.out.println("School semester starts the second Tuesday of September of this year.");
        System.out.println("What is the date?");
        System.out.println(semesterStart);
        System.out.println("School summer vacation starts June 25th");
        System.out.println("Assuming:");
        System.out.println("*  Two weeks off in December");
        System.out.println("*  Two other vacation weeks");
        System.out.println("*  School is taught Monday - Friday");
        System.out.println("How many days of school are there?");
        System.out.println((weeksBetween - 4) * 5 + summerExtraDays);

    }
    public static void taskMeeting() {
        LocalDate today = LocalDate.now();
        LocalDateTime meeting = LocalDateTime.of(today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)),
                LocalTime.of(13, 30));
        System.out.println("A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.");
        System.out.println("What is the time of the week's meetings?");
        System.out.println(meeting);
    }
    public static void taskFlight123() {
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(LocalDate.of(2014, 6, 13),
                LocalTime.of(22,30), SFO);
        System.out.println("Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014");
        System.out.println("The flight is 5 hours 30 minutes");
        System.out.println("What is the local time in Boston when the flight takes off?");
        System.out.println(departure.withZoneSameInstant(BOS));
        System.out.println("What is the local time at Boston Logan airport when the flight arrives?");
        System.out.println(departure.plusHours(5).plusMinutes(30).withZoneSameInstant(BOS));
        System.out.println("What is the local time in San Francisco when the flight arrives?");
        System.out.println(departure.plusHours(5).plusMinutes(30));
    }
    public static void taskFlight456() {
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");
        ZonedDateTime departure = ZonedDateTime.of(LocalDate.of(2014, 6, 28), LocalTime.of(22, 30), SFO);
        ZonedDateTime meeting = ZonedDateTime.of(LocalDate.of(2014, 6, 30), LocalTime.of(9, 0), BLR);
        ZonedDateTime arrival = departure.plusHours(22).withZoneSameInstant(BLR);
        System.out.println("Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014");
        System.out.println("The flight time is 22 hours");
        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time?");
        System.out.println(arrival.isBefore(meeting));
        System.out.println("Can the traveler call her husband at a reasonable time when she arrives?");
        long hourInSFO = arrival.withZoneSameInstant(SFO).getHour();
        if (hourInSFO < 22 && hourInSFO >= 8) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void taskFlight123second() {
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(LocalDate.of(2014, 11, 1), LocalTime.of(22, 30), SFO);
        System.out.println("Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014");
        System.out.println("Flight time is 5 hours 30 minutes.");
        System.out.println("What day and time does the flight arrive in Boston?");
        System.out.println(departure.plusHours(5).plusMinutes(30).withZoneSameInstant(BOS));
        System.out.println("What happened?");
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("EXCEPTIONS\n");
        System.out.println("ArrayIndexOutOfBoundsException:");
        taskArrayIndexOutOfBoundsException();
        System.out.println();
        System.out.println("FileNotFoundException:");
        taskFileNotFoundException();
        System.out.println();
        System.out.println("NullPointerException:");
        taskNullPointerException();
        System.out.println();
        System.out.println("IOException:");
        taskIOException();
        System.out.println();
        System.out.println("ClassCastException:");
        taskClassCastException();
        System.out.println();
        System.out.println("ArithmeticException:");
        taskArithmeticException();
        System.out.println();
        System.out.println("OutOfMemoryError:");
        taskOutOfMemoryError();
        System.out.println();
        System.out.println("StackOverflowError:");
        taskStackOverflowError();
        System.out.println();

        System.out.println("DATES AND TIME\n");
        taskLincoln();
        System.out.println();
        taskCumberbatch();
        System.out.println();
        taskTrain();
        System.out.println();
        taskFlight();
        System.out.println();
        taskSchool();
        System.out.println();
        taskMeeting();
        System.out.println();
        taskFlight123();
        System.out.println();
        taskFlight456();
        System.out.println();
        taskFlight123second();
    }
}
