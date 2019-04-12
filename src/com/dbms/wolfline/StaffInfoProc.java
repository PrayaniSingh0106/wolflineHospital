package com.dbms.wolfline;

import java.sql.ResultSet;
import java.util.Scanner;

public class StaffInfoProc {

	public static void TaskMenu() {
		try {
			Scanner in = new Scanner(System.in);
			int choice = 0;

			while (choice != 4) {
				System.out.println("Options:\n1.Enter details for new Staff" + "\n2.Update patient Staff"
						+ "\n3.Delete a staff's information" + "\n4.Exit");
				System.out.print(">>");
				choice = in.nextInt();

				if (choice != 1 && choice != 2 && choice != 3) {
					continue;
				} else if (choice == 1) {
					enterNewStaff();
				} else if (choice == 2) {
					updateStaff();
				} else if (choice == 3) {
					deleteStaff();
				}

			}
		} catch (Exception e) {
			System.out.println("Something went wrong! going back to the main menu.\n");
		}
	}

	private static void deleteStaff() {
		// TODO Auto-generated method stub
		try {

			Staff staff = new Staff();
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter the Staff's Id of the staff, who's information you want to delete: ");
			
			staff.setId(in.nextInt());

			String queryDel = "DELETE from staff WHERE id = " + staff.getId();
			int result = StaffInfoProcDAO.updateDatabase(queryDel);

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

	private static void updateStaff() {
		// TODO Auto-generated method stub
		try {

			Staff staff = new Staff();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ID of the patient you want to update");
			staff.setId(in.nextInt());

			String query = "SELECT * from staff where id =" + staff.getId();
			ResultSet result = StaffInfoProcDAO.queryDatabase(query);

			int id, age;
			String name, gender, job_title, professional_title, department, phone, address;

			if (result.next()) {
				id = result.getInt("id");
				name = result.getString("name");
				age = result.getInt("age");
				gender = result.getString("gender");
				job_title = result.getString("job_title");
				professional_title = result.getString("professional_title");
				department = result.getString("department");
				phone = result.getString("phone");
				address = result.getString("address");

			} else {
				System.out.println("No such patient patient exsist");
				return;
			}
			System.out.println("Old value for name:" + name);
			System.out.println("Do you want to update it?");
			String y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("Enter the new name:");
				name = in.nextLine();
			}
			System.out.println("Old value for age:" + age);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("Enter the new age:");
				age = in.nextInt();
			}
			System.out.println("Old value for gender:" + gender);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new gender:(M/F)");
				gender = in.nextLine();
			}
			System.out.println("Old value for job_title:" + job_title);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new job_title:");
				job_title = in.nextLine();
			}
			System.out.println("Old value for professional_title:" + professional_title);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new professional_title:");
				professional_title = in.nextLine();
			}

			System.out.println("Old value for department:" + department);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new department:");
				department = in.nextLine();
			}

			System.out.println("Old value for phone:" + phone);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new treatment_plan:");
				phone = in.nextLine();
			}

			System.out.println("Old value for phone:" + address);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new address:");
				address = in.nextLine();
			}
			
			String query1 = "UPDATE staff" + " SET id = '" + id + "', name = '" + name + "', age = '" + age
					+ "', gender = '" + gender + "', job_title = '" + job_title + "', professional_title = '" + professional_title
					+ "', department = '" + department + "', phone = '" + phone + " address = '" + address
					+ "')" + "where id = " + staff.getId();
			int result1 = StaffInfoProcDAO.updateDatabase(query1);

			if (result1 == 1) {
				System.out.println("Staff upadted.\n");
			} else {
				System.out.println("Failed to update the record. Try again.\n");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void enterNewStaff() {
		// TODO Auto-generated method stub
		 
		try {

			Staff staff = new Staff();
			
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ID of the patient: ");
			int id = in.nextInt();
			staff.setId(id);
			
			System.out.println("Enter the name of the patient: ");
			staff.setName(in.nextLine());
			
			System.out.println("Enter the age of the patient: ");
			staff.setAge(in.nextInt());
			
			System.out.println("Enter the gender of the patient: ");
			staff.setGender(in.nextLine());
			
			System.out.println("Enter the job_title of the patient: ");
			staff.setJobTitle(in.nextLine());
			
			System.out.println("Enter the professional_title of the patient: ");
			staff.setProfessionalTitle(in.nextLine());
			
			System.out.println("Enter the department of the patient: ");
			staff.setDepartment(in.nextLine());
			
			System.out.println("Enter the phone of the patient: ");
			staff.setPhone(in.nextLine());
			
			System.out.println("Enter the address of the patient: ");
			staff.setAddress(in.nextLine());

			String query = "INSERT INTO staff(id, name, age, gender ,job_title ,professional_title ,department , phone, address) VALUES(?,?,?,?,?,?,?,?,?,?);";
			
			int result = StaffInfoProcDAO.executeInsert(query, staff);
			System.out.println("Number of rows affected: result");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
