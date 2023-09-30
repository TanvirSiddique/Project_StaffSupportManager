package uk.ac.ncl.student.siddique.cw.part1;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Util {
    private static Util obj;
    private Util() {}

    public static Util getInstance()
    {
        if (obj == null) {
            obj = new Util();
        }
        return obj;
    }

    public int getTwoDigitRandomNumber() {
        Random random = new Random();
        return random.nextInt(10, 100);
    }

    public char getRandomLetter() {
        Random random = new Random();
        return (char) random.nextInt('a', 'z' + 1);
    }

    public int getThreeDigitRandomNumber() {
        Random random = new Random();
        return random.nextInt(100, 1000);
    }

    public int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public Date getDateWithAddedYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }
}
