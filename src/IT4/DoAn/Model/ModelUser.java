package IT4.DoAn.Model;

public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    // test

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    //

    public ModelUser(int userID, String userName, String email, String password, String verifyCode, String confirmPassword) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
        //
        this.confirmPassword = confirmPassword;
    }

    public ModelUser(int userID, String userName, String email, String password, String confirmPassword) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        //
        this.confirmPassword = confirmPassword;
    }

    public ModelUser() {
    }

    private int userID;
    private String userName;
    private String email;
    private String password;
    private String verifyCode;
    // test
    private String confirmPassword;
}

