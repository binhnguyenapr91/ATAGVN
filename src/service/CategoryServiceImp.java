package service;

import model.Category;
import model.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImp implements CategoryService {
    @Override
    public List<Category> getListCategory() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM atagvn.category";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Category> list = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setCategoryId(rs.getString("CategoryID"));
            category.setCategoryName(rs.getString("CategoryName"));
            list.add(category);
        }
        return list;
    }


    public Category getCategory(String categoryId) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql =  "select * from atagvn.category where CategoryID=  '"+categoryId+"'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Category category = new Category();
        while (rs.next()) {
            category.setCategoryId(rs.getString("categoryId"));
            category.setCategoryName(rs.getString("categoryName"));
        }
        return category;
    }

    public static void main(String[] args) {
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        try {
            for (Category c : categoryServiceImp.getListCategory()
            ) {
                System.out.println(c.getCategoryName());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
