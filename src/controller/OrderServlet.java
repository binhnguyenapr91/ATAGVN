package controller;

import model.Order;
import service.OrderService;
import service.OrderServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {
    private OrderServiceImp orderServiceImp = new OrderServiceImp();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateOrder(request, response);
                break;
            default:
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateOrderForm(request, response);
                break;
            case "delete":
                break;
            default:
                showAllOrders(request, response);
                break;
        }
    }

    private void updateOrderForm(HttpServletRequest request, HttpServletResponse response) {
        String orderID = request.getParameter("orderID");
        OrderService orderService = new OrderServiceImp();
        Order handler = orderService.findByID(orderID);
        request.setAttribute("order", handler);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/updateOrder.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
//can kiem tra
    private void updateOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            String orderID = request.getParameter("orderID");
            String accountID = request.getParameter("accountID");
            String orderDate = request.getParameter("orderDate");
            Date df = new SimpleDateFormat("yyyy-MM-dd").parse(orderDate);

            String receiver = request.getParameter("receiver");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            Integer status = Integer.parseInt(request.getParameter("status"));
            Order handler = new Order(orderID, accountID, (java.sql.Date) df, receiver, address, email, phoneNumber, status);
            orderServiceImp.updateOder(handler);
            List<Order> orders;
            orders = orderServiceImp.viewAllOrder();
            request.setAttribute("orders", orders);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/viewOrder.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void showAllOrders(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orders = orderServiceImp.viewAllOrder();
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/viewOrder.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
