package controller;

import DAO.ProductDAO;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="EditUpdateServlet",value ="/editupdate")
public class EditUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        detail(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String datePost = request.getParameter("datepost");
        String detail = request.getParameter("detail");
        String status=request.getParameter("status");
        String category = request.getParameter("category");
        ProductDAO productDAO =new ProductDAO();
        productDAO.editProduct(name,price,quantity,datePost,detail,status ,img,category,id);
//        productDAO.editProduct(name,"65","6548","2021-02-02","hahaha","STOCKING","haha/haha","2","24");
        List<Category> listCate = productDAO.getAllCategory();
        request.setAttribute("listCate",listCate);
        request.getRequestDispatcher("product/editupdate.jsp").forward(request,response);
    }
}
