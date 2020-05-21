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

@WebServlet(name = "SortByPriceServlet",urlPatterns = "/sort")
public class SortByPriceServlet extends HttpServlet {
    ProductServiceImp productServiceImp = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort = request.getParameter("sortByPrice");
        List<Product> productList=null;
        switch (sort){
            case "desc":
                try {
                    productList = this.productServiceImp.sortByPriceDesc();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "asc":
                try {
                    productList = this.productServiceImp.sortByPriceAsc();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("showSortResult.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sort = request.getParameter("sortByPrice");
//        List<Product> productList=null;
//        if (sort==null){
//            sort="";
//            switch (sort){
//                default:
//                    listProduct(request,response);
//                    break;
//            }
//        }
//    }
//
//    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
//        String sort = request.getParameter("sortByPrice");
//        List<Product> productList=null;
//        try {
//            productList = this.productServiceImp.getListProduct();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("productList",productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("showSortResult.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
