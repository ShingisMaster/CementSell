import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HashOrderAdapter implements OrderAdapter {

    @Override
    public List<Order> read (String path) {

        List<Order> orders = new ArrayList<>();
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {

            String[] parts = line.split("#");
            orders.add(new Order(LocalDateTime.parse(parts[0]), parts[1], Integer.parseInt(parts[2])));

        }

        return orders;
    }

}
