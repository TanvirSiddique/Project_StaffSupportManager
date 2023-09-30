package uk.ac.ncl.student.siddique.cw.parttwo;

import uk.ac.ncl.student.siddique.cw.part1.AbstractStaffFactory;
import uk.ac.ncl.student.siddique.cw.part1.Name;
import uk.ac.ncl.student.siddique.cw.part1.Staff;

import java.util.Calendar;
import java.util.Date;

public class TestAbstractStaffFactory {

    public static void main (String[] args) {
        TestAbstractStaffFactory testAbstractStaffFactory = new TestAbstractStaffFactory();
        System.out.println("Test create Lecturer");
        testAbstractStaffFactory.createLecturer();
        System.out.println("Test create Researcher");
        testAbstractStaffFactory.createResearcher();
        System.out.println("Test get Staff Info");
        testAbstractStaffFactory.testGetStaffInfo();
        System.out.println("Test hash code");
        testAbstractStaffFactory.testHashCode();


    }

    private void createLecturer() {
        Name name = Name.valueOf("Tanvir Ahmed");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 11,10);
        Date birthDate = calendar.getTime();
        String staffType = "lecturer";
        String employmentStatus = "permanent";
        Staff staff = AbstractStaffFactory.getInstance(name, birthDate,staffType, employmentStatus);
        Assertions.assertNotNull(staff);

    }

    private void createResearcher() {
        Name name = Name.valueOf("Anika Jahan");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, 01,24);
        Date birthDate = calendar.getTime();
        String staffType = "researcher";
        String employmentStatus = "fixed";
        Staff staff1 = AbstractStaffFactory.getInstance(name, birthDate,staffType, employmentStatus);
        Assertions.assertNotNull(staff1);

    }

    private void testGetStaffInfo() {
        Name name = Name.valueOf("Shahid Husain");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, 04,15);
        Date birthDate = calendar.getTime();
        String staffType = "lecturer";
        String employmentStatus = "permanent";
        Staff staff2 = AbstractStaffFactory.getInstance(name, birthDate,staffType, employmentStatus);
        Assertions.assertEquals(employmentStatus, staff2.getStaffEmploymentStatus());
        Assertions.assertEquals(staffType, staff2.getStaffType());
        Assertions.assertNotNull(staff2.getSmartCard());
        Assertions.assertNotNull(staff2.getStaffID());
    }

    private void testHashCode() {
        Name name1 = Name.valueOf("Tanvir Ahmed");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 11,10);
        Date birthDate1 = calendar.getTime();
        String staffType1 = "lecturer";
        String employmentStatus1 = "permanent";
        Staff staff1 = AbstractStaffFactory.getInstance(name1, birthDate1,staffType1, employmentStatus1);

        Name name2 = Name.valueOf("Anika Jahan");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1989, 01,24);
        Date birthDate2 = calendar.getTime();
        String staffType2 = "researcher";
        String employmentStatus2 = "fixed";
        Staff staff2 = AbstractStaffFactory.getInstance(name2, birthDate2,staffType2, employmentStatus2);

        Assertions.assertEquals(staff1.hashCode(), staff1.hashCode());
        Assertions.assertNotEquals(staff1.hashCode(), staff2.hashCode());

    }

}
