package controller;

import model.DBConnect;
import model.Product;
import service.ProductServiceImp;

import java.io.File;
import java.lang.String;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@MultipartConfig
@WebServlet(name = "AddProductServlet",urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    ProductServiceImp productServiceImp = new ProductServiceImp();
    private static final String UPLOAD_DIRECTORY = "../product";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String categoryId =request.getParameter("categoryId");
        String productName= request.getParameter("productName");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        int quantityInStock  = Integer.parseInt(request.getParameter("quantityInStock"));
        String productImage = request.getParameter("productImage");
       int status = Integer.parseInt(request.getParameter("status"));
        String description = request.getParameter("description");
        try {
            this.productServiceImp.saveProduct(new Product(productId,categoryId,productName,productPrice,quantityInStock,productImage,status,description));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/productManagement.jsp");
        dispatcher.forward(request,response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/productManagement.jsp");
        dispatcher.forward(request,response);
    }
}
