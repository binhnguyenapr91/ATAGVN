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
import java.util.List;

@WebServlet(name = "AccountServlet", urlPatterns = "/accountServlet")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateAccountForm(req, resp);
                break;
            default:
                viewAllAccount(req, resp);
        }
    }

    private void updateAccountForm(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String accountId = httpServletRequest.getParameter("id");
        AccountService accountService = new AccountImp();
        Account handler = accountService.findById(accountId);
        httpServletRequest.setAttribute("account", handler);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("admin/updateAccount.jsp");
        try {
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewAllAccount(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Account> accounts = accountService.viewAllAccount();
        httpServletRequest.setAttribute("accounts", accounts);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("admin/viewAccount.jsp");
        try {
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateAccount(req, resp);
                break;
            default:
                viewAllAccount(req, resp);
        }
    }

    private void updateAccount(HttpServletRequest req, HttpServletResponse resp) {
        String accountId = req.getParameter("accountId");
        String accountName = req.getParameter("accountName");
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        String accountAccess = req.getParameter("accountAccess");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        boolean gender = Boolean.parseBoolean(req.getParameter("isGender"));
        boolean status = Boolean.parseBoolean(req.getParameter("isStatus"));
        Account handler = new Account(accountId, accountName, loginName, password, accountAccess, address, phoneNumber, gender, status);
        AccountService accountService = new AccountImp();
        RequestDispatcher requestDispatcher;
        boolean updateResult = false;
        updateResult = accountService.updateAccountById(handler);
        if (updateResult = true) {
            try {
                requestDispatcher = req.getRequestDispatcher("/admin/viewAccount.jsp");
                requestDispatcher.forward(req,resp);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}