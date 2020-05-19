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

    @Override
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

    @Override
    public List<Product> getListProduct(String categoryId) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "select * from product where CategoryId = '" + categoryId + "'";
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

    @Override
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

    @Override
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

    @Override
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
    public void saveProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Product(ProductID,CategoryID,ProductName,ProductPrice,QuantityInStock,Image,Status,Desciption) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = DBConnect.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getProductId());
            ps.setString(2, product.getCategoryId());
            ps.setString(3, product.getProductName());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getQuantityInStock());
            ps.setFloat(6,product.getProductPrice());
            ps.setString(7,product.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
