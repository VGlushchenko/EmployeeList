package com.in6k.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	
	public Select (Connection conn) throws SQLException {
		
		String query = "SELECT * FROM USER";
		
		Statement sel = conn.createStatement ();

		ResultSet result = sel.executeQuery(query);
		
		while(result.next()) {
			String id = result.getString("ID");
            String email = result.getString("email");
            String login = result.getString("login");
            String password = result.getString("password");
            System.out.println(id + " | " + email + " | " + login + " | " + password + "\n");
		}
	            
	}
		
}