package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ReceiptDAO {

    ConnectionToSQLServer connectionToSQLServer;

    public void UpdateDeleteReason(String reason, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE DELIVERYRECEIPT SET DELETEREASON = ? WHERE RECEIPT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reason);
            preparedStatement.setInt(2, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddReceipt(int con_Id, int order_Id, String reason) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "INSERT INTO DELIVERYRECEIPT (CON_ID, ORDER_ID, DELETEREASON) VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, con_Id);
            preparedStatement.setInt(2, order_Id);
            preparedStatement.setString(3, reason);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<Vector<String>> getAllOrderHistory(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        Vector<Vector<String>> data = new Vector<>();
        String sql = "SELECT O.ORDER_ID, O.ORDER_NAME, O.ORDER_PRICE, S.SHIPPER_ID, S.SHIPPER_NAME, C.CON_ID, O.ORDER_DATE_CREATE, O.ORDER_DELIVERY_EXPECTED, O.ORDER_DELIVERY_ACTUAL, D.DELETEREASON\n"
                + "FROM (((CONTAINER AS C INNER JOIN SHIPPER AS S\n"
                + "ON C.SHIPPER_ID = S.SHIPPER_ID) iNNER JOIN DELIVERYRECEIPT AS D\n"
                + "ON C.CON_ID = D.CON_ID) iNNER JOIN ORDERS AS O\n"
                + "ON O.ORDER_ID = D.ORDER_ID)\n"
                + "WHERE O.ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Vector<String> info = new Vector<>();
                String orderID = rs.getString("ORDER_ID");
                String orderName = rs.getString("ORDER_NAME");
                String orderPrice = rs.getString("ORDER_PRICE");
                String shipperID = rs.getString("SHIPPER_ID");
                String shipperName = rs.getString("SHIPPER_NAME");
                String conID = rs.getString("CON_ID");
                String orderDateCreate = rs.getString("ORDER_DATE_CREATE");
                String orderDelivery_Expected = rs.getString("ORDER_DELIVERY_EXPECTED");
                String orderDelivery_Actual = rs.getString("ORDER_DELIVERY_ACTUAL");
                String reasonDelete = rs.getString("DELETEREASON");
                info.add(orderID);
                info.add(orderName);
                info.add(orderPrice);
                info.add(shipperID);
                info.add(shipperName);
                info.add(conID);
                info.add(orderDateCreate);
                info.add(orderDelivery_Expected);
                info.add(orderDelivery_Actual);
                info.add(reasonDelete);
                data.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
