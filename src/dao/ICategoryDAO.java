package dao;

import model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ICategoryDAO {
    public List<Category> getListCategory() throws SQLException;
}
