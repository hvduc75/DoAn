package IT4.DoAn.Service;

import IT4.DoAn.DAO.StatisticalDAO;
import IT4.DoAn.Model.Order;
import IT4.DoAn.Model.Shipper;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

public class StatisticalService {
    private StatisticalDAO statisticalDao;
    public StatisticalService() {
        statisticalDao = new StatisticalDAO();
    }
    
    public Vector<Vector<String>> getAllStatisticalShipper(Timestamp before, Timestamp after) {
        return statisticalDao.getAllStatisticalShipper(before, after);
    }
    
    public List<Order> getAllOrderDeliveredByMonth(Timestamp before, Timestamp after) {
        return statisticalDao.getAllOrderDeliveredByMonth(before, after);
    }
    
    public List<Order> getAllOrderDeliveringByMonth(Timestamp before, Timestamp after) {
        return statisticalDao.getAllOrderDeliveringByMonth(before, after);
    }
    
    public int getShipperNumber() {
        return statisticalDao.getShipperNumber();
    }
    
    public int getShipperNumberOnline() {
        return statisticalDao.getShipperNumberOnline();
    }
    
    public int getShipperNumberOffline() {
        return statisticalDao.getShipperNumberOffline();
    }
    
    public int getOrderNumber() {
        return statisticalDao.getOrderNumber();
    }
    
    public int getOrderNumberDelivering() {
        return statisticalDao.getOrderNumberDelivering();
    }
    
    public int getOrderNumberDelivered() {
        return statisticalDao.getOrderNumberDelivered();
    }
    
    public List<Shipper> getAllShipperByScore() {
        return statisticalDao.getAllShipperByScore();
    }
}
