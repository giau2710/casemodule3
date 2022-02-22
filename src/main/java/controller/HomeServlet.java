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

@WebServlet(name ="HomeServlet",value ="/index")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        detail(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("pid");
        ProductDAO productDAO =new ProductDAO();
//        Product product = productDAO.getProductById(id);
        List<Category> listCate = productDAO.getAllCategory();
//        request.setAttribute("detail",product);
        request.setAttribute("listCate",listCate);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
