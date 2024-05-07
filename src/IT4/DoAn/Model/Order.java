package IT4.DoAn.Model;

import java.sql.Timestamp;

public class Order {
    private int Id;
    private String Name;
    private String Delivery_Location;
    private String Receive_Location;
    private int Status;
    private String Description;
    private String Feedback;
    private double Distance;
    private double Price;
    private Timestamp Date_Create;
    private Timestamp Delivery_Expected;
    private Timestamp Delivery_Actual;
    private int Delivery_Count;
    private Boolean Check_Delete;
    private int Container_ID;
    private String User_name;
    private String User_phone;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDelivery_Location() {
        return Delivery_Location;
    }

    public void setDelivery_Location(String Delivery_Location) {
        this.Delivery_Location = Delivery_Location;
    }

    public String getReceive_Location() {
        return Receive_Location;
    }

    public void setReceive_Location(String Receive_Location) {
        this.Receive_Location = Receive_Location;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Timestamp getDate_Create() {
        return Date_Create;
    }

    public void setDate_Create(Timestamp Date_Create) {
        this.Date_Create = Date_Create;
    }

    public Timestamp getDelivery_Expected() {
        return Delivery_Expected;
    }

    public void setDelivery_Expected(Timestamp Delivery_Expected) {
        this.Delivery_Expected = Delivery_Expected;
    }

    public Timestamp getDelivery_Actual() {
        return Delivery_Actual;
    }

    public void setDelivery_Actual(Timestamp Delivery_Actual) {
        this.Delivery_Actual = Delivery_Actual;
    }

    public int getDelivery_Count() {
        return Delivery_Count;
    }

    public void setDelivery_Count(int Delivery_Count) {
        this.Delivery_Count = Delivery_Count;
    }

    public Boolean getCheck_Delete() {
        return Check_Delete;
    }

    public void setCheck_Delete(Boolean Check_Delete) {
        this.Check_Delete = Check_Delete;
    }

    public int getContainer_ID() {
        return Container_ID;
    }

    public void setContainer_ID(int Container_ID) {
        this.Container_ID = Container_ID;
    }
    
    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public String getUser_phone() {
        return User_phone;
    }

    public void setUser_phone(String User_phone) {
        this.User_phone = User_phone;
    }
//    @Override
//    public String toString() {
//        return Name;
//    }

}
