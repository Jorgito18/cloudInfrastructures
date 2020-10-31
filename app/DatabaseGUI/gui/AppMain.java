package gui;

import java.util.concurrent.TimeUnit;

import java.sql.*;

import java.awt.FlowLayout;

import javax.swing.*;

public class AppMain {
	   static final String JDBC_DRIVER =
	      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://127.0.0.1/etud?relaxAutoCommit=true";
	   static final String DB_USER = "bdelbouys";
	   static final String DB_PASS = "bdelbouys";

	   public static void main(String[] args) {
		Connection conn = null;
		while(conn == null) {
			try {
				Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database ...");
				conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			} catch (Exception e) {
				// do nothing			
			}
			try {
				TimeUnit.SECONDS.sleep(15);
			} catch (Exception e) {
				// do nothing			
			}
		}
		try {
			System.out.println("Database found !");
			conn.close();
		} catch (Exception e) {
			// do nothing
		}
	      JFrame f=new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	      f.getContentPane().add(new PersonUI());
	      f.setSize(600, 280);
	      f.setVisible(true);
	   }
	}
