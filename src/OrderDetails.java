//lớp TradeOrder để lưu thông tin về giao dịch
public class OrderDetails {
    private int price, quantity;
    private String userName, maCP;

    public OrderDetails(int price, String maCP, int quantity, String userName) {
        this.price = price;
        this.maCP = maCP;
        this.quantity = quantity;
        this.userName = userName;

    }

    public int getPrice() {
        return price;
    }

    public String getMaCP() {
        return maCP;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "TradeOrder{" + "price=" + price + ", soLuong=" + quantity + ", userName=" + userName + ", maCP=" + maCP + '}';
    }
}
