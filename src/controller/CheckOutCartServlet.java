package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Account;
import model.Item;
import model.Order;
import model.Product;
import service.AccountImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Array;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "CheckOutCartServlet", urlPatterns = "/checkoutcart")

public class CheckOutCartServlet extends HttpServlet {
    AccountImp accountImp = new AccountImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String isLogined = (String) session.getAttribute("cookieIsLogin");
        if (isLogined.equals("not yet")){
            String announcementToLogin = "Please login first!";
            request.setAttribute("announcementToLogin", announcementToLogin);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            String email = request.getParameter("email");
            String name = "";
            String address = "";
            String phoneNumber = "";

            if (!email.equals("example@gmail.com")) {
                name = request.getParameter("fullName");
                phoneNumber = request.getParameter("phoneNumber");
                address = request.getParameter("address");
            }

            String orderUserName = (String) session.getAttribute("cookieUserName");
            Account loginedAccount = accountImp.findByLoginName(orderUserName);

            Order order = (Order) session.getAttribute("order");
            List<Item> list = order.getItems();
            Account account = new Account(loginedAccount.getAccountId(),name,orderUserName,loginedAccount.getAccountAccess(),loginedAccount.getPassword(),address,phoneNumber,loginedAccount.isGender(),loginedAccount.isStatus());



        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();


        String isLogined = (String) session.getAttribute("cookieIsLogin");
        if (isLogined.equals("not yet")){
            String announcementToLogin = "Please login first!";
            request.setAttribute("announcementToLogin", announcementToLogin);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            String userName = (String) session.getAttribute("cookieUserName");
            AccountImp accountImp = new AccountImp();
            Account account = accountImp.findByLoginName(userName);

            String accountName = account.getAccountName();
            String email = "Please input your email";
            String phoneNumber = account.getPhoneNumber();
            String address = account.getAddress();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
            request.setAttribute("defaultAccountName",accountName);
            request.setAttribute("defaultEmail",email);
            request.setAttribute("defaultPhoneNumber",phoneNumber);
            request.setAttribute("defaultAddress",address);

            requestDispatcher.forward(request,response);
        }
    }
}
