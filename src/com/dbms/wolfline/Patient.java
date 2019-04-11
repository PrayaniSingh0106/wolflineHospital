package com.dbms.wolfline;

import java.sql.Date;

public class Patient {
//	| ssn                  | varchar(20)  | NO   |     | NULL    |       |
		//	| name                 | varchar(20)  | NO   |     | NULL    |       |
		//	| dob                  | date         | NO   |     | NULL    |       |
		//	| gender               | char(1)      | NO   |     | NULL    |       |
		//	| phone                | varchar(15)  | YES  |     | NULL    |       |
		//	| address              | varchar(100) | YES  |     | NULL    |       |
		//	| treatment_plan       | varchar(100) | YES  |     | NULL    |       |
		//	| in_ward              | int(11)      | YES  |     | NULL    |       |
		//	| Completing_treatment | varchar(3)   | YES  |     | NULL   
	
	private String id;
	private String ssn;
	private String name;
	private Date dob;
	private String gender;
	private String phone;
	private String address;
	private String treatment_plan;
	private int in_ward;
	private String Completing_treatment;
	
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTreatment_plan() {
		return treatment_plan;
	}
	public void setTreatment_plan(String treatment_plan) {
		this.treatment_plan = treatment_plan;
	}
	public int getIn_ward() {
		return in_ward;
	}
	public void setIn_ward(int in_ward) {
		this.in_ward = in_ward;
	}
	public String getCompleting_treatment() {
		return Completing_treatment;
	}
	public void setCompleting_treatment(String completing_treatment) {
		Completing_treatment = completing_treatment;
	}
	
}
