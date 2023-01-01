package sqlSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
	public static boolean addingStudentTable() {
		String url = "jdbc:mysql://localhost:3306/SchoolMg";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Students " + "(id INTEGER not NULL, " + " fname VARCHAR(8), "
				+ " lname VARCHAR(8), " + " birthdate date, " + " PRIMARY KEY ( id ))";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = (Statement) conn.createStatement();
			int m = ((java.sql.Statement) st).executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}




	public static boolean addingSubjectsTable() {
		String url = "jdbc:mysql://localhost:3306/SchoolMg";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Subjects " + "(id INTEGER not NULL, " + "  title VARCHAR(8), "
				+ " description VARCH"
				+ "AR(250), " + " pricePerStudent decimal, " + " PRIMARY KEY ( id ))";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = (Statement) conn.createStatement();
			int m = ((java.sql.Statement) st).executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select one of the options:");
		System.out.println("1. Create  Table Students");
		System.out.println("2. Create  Table Subjects");
		System.out.println("8. Exit");
		int select = sc.nextInt();
		
		
		switch(select) {
		case 1:
			addingStudentTable();
			break;
		case 2:
			addingSubjectsTable();
			break;
		case 3:	
			System.out.println("Exiting bye....");
			break;
		
		}		
		

	}

}
