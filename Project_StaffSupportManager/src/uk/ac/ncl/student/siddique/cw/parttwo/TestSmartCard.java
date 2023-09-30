package uk.ac.ncl.student.siddique.cw.parttwo;

import uk.ac.ncl.student.siddique.cw.part1.Name;
import uk.ac.ncl.student.siddique.cw.part1.SmartCard;
import uk.ac.ncl.student.siddique.cw.part1.SmartCardNumber;

import java.util.Calendar;
import java.util.Date;

public class TestSmartCard {



    public static void main (String[] args) {
        TestSmartCard testSmartCard = new TestSmartCard();
        System.out.println("Test create SmartCard");
        testSmartCard.createSmartCard();
        System.out.println("Test get SmartCard Info");
        testSmartCard.testGetSmartCardInfo();

    }

    private void createSmartCard() {
        Name name = Name.valueOf("Tanvir Siddique");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 11,10);
        Date birthDate = calendar.getTime();
        String employmentStatus = "fixed";
        SmartCardNumber smartCardNumber = new SmartCardNumber(name, new Date());
        SmartCard smartCard = new SmartCard(name, birthDate, employmentStatus, smartCardNumber);
        Assertions.assertNotNull(smartCard);

    }

    private void testGetSmartCardInfo() {
        Name name = Name.valueOf("Athar Ali");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1996,06,02);
        Date birthDate = calendar.getTime();
        String employmentStatus = "permanent";
        Date issueDate = new Date();
        SmartCardNumber smartCardNumber = new SmartCardNumber(name,issueDate);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(issueDate);
        calendar1.add(Calendar.YEAR, 10);
        Date expiryDate =calendar1.getTime();

        SmartCard smartCard = new SmartCard(name, birthDate, employmentStatus, smartCardNumber);
        Assertions.assertEquals(name, smartCard.getStaffName());
        Assertions.assertEquals(birthDate, smartCard.getBirthDate());
        Assertions.assertEquals(employmentStatus, smartCard.getEmploymentStatus());
        Assertions.assertEquals(smartCardNumber, smartCard.getSmartCardNumber());
        Assertions.assertEquals(issueDate, smartCard.getIssueDate());
        Assertions.assertEquals(expiryDate, smartCard.getExpiryDate());

    }



}
