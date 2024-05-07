package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class SearchDAO {
    ConnectionToSQLServer connectionToSQLServer;
    public int NOOBDelivered(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(ORDER_STATUS) AS 'SO LUONG'\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_STATUS = 2\n"
                + "GROUP BY ORDER_STATUS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) { // Di chuyển con trỏ đến hàng đầu tiên
                int NumberOfOrder = rs.getInt("SO LUONG");
                return NumberOfOrder;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int NOODelivered(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(ORDER_STATUS) AS 'SO LUONG'\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_STATUS = 3\n"
                + "GROUP BY ORDER_STATUS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) { // Di chuyển con trỏ đến hàng đầu tiên
                int NumberOfOrder = rs.getInt("SO LUONG");
                return NumberOfOrder;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int NOODeliveredNotFeedBack(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT COUNT(ORDER_STATUS) AS 'SO LUONG'\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_STATUS = 3 AND O.ORDER_FEEDBACK IS NULL\n"
                + "GROUP BY ORDER_STATUS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) { // Di chuyển con trỏ đến hàng đầu tiên
                int NumberOfOrder = rs.getInt("SO LUONG");
                return NumberOfOrder;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Vector<Vector<String>> getAllBDOrderInformation(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        Vector<Vector<String>> data = new Vector<>();
        String sql = "SELECT S.SHIPPER_ID, S.SHIPPER_NAME, O.ORDER_ID, C.CON_ID, O.ORDER_NAME, O.ORDER_PRICE, O.ORDER_DATE_CREATE, O.ORDER_DELIVERY_EXPECTED\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_STATUS = 2";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Vector<String> info = new Vector<>();
                String shipperID = rs.getString("SHIPPER_ID");
                String shipperName = rs.getString("SHIPPER_NAME");
                String orderID = rs.getString("ORDER_ID");
                String conID = rs.getString("CON_ID");
                String orderName = rs.getString("ORDER_NAME");
                String orderPrice = rs.getString("ORDER_PRICE");
                String orderDateCreate = rs.getString("ORDER_DATE_CREATE");
                String orderDelivery_Expected = rs.getString("ORDER_DELIVERY_EXPECTED");
                info.add(shipperID);
                info.add(shipperName);
                info.add(orderID);
                info.add(conID);
                info.add(orderName);
                orderPrice+="00đ";
                info.add(orderPrice);
                info.add(orderDateCreate);
                info.add(orderDelivery_Expected);
                data.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public Vector<Vector<String>> getAllDOrderInformation(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        Vector<Vector<String>> data = new Vector<>();
        String sql = "SELECT S.SHIPPER_ID, S.SHIPPER_NAME,O.ORDER_ID, O.ORDER_NAME, O.ORDER_PRICE, O.ORDER_DATE_CREATE, O.ORDER_DELIVERY_ACTUAL\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_STATUS = 3";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Vector<String> info = new Vector<>();
                String shipperID = rs.getString("SHIPPER_ID");
                String shipperName = rs.getString("SHIPPER_NAME");
                String orderID = rs.getString("ORDER_ID");
                String orderName = rs.getString("ORDER_NAME");
                String orderPrice = rs.getString("ORDER_PRICE");
                String orderDateCreate = rs.getString("ORDER_DATE_CREATE");
                String orderDelivery_Actual = rs.getString("ORDER_DELIVERY_ACTUAL");
                info.add(shipperID);
                info.add(shipperName);
                info.add(orderID);
                info.add(orderName);
                orderPrice+="00đ";
                info.add(orderPrice);
                info.add(orderDateCreate);
                info.add(orderDelivery_Actual);
                data.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public Vector<Vector<String>> getAllDOrderInformationNotFeedback(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        Vector<Vector<String>> data = new Vector<>();
        String sql = "SELECT S.SHIPPER_ID, S.SHIPPER_NAME,O.ORDER_ID, O.ORDER_NAME, O.ORDER_PRICE, O.ORDER_DATE_CREATE, O.ORDER_DELIVERY_ACTUAL\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_STATUS = 3 AND O.ORDER_FEEDBACK IS NULL";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Vector<String> info = new Vector<>();
                String shipperID = rs.getString("SHIPPER_ID");
                String shipperName = rs.getString("SHIPPER_NAME");
                String orderID = rs.getString("ORDER_ID");
                String orderName = rs.getString("ORDER_NAME");
                String orderPrice = rs.getString("ORDER_PRICE");
                String orderDateCreate = rs.getString("ORDER_DATE_CREATE");
                String orderDelivery_Actual = rs.getString("ORDER_DELIVERY_ACTUAL");
                info.add(shipperID);
                info.add(shipperName);
                info.add(orderID);
                info.add(orderName);
                orderPrice+="00đ";
                info.add(orderPrice);
                info.add(orderDateCreate);
                info.add(orderDelivery_Actual);
                data.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public Vector<Vector<String>> getAllDOrderInformationFeedbacked(int id, int orderId) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        Vector<Vector<String>> data = new Vector<>();
        String sql = "SELECT S.SHIPPER_ID, S.SHIPPER_NAME,O.ORDER_ID, O.ORDER_NAME, O.ORDER_PRICE, O.ORDER_DATE_CREATE, O.ORDER_DELIVERY_ACTUAL\n"
                + "FROM (CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.CON_ID = C.CON_ID\n"
                + "WHERE S.SHIPPER_ID = ? AND O.ORDER_ID = ? AND O.ORDER_STATUS = 3 AND O.ORDER_FEEDBACK IS NOT NULL";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Vector<String> info = new Vector<>();
                String shipperID = rs.getString("SHIPPER_ID");
                String shipperName = rs.getString("SHIPPER_NAME");
                String orderID = rs.getString("ORDER_ID");
                String orderName = rs.getString("ORDER_NAME");
                String orderPrice = rs.getString("ORDER_PRICE");
                String orderDateCreate = rs.getString("ORDER_DATE_CREATE");
                String orderDelivery_Actual = rs.getString("ORDER_DELIVERY_ACTUAL");
                info.add(shipperID);
                info.add(shipperName);
                info.add(orderID);
                info.add(orderName);
                orderPrice+="00đ";
                info.add(orderPrice);
                info.add(orderDateCreate);
                info.add(orderDelivery_Actual);
                data.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
