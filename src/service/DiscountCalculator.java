import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiscountCalculator {
    private final PriceConfig config;

    public DiscountCalculator (PriceConfig config) {
        this.config = config;
    }

    public List<CountedOrder> countOrdersPrice(List<Order> orders) {

        List<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort(Comparator.comparing(Order::getTime));

        List<CountedOrder> countedOrders = new ArrayList<>();
        double price = config.getBasePrice();
        double discount = config.getStartDiscount();
        double discountStep = config.getDiscountStep();

        for (Order order : sortedOrders) {

            double countedPrice = order.getAmount() * price * (1 - discount / 100);
            countedOrders.add(new CountedOrder(order, countedPrice));
            discount = Math.max(0.0, discount - discountStep);
        }


        return countedOrders;
    }


}
