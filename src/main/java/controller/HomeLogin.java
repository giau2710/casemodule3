package controller;

import DAO.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="HomeLogin",value ="/homelogin")
public class HomeLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        processRequestViewListProduct(request,response);

    }

    protected void processRequestViewListProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        List<Category> listCate =dao.getAllCategory();
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("product/homelogin.jsp").forward(request, response);
    }
}
