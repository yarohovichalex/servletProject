package by.htp.servis;

import java.util.ArrayList;
import java.util.List;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.dao.BaseDao;
import by.htp.dao.ServiceVariable;
import by.htp.dao.UserService;
import by.htp.dao.impl.AddBookDaoImpl;
import by.htp.dao.impl.AddUserDaoImpl;
import by.htp.dao.impl.CheckServiceVariable;
import by.htp.dao.impl.DeleteBookDaoImpl;
import by.htp.dao.impl.EditBookDaoImpl;
import by.htp.dao.impl.IncrementServiceVariable;
import by.htp.dao.impl.OutputBookDaoImpl;
import by.htp.dao.impl.RenderBookDaoImpl;
import by.htp.dao.impl.SearchBookDaoImpl;
import by.htp.dao.impl.TakeBookDaoImpl;
import by.htp.dao.impl.TakeServiceVariable;
import by.htp.dao.impl.UserAuthenticationImpl;

public class BookService
{
    private static List<Book> list = new ArrayList<>();

    public BookService()
    {
        super();
    }

    private BaseDao dao;
    private User us;
    
    public boolean loginVerification (String login) {
        CheckServiceVariable dao = new CheckServiceVariable();
        return dao.verifyUsername(login);
    }

    public void delete(int id)
    {
        dao = new DeleteBookDaoImpl();
        dao.delete(id);
    }
    public void render(String login)
    {
        RenderBookDaoImpl dao = new RenderBookDaoImpl();
        dao.render(login);
    }
    public void takeBook(int id, User user)
    {
        TakeBookDaoImpl dao = new TakeBookDaoImpl();
        dao.takeBook(id, user);
    }
    public int getCount() {
        ServiceVariable count = new TakeServiceVariable();
        return count.imageCount();
    }
    public void incrementCount(int countImg) {
        IncrementServiceVariable count = new IncrementServiceVariable();
        count.incremenCount(countImg);
    }
    
    
    public void createUser(User user) {
        UserService creatorOfUser = new AddUserDaoImpl();
        creatorOfUser.criateUser(user);
    }

    public void criate(Book book)
    {
        dao = new AddBookDaoImpl();
        dao.criate(book);
    }

    public User searchUser(String login, String password)
    {
        dao = new UserAuthenticationImpl();
        us = dao.searchUser(login, password);
        return us;
    }

    public void editBook(int id, Book book)
    {
        dao = new EditBookDaoImpl();
        dao.editBook(id, book);
    }

    public List<Book> outputBook()
    {
        dao = new OutputBookDaoImpl();
        list.clear();
        list = dao.outputBook();
        return list;
    }

    public List<Book> bookComents(int id)
    {
        dao = new OutputBookDaoImpl();
        list.clear();
        list = dao.outputBook();
        return list;
    }

    public List<Book> searchBookDao(String bookName)
    {
        dao = new SearchBookDaoImpl();
        list.clear();
        list = dao.searchBookDao(bookName);
        return list;
    }

}
