import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime time;
    private final String buyer;
    private final Integer amount;

    public Order(LocalDateTime time, String buyer, Integer amount) {
        this.time = time;
        this.buyer = buyer;
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Количество заказанного товара должно быть больше нуля");
        } else {
            this.amount = amount;
        }
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
