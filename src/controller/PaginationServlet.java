package controller;

import model.Product;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PaginationServlet", urlPatterns = "/pagination")
public class PaginationServlet extends HttpServlet {
    public static final int PRODUCT_QUANTITY_PER_PAGE = 6;
    ProductServiceImp productServiceImp = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int pageNumber;
        if (page == null) {
            pageNumber = 1;
        } else {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        int perPage = 6;
        List<Product> productList = null;
        List<Product> subList = null;

        try {
            productList = productServiceImp.getListProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int start = (pageNumber - 1) * perPage;
        int lastNumber = productList.size();
        int end;
        if (start < lastNumber - PRODUCT_QUANTITY_PER_PAGE) {
            end = start + PRODUCT_QUANTITY_PER_PAGE;
        } else {
            end = start + (lastNumber-start);
        }


        subList = productList.subList(start, end);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp?page=1");
        request.setAttribute("subList", subList);
        requestDispatcher.forward(request, response);
    }
}
