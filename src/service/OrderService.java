package service;

import model.Account;
import model.Item;
import model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getRecentOrderList();
    String getMaxOrderIdByOrderIdHead(String orderIdHead);
    void addOrderFromCart(Order order);
    void addOrderProductFromCart(String orderId, String productId, int quantity, float priceEach, String accountId);
    void updateQuantityProduct(int quantity, String productId);
}
