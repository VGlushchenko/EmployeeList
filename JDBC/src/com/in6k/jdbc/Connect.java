package com.in6k.jdbc;

import java.sql.*;

public class Connect {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		try {	
			Class.forName ("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection ("jdbc:mysql://localhost/db", "root", "");
			System.out.println ("Database connection established");
			
			new Select(conn);
			
		}catch (Exception e) {
			   System.err.println ("Cannot connect to database server");
			   e.printStackTrace();
		}
		
		finally {
			if (conn != null) {
				try {
					conn.close ();
					System.out.println ("Database connection terminated"); 
				}
				catch (Exception e) { }
			}
			
		}
		
	}
	
}