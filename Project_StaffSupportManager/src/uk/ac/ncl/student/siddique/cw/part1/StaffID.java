package uk.ac.ncl.student.siddique.cw.part1;

import java.util.Objects;

public class StaffID {
    private char singleLetter;
    private int digit;

    public StaffID () {
        this.singleLetter = Util.getInstance().getRandomLetter();
        this.digit = Util.getInstance().getThreeDigitRandomNumber();
    }

    public char getSingleLetter() {
        return singleLetter;
    }

    public int getDigit() {
        return digit;
    }



    @Override
    public String toString() {
        return Character.toString(getSingleLetter()) + Integer.toString(getDigit());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffID staffID = (StaffID) o;
        return singleLetter == staffID.singleLetter && digit == staffID.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(singleLetter, digit);
    }
}