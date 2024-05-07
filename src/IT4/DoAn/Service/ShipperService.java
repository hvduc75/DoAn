package IT4.DoAn.Service;

import IT4.DoAn.DAO.ShipperDAO;
import IT4.DoAn.Model.Shipper;
import java.util.List;

public class ShipperService {
    private ShipperDAO shipperDao;

    public ShipperService() {
        shipperDao = new ShipperDAO();
    }
    
    public List<Shipper> getAllShipper(String condition) {
        return shipperDao.getAllShipper(condition);
    }
    
    public Shipper getShipperById(int id) {
        return shipperDao.getShipperById(id);
    }

    public void AddShipper(Shipper shipper) {
        shipperDao.AddShipper(shipper);
    }
    
    public void UpdateShipper(Shipper shipper) {
        shipperDao.updateShipper(shipper);
    }
    
    public void UpdateDelete(int id) {
        shipperDao.UpdateDelete(id);
    }
    
    public void UpdateStatus(Boolean status, int id) {
        shipperDao.UpdateStatus(status, id);
    }
    
    public void UpdateStar(float star, int id) {
        shipperDao.UpdateStar(star, id);
    }
    
    public void UpdateOrdersOfShipper(int id) {
        shipperDao.UpdateOrdersOfShipper(id);
    }
}
