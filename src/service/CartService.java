package service;

import model.Item;

import java.sql.SQLException;
import java.util.List;

public interface CartService {
    public boolean updateItem(Item item) throws SQLException;
    public boolean deleteItem(String id) throws SQLException;
}
