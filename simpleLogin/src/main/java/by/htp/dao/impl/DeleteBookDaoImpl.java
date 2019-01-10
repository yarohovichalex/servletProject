package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import by.htp.bean.Book;
import by.htp.dao.BaseDao;

public class DeleteBookDaoImpl implements BaseDao{
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	
	public void delete(int id) {
		System.out.println("delete " + id);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){			
			PreparedStatement ps = cn.prepareStatement("delete from book where id = ?;");			
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
}

	

	@Override
	public List<Book> searchBookDao(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> outputBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criate(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBook(int id, Book book) {
		// TODO Auto-generated method stub
		
	}

	
}
