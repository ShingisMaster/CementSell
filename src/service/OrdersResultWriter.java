import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrdersResultWriter {

    public void writeToFile(List<BuyersOrdersTotal> orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter
                ("/Users/maksimzdanov/Desktop/Обучение по  Java /Практики/module2/out/output.txt"))){
            for (BuyersOrdersTotal order : orders) {
                writer.write(order.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
