package com.dbms.wolfline;

import java.sql.ResultSet;

public class StaffInfoProcess {

	private static String query = "";
	
	public static ResultSet insertValuesInStaff() {
		query = "INSERT INTO staff(id, name, age, gender ,job_title ,professional_title ,department , phone, address) "
				+ "VALUES(100,'Mary',40,'F','Doctor','Senior','Neurology',654,'90 ABC St , Raleigh NC 27');";
		ResultSet result = QueryExecutor.queryDatabase(query);
		return result;
	}
	public static ResultSet updateStaffInfo() {
		query = "UPDATE staff "
				+ "SET phone = '454-988-9563', dob = '1976-04-4', address = '4041 Roach Road' WHERE id=18;";
		ResultSet result = QueryExecutor.queryDatabase(query);
		return result;
		
	}
	public static ResultSet deleteStaffInfo() {
		query = "DELETE  FROM staff WHERE id=?";
		ResultSet result = QueryExecutor.queryDatabase(query);
		return result;
	}
}
