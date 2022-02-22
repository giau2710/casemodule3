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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditServlet", value = "/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        detail(request, response);
    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html/charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        detail(request,response);
//    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(id);
        List<Category> listCate = productDAO.getAllCategory();
        List<Product> listP = productDAO.getAllProduct();
        List<Integer> listId = new ArrayList<>();
        listId.add(1);
        listId.add(2);
        listId.add(3);
        listId.add(4);
        listId.add(5);
        request.setAttribute("idCur",id);
        request.setAttribute("listId", listId);
        request.setAttribute("detail", product);
        request.setAttribute("listCate", listCate);
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("product/edit.jsp").forward(request, response);
    }
}
