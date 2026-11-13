import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

public class TxtOrderAdapter implements OrderAdapter {

    @Override
    public void read(String path, List<Order> orders) {

        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < lines.size(); i++) {

            String line = lines.get(i);
            String[] parts = line.split(Pattern.quote("|"), -1);

            if (parts.length != 3) {
                throw new IllegalArgumentException("Некорректное количество элементов в строке " + (i + 1)  + " в " + path);
            }

            try {

                LocalDateTime time = LocalDateTime.parse(parts[0].trim());
                String buyer = parts[1].trim();
                Integer amount = Integer.parseInt(parts[2].trim());

                orders.add(new Order(time, buyer, amount));

            } catch (DateTimeParseException e) {

                throw new IllegalArgumentException("Некорректная дата в строке " + (i + 1)  + " в " + path, e);

            } catch (NumberFormatException e) {

                throw new IllegalArgumentException("Некорректное количество товара в строке " + (i + 1)  + " в " + path, e);

            } catch (IllegalArgumentException e) {

                throw new IllegalArgumentException("Некорректные данные в строке " + (i + 1) + ": " + e.getMessage()  + " в " + path, e);
            }
        }
    }
}
