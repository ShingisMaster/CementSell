import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiscountCalculator {
    private final PriceConfig config;

    public DiscountCalculator(PriceConfig config) {
        this.config = config;
    }

    public List<CountedOrder> countOrdersPrice(List<Order> orders) {

        List<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort(Comparator.comparing(Order::getTime));

        List<CountedOrder> countedOrders = new ArrayList<>();

        BigDecimal price = config.getBasePrice();
        BigDecimal discount = BigDecimal.valueOf(config.getStartDiscount());
        BigDecimal discountStep = BigDecimal.valueOf(config.getDiscountStep());

        for (Order order : sortedOrders) {

            BigDecimal countedPrice = BigDecimal.valueOf(order.getAmount())
                    .multiply(price)
                    .multiply(
                            BigDecimal.ONE.subtract(
                                    discount.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                            )
                    );

            countedOrders.add(new CountedOrder(order, countedPrice));

            discount = discount.subtract(discountStep);

            if (discount.compareTo(BigDecimal.ZERO) < 0) {
                discount = BigDecimal.ZERO;
            }
        }


        return countedOrders;
    }


}
