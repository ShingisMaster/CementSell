import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PriceConfig {

    private final BigDecimal basePrice;
    private final BigDecimal startDiscount;
    private final BigDecimal discountStep;

    public PriceConfig(String path) {

        Properties properties = new Properties();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.basePrice = new BigDecimal(properties.getProperty("price.basePricePerKg"));
        this.startDiscount = new BigDecimal(properties.getProperty("price.startDiscount"));
        this.discountStep = new BigDecimal (properties.getProperty("price.discountStep"));



        if (basePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }

        if (startDiscount.compareTo(BigDecimal.ZERO) < 0 || startDiscount.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Некорректная начальная скидка");
        }

        if (discountStep.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Шаг скидки должен быть больше 0");
        }

    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public BigDecimal getStartDiscount() {
        return startDiscount;
    }

    public BigDecimal getDiscountStep() {
        return discountStep;
    }


}
