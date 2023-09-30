package uk.ac.ncl.student.siddique.cw.parttwo;

import uk.ac.ncl.student.siddique.cw.part1.Name;

public class TestName {
        public static void main(String[] args) {
            TestName testName = new TestName();
            System.out.println("Test create name");
            testName.createName();
            System.out.println("Test get Name information");
            testName.getNameInfo();
            System.out.println("Test hash code");
            testName.testHashCode();
            System.out.println("Test equals");
            testName.testEquals();
        }

        private void createName() {
            //test normal case
            Name name = Name.valueOf("Tanvir Siddique");
            Assertions.assertNotNull(name);

            //test exception case
            try{
                final Name name1 = Name.valueOf(null);
            } catch (Throwable t) {
                Assertions.assertExpectedThrowable(IllegalArgumentException.class,t);
            }
        }

        private void getNameInfo() {
            String firstName = "Tanvir";
            String lastName = "Siddique";
            Name name = Name.valueOf("Tanvir Siddique");
            Assertions.assertEquals(firstName, name.getFirstName());
            Assertions.assertEquals(lastName,name.getLastName());
        }

        private void testHashCode() {
            Name name = Name.valueOf("Tanvir Siddique");
            Name name1 = Name.valueOf("Mamun Siddique");
            Name nameCopy = Name.valueOf("Tanvir Siddique");

            Assertions.assertEquals(name.hashCode(), nameCopy.hashCode());
            Assertions.assertNotEquals(name.hashCode(), name1.hashCode());
        }

        private void testEquals() {
            Name name = Name.valueOf("Tay Husain");
            Assertions.assertTrue(name.equals(name));
            Assertions.assertFalse(name.equals(null));
            Assertions.assertFalse(name.equals("Adib"));
            Assertions.assertTrue(name.equals(Name.valueOf("Tay Husain")));
            Assertions.assertFalse(name.equals(Name.valueOf("Adib Husain")));
            Assertions.assertFalse(name.equals(Name.valueOf("Humaira Noor")));

        }
}
