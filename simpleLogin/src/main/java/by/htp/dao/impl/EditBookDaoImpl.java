package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import by.htp.bean.Book;
import by.htp.dao.BaseDao;

public class EditBookDaoImpl implements BaseDao {
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
		
	
	
	

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
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criate(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBook(int id, Book book) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			PreparedStatement ps = cn.prepareStatement("UPDATE book SET nameBook = ?, nameAuthor = ?," 
					+ "	publishDate = ? where id = ?;");
			ps.setString(1, book.getTittle());
			ps.setString(2, book.getAuthorName());
			
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String stringDate = formatter.format(book.getDate());			
			
			ps.setString(3, stringDate);
			ps.setString(4, String.valueOf(id));
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
