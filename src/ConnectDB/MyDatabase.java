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
                        rs.getDate("ngayDay"),rs.getInt("Ca"),
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
        String query = "INSERT INTO lichhoc (idLichHoc, monHoc, idUser, ngayDay,Ca,idPhongHoc, trangThaiLich) VALUES (?, ?, ?, ?, ?,?,?)";
        try {
            Connection con =myconnect();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, lh.getIdLichHoc());
            pstmt.setString(2,lh.getMonHoc());
            pstmt.setString(3, lh.getIdUser());
            pstmt.setDate(4, sqlDate);
            pstmt.setInt(5, lh.getSoTiet());
            pstmt.setString(6, lh.getIdPhong());
            pstmt.setBoolean(7, true);
            pstmt.executeUpdate();
          
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public static  ArrayList<LichHoc> ListLichHocByDate(Date ngay)
    {
       ArrayList<LichHoc> lichHocData = new ArrayList<>();
        try {
            Connection connection=myconnect();
            String query = "SELECT * FROM lichhoc WHERE ngayDay = ? and trangThaiLich=1 ORDER BY Ca";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(ngay.getTime()));
            ResultSet rs = statement.executeQuery();

            
            while(rs.next())
            {
               LichHoc sp=new LichHoc(rs.getString("idLichHoc"),
                        rs.getString("monHoc"),
                        rs.getString("idUser"),
                        rs.getDate("ngayDay"),rs.getInt("Ca"),
                        rs.getString("idPhongHoc"),rs.getBoolean("trangThaiLich"));
                lichHocData.add(sp);
            
            }
        
        
        } catch (Exception e) {
        }
        return lichHocData;
    }
    public static  ArrayList<String> GetListPhongHocTheoCa(int ca)
    {
       ArrayList<String> list = new ArrayList<>();
        try {
            Connection connection=myconnect();
            String query = "SELECT * FROM lichhoc WHERE Ca = ? and trangThaiLich=0 ORDER BY Ca";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ca);
            ResultSet rs = statement.executeQuery();

            
            while(rs.next())
            {
               LichHoc lh=new LichHoc(rs.getString("idLichHoc"),
                        rs.getString("monHoc"),
                        rs.getString("idUser"),
                        rs.getDate("ngayDay"),rs.getInt("Ca"),
                        rs.getString("idPhongHoc"),rs.getBoolean("trangThaiLich"));
                list.add(lh.getIdPhong());
            
            }
        
        
        } catch (Exception e) {
        }
        return list;
    }
    
     public static  boolean ValidateLichHoc(LichHoc lh)
    {
        boolean check=false;
        try {
            Connection connection=myconnect();
            String query = "SELECT * FROM lichhoc WHERE idUser=?,ngayDay=?,Ca=?,idPhongHoc=?,trangThaiLich=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lh.getIdUser());
             statement.setDate(2, new java.sql.Date(lh.getNgay().getTime()));
            statement.setString(3, lh.getIdPhong());
            statement.setBoolean(4, lh.isTrangThai());
            ResultSet rs = statement.executeQuery();
            if(!rs.next())
                check=true;
            
            connection.close();
        
        } catch (Exception e) {
        }
        return check;
    }
     
    public static LichHoc GetLichHocById(String id)
    {
       LichHoc lh = new LichHoc();
        try {
            Connection connection=myconnect();
            String query = "SELECT * FROM lichhoc WHERE idLichHoc=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               lh.setIdLichHoc(rs.getString("idLichHoc"));
               lh.setMonHoc(rs.getString("monHoc"));
               lh.setIdUser(rs.getString("idUser"));
               lh.setNgay(rs.getDate("ngayDay"));
               lh.setSoTiet(rs.getInt("Ca"));
               lh.setIdPhong(rs.getString("idPhongHoc"));
               lh.setTrangThai(rs.getBoolean("trangThaiLich"));
                
            }
        } catch (Exception e) {
        }
        return lh;
    }
    
     public static void UpdateLichHoc(LichHoc lh )
    {
        java.sql.Date sqlDate = new java.sql.Date(lh.getNgay().getTime());
        String query = "UPDATE lichhoc SET monHoc=?,idUser=?,ngayDay=?,Ca=?,idPhongHoc=?,trangThaiLich=? WHERE idLichHoc=?";
        try {
            Connection con =myconnect();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,lh.getMonHoc());
            pstmt.setString(2, lh.getIdUser());
            pstmt.setDate(3, sqlDate);
            pstmt.setInt(4, lh.getSoTiet());
            pstmt.setString(5, lh.getIdPhong());
            pstmt.setBoolean(6, true);
            pstmt.setString(7,lh.getIdLichHoc());
            pstmt.executeUpdate();
          
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
      public static void DeleteLichHoc(String id )
    {
        String query = "DELETE lichhoc WHERE monHoc=? AND trangThaiLich=false" ;
        try {
            Connection con =myconnect();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
          
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
