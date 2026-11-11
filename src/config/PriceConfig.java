import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PriceConfig {

    private final int basePrice;
    private final int startDiscount;
    private final int discountStep;

    public PriceConfig(String path) throws IOException {

        Properties properties = new Properties();

        BufferedReader reader = Files.newBufferedReader(Path.of(path));
        properties.load(reader);
        reader.close();

        this.basePrice = Integer.parseInt(properties.getProperty("price.basePrice"));
        this.startDiscount = Integer.parseInt(properties.getProperty("price.startDiscount"));
        this.discountStep = Integer.parseInt(properties.getProperty("price.discountStep"));

        if (startDiscount < 0 || startDiscount > 100) {
            throw new IllegalArgumentException("Некорректная начальная скидка");
        }

        if (discountStep <= 0) {
            throw new IllegalArgumentException("Шаг скидки должен быть больше 0");
        }

    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getStartDiscount() {
        return startDiscount;
    }

    public int getDiscountStep() {
        return discountStep;
    }


}
