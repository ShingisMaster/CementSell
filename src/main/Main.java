import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Пути к файлам-исходникам
        String path1 = "src/resources/discount_day.txt";
        String path2 = "src/resources/discount_day_without_ext";

        //Чтение исходного файла, запись данных о заказах
        OrderAdapter adapter1 = new TxtOrderAdapter();
        List<Order> orders1 = adapter1.read(path1);

        //Путь к файлу-конфигурации для задания цены, скидки и ее шага для заказов
        PriceConfig cfg = new PriceConfig("src/config/price.properties");

        //Чтение параметров из конфиг-файла, применение сортировки и скидки к списку заказов
        DiscountCalculator calculator = new DiscountCalculator(cfg);
        List<CountedOrder> countedOrders = new ArrayList<>(calculator.countOrdersPrice(orders1));

        //Агрегация списка заказов по имени покупателя, суммирование стоимости заказов
        OrdersResultAggregator agr = new OrdersResultAggregator();
        List<BuyersOrdersTotal> ordersTotal = new ArrayList<>(agr.aggregateOrders(countedOrders));

        //Печать итогового списка в файл
        String pathOut = "/Users/maksimzdanov/Desktop/Обучение по  Java /Практики/module2/out/output.txt";
        OrdersResultWriter writer = new OrdersResultWriter();
        writer.writeToFile(ordersTotal, pathOut);


        //Отладочные принты

        //Прочитанные исходники
        System.out.println("\nRaw orders:\n");
        for (Order order : orders1) {
            System.out.println(order + "\n");
        }

        //Сортированный список с расчитанной скидкой
        System.out.println("\nSorted by date orders with counted price by given discount specs:\n");
        for (CountedOrder order : countedOrders) {
            System.out.println(order + "\n");
        }

        //Сгруппированные итоговый список
        System.out.println("\nGrouped by buyer's name orders with total price for each buyer:\n");
        for (BuyersOrdersTotal buyer : ordersTotal) {
            System.out.println(buyer + "\n");
        }

    }
}
