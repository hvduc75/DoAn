package IT4.DoAn.Service;

import IT4.DoAn.DAO.UserDAO;
import IT4.DoAn.Model.ModelLogin;
import IT4.DoAn.Model.ModelUser;
import java.sql.SQLException;

public class ServiceUser {

    private UserDAO userDao;
    public ServiceUser() {
        userDao = new UserDAO();
    }
    
    public ModelUser login(ModelLogin login) throws SQLException{
        return userDao.login(login);
    }
    
    public void insertUser(ModelUser user) throws SQLException {
        userDao.insertUser(user);
    }
    
    public boolean checkDuplicateUser(String user) throws SQLException {
        return userDao.checkDuplicateUser(user);
    }
    
    public boolean checkDuplicateEmail(String user) throws SQLException {
        return userDao.checkDuplicateEmail(user);
    }
    
     public boolean checkConfirmPassword(String password, String confirmPassword) {
         return userDao.checkConfirmPassword(password, confirmPassword);
     }
     
     public void doneVerify(int userID) throws SQLException {
         userDao.doneVerify(userID);
     }
     
     public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
         return userDao.verifyCodeWithUser(userID, code);
     }
}
