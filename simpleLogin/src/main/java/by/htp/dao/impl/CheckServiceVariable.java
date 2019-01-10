package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckServiceVariable
{
    private static final String url = "jdbc:mysql://localhost/logindb?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
            + "=false&serverTimezone=UTC&useSSL=false";

    public boolean verifyUsername(String login)
    {
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
            ResultSet rs = st.executeQuery("select * from user;");
            while (rs.next())
            {
                String userLogin = rs.getString("login");
                if (login.equals(userLogin))
                {
                    return true;
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
