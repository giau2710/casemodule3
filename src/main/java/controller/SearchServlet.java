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

@WebServlet(name ="SearchServlet",value ="/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        search(request,response);

    }
    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("searchproduct");
        ProductDAO dao = new ProductDAO();

        List<Category> listCate = dao.getAllCategory();
        List<Product> listS = dao.search(name);
        request.setAttribute("listP", listS);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("product/search.jsp").forward(request, response);
    }
}
