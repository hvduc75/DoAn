package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import IT4.DoAn.Model.Shipper;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StatisticalDAO {

    ConnectionToSQLServer connectionToSQLServer;
    
    public Vector<Vector<String>> getAllStatisticalShipper(Timestamp before, Timestamp after) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        Vector<Vector<String>> data = new Vector<>();
        String sql = "SELECT S.SHIPPER_ID, S.SHIPPER_NAME, COUNT(O.ORDER_ID) AS NUMBER_ORDER, SUM(O.ORDER_PRICE) AS TOTAL_ORDER_PRICE\n"
                + "FROM CONTAINER AS C \n"
                + "INNER JOIN SHIPPER AS S ON C.SHIPPER_ID = S.SHIPPER_ID \n"
                + "INNER JOIN ORDERS AS O ON O.CON_ID = C.CON_ID\n"
                + "WHERE O.ORDER_STATUS = 3 AND ORDER_DELIVERY_ACTUAL >= ? \n"
                + "AND ORDER_DELIVERY_ACTUAL < ?\n"
                + "GROUP BY S.SHIPPER_ID, S.SHIPPER_NAME";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, before);
            preparedStatement.setTimestamp(2, after);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Vector<String> info = new Vector<>();
                String shipperID = rs.getString("SHIPPER_ID");
                String shipperName = rs.getString("SHIPPER_NAME");
                String numberOrder = rs.getString("NUMBER_ORDER");
                String totalPrice = rs.getString("TOTAL_ORDER_PRICE");
                info.add(shipperID);
                info.add(shipperName);
                info.add(numberOrder);
                totalPrice+="00đ";
                info.add(totalPrice);
                data.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getShipperNumber() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(SHIPPER_ID) AS SHIPPERNUM FROM SHIPPER";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("SHIPPERNUM");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getShipperNumberOnline() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(SHIPPER_ID) AS SHIPPERNUM FROM SHIPPER WHERE SHIPPER_STATUS = 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("SHIPPERNUM");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getShipperNumberOffline() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(SHIPPER_ID) AS SHIPPERNUM FROM SHIPPER WHERE SHIPPER_STATUS = 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("SHIPPERNUM");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getOrderNumber() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(ORDER_ID) AS ORDERNUM FROM ORDERS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("ORDERNUM");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getOrderNumberDelivering() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(ORDER_ID) AS ORDERNUM FROM ORDERS WHERE ORDER_STATUS = 2";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("ORDERNUM");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getOrderNumberDelivered() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(ORDER_ID) AS ORDERNUM FROM ORDERS WHERE ORDER_STATUS = 3";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("ORDERNUM");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Shipper> getAllShipperByScore() {
        List<Shipper> Shippers = new ArrayList<>();
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT * FROM SHIPPER\n"
                + "WHERE SHIPPER_CHECK_DELETE=0\n"
                + "ORDER BY SHIPPER_SCORE DESC";

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
}
