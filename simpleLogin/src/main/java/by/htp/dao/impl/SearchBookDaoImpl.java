package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.bean.Book;
import by.htp.dao.BaseDao;

public class SearchBookDaoImpl implements BaseDao
{
    private static final String url = "jdbc:mysql://localhost/logindb?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
            + "=false&serverTimezone=UTC&useSSL=false";

    public List<Book> searchBookDao(String bookName)
    {

        List<Book> bookNameList = new ArrayList<>();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }
        try (Connection cn = DriverManager.getConnection(url, "root", "root"))
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from book;");
            while (rs.next())
            {
                String nameBook = rs.getString("nameBook");
                if (nameBook.contains(bookName))
                {
                    String nameAuthor = rs.getString("nameAuthor");
                    String bookImage = rs.getString("bookImg");
                    Date date = rs.getDate("publishDate");
                    int id = rs.getInt("id");
                    bookNameList.add(new Book(nameBook, nameAuthor, date, id, bookImage));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookNameList;
    }

    @Override
    public List<Book> outputBook()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(int f)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void criate(Book entity)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void editBook(int id, Book book)
    {
        // TODO Auto-generated method stub

    }

}
