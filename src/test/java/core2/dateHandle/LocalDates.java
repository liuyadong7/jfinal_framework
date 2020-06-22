package core2.dateHandle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDates {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println("today:" + today);

        LocalDate aBirthday = LocalDate.of(1995, 11, 24);
        System.out.println("aBirthday:" + aBirthday);

        aBirthday = LocalDate.of(2020, Month.JUNE, 22);
        System.out.println("aBirthday:" + aBirthday);

        LocalDate programmersDay = LocalDate.of(2018, 1, 1);
        programmersDay = programmersDay.plusDays(255);
        System.out.println("programmers:" + programmersDay);

        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 4);
        LocalDate christmas = LocalDate.of(2018, Month.DECEMBER, 25);
        System.out.println("Until christmas: " + independenceDay.until(christmas));
        System.out.println("Until christmas: " + independenceDay.until(christmas, ChronoUnit.DAYS));

        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));

        // 得到周几
        DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOfLastMillennium:" + startOfLastMillennium);
        System.out.println(startOfLastMillennium.getValue());

        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }

}
