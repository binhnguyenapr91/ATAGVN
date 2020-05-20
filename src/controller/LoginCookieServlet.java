package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginCookieServlet", urlPatterns = "/loginCookie")
public class LoginCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ok");
        Cookie[] cookies = request.getCookies();
        String userName ="";
        String logined = "";

        for (Cookie c : cookies){
            if (c.getName().equals("cookieUserName"))
                userName = c.getValue();

        }

        for (Cookie c : cookies){
            if (c.getName().equals("cookieIsLogin"))
                logined = c.getValue();

        }

        request.setAttribute("loginName", userName);
        request.setAttribute("isLogin", logined);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }
}
