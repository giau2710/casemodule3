package controller;

import DAO.ProductDAO;
import DAO.UserDAO;
import model.Category;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name ="LoginServlet",value ="/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            showLoginForm(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            processLogin(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
            request.getRequestDispatcher("user/login.jsp").forward(request,response);
    }

    private void processLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        List<Category> listCate = productDAO.getAllCategory();
       User user = userDAO.getUser(userName,password);
       List<String> listAdin=userDAO.listAdmin();
       boolean check=false;
       for (String s:listAdin){
           if(userName.equals(s)){
               check=true;
               break;
           }
       }

       if (user==null || !check) {
           request.setAttribute("messwrong","Wrong username or password");
           request.getRequestDispatcher("user/login.jsp").forward(request,response);
       } else {
           request.setAttribute("listCate",listCate);
           request.getRequestDispatcher("product/homelogin.jsp").forward(request,response);
       }

    }
}
