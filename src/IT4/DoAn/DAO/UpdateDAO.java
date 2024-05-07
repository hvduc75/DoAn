package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import IT4.DoAn.Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UpdateDAO {
    ConnectionToSQLServer connectionToSQLServer;
    public List<Order> getAllOrdersBeingDelivered() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        List<Order> Orders = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS WHERE ORDER_CHECK_DELETE=0 AND ORDER_STATUS = 2";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("ORDER_ID"));
                order.setName(rs.getString("ORDER_NAME"));
                order.setDelivery_Location(rs.getString("ORDER_DELIVERY_LOCATION"));
                order.setReceive_Location(rs.getString("ORDER_RECEIVE_LOCATION"));
                order.setStatus(rs.getInt("ORDER_STATUS"));
                order.setFeedback(rs.getString("ORDER_DESCRIPTION"));
                order.setDistance(rs.getDouble("ORDER_DISTANCE"));
                order.setPrice(rs.getDouble("ORDER_PRICE"));
                order.setContainer_ID(rs.getInt("CON_ID"));
                order.setCheck_Delete(rs.getBoolean("ORDER_CHECK_DELETE"));
                order.setDate_Create(rs.getTimestamp("ORDER_DATE_CREATE"));
                order.setDelivery_Expected(rs.getTimestamp("ORDER_DELIVERY_EXPECTED"));
                order.setDelivery_Count(rs.getInt("ORDER_DELIVERY_COUNT"));
                Orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Orders;
    }
}
