package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import IT4.DoAn.Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    ConnectionToSQLServer connectionToSQLServer;
    public List<Order> getAllOrders() {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        List<Order> Orders = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS WHERE ORDER_CHECK_DELETE=0 AND ORDER_STATUS = 1 AND (ORDER_DELIVERY_COUNT = 1 OR ORDER_DELIVERY_COUNT = 2 OR ORDER_DELIVERY_COUNT = 3 OR ORDER_DELIVERY_COUNT IS NULL)";
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
                order.setUser_name(rs.getString("USER_NAME"));
                order.setUser_phone(rs.getString("USER_PHONE"));
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
    
    public List<Order> getAllOrdersByAddress(String Address) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        List<Order> Orders = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS WHERE ORDER_CHECK_DELETE=0 AND ORDER_STATUS = 1 AND ORDER_DELIVERY_LOCATION=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Address);
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
//                order.setUser_name(rs.getString("USER_NAME"));
//                order.setUser_name(rs.getString("USER_PHONE"));
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
    
    public List<Order> getAllOrdersByUserPhone(String PhoneNumber) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        List<Order> Orders = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS WHERE USER_PHONE=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PhoneNumber);
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
                order.setUser_name(rs.getString("USER_NAME"));
                order.setUser_phone(rs.getString("USER_PHONE"));
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
    
    public Order getOrderById(int OrderId) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = ? AND ORDER_CHECK_DELETE = 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, OrderId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("ORDER_ID"));
                order.setName(rs.getString("ORDER_NAME"));
                order.setDelivery_Location(rs.getString("ORDER_DELIVERY_LOCATION"));
                order.setReceive_Location(rs.getString("ORDER_RECEIVE_LOCATION"));
                order.setStatus(rs.getInt("ORDER_STATUS"));
                order.setDescription(rs.getString("ORDER_DESCRIPTION"));
                order.setDistance(rs.getDouble("ORDER_DISTANCE"));
                order.setPrice(rs.getDouble("ORDER_PRICE"));
                order.setContainer_ID(rs.getInt("CON_ID"));
                order.setUser_name(rs.getString("USER_NAME"));
                order.setUser_phone(rs.getString("USER_PHONE"));
                order.setCheck_Delete(rs.getBoolean("ORDER_CHECK_DELETE"));
                order.setDate_Create(rs.getTimestamp("ORDER_DATE_CREATE"));
                order.setDelivery_Expected(rs.getTimestamp("ORDER_DELIVERY_EXPECTED"));
                order.setDelivery_Count(rs.getInt("ORDER_DELIVERY_COUNT"));
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void AddOrder(Order order) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "INSERT INTO ORDERS (ORDER_NAME, ORDER_DELIVERY_LOCATION, ORDER_RECEIVE_LOCATION, ORDER_DESCRIPTION, ORDER_DISTANCE, ORDER_PRICE, USER_NAME, USER_PHONE, ORDER_DATE_CREATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getDelivery_Location());
            preparedStatement.setString(3, order.getReceive_Location());
            preparedStatement.setString(4, order.getDescription());
            preparedStatement.setDouble(5, order.getDistance());
            preparedStatement.setDouble(6, order.getPrice());          
            preparedStatement.setString(7, order.getUser_name());
            preparedStatement.setString(8, order.getUser_phone());
            preparedStatement.setTimestamp(9, order.getDate_Create());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateOrder(Order order) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_NAME = ?, ORDER_DELIVERY_LOCATION = ?, ORDER_RECEIVE_LOCATION = ?, ORDER_DESCRIPTION = ?, ORDER_DISTANCE = ?, ORDER_PRICE = ?, USER_NAME = ?, USER_PHONE = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getDelivery_Location());
            preparedStatement.setString(3, order.getReceive_Location());
            preparedStatement.setString(4, order.getDescription());
            preparedStatement.setDouble(5, order.getDistance());
            preparedStatement.setDouble(6, order.getPrice());
            preparedStatement.setString(7, order.getUser_name());
            preparedStatement.setString(8, order.getUser_phone());
            preparedStatement.setInt(9, order.getId());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateDelete(int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_CHECK_DELETE = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateFeedBack(String feedBack, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_FEEDBACK = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, feedBack);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateContainer_ID(int CON_ID, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET CON_ID = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CON_ID);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateDateExpected(Timestamp Date_Expected, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_DELIVERY_EXPECTED = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, Date_Expected);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateDateActual(Timestamp Date_Actual, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_DELIVERY_ACTUAL = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, Date_Actual);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateStatus(int Status, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_STATUS = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Status);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateDeliveryCount(int Count, int id) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "UPDATE ORDERS SET ORDER_DELIVERY_COUNT = ? WHERE ORDER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Count);
            preparedStatement.setInt(2, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
