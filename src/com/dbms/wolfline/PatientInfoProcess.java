package com.dbms.wolfline;

import java.sql.ResultSet;
import java.util.Scanner;

public class PatientInfoProcess {

	// Enter/update/delete basic information about staff, patients, and wards.
	public static void TaskMenu() {
		try {
			Scanner in = new Scanner(System.in);
			int choice = 0;

			while (choice != 4) {
				System.out.println("Options:\n1.Enter details for new patient" + "\n2.Update patient information"
						+ "\n3.Delete a patient" + "\n4.Exit");
				System.out.print(">>");
				choice = in.nextInt();

				if (choice != 1 && choice != 2 && choice != 3) {
					continue;
				} else if (choice == 1) {
					enterNewPatient();
				} else if (choice == 2) {
					updatePatient();
				} else if (choice == 3) {
					deletePatient();
				}

			}
		} catch (Exception e) {
			System.out.println("Something went wrong! going back to the main menu.\n");
		}
	}

	private static void deletePatient() {
		// TODO Auto-generated method stub
		
	}

	private static void updatePatient() {
		// TODO Auto-generated method stub
	try {
			
			Patient patient = new Patient();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ID of the patient you want to update");
			patient.setId(in.nextLine());

			String query = "SELECT * from patient where id =" + patient.getId();
			ResultSet result = PatientInfoProcDAO.queryDatabase(query);

			String SSN, name, DOB, gender, phone, address, treatment_plan, completing_treatment, in_ward;

			if (result.next()) {
				SSN = result.getString("SSN");
				name = result.getString("name");
				DOB = result.getString("DOB");
				gender = result.getString("gender");
				phone = result.getString("phone");
				address = result.getString("address");
				treatment_plan = result.getString("treatment_plan");
				completing_treatment = result.getString("completing_treatment");
				in_ward = result.getString("in_ward");

			} else {
				System.out.println("No such patient patient exsist");
				return;
			}
			System.out.println("Old value for SSN:" + SSN);
			System.out.println("Do you want to update it?");
			String y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("Enter the new SSN:");
				SSN = in.nextLine();
			}
			System.out.println("Old value for name:" + name);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("Enter the new name:");
				name = in.nextLine();
			}
			System.out.println("Old value for DOB:" + DOB);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new SSN:");
				DOB = in.nextLine();
			}
			System.out.println("Old value for gender:" + gender);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new gender(M/F):");
				gender = in.nextLine();
			}
			System.out.println("Old value for phone:" + phone);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new phone:");
				phone = in.nextLine();
			}

			System.out.println("Old value for address:" + address);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new address:");
				address = in.nextLine();
			}

			System.out.println("Old value for treatment_plan:" + treatment_plan);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new treatment_plan:");
				treatment_plan = in.nextLine();
			}

			System.out.println("Old value for phone:" + completing_treatment);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new completing_treatment:");
				completing_treatment = in.nextLine();
			}

			System.out.println("Old value for address:" + in_ward);
			System.out.println("Do you want to update it?");
			y_n = in.nextLine();
			if (y_n.equals("y") || y_n.equals("Y")) {
				System.out.println("enter the new in ward value(Y/N):");
				in_ward = in.nextLine();
			}
			String query1 = "UPDATE patient" + "SET ssn = '" + SSN + "', name = '" + name + "', dob = '" + DOB
					+ "', gender = '" + gender + "', phone = '" + phone + "', address = '" + address
					+ "', treatment_plan = '" + treatment_plan + "', completing_treatment = '" + completing_treatment
					+ "')" + "where id = " + patient.getId();
			int result1 = PatientInfoProcDAO.updateDatabase(query1);

			if (result1 == 1) {
				System.out.println("patient upadted.\n");
			} else {
				System.out.println("Failed to update the record. Try again.\n");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void enterNewPatient() {
		// TODO Auto-generated method stub
		//id                   | int(11)      | NO   | PRI | NULL    |       |
		//	| ssn                  | varchar(20)  | NO   |     | NULL    |       |
		//	| name                 | varchar(20)  | NO   |     | NULL    |       |
		//	| dob                  | date         | NO   |     | NULL    |       |
		//	| gender               | char(1)      | NO   |     | NULL    |       |
		//	| phone                | varchar(15)  | YES  |     | NULL    |       |
		//	| address              | varchar(100) | YES  |     | NULL    |       |
		//	| treatment_plan       | varchar(100) | YES  |     | NULL    |       |
		//	| in_ward              | int(11)      | YES  |     | NULL    |       |
		//	| Completing_treatment | varchar(3)   | YES  |     | NULL   
		
		try {
			
			Patient patient = new Patient();
			
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the ID of the patient: ");
			String id = in.nextLine();
			patient.setId(id);
			System.out.println("Enter the ssn of the patient: ");
			patient.setSsn(in.nextLine());
			System.out.println("Enter the name of the patient: ");
			patient.setName(in.nextLine());
			System.out.println("Enter the dob of the patient: ");
			patient.setDob(in.nextLine());
			System.out.println("Enter the gender of the patient: ");
			patient.setGender(in.nextLine());
			System.out.println("Enter the phone of the patient: ");
			patient.setPhone(in.nextLine());
			System.out.println("Enter the address of the patient: ");
			patient.setAddress(in.nextLine());
			System.out.println("Enter the treatment_plan of the patient: ");
			patient.setTreatment_plan(in.nextLine());
			System.out.println("Enter the in_ward of the patient: ");
			patient.setIn_ward(Integer.parseInt(in.nextLine()));
			System.out.println("Enter the Completing_treatment of the patient: ");
			patient.setTreatment_plan(in.nextLine());
			
			/*
			 * if(patient_id==null||patient_ssn==null||patient_name==null||patient_dob==null
			 * ||patient_gender==null) { System.out.
			 * println("patient_id, patient_ssn, patient_name, patient_dob and patient_gender can't be null. "
			 * );
			 * 
			 * }
			 */
			
					String query="INSERT INTO patient(id, ssn, name, dob, gender, phone, address, treatment_plan, completing_treatment) VALUES(?,?,?,?,?,?,?,?,?)";
					int result = PatientInfoProcDAO.executeInsert(query, patient); 
					PatientInfoProcDAO.printUpdateResults(result);
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
