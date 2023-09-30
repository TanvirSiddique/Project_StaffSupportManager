package uk.ac.ncl.student.siddique.cw.part1;

import uk.ac.ncl.student.siddique.cw.part1.Name;
import uk.ac.ncl.student.siddique.cw.part1.Staff;
import uk.ac.ncl.student.siddique.cw.part1.StaffID;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class StaffManager {

	//you can add attributes and other methods if needed. 
	//you can throw an exception if needed
	private static Set<Name> studentList = new HashSet<>();
	private static Set<Module> moduleList = new HashSet<>();
	private static Map<StaffID, Staff> staffList = new HashMap<>();


	public Set<Module> readInModules(String path) throws FileNotFoundException {
		//add your code here. Do NOT change the method signature

		File mFile = new File(path);
		Scanner sc = new Scanner(mFile);

		// Adding the module to the HasSet modulelist
		while(sc.hasNextLine()) {

			Module m = Module.valueOf(sc.nextLine());
			moduleList.add(m);
		}
		return moduleList;
	}


	public Set<Name> readInStudents(String path) throws FileNotFoundException  {
		//add your code here. Do NOT change the method signature

		File sFile = new File(path);
		Scanner sc = new Scanner(sFile);
		// Adding the student to the HasSet studentlist
		while(sc.hasNextLine()) {

			Name nm = Name.valueOf(sc.nextLine());
			studentList.add(nm);
		}
		return studentList;
	}


	public int noOfStaff(String type) { 
		//add your code here. Do NOT change the method signature

		int count = 0;
		for (Staff stf: staffList.values()) {
			if (stf.getStaffType().equals(type)) {
				count ++;
			}
		}
		return  count;
	}



	public boolean addData(StaffID id, Set<Module> modules, Set<Name> students) {		 
		//add your code here. Do NOT change the method signature

		if (! staffList.containsKey(id) ) {
			return false;
		}
		if (modules.size() == 0 &&  students.size() == 0){
			return false;
		}
		if (modules == null && students == null) throw new NullPointerException("Both Sets cannot be Null");

		Staff staff = staffList.get(id);
		if (staff.getStaffType().equals("lecturer")) {
			((Lecturer) staff).setModules(modules);
		} else if (staff.getStaffType().equals("researcher")) {
			((Researcher) staff).setStudents(students);
		}
		return true;
	}


	public Staff employStaff(String firstName, String lastName, Date dob, String staffType, String employmentStatus) {
		//add your code here. Do NOT change the method signature

		if (firstName == null || lastName == null || dob == null || staffType == null || employmentStatus == null) {
			return null;
		}

		if (!(staffType.equals("researcher") || staffType.equals("lecturer"))) {
			return null;
		}

		if (!(employmentStatus.equals("fixed") || employmentStatus.equals("permanent"))) {
			return null;
		}

		//Validation
		int dobYear = Util.getInstance().getYearFromDate(dob);
		int currentYear = Util.getInstance().getCurrentYear();
		int age = currentYear - dobYear;

		if (age < 22 || age > 67) {
			return null;
		}

		Name name = new Name(firstName, lastName);
		for (Staff staff : staffList.values()) {

			if (staff.getSmartCard().getStaffName().equals(name) && staff.getSmartCard().getBirthDate().equals(dob)) {
				return null;
			}
		}

		Staff staff = AbstractStaffFactory.getInstance(name, dob, staffType, employmentStatus);
		staffList.put(staff.getStaffID(), staff);
		return staff;
	}


	public Collection<Staff> getAllStaff() {
		//add your code here. Do NOT change the method signature

		return staffList.values() ;
	}


	public void terminateStaff(StaffID id) {
		//add your code here. Do NOT change the method signature

		Staff staff = staffList.get(id);
		staffList.remove(staff);
	}




}
