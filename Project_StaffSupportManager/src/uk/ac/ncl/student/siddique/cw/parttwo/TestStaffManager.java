package uk.ac.ncl.student.siddique.cw.parttwo;


import uk.ac.ncl.student.siddique.cw.part1.Name;
import uk.ac.ncl.student.siddique.cw.part1.StaffManager;
import uk.ac.ncl.student.siddique.cw.part1.Staff;
import uk.ac.ncl.student.siddique.cw.part1.Module;

import java.io.FileNotFoundException;
import java.util.*;


public class TestStaffManager {

    public static void main(String[] args) {
        TestStaffManager testStaffManager = new TestStaffManager();
        System.out.println("Test Read in Module");
        testStaffManager.testReadInModules();
        System.out.println("Test Read in Student");
        testStaffManager.testReadInStudent();
        System.out.println("Test number of Staff");
        testStaffManager.testNoOfStaff();
        System.out.println("Test employed Staff");
        testStaffManager.testEmployStaff();
        System.out.println("Test Add Data");
        testStaffManager.testAddData();
    }

    private void testReadInModules() {
        StaffManager staffManager = new StaffManager();
        try {
            staffManager.readInModules("modules.TXT");
        } catch (Throwable t) {
            Assertions.assertExpectedThrowable(FileNotFoundException.class,t);
        }
    }

    private void testReadInStudent() {
        StaffManager staffManager = new StaffManager();
        try {
            staffManager.readInStudents("students.TXT");
        } catch (Throwable t) {
            Assertions.assertExpectedThrowable(FileNotFoundException.class,t);
        }
    }


    private void testNoOfStaff() {
        String firstname ="Adiba";
        String lastName = "Anni";
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, 2, 21);
        Date birthDate = calendar.getTime();
        String staffType = "researcher";
        String employmentStatus = "fixed";
        StaffManager staffManager = new StaffManager();
        Staff staff = staffManager.employStaff(firstname,lastName,birthDate,staffType,employmentStatus);
        Assertions.assertEquals(1, staffManager.noOfStaff("researcher"));

    }

    private void testEmployStaff() {
        String firstname ="Susmita";
        String lastName = "Snigdha";
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 3, 15);
        Date birthDate = calendar.getTime();
        String staffType = "lecturer";
        String employmentStatus = "permanent";
        StaffManager staffManager = new StaffManager();
        Staff staff1 = staffManager.employStaff(firstname,lastName,birthDate,staffType,employmentStatus);
        Assertions.assertNotNull(staff1);

        Staff staff2 = staffManager.employStaff(firstname, lastName, null, staffType, employmentStatus);
        Assertions.assertNull(staff2);

        Staff staff3 = staffManager.employStaff(firstname, lastName, birthDate, "security", employmentStatus);
        Assertions.assertNull(staff3);

    }

    private void testAddData() {
        String firstname ="Adiba";
        String lastName = "Anni";
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, 01, 10);
        Date birthDate = calendar.getTime();
        String staffType = "researcher";
        String employmentStatus = "fixed";
        Name name1 = Name.valueOf("Arman Haider");
        Name name2 = Name.valueOf("Arsalan Goraya");
        Set<Name> students = new HashSet<>(Arrays.asList(name1,name2));
        Module m1 = Module.valueOf("CSC8021, Computer Networks, 1, 10");
        Module m2 = Module.valueOf("CSC8015, Cybersecurity, 2, 10");
        Set<Module> modules = new HashSet<>(Arrays.asList(m1,m2));
        StaffManager staffManager = new StaffManager();
        Staff staffNew = staffManager.employStaff(firstname,lastName,birthDate,staffType,employmentStatus);
        //staffManager.addData(staffNew.getStaffID(),modules,students);
        Assertions.assertTrue(staffManager.addData(staffNew.getStaffID(),modules,students));

    }


}
