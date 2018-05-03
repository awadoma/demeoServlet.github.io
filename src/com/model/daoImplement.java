package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class daoImplement implements daoInterface {
    private Daofactory daofactory;
    
	public daoImplement(Daofactory daofactory) {
		this.daofactory = daofactory;
	}

	@Override
	public void save(login login) {
		Connection con=null;
		PreparedStatement pstmt = null;
		
		try {
			con=daofactory.getconnection();
		    pstmt = con.prepareStatement("insert into login(name,password) value(?,?)");
		    pstmt.setString(1, login.name);
		    pstmt.setString(2, login.password);
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<login> getAll() {
		List<login> ls = new ArrayList<login>();
		
		try {
			Connection con = daofactory.getconnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from login");
			while(rs.next()) {
				login login= new login();
				int id = rs.getInt("id");
				String name=rs.getString("name");
				String password =rs.getString("password");
				login.setId(id);
				login.setName(name);
				login.setPassword(password);
				ls.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}

}
