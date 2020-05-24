package service;


import model.Order;

import model.Account;
import model.Item;


import java.util.List;

public interface OrderService {

    List<Order> viewAllOrder();

    void updateOder(Order order);

    boolean deleteOder(String orderID);

    Order findByID(String orderIDToFind);

    void addNewOrder(Account account, List<Item> list);

}
