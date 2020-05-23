package service;

import model.DBConnect;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImp implements OrderService {
    private static final String SELECT_ALL_ORDER = "select * from atagvn.orders;";
    private static final String SELECT_BY_ID = "select * from atagvn.orders where orderID = ?;";

    @Override
    public List<Order> viewAllOrder() {
        List<Order> orders = new ArrayList<>();
        String orderID = "";
        String accountID = "";
        Date orderDate;
        String receiver = "";
        String address = "";
        String email = "";
        String phoneNumber = "";
        int status = 0;
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                orderID = rs.getString(1);
                accountID = rs.getString(2);
                orderDate = rs.getDate(3);
                receiver = rs.getString(4);
                address = rs.getString(5);
                email = rs.getString(6);
                phoneNumber = rs.getString(7);
                status = rs.getInt(8);
                orders.add(new Order(orderID,accountID,orderDate,receiver,address,email,phoneNumber,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void updateOder(Order order) {

    }

    @Override
    public void deleteOder(String orderID) {

    }
}
