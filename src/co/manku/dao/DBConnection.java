
package co.manku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	public static Connection getDBConnection() {
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/Appointment", "root", "password");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
		
	}
	
	public static ResultSet processQuery(String query) {
		Connection con=getDBConnection();
		ResultSet res=null;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement(query);
			res=pstmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return res;
		}
		
	}
	
	public static int update(String query) {
		Connection con=getDBConnection();
		int res=-1;
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(query);
			res=pstmt.executeUpdate();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return res;
		}
	}
	
	public static void main(String[] args) {
		ResultSet res=processQuery("show tables");
		try {
			while(res.next()) {
				System.out.println(res.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		int update=update("insert into Applicant_Login values ('root','password',123)");
		System.out.println(update);
	}


}
