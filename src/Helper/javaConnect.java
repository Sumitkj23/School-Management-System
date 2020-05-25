package Helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumit Kumar
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class javaConnect {
    public static Connection connectDb()        // static method... so call directly by the help of class name
    {
        Connection conn = null;
        
        try
        {
            Class.forName("org.sqlite.JDBC");       // load jdbc driver
            conn = DriverManager.getConnection("jdbc:sqlite:src\\School_Management.sqlite");    // path of the database
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
    }
}
