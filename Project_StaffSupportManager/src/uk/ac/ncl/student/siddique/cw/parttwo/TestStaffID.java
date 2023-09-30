package uk.ac.ncl.student.siddique.cw.parttwo;

import uk.ac.ncl.student.siddique.cw.part1.StaffID;

public class TestStaffID {
    public static void main (String[] args) {
        TestStaffID testStaffID = new TestStaffID();
        System.out.println("Test create staffID");
        testStaffID.createStaffID();
        System.out.println("Test hash code");
        testStaffID.testHashCode();
        System.out.println("Test equals");
        testStaffID.testEquals();
    }

    private void createStaffID() {

        StaffID staffID = new StaffID();
        Assertions.assertNotNull(staffID);

    }

    private void testHashCode() {
        StaffID staffID = new StaffID();
        StaffID staffID1 = new StaffID();

        Assertions.assertEquals(staffID.hashCode(), staffID.hashCode());
        Assertions.assertNotEquals(staffID.hashCode(), staffID1.hashCode());

    }

    private void testEquals() {
        StaffID staffID = new StaffID();
        StaffID staffID1 = new StaffID();
        Assertions.assertTrue(staffID.equals(staffID));
        Assertions.assertFalse(staffID.equals(null));
        Assertions.assertFalse(staffID1.equals(staffID));
    }

}
