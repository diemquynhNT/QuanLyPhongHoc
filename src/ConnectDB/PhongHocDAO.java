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
   
}
