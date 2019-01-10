package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncrementServiceVariable 
{
    private static final String url = "jdbc:mysql://localhost/logindb?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
            + "=false&serverTimezone=UTC&useSSL=false";

    
    public int incremenCount(int countImg)
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
            String sql = "UPDATE servicevariables set userImageCount = userImageCount + 1 where id = 1;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

}
