package controller;

import model.DBConnect;
import model.ResultReport;
import service.Report;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReprotServlet", urlPatterns = "/reportServlet")
public class ReportServlet extends HttpServlet {
    private Report rp = new Report();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String startDate = req.getParameter("startTime");
        String endDate = req.getParameter("endTime");
        try {
            List<ResultReport> resultReports = rp.getOrdersDetailByName(name, startDate, endDate);
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

    protected void test1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "reportOrdersDetailByTime":

                break;
            default:
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/reportManagement.jsp");
                requestDispatcher.forward(req, resp);
        }

    }

    private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/resultReport.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void selectOrdersDetailByTime(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
