package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.htp.bean.User;
import by.htp.dao.UserService;

public class AddUserDaoImpl implements UserService
{
    private static final String url = "jdbc:mysql://localhost/logindb?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
            + "=false&serverTimezone=UTC&useSSL=false";

    public void criateUser(User user)
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
            String sql = "INSERT INTO user(name, surname, login, password, imageAdress) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getImageAdres());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
