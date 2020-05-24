package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImp implements OrderService {

    public static final String SELECT_ALL_ORDER = "select * from atagvn.orders;";
    public static final String GET_MAX_ORDER_ID_BY_ID_HEAD = "select * from atagvn.orders where OrderID like ? order by OrderID desc limit 1;";
    public static final String ADD_NEW_ORDER_FROM_CART = "insert into atagvn.orders(OrderID, AccountID, Receiver, Address, Email, PhoneNumber) value (?,?,?,?,?,?);";
    private static final String ADD_NEW_ORDER_PRODUCT_FROM_CART = "insert into atagvn.order_product value (?,?,?,?,?);";
    public static final String UPDATE_QUANTITY_AFTER_ORDER = "update product set QuantityInStock = ? where ProductID=?";

    @Override
    public List<Order> getRecentOrderList() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                String orderId = resultSet.getString("OrderID");
                String accountId = resultSet.getString("AccountID");
                String receiver = resultSet.getString("Receiver");
                String address = resultSet.getString("Address");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");

                orderList.add(new Order(orderId,accountId,receiver,address,email,phoneNumber));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public String getMaxOrderIdByOrderIdHead(String orderIdHead) {
        String maxOrderIdByOrderIdHead = "";
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_ORDER_ID_BY_ID_HEAD);
            preparedStatement.setString(1,orderIdHead+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                maxOrderIdByOrderIdHead = resultSet.getString("OrderID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxOrderIdByOrderIdHead;
    }

    @Override
    public void addOrderFromCart(Order order) {
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_ORDER_FROM_CART);
            preparedStatement.setString(1,order.getOrderID());
            preparedStatement.setString(2,order.getAccountID());
            preparedStatement.setString(3,order.getReceiver());
            preparedStatement.setString(4,order.getAddress());
            preparedStatement.setString(5,order.getEmail());
            preparedStatement.setString(6,order.getPhoneNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addOrderProductFromCart(String orderId, String productId, int quantity, float priceEach, String accountId) {
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_ORDER_PRODUCT_FROM_CART);
            preparedStatement.setString(1,orderId);
            preparedStatement.setString(2,productId);
            preparedStatement.setString(3,String.valueOf(quantity));
            preparedStatement.setString(4,String.valueOf(priceEach));
            preparedStatement.setString(5,accountId);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateQuantityProduct(int quantity, String productId) {
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_AFTER_ORDER);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, productId);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
