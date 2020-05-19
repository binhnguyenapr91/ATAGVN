package service;

import model.DBConnect;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements ProductService{


    public List<Product> getListProduct() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "select * from product";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getString("ProductID"));
            product.setCategoryId(rs.getString("CategoryId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductPrice(rs.getFloat("ProductPrice"));
            product.setQuantityInStock(rs.getInt("QuantityInStock"));
            product.setImage(rs.getString("Image"));
            product.setStatus(rs.getInt("Status"));
            product.setDescription(rs.getString("Description"));
            products.add(product);
        }
        return products;
    }


    public List<Product> getListProduct(String categoryId) throws SQLException {
        return null;
    }


    public List<Product> getListProductIP() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "select product.* from product where ProductID like '%IP%' limit 3";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getString("ProductID"));
            product.setCategoryId(rs.getString("CategoryId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductPrice(rs.getFloat("ProductPrice"));
            product.setQuantityInStock(rs.getInt("QuantityInStock"));
            product.setImage(rs.getString("Image"));
            product.setStatus(rs.getInt("Status"));
            product.setDescription(rs.getString("Description"));
            products.add(product);
        }
        return products;
    }


    public ArrayList<Product> getListProductSS() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "\n" +
                "select product.* from product where ProductID like '%SS%' limit 3";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getString("ProductID"));
            product.setCategoryId(rs.getString("CategoryId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductPrice(rs.getFloat("ProductPrice"));
            product.setQuantityInStock(rs.getInt("QuantityInStock"));
            product.setImage(rs.getString("Image"));
            product.setStatus(rs.getInt("Status"));
            product.setDescription(rs.getString("Description"));
            products.add(product);
        }
        return products;
    }


    public Product getProduct(String productId) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "select * from product where ProductID = '"+productId+"'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            product.setProductId(rs.getString("ProductID"));
            product.setCategoryId(rs.getString("CategoryId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductPrice(rs.getFloat("ProductPrice"));
            product.setQuantityInStock(rs.getInt("QuantityInStock"));
            product.setImage(rs.getString("Image"));
            product.setStatus(rs.getInt("Status"));
            product.setDescription(rs.getString("Description"));
        }
        return product;
    }

    @Override
    public List<Product> showAllProduct() {
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }
}
