package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="productServlet", urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action ==null){
            action = "";
        }
        switch (action){
            case "add":
                addProduct(req,resp);
                break;
            default:
                listProducts(req,resp);
                break;
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productID = req.getParameter("productId");
        String productName = req.getParameter("productName");
        float productPrice = Float.parseFloat(req.getParameter("productPrice"));
        int quantityInStock = Integer.parseInt(req.getParameter("quantityInStock"));
        int status = Integer.parseInt(req.getParameter("status"));
        String description = req.getParameter("description");
        String img = req.getParameter("img");
        String categoryName = req.getParameter("categoryName");

        Product product = new Product(productID,productName,productPrice,quantityInStock,img,status,description,categoryName);
        try {
            this.productService.saveProduct(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addProduct.jsp");
        req.setAttribute("message","New product is added!");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action ==null){
            action = "";
        }
        switch (action){
            default:
                listProducts(req,resp);
                break;
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> productList = null;
        try {
            productList = this.productService.getListProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
