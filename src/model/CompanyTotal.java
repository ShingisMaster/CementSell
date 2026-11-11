public class CompanyTotal {
    private final String customerName;
    private final Double totalPrice;

    public CompanyTotal(String customerName, Double totalPrice) {
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "customerName= " + customerName + '\'' + ", totalPrice= " + totalPrice + "\n";
    }

}
