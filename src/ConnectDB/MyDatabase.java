/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
