package service;

import model.Account;
import model.DBConnect;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class OrderServiceImp implements OrderService {
    @Override
    public void addNewOrder(Account account, List<Item> list) {
        Connection connection = DBConnect.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into atagvn.order_product values ()")
    }
}
