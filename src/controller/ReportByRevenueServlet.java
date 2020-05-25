package controller;

import model.ResultReport;
import model.RevenueReport;
import service.Report;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReprotByRevenueServlet", urlPatterns = "/reportByRevenueServlet")
public class ReportByRevenueServlet extends HttpServlet {
    private Report report = new Report();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/reportRevenueByTime.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getRevenueByTime(req, resp);
    }

    private void getRevenueByTime(HttpServletRequest req, HttpServletResponse resp) {
        String startDate = req.getParameter("startTime");
        String endDate = req.getParameter("endTime");
        try {
            List<RevenueReport> revenueReport = report.getTotalRevenue(startDate,endDate);
            req.setAttribute("results", revenueReport);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/resultRevenue.jsp");
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
