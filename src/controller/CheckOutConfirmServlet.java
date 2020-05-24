package controller;

import model.Item;
import model.Order;
import service.OrderServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckOutConfirmServlet", urlPatterns = "/checkoutconfirm")
public class CheckOutConfirmServlet extends HttpServlet {
    OrderServiceImp orderServiceImp = new OrderServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String accountId = request.getParameter("accountId");
        String receiver = request.getParameter("receiver");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        Order orderSession = (Order) session.getAttribute("order");
        List<Item> list = orderSession.getItems();

        Order order = new Order(orderId, accountId, receiver, address, email,phoneNumber);
        orderServiceImp.addOrderFromCart(order);
        for (int i = 0; i < list.size(); i++) {
            String productId = list.get(i).getProduct().getProductId();
            String quantity = String.valueOf(list.get(i).getQuantity());
            String priceEach = String.valueOf(list.get(i).getPrice());
            orderServiceImp.addOrderProductFromCart(orderId,productId,Integer.parseInt(quantity),Float.parseFloat(priceEach),accountId);
        }

        String announcementOrderSuccessful = "Order Completed ! Please wait Admin to Confirm";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        request.setAttribute("announcementOrderSuccessful",announcementOrderSuccessful);
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
