package controller;

import model.Account;
import model.ResultReport;
import service.AccountImp;
import service.Report;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReprotByName_TimeServlet", urlPatterns = "/reportByName_TimeServlet")
public class ReportByName_TimeServlet extends HttpServlet {
    private Report report = new Report();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showReport(req, resp);

        }
    }

    private void showReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountImp accountImp = new AccountImp();
        List<Account> users = accountImp.viewAllAccount();
        req.setAttribute("users",users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/reportByName_Time.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        selectOrdersDetailByTime(req, resp);
    }

    private void selectOrdersDetailByTime(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String startDate = req.getParameter("startTime");
        String endDate = req.getParameter("endTime");
        try {
            List<ResultReport> resultReports = report.getOrdersDetailByName(name, startDate, endDate);
            req.setAttribute("results", resultReports);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/resultReport.jsp");
            requestDispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
