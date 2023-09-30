package uk.ac.ncl.student.siddique.cw.part1;

import java.util.*;

public class SmartCardNumber {

    private String initial;
    private int serialNum;
    private int year;

    public SmartCardNumber(Name name, Date issueDate){
        this.initial = name.getFirstName().substring(0, 1) + name.getLastName().substring(0, 1);
        this.serialNum = Util.getInstance().getTwoDigitRandomNumber();
        this.year = Util.getInstance().getYearFromDate(issueDate);
    }

    public String getInitial() {
        return initial;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public int getYear() {
        return year;
    }



    @Override
    public String toString() {
        return getInitial() + "-" + Integer.toString(getSerialNum()) + "-" + Integer.toString(getYear());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartCardNumber that = (SmartCardNumber) o;
        return serialNum == that.serialNum && year == that.year && Objects.equals(initial, that.initial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initial, serialNum, year);
    }
}


