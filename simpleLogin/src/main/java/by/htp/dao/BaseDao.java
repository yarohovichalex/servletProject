package by.htp.dao;

import java.util.List;

import by.htp.bean.Book;
import by.htp.bean.User;

public interface BaseDao {
	default User searchUser(String login, String password) {
		return null;
	}
	List<Book> searchBookDao(String bookName);
	List<Book> outputBook();
	void delete(int id);
	void criate(Book entity); 
	void editBook(int id, Book book);
}
