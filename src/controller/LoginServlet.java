package controller;

import model.Account;
import service.AccountImp;
import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    AccountImp accountImp = new AccountImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action="";
        switch (action){
            case "login" : {
                checkLogin(request,response);
                break;
            }
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountImp.findByLoginName(userName);

        if (account == null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            String announcement = "Not found 'username'. Please SignUp first!";
            request.setAttribute("announcement",announcement);
                requestDispatcher.forward(request,response);
        }else {
            if (userName.equals("mrthinh2502")){
                if (!password.equals(account.getPassword())){
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                    String announcement = "Wrong 'password'. Please try again!";
                    request.setAttribute("announcement",announcement);
                    requestDispatcher.forward(request,response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
                    requestDispatcher.forward(request,response);
                }
            } else if (account.getPassword().equals(password)){
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("index.jsp");
                int logined = 1;
                request.setAttribute("loginName",userName);
                request.setAttribute("isLogin",logined);
                requestDispatcher1.forward(request,response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                String announcement = "Wrong 'password'. Please try again!";
                request.setAttribute("announcement",announcement);
                requestDispatcher.forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
