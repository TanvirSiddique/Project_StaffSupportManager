package uk.ac.ncl.student.siddique.cw.part1;

import java.util.*;

public abstract class AbstractStaffFactory implements Staff {
    public static final String LECTURER_STAFF = "lecturer";
    public static final String RESEARCHER_STAFF = "researcher";

    private static final Map<String, Staff> staffs = new HashMap<>();
    private String employmentStatus;
    private String staffType;
    private SmartCard smartCard;
    private StaffID staffID;

    AbstractStaffFactory(StaffID staffID, SmartCard smartCard, String staffType, String employmentStatus) {
        this.staffID = staffID;
        this.staffType = staffType;
        this.employmentStatus = employmentStatus;
        this.smartCard = smartCard;
    }

    public static Staff getInstance(Name name, Date dob, String staffType, String employmentStatus) {

        StaffID newStaffId = new StaffID();
        while (staffs.containsKey(newStaffId.toString())) {
            newStaffId = new StaffID();
        }

        SmartCardNumber smartCardNumber = new SmartCardNumber(name, Util.getInstance().getCurrentDate());

        while (true) {
            boolean exist = false;
            for (Staff staff : staffs.values()) {
                if (staff.getSmartCard().getSmartCardNumber().equals(smartCardNumber)) {
                    exist = true;
                    break;
                }
            }

            if (exist) {
                smartCardNumber = new SmartCardNumber(name, Util.getInstance().getCurrentDate());
            } else {
                break;
            }
        }

        SmartCard newSmartCard = new SmartCard(name, dob, employmentStatus, smartCardNumber);

        Staff stf = staffs.get( newStaffId);

        if (stf != null)
            return stf;

        if (staffType.equals(LECTURER_STAFF)) {
            stf = new Lecturer(newStaffId, newSmartCard, staffType, employmentStatus);
        } else if (staffType.equals(RESEARCHER_STAFF)) {
            stf = new Researcher (newStaffId, newSmartCard, staffType, employmentStatus);
        } else {
            throw new IllegalArgumentException("invalid staff type: " + staffType);
        }

        staffs.put(newStaffId.toString(), stf);

        return  stf;

    }


    public String getStaffEmploymentStatus() {
        return employmentStatus;
    }

    public String getStaffType() {
        return staffType;
    }

    public SmartCard getSmartCard() {
        return smartCard;
    }

    public StaffID getStaffID() {
        return staffID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractStaffFactory that = (AbstractStaffFactory) o;
        return Objects.equals(employmentStatus, that.employmentStatus) && Objects.equals(staffType, that.staffType) && Objects.equals(smartCard, that.smartCard) && Objects.equals(staffID, that.staffID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employmentStatus, staffType, smartCard, staffID);
    }


}
