package com.dbms.wolfline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WardInfoProcDAO {

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;

	public static void setConnection(Connection connection) {
		WardInfoProcDAO.connection = connection;
	}

	public static int executeInsert(String query, Ward ward) {

		int result = -1;

		if (connection == null) {
			System.err.println("No connection to the database exists.");
			return -1;
		}

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			result = stmt.executeUpdate(query);

			stmt.setString(1, ward.getWardNo());
			stmt.setString(2, ward.getCapacity());
			stmt.setString(3, ward.getCost());
			stmt.setString(4, ward.getResponsible_nurse());

		} catch (Exception e) {
			System.err.println("Message: " + e.getMessage());
			System.out.println("Executing query failed.");
		}

		return result;
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

	public static int updateDatabase(String query) {
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

	public static int deleteRecord(String wardNo) {
		
		
		return 0;
	}
}
