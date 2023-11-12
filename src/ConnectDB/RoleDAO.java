/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import Model.Role;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoleDAO {
     public static ArrayList<Role> findAllRole()
    {
        ArrayList<Role> list=new ArrayList<>();
        try {
            Connection con=ConnectDB.MyDatabase.myconnect();
            String query = "SELECT * FROM role";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Role r=new Role(rs.getString("idRole"), rs.getString("tenRole"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
