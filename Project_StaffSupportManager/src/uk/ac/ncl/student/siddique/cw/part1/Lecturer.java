package uk.ac.ncl.student.siddique.cw.part1;

import java.util.*;

final class Lecturer extends AbstractStaffFactory {

    private static Set<Module> modules = new HashSet<>();

    public Lecturer(StaffID staffID, SmartCard smartCard, String staffType, String employmentStatus ) {
        super(staffID, smartCard, staffType, employmentStatus);;

    }

    public Set<Module> assignedModules() {
        return modules;
    }

    public boolean teachingEnough() {
        int totalCredit = 0;
        for (Module m : modules) {
           totalCredit += m.getCredits();
        }
        if (totalCredit >= 40) {
            return true;
        } else { return false;}
    }

    public void setModules(Set<Module> mdl) {

        int creditsTotal = 0;
        for(Module m : modules) {
            creditsTotal += m.getCredits();
        }

        int credits = 0;
        for (Module ml : mdl) {
            credits += ml.getCredits();
        }

        if (creditsTotal + credits <=40) {
            for (Module module : mdl) {
                modules.add(module);
            }
        }

    }

    @Override
    public Name getName() {
        return null;
    }
}
