package service;

import model.Order;

import java.util.List;

public interface OrderService {
    List<Order> viewAllOrder ();
    void updateOder (Order order);
    void deleteOder (String orderID);
    Order findByID (String orderIDToFind);
}
