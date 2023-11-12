/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import Model.KhoaHoc;
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
    
    
      
      //KHÓA HỌC
    public static ArrayList<KhoaHoc> fillAllKhoaHoc()
    {
         ArrayList<KhoaHoc> list=new ArrayList<>();
        try {
            Connection con=myconnect();
            String query = "SELECT * FROM khoahoc where trangThai=1";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               KhoaHoc kh=new KhoaHoc(rs.getString("IdKhoaHoc"), rs.getString("TenKhoaHoc"), rs.getBoolean("trangThai"));
               list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
