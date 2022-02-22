package DAO;

import context.DBContext;
import model.Category;
import model.Role;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public User getUser(String user, String pass) throws SQLException {
        String query="SELECT * FROM customer\n" +
                "where username=? and `password`=?;";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        ps.setString(1,user);
        ps.setString(2,pass);
        rs = ps.executeQuery();
        while (rs.next()){
            return new User(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    Role.valueOf(rs.getString(7)));
        }

        return null;
    }
    public void addUser(String fullName, String username, String password, String phoneNumber, String email) {
        String query = "INSERT INTO `customer` ( `fullname`, `username`, `password`, `phonenumber`, `email`, `role`) VALUES ( ?, ?, ?,?,?,?);";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, fullName);
            ps.setString(2, String.valueOf(username));
            ps.setString(3, String.valueOf(password));
            ps.setString(4, phoneNumber);
            ps.setString(5, email);
            ps.setString(6, "CUSTOMER");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<String> listAdmin() {
        String query = "select * from customer where role='ADMIN'";
        List<String> listUsernameAdmin = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listUsernameAdmin.add(rs.getString(3))
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUsernameAdmin;
    }

    public static void main(String[] args) throws SQLException {
        UserDAO userDAO =new UserDAO();
       User user= userDAO.getUser("giau","giau");
        System.out.println(userDAO.listAdmin());
//        if(user==null){
//            System.out.println("null");
//        }else {
//            System.out.println("dung");
//        }
    }
}
