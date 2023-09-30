package uk.ac.ncl.student.siddique.cw.part1;

import java.util.Calendar;
import java.util.Date;

public class SmartCard {
    private Name staffName;
    private Date birthDate;
    private SmartCardNumber smartCardNumber;
    private String employmentStatus;
    private Date issueDate;
    private Date expiryDate;

    public SmartCard(Name staffName, Date birthDate, String employmentStatus, SmartCardNumber smartCardNumber) {
        this.staffName = staffName;
        this.birthDate = birthDate;
        this.employmentStatus = employmentStatus;
        this.issueDate = Util.getInstance().getCurrentDate();
        this.smartCardNumber = smartCardNumber;
        setExpiryDate();
    }

    public Name getStaffName() {
        return staffName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public SmartCardNumber getSmartCardNumber() {
        return smartCardNumber;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getExpiryDate(){
        return expiryDate;
    }

    private void setExpiryDate(){

        int year = getEmploymentStatus().equals("permanent") ? 10 : 2;
        this.expiryDate = Util.getInstance().getDateWithAddedYear(this.issueDate, year);

    }
}




