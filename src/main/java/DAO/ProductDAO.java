package DAO;

import context.DBContext;
import model.Category;
import model.Product;
import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {


    @Override
    public List<Product> getAllProduct() {
        String query = "select * from product";
        List<Product> list = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        Status.valueOf(rs.getString(7)),
                        rs.getString(8)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Category> getAllCategory() {
        String query = "select * from category";
        List<Category> listCate = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCate.add(new Category(rs.getInt(1),
                        rs.getString(2))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCate;
    }

    public List<Product> getAllProductById(String id) {
        String query = "SELECT * FROM product\n" +
                "where cateId=?;";
        List<Product> list = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        Status.valueOf(rs.getString(7)),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductById(String id) {
        String query = "SELECT * FROM product\n" +
                "where id=?;";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        Status.valueOf(rs.getString(7)),
                        rs.getString(8)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> search(String name) {
        String query = "SELECT * FROM product\n" +
                "where `name` like ?;";
        List<Product> list = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        Status.valueOf(rs.getString(7)),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addProduct(String name, String price, String quantity, String datePost, String detail, String status, String img, String category) {
        String query = "INSERT INTO product ( `name`, price, quantity, datePost, details, status, img, cateId) \n" +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, String.valueOf(price));
            ps.setString(3, String.valueOf(quantity));
            ps.setString(4, datePost);
            ps.setString(5, detail);
            ps.setString(6, status);
            ps.setString(7, img);
            ps.setString(8, String.valueOf(category));
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editProduct(String name, String price, String quantity, String datePost, String detail, String status, String img, String category, String id) {
        String query = "UPDATE `product` SET `name` = ?, `price` = ?, `quantity` = ?, `datePost` = ?, `details` = ?, `status` = ?, `img` = ?, `cateId` = ? WHERE (`id` = ?);";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, String.valueOf(price));
            ps.setString(3, String.valueOf(quantity));
            ps.setString(4, datePost);
            ps.setString(5, detail);
            ps.setString(6, status);
            ps.setString(7, img);
            ps.setString(8, String.valueOf(category));
            ps.setString(9, id);

            System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
//        System.out.println(productDAO.getAllProduct());
//        System.out.println(productDAO.getAllProductById("1"));
//        System.out.println(productDAO.search("pro"));
        productDAO.editProduct("2", "65", "6548", "2021-02-02", "hahaha", "STOCKING", "haha/haha", "2", "2");
    }
}
