package uk.ac.ncl.student.siddique.cw.parttwo;


import uk.ac.ncl.student.siddique.cw.part1.Module;
import uk.ac.ncl.student.siddique.cw.part1.Name;

import java.lang.module.ModuleFinder;

public class TestModule {
    public static void main(String[] args) {
        TestModule testModule = new TestModule();
        System.out.println("Test create module");
        testModule.createModule();
        System.out.println("Test get Module information");
        testModule.getModuleInfo();
        System.out.println("Test hash code");
        testModule.testHashCode();
        System.out.println("Test equals");
        testModule.testEquals();


    }

    private void createModule() {
        //testing normal case
        Module module = Module.valueOf("CSC8015, Cybersecurity, 2, 10");
        Assertions.assertNotNull(module);

        //testing exception case
        try{
             final Module module1 = Module.valueOf(null);
        } catch (Throwable throwable) {
            Assertions.assertExpectedThrowable(IllegalArgumentException.class, throwable);
        }
    }

    private void getModuleInfo() {
        String moduleCode = "CSC8015";
        String moduleName = "Cybersecurity";
        int semester = 2;
        int credits = 10;

        Module module = Module.valueOf("CSC8015, Cybersecurity, 2, 10");
        Assertions.assertEquals(moduleCode, module.getModuleCode());
        Assertions.assertEquals(moduleName, module.getModuleName());
        Assertions.assertEquals(semester, module.getSemester());
        Assertions.assertEquals(credits, module.getCredits());
    }

    private void testHashCode() {
        Module module = Module.valueOf("CSC8015, Cybersecurity, 2, 10");
        Module module1 = Module.valueOf("CSC8017, Database Systems, 1, 20");
        Module moduleCopy = Module.valueOf("CSC8015, Cybersecurity, 2, 10");

        Assertions.assertEquals(module.hashCode(), moduleCopy.hashCode());
        Assertions.assertNotEquals(module.hashCode(), module1.hashCode());

    }

    private void testEquals() {
        Module module = Module.valueOf("CSC8017, Database Systems, 1, 10");
        Assertions.assertTrue(module.equals(module));
        Assertions.assertFalse(module.equals(null));
        Assertions.assertFalse(module.equals("CSC8018, Web Technologies, 1, 10"));
        Assertions.assertTrue(module.equals(Module.valueOf("CSC8017, Database Systems, 1, 10")));
        Assertions.assertFalse(module.equals(Module.valueOf("CSC8018, Web Technologies, 1, 10")));
        Assertions.assertFalse(module.equals(Module.valueOf("CSC8019, Software Engineering and Team Project, 2, 20")));
    }

}
