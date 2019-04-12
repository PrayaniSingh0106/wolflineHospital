package com.dbms.wolfline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mainproject {
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/psingh25";
	private static final String user = "psingh25";
	private static final String password = "200251108";

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	private static int num_ba = 2;

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);

			QueryExecutor.setConnection(connection);

			int choice = 0;
			while (choice != 5) {
				Scanner in = new Scanner(System.in);
				System.out.println("Options:\n1.Information processing"
						+ "\n2.Medical information"
						+ "\n3.Mantaining Billing Account" + "\n4.Reports"
						+ "\n5.Exit");
				System.out.print(">>");
				choice = in.nextInt();
				System.out.print("\n");

				if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
					continue;
				}
				if (choice == 1) {
					
					Scanner ip = new Scanner(System.in);
					int ipChoice = 0;
					
					while(ipChoice!=4) {
						System.out.println("Options:\n1.Information processing of staff : "
								+ "\n2.Information processing of patient: "
								+ "\n3.Information processing of ward" 
								+ "\n4.Exit");
						System.out.print(">>");	
						ipChoice = ip.nextInt();
						System.out.println();
						
						if (ipChoice != 1 && ipChoice != 2 && ipChoice != 3) {
							continue;
						}
						
						switch(ipChoice) {
							
						case 1:
							PatientInfoProcess.TaskMenu();
							break;
						case 2:
							StaffInfoProc.TaskMenu();
							break;
						case 3:
							WardInfoProcess.TaskMenu();
							break;
							
						}
						
					}
					
				} else if (choice == 2) {
					// MedicalInformation.TaskMenu();
				} else if (choice == 3) {
					//BillingAccount.TaskMenu();
				} else if (choice == 4) {
					//Report.TaskMenu();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
