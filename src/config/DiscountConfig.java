import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DiscountConfig {

    private final int startDiscount;
    private final int discountStep;
    private final int minDiscount;

    public DiscountConfig(String path) throws IOException {

        Properties properties = new Properties();

        BufferedReader reader = Files.newBufferedReader(Path.of(path));
        properties.load(reader);
        reader.close();

        this.startDiscount = Integer.parseInt(properties.getProperty("discount.start"));
        this.discountStep = Integer.parseInt(properties.getProperty("discount.step"));
        this.minDiscount = Integer.parseInt(properties.getProperty("discount.min"));

        if (startDiscount < 0 || startDiscount > 100) {
            throw new IllegalArgumentException("Некорректная начальная скидка");
        }

        if (discountStep <= 0) {
            throw new IllegalArgumentException("Шаг скидки должен быть больше 0");
        }

        if (minDiscount < 0 || minDiscount > 100) {
            throw new IllegalArgumentException("Некорректная минимальная скидка");
        }

        if (minDiscount > startDiscount) {
            throw new IllegalArgumentException("Минимальная скидка не может превышать начальную");
        }
    }

    public int getStartDiscount() {
        return startDiscount;
    }

    public int getDiscountStep() {
        return discountStep;
    }

    public int getMinDiscount() {
        return minDiscount;
    }


}
