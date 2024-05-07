package IT4.DoAn.DAO;

import IT4.DoAn.Controller.ConnectionToSQLServer;
import IT4.DoAn.Model.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class ContainerDAO {
    ConnectionToSQLServer connectionToSQLServer;
    public void AddContainer(Container container) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "INSERT INTO CONTAINER (CON_DATE_CREATE, SHIPPER_ID) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, container.getDate_Create());
            preparedStatement.setInt(2, container.getShipper_Id());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getContainer_ID(Timestamp Date_Create) {
        Connection connection = connectionToSQLServer.getJDBCConnectionShipper();
        String sql = "SELECT * FROM CONTAINER WHERE CON_DATE_CREATE = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, Date_Create);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) { // Di chuyển con trỏ đến hàng đầu tiên
                int container_ID = rs.getInt("CON_ID");
                return container_ID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
