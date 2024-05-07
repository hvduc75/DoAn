package IT4.DoAn.Service;

import IT4.DoAn.DAO.ReceiptDAO;
import java.util.Vector;

public class ReceiptService {
    private ReceiptDAO receiptDao;
    public ReceiptService() {
        receiptDao = new ReceiptDAO();
    }
 
    public void UpdateDeleteReason(String reason, int id) {
        receiptDao.UpdateDeleteReason(reason, id);
    }
    
    public void AddReceipt(int con_Id, int order_Id, String reason) {
        receiptDao.AddReceipt(con_Id, order_Id, reason);
    }
    
    public Vector<Vector<String>> getAllOrderHistory(int id) {
        return receiptDao.getAllOrderHistory(id);
    }
}
