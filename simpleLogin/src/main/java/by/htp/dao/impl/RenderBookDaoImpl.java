package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RenderBookDaoImpl {
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	
	public void render(String login) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){			
            PreparedStatement ps = cn.prepareStatement("UPDATE user SET readBook = ? where login = ?;");
            ps.setInt(1, 0);           
            ps.setString(2, login);
            ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
}	
}
