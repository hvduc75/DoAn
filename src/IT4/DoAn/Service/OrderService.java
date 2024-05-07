package IT4.DoAn.Service;

import IT4.DoAn.DAO.OrderDAO;
import IT4.DoAn.Model.Order;
import java.sql.Timestamp;
import java.util.List;

public class OrderService {
    private OrderDAO orderDao;
    public OrderService() {
        orderDao = new OrderDAO();
    }
    
    public List<Order> getAllOrder() {
        return orderDao.getAllOrders();
    }
    
    public List<Order> getOrderByAddress(String address) {
        return orderDao.getAllOrdersByAddress(address);
    }
    
    public List<Order> getAllOrdersByUserPhone(String PhoneNumber) {
        return orderDao.getAllOrdersByUserPhone(PhoneNumber);
    }
    
    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public void addOrder(Order order) {
        orderDao.AddOrder(order);
    }
 
    public void UpdateOrder(Order order) {
        orderDao.UpdateOrder(order);
    }
    
    public void UpdateDelete(int id) {
        orderDao.UpdateDelete(id);
    }
    
    public void UpdateFeedBack(String feedBack, int id) {
        orderDao.UpdateFeedBack(feedBack, id);
    }
    
    public void UpdateCONTAINER_ID(int CON_ID, int id) {
        orderDao.UpdateContainer_ID(CON_ID, id);
    }
    
    public void UpdateDateExpected(Timestamp Date_Expected, int id) {
        orderDao.UpdateDateExpected(Date_Expected, id);
    }
    
    public void UpdateDateActual(Timestamp Date_Actual, int id) {
        orderDao.UpdateDateActual(Date_Actual, id);
    }
    
    public void UpdateStatus(int Status, int id) {
        orderDao.UpdateStatus(Status, id);
    }
    
    public void UpdateDeliveryCount(int Count, int id) {
        orderDao.UpdateDeliveryCount(Count, id);
    }
}
