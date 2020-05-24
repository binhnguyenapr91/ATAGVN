package controller;

import model.Product;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateProductServlet",urlPatterns = "/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    ProductServiceImp productServiceImp = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String categoryId =request.getParameter("categoryId");
        String productName= request.getParameter("productName");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        int quantityInStock  = Integer.parseInt(request.getParameter("quantityInStock"));
        String productImage = request.getParameter("productImage");
        int status = Integer.parseInt(request.getParameter("status"));
        String description = request.getParameter("description");
        Product product = new Product(productId,categoryId,productName,productPrice,quantityInStock,productImage,status,description);
        try {
            this.productServiceImp.updateProduct(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/productManagement.jsp");
        request.setAttribute("product",product);
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/productManagement.jsp");
        dispatcher.forward(request,response);
    }
}
