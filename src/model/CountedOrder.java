import java.math.BigDecimal;

public class CountedOrder {
    private final Order order;
    private final BigDecimal calculatedPrice;


    public CountedOrder (Order order, BigDecimal calculatedPrice) {
        this.order = order;
        this.calculatedPrice = calculatedPrice;
    }

    public Order getOrder() {
        return order;
    }

    public BigDecimal getCalculatedPrice() {
        return calculatedPrice;
    }

    @Override
    public String toString() {
        return order.toString() + ", DiscountedPrice=" + calculatedPrice + "}";
    }
}
