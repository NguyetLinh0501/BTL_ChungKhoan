import java.util.HashMap;
import java.util.*;

public class Traders {
    private String userName, password, name, address;
    private int money;
    private ITrader i;
    private Map<String, Stock> listStock;

    public Traders(String userName, String password, String name, String address, int money) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.address = address;
        this.money = money;
        listStock = new HashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getMoney() {
        return money;
    }

    public boolean setMoney(int money) {
        this.money = money;
        return false;
    }

    public ITrader getI() {
        return i;
    }

    public void setI(ITrader i) {
        this.i = i;
    }

    public void buy(String maCP, int soLuong, int price) {
        i.buy(this, maCP, soLuong, price);
    }

    public void sell(String maCP, int quantity, int price) {
        Stock st = listStock.get(maCP + " ");
        if (st != null && quantity <= st.getQuantity()) {
            i.sell(this, maCP, quantity, price);
        } else {
            System.out.println("Bạn không có cổ phiếu này hoặc số lượng bán vượt quá số lượng bạn đang có");
        }
    }

    //xư rlis giao dịch mua bán
    public static final int SELL = 0;
    public static final int BUY = 1;

    public boolean giaodich(int loaiGD, OrderDetails o, String tenCP) {
        Stock st = listStock.get(o.getMaCP());
        //giao dịch mua
        if (loaiGD == BUY) {
            boolean check = setMoney(o.getQuantity() * o.getPrice());
            if (!check) {
                System.out.println("Bạn không có đủ tiền để mua cổ phiếu này");
                return false;
            }
            if (st == null) {
                listStock.put(o.getMaCP() + "", new Stock(o, tenCP));
            } else {
                st.setQuantity(st.getQuantity() + o.getQuantity());
            }
            System.out.println("Đã mua");
            return true;
        }
        //giao dịch bán
        else if (loaiGD == SELL) {
            st.setQuantity(st.getQuantity() - o.getQuantity());
            setMoney(-o.getQuantity() * o.getPrice());
            System.out.println("Đã bán");
            return true;
        }
        return false;
    }

    public interface ITrader {
        boolean login(Traders trader);

        boolean logout(Traders trader);

        public void buy(Traders trader, String maCP, int soLuong, int price);

        public void sell(Traders trader, String maCP, int soLuong, int price);

    }

}
