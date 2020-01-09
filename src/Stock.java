import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Stock {

    private String tenCP, maCP;
    private int price, quantity;
    private Queue<OrderDetails> sellOrder;
    private Queue<OrderDetails> buyOrder;

    public Stock(String maCP, String tenCP, int price, int soLuong) {
        this.tenCP = tenCP;
        this.price = price;
        this.quantity = soLuong;
        this.maCP = maCP;

        Comparator<OrderDetails> c_sellOrder = new Comparator<OrderDetails>() {
            @Override
            public int compare(OrderDetails o1, OrderDetails o2) {
                return (o1.getPrice() - o2.getPrice());
            }
        };
        sellOrder = new PriorityQueue<>(c_sellOrder);

        Comparator<OrderDetails> c_buyOrder = new Comparator<OrderDetails>() {
            @Override
            public int compare(OrderDetails o1, OrderDetails o2) {
                return -(o1.getPrice() - o2.getPrice());
            }
        };
        buyOrder = new PriorityQueue<>(c_buyOrder);

    }

    public Stock(OrderDetails o, String tenCP) {

    }


    public OrderDetails getSellOrder() {
        return sellOrder.poll();
    }

    public OrderDetails getBuyOrder() {
        return buyOrder.poll();
    }

    public void setQuantity(int soLuong) {
        this.quantity = soLuong;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTenCP() {
        return tenCP;
    }

    public int getPrice() {
        return price;
    }

    public String getMaCP() {
        return maCP;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addBuyOrder(String userName, String maCP, int soLuong, int price) {
        buyOrder.add(new OrderDetails(price, maCP, soLuong, userName));
    }

    public void addBuyOrder_list(List<OrderDetails> list_buyOrder) {
        buyOrder.addAll(list_buyOrder);
    }

    public void addSellOrder(String userName, String maCP, int soLuong, int price) {
        sellOrder.add(new OrderDetails(price, maCP, soLuong, userName));
    }

    public void addSellOrder_list(List<OrderDetails> sellOrder1) {
        sellOrder.addAll(sellOrder1);
    }

    @Override
    public String toString() {
        return "Stock{" + "MaCP=" + maCP + ", TenCP=" + tenCP + ", soLuong=" + quantity + ", price=" + price + '}';
    }

}
