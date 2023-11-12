/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import static ConnectDB.MyDatabase.myconnect;
import Model.LichHoc;
import Model.PhongHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class LichHocDAO{
   
    public static void AddLichHoc(LichHoc lh) {
       java.sql.Date sqlDate = new java.sql.Date(lh.getNgay().getTime());
        String query = "INSERT INTO lichhoc(idLichHoc,IdKhoaHoc,idUser,ngayDay,Ca,idPhongHoc,trangThaiLich) VALUES (?,?,?,?,?,?,?)";
        Connection con=ConnectDB.MyDatabase.myconnect();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, lh.getIdLichHoc());
            pstmt.setString(2,lh.getIdKhoaHoc());
            pstmt.setString(3, lh.getIdUser());
            pstmt.setDate(4, sqlDate);
            pstmt.setFloat(5, lh.getCa());
            pstmt.setString(6, lh.getIdPhong());
            pstmt.setBoolean(7, true);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<LichHoc> findAll()
    {

         ArrayList<LichHoc> list=new ArrayList<>();
        try {
            Connection con=MyDatabase.myconnect();
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
   
   
    public static ArrayList<PhongHoc> findAllPhongHoc()
    {
         ArrayList<PhongHoc> list=new ArrayList<>();
        try {
            Connection con=MyDatabase.myconnect();
            String query = "SELECT * FROM phonghoc";
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
  
    public static  ArrayList<LichHoc> ListLichHocByDate(Date ngay)
    {
       ArrayList<LichHoc> lichHocData = new ArrayList<>();
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM lichhoc WHERE ngayDay = ?  ORDER BY Ca";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(ngay.getTime()));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               LichHoc lh=new LichHoc(rs.getString("idLichHoc"),
                        rs.getString("IdKhoaHoc"),
                        rs.getString("idUser"),
                        rs.getDate("ngayDay"),
                        rs.getFloat("Ca"),
                        rs.getString("idPhongHoc"),
                       rs.getBoolean("trangThaiLich"));
                lichHocData.add(lh);
            }
        } catch (Exception e) {
        }
        return lichHocData;
    }
    
    public static  ArrayList<LichHoc> GetListPhongHocTheoCaNgay(float ca,Date ngay)
    {
        ArrayList<LichHoc> list = new ArrayList<>();
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM lichhoc WHERE Ca = ? and ngayDay=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1, ca);
            statement.setDate(2, new java.sql.Date(ngay.getTime()));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
              LichHoc lh=new LichHoc(rs.getString("idLichHoc"),
                        rs.getString("IdKhoaHoc"),
                        rs.getString("idUser"),
                        rs.getDate("ngayDay"),
                        rs.getFloat("Ca"),
                        rs.getString("idPhongHoc"),
                       rs.getBoolean("trangThaiLich"));
                list.add(lh);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
     public static  boolean ValidateLichHoc(LichHoc lh)
    {
        boolean check=false;
        try {
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM lichhoc WHERE idUser=?"
                    + "AND ngayDay=? AND Ca=? AND idPhongHoc=? AND trangThaiLich=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lh.getIdUser());
            statement.setDate(2, new java.sql.Date(lh.getNgay().getTime()));
            statement.setFloat(3, lh.getCa());
            statement.setString(4, lh.getIdPhong());
            statement.setBoolean(5, lh.isTrangThai());
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
            Connection connection=MyDatabase.myconnect();
            String query = "SELECT * FROM lichhoc WHERE idLichHoc=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               lh.setIdLichHoc(rs.getString("idLichHoc"));
               lh.setIdKhoaHoc(rs.getString("IdKhoaHoc"));
               lh.setIdUser(rs.getString("idUser"));
               lh.setNgay(rs.getDate("ngayDay"));
               lh.setCa(rs.getInt("Ca"));
               lh.setIdPhong(rs.getString("idPhongHoc"));
               lh.setTrangThai(rs.getBoolean("trangThaiLich"));
            }
        } catch (Exception e) {
        }
        return lh;
    }
    
    public static void UpdateLichHoc(LichHoc lh ) {
        java.sql.Date sqlDate = new java.sql.Date(lh.getNgay().getTime());
        String query = "UPDATE lichhoc SET IdKhoaHoc=?, idUser=?, ngayDay=?, Ca=?, idPhongHoc=?, trangThaiLich=? WHERE idLichHoc=?";
    try {
        Connection con = MyDatabase.myconnect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, lh.getIdKhoaHoc());
        pstmt.setString(2, lh.getIdUser());
        pstmt.setDate(3, sqlDate);
        pstmt.setFloat(4, lh.getCa());
        pstmt.setString(5, lh.getIdPhong());
        pstmt.setBoolean(6, lh.isTrangThai());
        pstmt.setString(7, lh.getIdLichHoc());
        pstmt.executeUpdate();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void DeleteLichHoc(String id )
    {
        String query = "DELETE from lichhoc WHERE idLichHoc =? AND trangThaiLich=false" ;
        try {
            Connection con =MyDatabase.myconnect();;
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
   public static int CountLichHocToDay(Date ngay) {
    int count = 0;
    String query = "SELECT COUNT(idLichHoc) as count FROM lichhoc WHERE ngayDay=?";
    try {
        Connection con = MyDatabase.myconnect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setDate(1, new java.sql.Date(ngay.getTime()));
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt("count");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return count;
}

    public static int CountLichHocToDayByStatus(Date ngay,Boolean status )
    {
        int count=0;
        String query = "SELECT COUNT(idLichHoc)as count FROM lichhoc WHERE ngayDay=? and trangThaiLich=?" ;
        try {
            Connection con=MyDatabase.myconnect();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setDate(1, new java.sql.Date(ngay.getTime()));
            pstmt.setBoolean(2, status);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return count;
    }
    
     public static int CountGVTrong1Ca(Date ngay, float ca, String idGiaoVien) {
    int count = 0;
    String query = "SELECT COUNT(DISTINCT idLichHoc) AS soluong FROM lichhoc "
            + "WHERE ca = ? AND ngayDay = ? AND idUser = ?";
    try {
        Connection con = MyDatabase.myconnect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setFloat(1, ca);
        pstmt.setDate(2, new java.sql.Date(ngay.getTime()));
        pstmt.setString(3, idGiaoVien);
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt("soluong");
        }
        con.close();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return count;
}

   public static int CountLopTrong1Ca(Date ngay, float ca, String idPhong) {
    int count = 0;
    String query = "SELECT idPhongHoc, ca, COUNT(*) AS soluong FROM lichhoc " +
                    "WHERE ca = ? AND ngayDay = ? AND idPhongHoc = ? " +
                    "GROUP BY idPhongHoc, ca";
    try {
        Connection con = MyDatabase.myconnect();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setFloat(1, ca);
        pstmt.setDate(2, new java.sql.Date(ngay.getTime()));
        pstmt.setString(3, idPhong);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt("soluong");
        }
        con.close();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    return count;
}
    

   
    
}
