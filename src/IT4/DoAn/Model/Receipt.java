package IT4.DoAn.Model;

public class Receipt {
    private int SHipperId;
    private int OrderId;
    private String Reason;

    public int getSHipperId() {
        return SHipperId;
    }

    public void setSHipperId(int SHipperId) {
        this.SHipperId = SHipperId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    
}
