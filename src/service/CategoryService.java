package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    public List<Category> getListCategory() throws SQLException;

    public Category getCategory(String categoryId) throws SQLException;

    public void updateCategory (Category category);
}
