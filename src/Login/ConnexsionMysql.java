package Login;
import javax.swing.*;
import java.sql.*;

public class ConnexsionMysql {
    Connection conn = null;

    public static Connection ConnexsionDB() {
        try {


            // Correct JDBC URL format
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/PROJETJAVA", "root", "root");

            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

