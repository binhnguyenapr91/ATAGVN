//package controller;
//
//import model.Product;
//import service.ProductServiceImp;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(name = "SortProductServlet",urlPatterns = "/sortProduct")
//public class SortProductServlet extends HttpServlet {
//    ProductServiceImp productServiceImp = new ProductServiceImp();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//doGet(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action= "";
//        if (action==null){
//            action="";
//            switch (action){
//                case "low":
//                    break;
//                case "hight":
//                    listProductHight(request,response);
//                    break;
//                default:
//                    listProduct(request,response);
//            }
//        }
//    }
//
//    private void listProductHight(HttpServletRequest request, HttpServletResponse response) {
//        List<Product> productList = null;
//        try {
//            productList =productServiceImp.sortProduct();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("productList", productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("sortProduct.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("categoryId");
//        List<Product> productList = null;
//        try {
//            productList =productServiceImp.getListProduct(id);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("productList", productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("sortProduct.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
