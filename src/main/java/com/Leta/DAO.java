package com.Leta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DAO {

	String url="jdbc:mysql://localhost:3306/user_info" ;
	String userName="root";
	String password="0991175590";
	
	 Connection connection;
	 PreparedStatement statement;
	 ResultSet result;
	 
	public DAO() {
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			System.out.println("Connection created successfully !");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public boolean addUser(User loginInfo) {
		try {
			
			if(loginInfo.getUserName().equals("")) return false;
			
		statement=connection.prepareStatement("insert into userAccount values (null,?,?)");
		statement.setString(1, loginInfo.getUserName() );
		statement.setString(2, loginInfo.getUserPassword() );
		statement.execute();
		loginInfo.setUserName("");
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

	 public boolean login(User loginInfo) {
		 try {
			 
			String query="select * from userAccount where userName=? and userPassword=?";
			statement=connection.prepareStatement(query);
			statement.setString(1, loginInfo.getUserName());
			statement.setString(2, loginInfo.getUserPassword());
			
			result=statement.executeQuery();
			
			if(result.next())   return true ; else return false;
		 
		 
		 
		 } catch (SQLException e) {
			 e.printStackTrace();
			return false;
		}
		 
	 }
	
	
	
}
