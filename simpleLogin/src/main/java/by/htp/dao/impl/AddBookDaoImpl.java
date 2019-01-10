package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import by.htp.bean.Book;
import by.htp.dao.BaseDao;

public class AddBookDaoImpl implements BaseDao{
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	
	
	public void criate(Book book) {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			String sql = "INSERT INTO book(id, nameBook, nameAuthor, publishDate) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, book.getId());
			ps.setString(2, book.getTittle());
			ps.setString(3, book.getAuthorName());
			ps.setDate(4, new java.sql.Date(book.getDate().getTime()));
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
	public void delete(int f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBook(int id, Book book) {
		// TODO Auto-generated method stub
		
	}

}
