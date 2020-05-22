package service;

import model.Item;

import java.sql.SQLException;

public class CartServiceImp implements CartService {
    @Override
    public boolean updateItem(Item item) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return false;
    }
}
