package com.dbms.wolfline;

import java.sql.ResultSet;
import java.util.Scanner;

import BillAcc.QueryExecutor;

public class WardInfoProcess {

	public static void TaskMenu() {
		try {
			Scanner in = new Scanner(System.in);
			int choice = 0;

			while (choice != 4) {
				System.out.println("Options:\n1.Enter details for new ward" + "\n2.Update ward information"
						+ "\n3.Delete a ward" + "\n4.Exit");
				System.out.print(">>");
				choice = in.nextInt();

				if (choice != 1 && choice != 2 && choice != 3) {
					continue;
				} else if (choice == 1) {
					enterNewWard();
				} else if (choice == 2) {
					updateWard();
				} else if (choice == 3) {
					deleteWard();
				}
				in.close();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong! going back to the main menu.\n");
		}
	}

	private static void enterNewWard() {
		// TODO Auto-generated method stub

		try {

			Ward ward = new Ward();

			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ward numer: ");
			ward.setWardNo((in.nextLine()));
			System.out.println("Enter the ssn of the patient: ");
			ward.setCapacity((in.nextLine()));
			System.out.println("Enter the capacity of the ward: ");
			ward.setCost((in.nextLine()));
			System.out.println("Enter the cost of the ward: ");
			ward.setResponsible_nurse((in.nextLine()));

			String query = "INSERT INTO ward(ward_no ,capacity, cost, responsible_nurse ) VALUES(?,?,?,?);";
			int res = WardInfoProcDAO.executeInsert(query, ward);
			PatientInfoProcDAO.printUpdateResults(res);
			in.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteWard() {
		// TODO Auto-generated method stub
		try {

			Ward ward = new Ward();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ward_number of the ward you want to delete: ");
			ward.setWardNo(in.nextLine());
			
			String queryDel = "DELETE from ward WHERE ward_no = " + ward.getWardNo();
			int result = WardInfoProcDAO.updateDatabase(queryDel);

			if (result == 0) {
				System.out.println("No such ward exsist.\n");
			} else {
				System.out.println(result + " number of row(s) affected.\n");
			}

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updateWard() {
		// TODO Auto-generated method stub
		try {

			Ward ward = new Ward();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ward_number of the ward you want to update: ");
			ward.setWardNo(in.nextLine());

			String query = "SELECT * from patient where id =" + ward.getWardNo();
			ResultSet result = WardInfoProcDAO.queryDatabase(query);

			String wardNo, capacity, cost, responsible_nurse;

			if (result.next()) {
				// wardNo = result.getString("ward_no");
				capacity = result.getString("capacity");
				cost = result.getString("cost");
				responsible_nurse = result.getString("responsible_nurse");

			} else {
				System.out.println("No such ward exist");
				return;
			}
			System.out.println("Old value for capacity:" + capacity);
			System.out.println("Do you want to update it?");
			String y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("Enter the new SSN:");
				capacity = in.nextLine();
			}
			System.out.println("Old value for cost:" + cost);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("Enter the new name:");
				cost = in.nextLine();
			}
			System.out.println("Old value for responsible_nurse:" + responsible_nurse); // Is it okay to use String when
																						// DB is int?
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new SSN:");
				responsible_nurse = in.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
