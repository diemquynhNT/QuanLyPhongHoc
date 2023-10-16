/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import Model.LichHoc;
import Model.PhongHoc;
import Model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author pengu73
 */
public class MyDatabase {
    
    public static Connection myconnect() {
        
        Connection con = null;
        final String url = "jdbc:mysql://127.0.0.1:3306/quanlyphonghoc";
        final String user = "root";
        final String password = "";
        
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return con;
    }
    
    public static ArrayList<LichHoc> findAll()
    {

         ArrayList<LichHoc> list=new ArrayList<>();
        try {
            Connection con=myconnect();
            String query = "SELECT * FROM lichhoc";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                LichHoc sp=new LichHoc(rs.getString("idLichHoc"),
                        rs.getString("monHoc"),rs.getString("idUser"),
                        rs.getDate("ngayDay"),rs.getString("soTiet"),
                        rs.getString("idPhongHoc"),rs.getBoolean("trangThaiLich"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public static ArrayList<Users> findAllUsers()
    {
         ArrayList<Users> list=new ArrayList<>();
        try {
            Connection con=myconnect();
            String query = "SELECT * FROM users";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users u =new Users(rs.getString("idUser"), 
                        rs.getString("hoTen"), 
                        rs.getString("email"), 
                        rs.getString("phone"),
                        rs.getString("gioiTinh"),
                        rs.getBoolean("trangThai"),
                        rs.getString("userName"),
                        rs.getString("password"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       public static ArrayList<PhongHoc> findAllPhongHoc()
    {
         ArrayList<PhongHoc> list=new ArrayList<>();
        try {
            Connection con=myconnect();
            String query = "SELECT * FROM phonghoc";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               PhongHoc phong=new PhongHoc(rs.getString("idPhongHoc"),
                       rs.getInt("soTang"),
                       rs.getInt("soGhe"),
                       rs.getBoolean("trangThaiSuDung"),
                       rs.getBoolean("trangThaiPhong"),
                       rs.getInt("thietBi"));
                list.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void AddLichHoc(LichHoc lh)
    {
        java.sql.Date sqlDate = new java.sql.Date(lh.getNgay().getTime());
        String query = "INSERT INTO lichhoc (idLichHoc, monHoc, idUser, ngayDay,soTiet,idPhongHoc, trangThaiLich) VALUES (?, ?, ?, ?, ?,?,?)";
        try {
            Connection con =myconnect();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, lh.getIdLichHoc());
            pstmt.setString(2,lh.getMonHoc());
            pstmt.setString(3, lh.getIdUser());
            pstmt.setDate(4, sqlDate);
            pstmt.setString(5, lh.getSoTiet());
            pstmt.setString(6, lh.getIdPhong());
            pstmt.setBoolean(7, true);
            pstmt.executeUpdate();
          
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    
}
