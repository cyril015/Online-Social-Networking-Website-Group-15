package util;

// Java Program to Illustrate Working Of JDBC
// with Above Query in Database

// Importing required classes
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


import dao.UserDAO;
import model.User;

// Main class
// JDBC demo class
class GFG {

 // Main driver method
 public static void main(String[] args)
 {

  // Declaring and initializing arguments that
  // needed to be passed later in getConnection()
  String url = "jdbc:mysql://localhost:3306/social_network";
  String uname = "root";
  String pass = "sakshi";

  // Query from the database taken
  // Custom query taken to illustrate
  String query
   = "select * from user";

  // Loading and registering drivers
  try {
	Class.forName("com.mysql.cj.jdbc.Driver");

  // Creating an connection object by
  // getConnection() method which is static method and
  // returns the instance of Connection class

  // This method takes 3 parameters as defined above
 // Connection con
   //= DriverManager.getConnection(url, uname, pass);

	Connection con = DBConnection.getInstance().getConnection();

  
  Statement st = con.createStatement();
  
  // It returns a tabular structure so we need
  // ResultSet as it stores chunk of data into
  // structures
  ResultSet rs = st.executeQuery("select * from user");

  // Now we are having our data in object of ResultSet
  // which is no more tabular

  // Note:
  // Fetching the above data by storing it as a String
  // Here pointer is lagging with data for which we
  // use next() method to
  // take it to next record
  rs.next();
  String name = rs.getString("first_name");
  
  // Lastly print the data
  System.out.println(name);

  // Here we
  // Here we are fetching username column data
  //String name = rs.getString("username");

  // Lastly print the data
  //System.out.println(name);

  // It is good practice to close the connection
  // using close() method

  // Closing the statement first
  st.close();
 
  // Now close the connection also
  con.close();
  
  UserDAO u=new UserDAO();
  u.register(new User(2,"neha","shah","neha","neha@gmail.com",""));
  
  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 }
}
