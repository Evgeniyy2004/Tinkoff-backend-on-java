package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static List<Date> allFridays13th(int year) {
        List<Date> result = new ArrayList<>();
        if (year < 0) {
            throw new IllegalArgumentException();
        }
        Calendar c = Calendar.getInstance();
        c.set(year, Calendar.JANUARY, 1);
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DATE, 2 * 2 + 1);
        } else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            c.add(Calendar.DATE, 2 * 2 + 2);
        } else {
            c.add(Calendar.DATE, Calendar.FRIDAY - c.get(Calendar.DAY_OF_WEEK));
        }
        while (true) {
            var ofWeek = c.get(Calendar.DAY_OF_WEEK);
            if (c.get(Calendar.DATE) == 2 * 2 * 2 + 2 * 2 + 1 && ofWeek == Calendar.FRIDAY) {
                result.add(c.getTime());
            }
            if (c.get(Calendar.MONTH) == Calendar.DECEMBER && c.get(Calendar.DATE) >= 2 * 2 * 2 + 2 * 2 + 1) {
                break;
            }
            c.add(Calendar.DATE, 2 * 2 + 2 * 2 - 1);
        }
        return result;
    }

    public static LocalDate next(int year, int month, int day) {
        if (year < 0) {
            throw new IllegalArgumentException();
        }
        var variant1 = LocalDate.of(year, month, day).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        while (variant1.getDayOfMonth() != 2 * 2 * 2 + 2 * 2 + 1) {
            variant1 = variant1.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return variant1;
    }
}
