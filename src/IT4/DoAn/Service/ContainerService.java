package IT4.DoAn.Service;

import IT4.DoAn.DAO.ContainerDAO;
import IT4.DoAn.Model.Container;
import java.sql.Timestamp;

public class ContainerService {
    
    private ContainerDAO containerDao;
    
    public ContainerService() {
        containerDao = new ContainerDAO();
    }

    public void addContainer(Container container) {
        containerDao.AddContainer(container);
    }
    
    public int getContainer_ID(Timestamp Date_Create) {
        return containerDao.getContainer_ID(Date_Create);
    }
}
