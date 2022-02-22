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


@WebServlet(name = "ViewListProductServlet", value = "/viewlistproduct")
public class ViewListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                processRequestViewListProduct(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    protected void processRequestViewListProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listCate = dao.getAllCategory();

        request.setAttribute("listP", list);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("product/viewlistproduct.jsp").forward(request, response);
    }
}
