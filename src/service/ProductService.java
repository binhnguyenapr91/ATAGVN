package service;

import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    public List<Product> getListProduct() throws SQLException;

    public List<Product> getListProduct(String categoryId) throws SQLException;

    public List<Product> getListProductIP() throws SQLException;

    public ArrayList<Product> getListProductSS() throws SQLException;

    public Product getProduct(String productId) throws SQLException;

    public void saveProduct(Product product) throws SQLException;
}
