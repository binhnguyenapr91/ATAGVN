package controller;

import model.Order;
import service.OrderServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckOutConfirmServlet", urlPatterns = "/checkoutconfirm")
public class CheckOutConfirmServlet extends HttpServlet {
    OrderServiceImp orderServiceImp = new OrderServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String priceEach = request.getParameter("priceEach");
        String accountId = request.getParameter("accountId");
        String accountName = request.getParameter("accountName");
        String orderDate = request.getParameter("orderDate");
        String receiver = request.getParameter("receiver");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        Order order = new Order(orderId, accountId, receiver, address, email,phoneNumber);
        orderServiceImp.addOrderFromCart(order);
        orderServiceImp.addOrderProductFromCart(orderId,productId,Integer.parseInt(quantity),Float.parseFloat(priceEach),accountId);

        String announcementOrderSuccessful = "Order Completed ! Please wait Admin to Confirm";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        request.setAttribute("announcementOrderSuccessful",announcementOrderSuccessful);
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
