package controller;

import model.Cart;
import model.Product;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    private ProductServiceImp productServiceImp = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String productId = request.getParameter("productId");
        String action = request.getParameter("action");
        ArrayList<Long> listBuy = null;
        String url = "";
        try {
            listBuy = (ArrayList<Long>) session.getAttribute("cartId");
            long idBuy = 0;
            if (request.getParameter("cartId") != null) {
                idBuy = Long.parseLong(request.getParameter("cartId"));
            }
            Product product = productServiceImp.getProductDetail(productId);
            switch (action) {
                case "insert":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cartId", idBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.insertToCart(product, 1);
                        listBuy.add(idBuy);
                    }
                    url = "/cart.jsp";
                    break;
                case "delete" :
                    break;
                default:
                    break;
            }
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        } catch (Exception e) {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
