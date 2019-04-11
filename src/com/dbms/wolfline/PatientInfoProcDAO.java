package com.dbms.wolfline;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientInfoProcDAO {
	/*
	 * private static final String jdbcURL =
	 * "jdbc:mariadb://localhost:3303/hospital"; private static final String user =
	 * "root"; private static final String password = "root";
	 */
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	

	public static void setConnection(Connection connection) {
		PatientInfoProcDAO.connection=connection;
	}
	
	public static int executeInsert(String query, Patient patient) {
		
		int result = -1;
		int count = -1;
		
		if (connection == null) {
			System.err.println("No connection to the database exists.");
			return -1;
		}

		try {
			
			PreparedStatement stmt=connection.prepareStatement(query);
			result = stmt.executeUpdate(query);
			
			stmt.setString(1, patient.getId());
			stmt.setString(2, patient.getSsn());
			stmt.setString(3, patient.getName());
			stmt.setDate(4, patient.getDob());
			stmt.setString(5, patient.getGender()); // Char to string?????????- ---------
			stmt.setString(6, patient.getPhone());
			stmt.setString(7, patient.getAddress());
			stmt.setString(8, patient.getTreatment_plan());
			stmt.setInt(9, patient.getIn_ward());
			stmt.setString(3, patient.getCompleting_treatment());
			
			//Number of rows affected
			 count=stmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("Message: " + e.getMessage());
			System.out.println("Executing query failed.");
		}
		return count;
		
	}
	
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
	

	public static void printUpdateResults(int res) {
		// TODO Auto-generated method stub
		System.out.println("No of rows affected"+res);
	}
}
