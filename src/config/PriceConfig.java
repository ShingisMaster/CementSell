import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PriceConfig {

    private final BigDecimal basePrice;
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


        this.basePrice = new BigDecimal(properties.getProperty("price.basePricePerKg"));
        this.startDiscount = Integer.parseInt(properties.getProperty("price.startDiscount"));
        this.discountStep = Integer.parseInt(properties.getProperty("price.discountStep"));



        if (basePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }

        if (startDiscount < 0 || startDiscount > 100) {
            throw new IllegalArgumentException("Некорректная начальная скидка");
        }

        if (discountStep <= 0) {
            throw new IllegalArgumentException("Шаг скидки должен быть больше 0");
        }

    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public double getStartDiscount() {
        return startDiscount;
    }

    public double getDiscountStep() {
        return discountStep;
    }


}
