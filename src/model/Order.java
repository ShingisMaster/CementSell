import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime time;
    private final String buyer;
    private final Integer amount;

    public Order(LocalDateTime time, String buyer, Integer amount) {
        this.time = time;
        this.buyer = buyer;
        this.amount = amount;
    }

    public String getBuyer() {
        return buyer;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }


    @Override
    public String toString() {
        return "Order{" + "date=" + time + ", customerName='" + buyer + '\'' + ", volume=" + amount;
    }


}
