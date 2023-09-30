package uk.ac.ncl.student.siddique.cw.parttwo;

import uk.ac.ncl.student.siddique.cw.part1.SmartCardNumber;

import uk.ac.ncl.student.siddique.cw.part1.Name;

import java.util.Calendar;
import java.util.Date;

public class TestSmartCardNumber {

    public static void main (String[] args) {
        TestSmartCardNumber testSmartCardNumber = new TestSmartCardNumber();
        System.out.println("Test create SmartCardNumber");
        testSmartCardNumber.createSmartCardNumber();
        System.out.println("Test get SmartCardNumber Info");
        testSmartCardNumber.testGetSmartCardNumberInfo();
        System.out.println("Test hash code");
        testSmartCardNumber.testhashCode();
        System.out.println("Test equals");
        testSmartCardNumber.testEquals();
    }

    private void createSmartCardNumber() {
        Name name = Name.valueOf("Tanvir Siddique");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 03,01);
        Date issueDate = calendar.getTime();
        SmartCardNumber smartCardNumber = new SmartCardNumber(name, issueDate);
        Assertions.assertNotNull(smartCardNumber);

    }

    private void testGetSmartCardNumberInfo() {
        Name name = Name.valueOf("Donna Hamid");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 01,03);
        Date issueDate = calendar.getTime();
        SmartCardNumber smartCardNumber = new SmartCardNumber(name, issueDate);
        String initials = name.getFirstName().substring(0, 1) + name.getLastName().substring(0, 1);
        int serialNumber = smartCardNumber.getSerialNum();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(issueDate);
        int Year = calendar1.get(Calendar.YEAR);

        Assertions.assertEquals(initials, smartCardNumber.getInitial());
        Assertions.assertNotNull(serialNumber);
        Assertions.assertEquals(Year, smartCardNumber.getYear());

    }

    private void testhashCode() {

        Name name = Name.valueOf("Tanvir Siddique");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 03,01);
        Date issueDate = calendar.getTime();
        SmartCardNumber smartCardNumber = new SmartCardNumber(name, issueDate);

        Name name1 = Name.valueOf("Donna Hamid");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, 01,03);
        Date issueDate1 = calendar.getTime();
        SmartCardNumber smartCardNumber1 = new SmartCardNumber(name1, issueDate1);

        Assertions.assertEquals(smartCardNumber.hashCode(), smartCardNumber.hashCode());
        Assertions.assertNotEquals(smartCardNumber.hashCode(), smartCardNumber1.hashCode());

    }

    private void testEquals() {

        Name name = Name.valueOf("Tanvir Siddique");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 03,01);
        Date issueDate = calendar.getTime();
        SmartCardNumber smartCardNumber = new SmartCardNumber(name, issueDate);

        Name name1 = Name.valueOf("Donna Hamid");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, 01,03);
        Date issueDate1 = calendar.getTime();
        SmartCardNumber smartCardNumber1 = new SmartCardNumber(name1, issueDate1);

        Assertions.assertTrue(smartCardNumber1.equals(smartCardNumber1));
        Assertions.assertFalse(smartCardNumber.equals(null));
        Assertions.assertFalse(smartCardNumber1.equals(smartCardNumber));

    }

}
