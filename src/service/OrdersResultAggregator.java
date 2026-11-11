import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrdersResultAggregator {

    public List<BuyersOrdersTotal> aggregateOrders (List<CountedOrder> countedOrders) {

        Map<String,Double> ordersTotal = new LinkedHashMap<>();

        for (CountedOrder countedOrder : countedOrders) {
            ordersTotal.merge(
                    countedOrder.getOrder().getBuyer(),
                    countedOrder.getCalculatedPrice(),
                    Double::sum);

        }

        List<BuyersOrdersTotal> result = new ArrayList<>();

        for (Map.Entry<String,Double> entry : ordersTotal.entrySet()) {
            result.add(new BuyersOrdersTotal(entry.getKey(), entry.getValue()));
        }

        return result;
    }


}
