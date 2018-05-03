package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Daofactory {
private static String url;
private static String user;
private static String pass;

Daofactory(String url, String user,String pass){
	this.url = url;
	this.user = user;
	this.pass=pass;
}

public static Daofactory getinstance() {
	
	 try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Daofactory daofactory = new Daofactory("jdbc:mysql://localhost:3306/login","root","zool/1985/ajeep/");
	return daofactory;
}

 public Connection getconnection() throws SQLException {
	 return DriverManager.getConnection(url,user,pass);
 }
 public daoInterface initialisDao() {
	 return new daoImplement(this);
 }
 
 
}
