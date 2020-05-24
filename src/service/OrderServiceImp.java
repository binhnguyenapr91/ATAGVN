package service;


import model.Account;
import model.DBConnect;
import model.Item;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImp implements OrderService {
    private static final String SELECT_ALL_ORDER = "select * from atagvn.orders;";
    private static final String SELECT_BY_ID = "select * from atagvn.orders where orderID = ?;";
    private static final String UPDATE_ORDER_BY_ID = "update atagvn.orders set AccountID=?, OrderDate=?, Receiver=?, Address=?, Email=?, PhoneNumber=?, Status = ? where OrderID = ?;";

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
                orders.add(new Order(orderID, accountID, orderDate, receiver, address, email, phoneNumber, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order findByID(String orderIDToFind) {
        Connection connection = DBConnect.getConnection();
        Order order = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
            ps.setString(1, orderIDToFind);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String orderID = resultSet.getString("OrderID");
                String accountID = resultSet.getString("AccountID");
                Date orderDate = resultSet.getDate("OrderDate");
                String receiver = resultSet.getString("Receiver");
                String address = resultSet.getString("Address");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                Integer status = resultSet.getInt("Status");

                order = new Order(orderID, accountID, orderDate, receiver, address, email, phoneNumber, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void addNewOrder(Account account, List<Item> list) {

    }

    @Override
    public void updateOder(Order order) {
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER_BY_ID);
            ps.setString(1, order.getAccountID());
            ps.setDate(2, order.getOrderDate());
            ps.setString(3, order.getReceiver());
            ps.setString(4, order.getAddress());
            ps.setString(5, order.getEmail());
            ps.setString(6, order.getPhoneNumber());
            ps.setInt(7, order.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteOder(String orderID) {
        boolean rowDeleted = false;
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("delete from atagvn.orders where OrderID = ?");
            ps.setString(1, orderID);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
