public class CountedOrder {
    private final Order order;
    private final double calculatedPrice;


    public CountedOrder (Order order, double calculatedPrice) {
        this.order = order;
        this.calculatedPrice = calculatedPrice;
    }

    public Order getOrder() {
        return order;
    }

    public double getCalculatedPrice() {
        return calculatedPrice;
    }

    @Override
    public String toString() {
        return order.toString() + ", DiscountedPrice=" + calculatedPrice + "}";
    }
}
