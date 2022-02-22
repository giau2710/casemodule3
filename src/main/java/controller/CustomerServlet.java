package controller;

import DAO.ProductDAO;
import DAO.UserDAO;
import model.Category;
import model.Product;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                break;
            case "signup":
                signUp(request, response);
                break;
            case "loginc":
                login(request, response);
                break;
            case "view":
                break;
            default:
                viewHome(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addcart":
                addCart(request, response);
                break;

            case "loginupdatec":
                try {
                    processLogin(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "adduser":
                addUser(request, response);
                break;
//            default:
//                signUp(request,response);
////                viewHome(request,response);
//                break;
        }
    }

    protected void signUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//        request.getRequestDispatcher("customer/signup.jsp").forward(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/signup.jsp");
        dispatcher.forward(request, response);

    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
//        request.getRequestDispatcher("customer/signup.jsp").forward(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/loginc.jsp");
        dispatcher.forward(request, response);

    }

    protected void getCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        List<Category> listCate = dao.getAllCategory();
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("customer/homecustomer.jsp").forward(request, response);
    }

    protected void addCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listCate = dao.getAllCategory();
        request.setAttribute("listP", list);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("customer/homecustomer.jsp").forward(request, response);
    }

    protected void viewHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listCate = dao.getAllCategory();
        request.setAttribute("listP", list);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("customer/homecustomer.jsp").forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        UserDAO userDAO = new UserDAO();
        if(confirm_password.equals(password)){
            userDAO.addUser(fullname, username, password, phonenumber, email);
//        productDAO.addProduct("name",65,6548,"2021-02-02","hahaha","STOCKING","haha/haha",2);
            request.getRequestDispatcher("customer/loginc.jsp").forward(request, response);
        }else {
            request.setAttribute("messwrong", "Password and confirmpassword not equals");
            request.getRequestDispatcher("customer/signup.jsp").forward(request, response);
        }

    }

    private void processLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        ProductDAO productDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();
        List<Category> listCate = productDAO.getAllCategory();
        User user = userDAO.getUser(userName, password);
        if (user == null) {
            request.setAttribute("messwrong", "Wrong username or password");
            request.getRequestDispatcher("customer/loginc.jsp").forward(request, response);
        } else {
            request.setAttribute("listCate", listCate);
            request.getRequestDispatcher("customer/homecustomer.jsp").forward(request, response);
        }

    }

}
