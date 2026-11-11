import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PriceConfig {

    private final double basePrice;
    private final double startDiscount;
    private final double discountStep;

    public PriceConfig(String path) {

        Properties properties = new Properties();

        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Path.of(path));
            properties.load(reader);
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        this.basePrice = Integer.parseInt(properties.getProperty("price.basePricePerKg"));
        this.startDiscount = Integer.parseInt(properties.getProperty("price.startDiscount"));
        this.discountStep = Integer.parseInt(properties.getProperty("price.discountStep"));

        if (startDiscount < 0 || startDiscount > 100) {
            throw new IllegalArgumentException("Некорректная начальная скидка");
        }

        if (discountStep <= 0) {
            throw new IllegalArgumentException("Шаг скидки должен быть больше 0");
        }

    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getStartDiscount() {
        return startDiscount;
    }

    public double getDiscountStep() {
        return discountStep;
    }


}
