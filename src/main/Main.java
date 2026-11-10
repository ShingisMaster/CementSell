import java.util.List;


public class Main {
    public static void main(String[] args)
    {
        String path1 = "src/resources/discount_day.txt";
        String path2 = "src/resources/discount_day_without_ext";

            OrderAdapter adapter1 = new TxtOrderAdapter();
            List<Order> orders1 = adapter1.read(path1);
            for (Order order : orders1) {
                System.out.println(order + "\n");
            }

            OrderAdapter adapter2 = new HashOrderAdapter();
            List<Order> orders2 = adapter2.read(path2);
            for (Order order : orders2) {
                System.out.println(order + "\n");
            }

    }
}
