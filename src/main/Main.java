import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String path1 = "src/resources/discount_day.txt";
        String path2 = "src/resources/discount_day_without_ext";
        PriceConfig cfg = new PriceConfig("src/config/price.properties");
        DiscountCalculator calculator = new DiscountCalculator(cfg);

        OrderAdapter adapter1 = new TxtOrderAdapter();
        List<Order> orders1 = adapter1.read(path1);
        for (Order order : orders1) {
            System.out.println(order + "\n");
        }

        System.out.println("\n\n\n");


        List<CountedOrder> countedOrders = new ArrayList<>(calculator.countOrdersPrice(orders1));
        for (CountedOrder order : countedOrders) {
            System.out.println(order + "\n");
        }

    }
}
