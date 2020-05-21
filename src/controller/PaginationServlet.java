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
    ProductServiceImp productServiceImp = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int pageNumber;
        if (page == null){
            pageNumber = 1;
        } else {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        int perPage = 3;
        String categoryss = request.getParameter("categoryss");
        if (categoryss == null) categoryss="ss";
        List<Product> productList = null;
        List<Product> subList = null;

        int start = (pageNumber-1)*perPage;
        int end = pageNumber*perPage;

        switch (categoryss){
            case "ss":{
                try {
                    productList = productServiceImp.getListProductSS();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            }
            case "ip":{
                try {
                    productList = productServiceImp.getListProductIP();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            }
        }

        subList = productList.subList(start,end);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("subList", subList);
        requestDispatcher.forward(request,response);
    }
}
