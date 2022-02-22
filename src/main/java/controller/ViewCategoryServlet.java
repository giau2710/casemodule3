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

@WebServlet(name = "ViewCategoryServlet", value = "/category")
public class ViewCategoryServlet extends HttpServlet {
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
        String cateId = request.getParameter("id");
        ProductDAO dao = new ProductDAO();
        List<Product> listProductById = dao.getAllProductById(cateId);
        List<Category> listCate =dao.getAllCategory();
        request.setAttribute("listP", listProductById);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("product/viewlistproduct.jsp").forward(request, response);
    }
}
