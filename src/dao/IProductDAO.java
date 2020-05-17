package dao;

import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IProductDAO {
    public List<Product> getListProduct() throws SQLException;

    public ArrayList<Product> getListProductIP() throws SQLException;

    public ArrayList<Product> getListProductSS() throws SQLException;
}
