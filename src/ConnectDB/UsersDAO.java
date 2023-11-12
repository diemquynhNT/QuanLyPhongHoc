/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import static ConnectDB.MyDatabase.myconnect;
import Model.LichHoc;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pengu73
 */
public class UsersDAO {
    
     public static ArrayList<Users> findAllUsers()
    {
         ArrayList<Users> list=new ArrayList<>();
        try {
            Connection con=ConnectDB.MyDatabase.myconnect();
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
                        rs.getString("idRole"),
                        rs.getDate("ngaySinh"),
                        rs.getString("DiaChi"),
                        rs.getString("ChuyenNghanh"),
                        rs.getString("TrinhDo"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
      public static ArrayList<Users> findAllTeacher()
    {
         ArrayList<Users> list=new ArrayList<>();
        try {
            Connection con=ConnectDB.MyDatabase.myconnect();
            String query = "SELECT * FROM users where idRole='GV' and trangThai=1";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users u =new Users(rs.getString("idUser"), 
                        rs.getString("hoTen"), 
                        rs.getString("email"), 
                        rs.getString("phone"),
                        rs.getString("gioiTinh"),
                        rs.getBoolean("trangThai"),
                        rs.getString("idRole"),
                        rs.getDate("ngaySinh"),
                        rs.getString("DiaChi"),
                        rs.getString("ChuyenNghanh"),
                        rs.getString("TrinhDo"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      
      public static Users GetUsersById(String id)
    {
        Users u = new Users();
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM users WHERE idUser=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               u.setIdUser(rs.getString("idUser"));
               u.setHoTen(rs.getString("hoTen"));
               u.setEmail(rs.getString("email"));
               u.setSdt(rs.getString("phone"));
               u.setGioiTinh(rs.getString("gioiTinh"));
               u.setTrangThai(rs.getBoolean("trangThai"));
               u.setIdRole( rs.getString("idRole"));
               u.setNgaySinh(rs.getDate("ngaySinh"));
               u.setDiaChi(rs.getString("DiaChi"));
               u.setChuyenNghanh(rs.getString("ChuyenNghanh"));
               u.setTrinhDo(rs.getString("TrinhDo"));
            }
        } catch (Exception e) {
        }
        return u;
    }
      
   public static boolean ValidateData(String mail,String phone)
    {
        boolean check=false;
        try {
            Connection connection=ConnectDB.MyDatabase.myconnect();
            String query = "SELECT * FROM users WHERE email=? OR phone=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,mail);
            statement.setString(2, phone);
            ResultSet rs = statement.executeQuery();
            if(!rs.next())
                check=true;
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return check;
    }
   public static boolean ValidateDataUpdate(String mail,String phone,String id)
    {
        boolean check=false;
        try {
            Connection connection=ConnectDB.MyDatabase.myconnect();
            String query = "SELECT * FROM users WHERE (email=? OR phone=?) and idUser <> ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,mail);
            statement.setString(2, phone);
            statement.setString(3, id);
            ResultSet rs = statement.executeQuery();
            if(!rs.next())
                check=true;
            
            connection.close();
        
        } catch (Exception e) {
            System.err.println(e);
        }
        return check;
    }
   
   public static boolean CheckUsersLichHoc(String id)
    {
        boolean check=false;
        try {
            Connection connection=ConnectDB.MyDatabase.myconnect();
            String query = "SELECT * FROM lichhoc WHERE idUser = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
                check=true;
            
            connection.close();
        
        } catch (Exception e) {
            System.err.println(e);
        }
        return check;
    }

   
    
    
}
