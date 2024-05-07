package IT4.DoAn.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToSQLServer {
    public static Connection getJDBCConnectionShipper() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLShipper";
        String user = "sa";
        String password = "123456789";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static Connection getJDBCConnectionAccount() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Accounts";
        String user = "sa";
        String password = "123456789";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Connection con = getJDBCConnectionAccount();
        if(con != null) {
            System.out.println("ket noi thanh cong");
        } else {
            System.out.println("ket noi that bai");
        }
    }
}
