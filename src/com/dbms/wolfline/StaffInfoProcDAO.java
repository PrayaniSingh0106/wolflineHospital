package com.dbms.wolfline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffInfoProcDAO {

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	

	public static void setConnection(Connection connection) {
		StaffInfoProcDAO.connection=connection;
	}
	
	
public static int executeInsert(String query, Staff staff) {
		
		int result = -1;
		int count = -1;
		
		if (connection == null) {
			System.err.println("No connection to the database exists.");
			return -1;
		}

		try {
			
			PreparedStatement stmt=connection.prepareStatement(query);
			
			stmt.setInt(1, staff.getId());
			stmt.setString(2, staff.getName());
			stmt.setInt(3, staff.getAge());
			stmt.setString(5, staff.getGender());
			stmt.setString(6, staff.getJobTitle());
			stmt.setString(7, staff.getProfessionalTitle());
			stmt.setString(8, staff.getDepartment());
			stmt.setString(9, staff.getPhone());
			stmt.setString(3, staff.getAddress());
			
			//Number of rows affected
			
			count=stmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("Message: " + e.getMessage());
			System.out.println("Executing query failed.");
		}
		return count;
		
	}
	
	//Update, delete
	public static int updateDatabase(String query){
		Statement statement = null;
		int result = -1;

		if (connection == null) {
			System.err.println("No connection to the database exists.");
			return -1;
		}

		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			System.out.println("Creating statement failed");
		}
		try {
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println("Message: " + e.getMessage());
			System.out.println("Executing query failed.");
		}
		return result;
	}

	
	//Select * from
	public static ResultSet queryDatabase(String query) {
		Statement statement = null;
		ResultSet result = null;

		if (connection == null) {
			System.err.println("No connection to the database exists.");
			return null;
		}

		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			System.out.println("Creating statement failed");
		}
		try {
			result = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println("Executing query failed.");
		}
		return result;
	}
}
