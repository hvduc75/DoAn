package IT4.DoAn.Service;

import IT4.DoAn.DAO.SearchDAO;
import java.util.Vector;

public class SearchService {
    private SearchDAO searchDao;
    public SearchService() {
        searchDao = new SearchDAO();
    }
 
    public int NOOBDelivered(int id) {
        return searchDao.NOOBDelivered(id);
    }
    
    public int NOODelivered(int id) {
        return searchDao.NOODelivered(id);
    }
    
    public int NOODeliveredNotFeedBack(int id) {
        return searchDao.NOODeliveredNotFeedBack(id);
    }
    
    public Vector<Vector<String>> getAllBDOrderInformation(int id){
        return searchDao.getAllBDOrderInformation(id);
    }
    
    public Vector<Vector<String>> getAllDOrderInformation(int id){
        return searchDao.getAllDOrderInformation(id);
    }
    
    public Vector<Vector<String>> getAllDOrderInformationNotFeedback(int id){
        return searchDao.getAllDOrderInformationNotFeedback(id);
    }
    
    public Vector<Vector<String>> getAllDOrderInformationFeedbacked(int id, int orderId){
        return searchDao.getAllDOrderInformationFeedbacked(id, orderId);
    }
}
