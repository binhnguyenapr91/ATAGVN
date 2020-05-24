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
import java.util.Calendar;
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
                deleteOrder (request, response);
                break;
            default:
                showAllOrders(request, response);
                break;
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
        String orderID = request.getParameter("orderID");
        orderServiceImp.deleteOder_product(orderID);
        orderServiceImp.deleteOder(orderID);
        List<Order> orders = new ArrayList<>();
        orders = orderServiceImp.viewAllOrder();
        request.setAttribute("orders", orders);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/viewOrder.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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
            String receiver = request.getParameter("receiver");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            Integer status = Integer.parseInt(request.getParameter("status"));
            orderServiceImp.updateOder(orderID, accountID, orderDate, receiver, address, email, phoneNumber, status);
            List<Order> orders;
            orders = orderServiceImp.viewAllOrder();
            request.setAttribute("orders", orders);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/viewOrder.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
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
