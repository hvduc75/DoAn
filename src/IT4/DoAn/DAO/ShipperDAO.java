package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import IT4.DoAn.Model.Shipper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShipperDAO {

    ConnectionToSQLServer connectionToSQLServer;

    public List<Shipper> getAllShipper(String condition) {
        List<Shipper> Shippers = new ArrayList<>();
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT * FROM SHIPPER WHERE SHIPPER_CHECK_DELETE = 0 AND " + condition;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Shipper shipper = new Shipper();
                shipper.setShipper_Id(rs.getInt("SHIPPER_ID"));
                shipper.setName(rs.getString("SHIPPER_NAME"));
                shipper.setBirthDay(rs.getString("SHIPPER_BIRTHDAY"));
                shipper.setGender(rs.getString("SHIPPER_GENDER"));
                shipper.setStartWork(rs.getString("SHIPPER_STARTWORK"));
                shipper.setPhone(rs.getString("SHIPPER_PHONE"));
                shipper.setCheck_Delete(rs.getBoolean("SHIPPER_CHECK_DELETE"));
                shipper.setEmail(rs.getString("SHIPPER_EMAIL"));
                shipper.setAddress(rs.getString("SHIPPER_ADDRESS"));
                shipper.setDescription(rs.getString("SHIPPER_DESCRIPTION"));
                shipper.setScore(rs.getFloat("SHIPPER_SCORE"));
                Shippers.add(shipper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Shippers;
    }

    public Shipper getShipperById(int shipperId) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT * FROM SHIPPER WHERE SHIPPER_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shipperId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Shipper shipper = new Shipper();
                shipper.setShipper_Id(rs.getInt("SHIPPER_ID"));
                shipper.setName(rs.getString("SHIPPER_NAME"));
                shipper.setBirthDay(rs.getString("SHIPPER_BIRTHDAY"));
                shipper.setGender(rs.getString("SHIPPER_GENDER"));
                shipper.setStartWork(rs.getString("SHIPPER_STARTWORK"));
                shipper.setPhone(rs.getString("SHIPPER_PHONE"));
                shipper.setEmail(rs.getString("SHIPPER_EMAIL"));
                shipper.setAddress(rs.getString("SHIPPER_ADDRESS"));
                shipper.setDescription(rs.getString("SHIPPER_DESCRIPTION"));
                shipper.setScore(rs.getFloat("SHIPPER_SCORE"));
                shipper.setStatus(rs.getBoolean("SHIPPER_STATUS"));
                return shipper;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void AddShipper(Shipper shipper) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "INSERT INTO SHIPPER (SHIPPER_NAME, SHIPPER_BIRTHDAY, SHIPPER_GENDER, SHIPPER_STARTWORK, SHIPPER_PHONE, SHIPPER_EMAIL, SHIPPER_ADDRESS, SHIPPER_DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shipper.getName());
            preparedStatement.setString(2, shipper.getBirthDay());
            preparedStatement.setString(3, shipper.getGender());
            preparedStatement.setString(4, shipper.getStartWork());
            preparedStatement.setString(5, shipper.getPhone());
            preparedStatement.setString(6, shipper.getEmail());
            preparedStatement.setString(7, shipper.getAddress());
            preparedStatement.setString(8, shipper.getDescription());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateShipper(Shipper shipper) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();

        String sql = "UPDATE SHIPPER SET SHIPPER_NAME = ?, SHIPPER_BIRTHDAY = ?, SHIPPER_GENDER = ?, SHIPPER_STARTWORK = ?, SHIPPER_PHONE = ?, SHIPPER_EMAIL = ?, SHIPPER_ADDRESS = ?, SHIPPER_DESCRIPTION = ? WHERE SHIPPER_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shipper.getName());
            preparedStatement.setString(2, shipper.getBirthDay());
            preparedStatement.setString(3, shipper.getGender());
            preparedStatement.setString(4, shipper.getStartWork());
            preparedStatement.setString(5, shipper.getPhone());
            preparedStatement.setString(6, shipper.getEmail());
            preparedStatement.setString(7, shipper.getAddress());
            preparedStatement.setString(8, shipper.getDescription());
            preparedStatement.setInt(9, shipper.getShipper_Id());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdateDelete(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();

        String sql = "UPDATE SHIPPER SET SHIPPER_CHECK_DELETE = ? WHERE SHIPPER_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, id);
          
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void UpdateStatus(Boolean staus, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();

        String sql = "UPDATE SHIPPER SET SHIPPER_STATUS = ? WHERE SHIPPER_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, staus);
            preparedStatement.setInt(2, id);
          
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void UpdateStar(float Star, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();

        String sql = "UPDATE SHIPPER SET SHIPPER_SCORE = ? WHERE SHIPPER_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, Star);
            preparedStatement.setInt(2, id);
          
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdateOrdersOfShipper(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();

        String sql = "UPDATE ORDERS\n"
                + "SET CON_ID = NULL, ORDER_STATUS = 1, ORDER_DELIVERY_EXPECTED = NULL\n"
                + "WHERE CON_ID = (SELECT O.CON_ID\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) INNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE O.ORDER_STATUS = 1 AND S.SHIPPER_ID = ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
          
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
