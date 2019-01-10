package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.htp.bean.User;

public class TakeBookDaoImpl {
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";

	
	public void takeBook(int id, User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
		    
			PreparedStatement ps = cn.prepareStatement("UPDATE user SET readBook = ? where login = ?;");
			System.out.println(id + " id");
			ps.setInt(1, id);			
			ps.setString(2, user.getLogin());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
