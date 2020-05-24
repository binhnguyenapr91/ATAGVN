package service;


import model.Order;

import model.Account;
import model.Item;
import model.Order;


import java.util.List;

public interface OrderService {


    List<Order> viewAllOrder();

    void updateOder(String orderID, String accountID, String orderDate, String receiver, String address, String email, String phoneNumber, int status);

    void deleteOder(String orderID);

    void deleteOder_product(String orderID);

    Order findByID(String orderIDToFind);

    void addNewOrder(Account account, List<Item> list);

    List<Order> getRecentOrderList();
    String getMaxOrderIdByOrderIdHead(String orderIdHead);
    void addOrderFromCart(Order order);
    void addOrderProductFromCart(String orderId, String productId, int quantity, float priceEach, String accountId);
    void updateQuantityProduct(int quantity, String productId);

}
