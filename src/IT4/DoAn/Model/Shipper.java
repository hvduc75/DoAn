package IT4.DoAn.Model;

public class Shipper {
    private int Shipper_Id;
    private String Name;
    private String BirthDay;
    private String Gender;
    private String StartWork;
    private String Phone;
    private String Email;
    private String Address;
    private String Description;
    private float Score;
    private Boolean Status;
    private Boolean check_Delete;

    public int getShipper_Id() {
        return Shipper_Id;
    }

    public void setShipper_Id(int Shipper_Id) {
        this.Shipper_Id = Shipper_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getStartWork() {
        return StartWork;
    }

    public void setStartWork(String StartWork) {
        this.StartWork = StartWork;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getScore() {
        return Score;
    }

    public void setScore(float Score) {
        this.Score = Score;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public Boolean getCheck_Delete() {
        return check_Delete;
    }

    public void setCheck_Delete(Boolean check_Delete) {
        this.check_Delete = check_Delete;
    }
    
//    @Override
//    public String toString() {
//        return String.valueOf(Shipper_Id);
//    }
}
