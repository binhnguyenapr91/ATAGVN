package controller;

import model.Item;
import model.Order;
import model.Product;
import service.ProductService;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/cartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String productId = request.getParameter("productId");
        String act = "Update";
        int newQuantity = 0;

        switch (action) {
            case "plus": {
                newQuantity = quantity + 1;
                break;
            }
            case "minutes": {
                newQuantity = quantity - 1;
                break;
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cartUpdateServlet");
        request.setAttribute("quantity", newQuantity);
        request.setAttribute("productId", productId);
        request.setAttribute("act", act);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String productId = request.getParameter("productId");
        String act = "Update";
        int newQuantity = 0;

        switch (action) {
            case "plus": {
                newQuantity = quantity + 1;
                break;
            }
            case "minutes": {
                newQuantity = quantity - 1;
                break;
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cartUpdateServlet");
        request.setAttribute("quantity", newQuantity);
        request.setAttribute("productId", productId);
        request.setAttribute("act", act);
        dispatcher.forward(request, response);
    }
}
