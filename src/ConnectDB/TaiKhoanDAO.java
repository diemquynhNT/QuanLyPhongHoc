/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import Model.LichHoc;
import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class TaiKhoanDAO {
    
     public static void AddTaiKhoan(TaiKhoan tk) {
        String query = "INSERT INTO taikhoan(idUser,UserName,password) VALUES (?,?,?)";
        Connection con=ConnectDB.MyDatabase.myconnect();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, tk.getIdUser());
            pstmt.setString(2,tk.getUserName());
            pstmt.setString(3, tk.getPassword());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static  boolean ValidateTaiKhoan(String tk)
    {
        boolean check=false;
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM taikhoan WHERE UserName=? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tk);
            ResultSet rs = statement.executeQuery();
            if(!rs.next())
                check=true;
            connection.close();
        } catch (Exception e) {
        }
        return check;
    }
     
    public static TaiKhoan GetTaiKhoanById(String id)
    {
       TaiKhoan lh = new TaiKhoan();
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM taikhoan WHERE idUser=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               lh.setIdUser(rs.getString("idUser"));
               lh.setUserName(rs.getString("UserName"));
               lh.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return lh;
    }
    
    public static void UpdateTK(TaiKhoan lh ) {
       
        String query = "UPDATE taikhoan SET UserName=?, password=? WHERE idUser=?";
    try {
        Connection con = MyDatabase.myconnect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, lh.getUserName());
        pstmt.setString(2, lh.getPassword());
        pstmt.setString(3, lh.getIdUser());
        pstmt.executeUpdate();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void DeleteLichHoc(String id )
    {
        String query = "DELETE from taikhoan WHERE idUser =?" ;
        try {
            Connection con =MyDatabase.myconnect();;
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
   
}
