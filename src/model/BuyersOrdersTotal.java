import java.math.BigDecimal;

public class BuyersOrdersTotal {
    private final String customerName;
    private final BigDecimal totalPrice;

    public BuyersOrdersTotal(String customerName, BigDecimal totalPrice) {
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }


    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "customerName= " + customerName  + ", totalPrice= " + totalPrice;
    }

}
