package IT4.DoAn.Model;

import java.sql.Timestamp;

public class Container {
    private int Container_Id;
    private Timestamp Date_Create;
    private int Shipper_Id;

    public int getContainer_Id() {
        return Container_Id;
    }

    public void setContainer_Id(int Container_Id) {
        this.Container_Id = Container_Id;
    }

    public Timestamp getDate_Create() {
        return Date_Create;
    }

    public void setDate_Create(Timestamp Date_Create) {
        this.Date_Create = Date_Create;
    }

    public int getShipper_Id() {
        return Shipper_Id;
    }

    public void setShipper_Id(int Shipper_Id) {
        this.Shipper_Id = Shipper_Id;
    }
    
}
