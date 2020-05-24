package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginCookieServlet", urlPatterns = "/loginSession")
public class LoginSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ss =request.getSession();
        ss.invalidate();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pagination");
        requestDispatcher.forward(request,response);
    }
}
