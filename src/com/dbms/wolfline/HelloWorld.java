package com.dbms.wolfline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {

	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/psingh25";
	private static final String user = "psingh25";
	private static final String password = "200251108";
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	
	public static void main(String[] args) {
		try {
			BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("org.mariadb.jdbc.Driver");
			HelloWorld.connection = DriverManager.getConnection(jdbcURL, user, password);
			QueryExecutor.setConnection(connection);
			
			while(true) {
				System.out.println("Options:\n1.Medical History of patient"
			                    +"\n2.Ward Usage Status"
			                    +"\n3.Patients per month"
			                    +"\n4.Ward usage in percentage"
			                    +"\n5.Patients of a particular doctor"
			                    +"\n6.Staff grouped by role"
			                    +"\n7.Exit");
				int selected=Integer.parseInt(bi.readLine());
				if(selected==1) {
					System.out.println("Enter patiend id and month");
					String inputs[] = bi.readLine().split(" ");
					ResultSet result=Report.getMedicalHistory(inputs[0], inputs[1]);
					Report.printResults(result);
				}
				else if(selected==2){
					ResultSet result=Report.getUsageStatus();
					Report.printResults(result);
				}
				else if(selected==3){
					
				}
				else if(selected==4){
					
				}
				else if(selected==5){
					
				}
				else if(selected==6){
					
				}
				else if(selected==7){
					break;
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(ResultSet result) {
		if (result != null) {
			try {
				result.close();
			} catch (Throwable whatever) {
			}
		}
	}
}