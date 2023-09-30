package uk.ac.ncl.student.siddique.cw.part1;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

final class Researcher extends AbstractStaffFactory {

    private static Set<Name> students = new HashSet<>();

    public Researcher(StaffID staffID, SmartCard smartCard, String staffType, String employmentStatus ) {
        super(staffID, smartCard, staffType, employmentStatus);;

    }

    public Set<Name> supervisedStudent() {
        return students;
    }

    public boolean supervisingEnough() {
        int totalStudent = students.size();

        if (totalStudent >= 10) {
            return true;
        } else { return false;}
    }

    public void setStudents(Set<Name> sdnt) {

        if (students.size() + sdnt.size() <=10) {
            for(Name nm : sdnt) {
                students.add(nm);
            }
        }

    }


    @Override
    public Name getName() {
        return null;
    }
}
