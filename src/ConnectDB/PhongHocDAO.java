/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import Model.PhongHoc;
import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class PhongHocDAO {
    public static PhongHoc GetPhongHocById(String id)
    {
       PhongHoc ph = new PhongHoc();
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM phonghoc WHERE idPhongHoc=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               ph=new PhongHoc(
                       rs.getString("idPhongHoc"),
                       rs.getInt("soTang"),
                       rs.getInt("soGhe"),
                       rs.getBoolean("trangThaiSuDung"),
                       rs.getString("thietBi"));
            }
        } catch (Exception e) {
        }
        return ph;
    }
    
     public static ArrayList<PhongHoc> GetPhongHocByInfo(Boolean trangThai,float ca,Date ngay)
    {
         ArrayList<PhongHoc> list=new ArrayList<>();
        try {
            Connection con=MyDatabase.myconnect();
            String query = "SELECT * FROM phonghoc where trangThaiSuDung=?";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               PhongHoc phong=new PhongHoc(
                       rs.getString("idPhongHoc"),
                       rs.getInt("soTang"),
                       rs.getInt("soGhe"),
                       rs.getBoolean("trangThaiSuDung"),
                       rs.getString("thietBi"));
                list.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   public static int CountPhongTang(int soTang)
    {
       int count=0;
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT COUNT(*) AS soluong FROM phonghoc where soTang=? GROUP BY soTang";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, soTang);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               count=rs.getInt("soluong");
            }
        } catch (Exception e) {
        }
        return count;
    }
   
    public static ArrayList<PhongHoc> GetAllPhongTrong(Date ngayDay,float ca)
    {
        ArrayList<PhongHoc> list=new ArrayList<>();
       try {
        Connection con = MyDatabase.myconnect();
        String query = "SELECT * FROM PhongHoc "
                     + "WHERE idPhongHoc NOT IN (SELECT idPhongHoc FROM LichHoc WHERE Ca = ? and ngayDay = ?) " +
                      "OR idPhongHoc IN (SELECT idPhongHoc FROM LichHoc WHERE Ca = ? and ngayDay = ? and trangThaiLich = 0) " +
                      "AND trangThaiSuDung = 1";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setFloat(1, ca);
        pst.setDate(2, new java.sql.Date(ngayDay.getTime()));
        pst.setFloat(3, ca);
        pst.setDate(4, new java.sql.Date(ngayDay.getTime()));
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
           PhongHoc phong = new PhongHoc(
                   rs.getString("idPhongHoc"),
                   rs.getInt("soTang"),
                   rs.getInt("soGhe"),
                   rs.getBoolean("trangThaiSuDung"),
                   rs.getString("thietBi"));
            list.add(phong);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<PhongHoc> GetAllPhongDangHoc(Date ngayDay,float ca)
    {
        ArrayList<PhongHoc> list=new ArrayList<>();
        try {
            Connection con=MyDatabase.myconnect();
            String query = "SELECT * FROM PhongHoc "
                    + "WHERE idPhongHoc IN (SELECT idPhongHoc FROM LichHoc WHERE Ca = ? and ngayDay=? and trangThaiLich=1)"
                    + "AND phonghoc.trangThaiSuDung=1";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setFloat(1, ca);
            pst.setDate(2, new java.sql.Date(ngayDay.getTime()));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               PhongHoc phong=new PhongHoc(
                       rs.getString("idPhongHoc"),
                       rs.getInt("soTang"),
                       rs.getInt("soGhe"),
                       rs.getBoolean("trangThaiSuDung"),
                       rs.getString("thietBi"));
                list.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
   
}
  