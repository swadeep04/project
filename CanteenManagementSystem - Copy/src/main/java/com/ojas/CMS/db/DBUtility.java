package com.ojas.CMS.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {

	public static Connection con = null;
	public static Connection getConnection() {
		
		try {
			File path = new File(
					"C:\\Users\\sp21392\\Downloads\\New folder (13)\\CanteenManagementSystem - Copy\\src\\main\\resources\\db.properties");
			FileInputStream fis = new FileInputStream(path);
			Properties p = new Properties();
			p.load(fis);
			System.out.println("---load the properties file----");
			Class.forName(p.getProperty("driver"));
		    con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
			System.out.println("---established connection ----");
			if(con!=null) {
				System.out.println("--connected---");
			}else {
				System.out.println("--Notable to connected---");
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
