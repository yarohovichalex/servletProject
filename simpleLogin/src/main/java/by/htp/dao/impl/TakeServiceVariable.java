package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.dao.ServiceVariable;

public class TakeServiceVariable implements ServiceVariable
{
    private static final String url = "jdbc:mysql://localhost/logindb?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
            + "=false&serverTimezone=UTC&useSSL=false";

    public TakeServiceVariable()
    {
        super();
    }

    public int imageCount()
    {
        int nameBook = 0;        
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
            ResultSet rs = st.executeQuery("select userImageCount from servicevariables;");
            while(rs.next()) {
                nameBook = rs.getInt("userImageCount");
            }                                 
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }       
        return nameBook;
    }
}
