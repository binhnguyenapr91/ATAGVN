package service;

import model.Account;
import model.Item;

import java.util.List;

public interface OrderService {
    void addNewOrder(Account account, List<Item>list);
}
