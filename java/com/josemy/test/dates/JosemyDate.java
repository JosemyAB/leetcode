package dates;

import java.time.LocalDate;

public class JosemyDate {

    public static int dayOfYearCumulative(int year, int month, int day) {

        int[] cumulativeDays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        if (month < 1 || month > 12) {
            throw  new IllegalArgumentException("Bad month");
        }

        int result = cumulativeDays[month - 1] + day;

        //Handle leap year
        if (month > 2 && leapYear(year)) {
            return result + 1;
        }
        return result;
    }

    public static int dayOfYearArray(int year, int month, int day) {
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int accumulatedDays = 0;
        for (int i = 0; i < month; i++) {
            accumulatedDays+=daysPerMonth[i];
        }

        if (month > 2 && leapYear(year)) {
            return accumulatedDays + 1;
        }
        return accumulatedDays;
    }

    public static int dayOfYearJavaSupport(int year, int month, int day) {
        return LocalDate.of(year, month, day).getDayOfYear();
    }

    /**
     * Leap year calculation
     * Rules:
     * - Divisible by 4: leap year
     * - EXCEPT divisible by 100: not a leap year
     * - EXCEPT divisible by 400: leap year
     */
    public static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
