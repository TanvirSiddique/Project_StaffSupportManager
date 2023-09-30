package uk.ac.ncl.student.siddique.cw.part1;

/**
 * uk.ac.ncl.student.siddique.cw.part1.Staff - interface to university staff.
 *
 * @author Rouaa Yassin Kassab
 * Copyright (C) 2023 Newcastle University, UK
 */ 

public interface Staff {

	//DO NOT remove or change the signature of any method. 
	//You can add more methods (e.g. setter methods) if your solution requires that
	
	/**
	 * Returns the staff ID. 
	 * All staff must have an ID
	 * @return the StaffID object
	 */
	StaffID getStaffID();
	
	
	/**
	 * Returns the smart card. 
	 * All staff must have a smart card
	 * @return the SmartCard object
	 */
	SmartCard getSmartCard();
 
	//
	/**
	 * Returns the uk.ac.ncl.student.siddique.cw.part1.Staff employment status.
	 * a uk.ac.ncl.student.siddique.cw.part1.Staff can be either on Permanent or fixed contract
	 * @return a string (Permanent or fixed)
	 */
	String getStaffEmploymentStatus();

	
	/**
	 * Returns the uk.ac.ncl.student.siddique.cw.part1.Staff type.
	 * a uk.ac.ncl.student.siddique.cw.part1.Staff can be either a Lecturer or a Researcher
	 * @return a string (Lecturer or Researcher)
	 */
    String getStaffType();


	Name getName();


    
}
