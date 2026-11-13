import java.util.List;

public interface OrderAdapter {
    List<Order> read (String path,   List<Order> orders);
}
