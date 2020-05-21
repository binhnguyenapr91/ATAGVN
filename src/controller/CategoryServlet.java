package controller;

import model.Category;
import service.CategoryServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/categoryServlet")
public class CategoryServlet extends HttpServlet {
    CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
    List<Category> categoryList;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "update":
                updateCategoryForm(req,resp);
            default:
                viewAllCategory(req,resp);
        }
    }

    private void updateCategoryForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String categoryId = req.getParameter("categoryId");
    Category category = new Category();
        try {
            category = categoryServiceImp.getCategory(categoryId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("category",category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/updateCategory.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void viewAllCategory(HttpServletRequest req, HttpServletResponse resp) {
        try {
            categoryList = categoryServiceImp.getListCategory();
            req.setAttribute("categories",categoryList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/viewCategory.jsp");
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "update":
                updateCategory(req,resp);
            default:
                viewAllCategory(req,resp);
        }
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        String categoryName = req.getParameter("categoryName");
        Category holder = new Category(categoryId,categoryName);
        categoryServiceImp.updateCategory(holder);
        try {
            categoryList = categoryServiceImp.getListCategory();
            req.setAttribute("categories",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin/viewCategory.jsp");
        requestDispatcher.forward(req,resp);
    }

}
