package com.thinkitive;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabaseOperations {

	Myconnection db = new Myconnection();
	Statement st;
	PreparedStatement ps;

	public void insertEmp(String name, String pass) {

		try {
			ps = db.getPreparedStatement("insert into Employees values(?,?)");
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.execute();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}

	}
	
	public boolean searchData(String name,String password){
		
		       st = db.getStatement();
		       Boolean b=false;
		
				try {
					ResultSet rs = st.executeQuery("select * from Employees");
		
					while (rs.next()) {
						if(rs.getString(1).equals(name) &&  rs.getString(2).equals(password)){
							b=true;
							break;
						}
					}
		
				} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
				finally{
					db.closeConnection();
				}
		
		return b;
		
	}


}
