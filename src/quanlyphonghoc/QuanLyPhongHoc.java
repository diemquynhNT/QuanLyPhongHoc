/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlyphonghoc;

import Jframe.HomeJFrame;
import Jframe.ImportExcelLichHocJFrame;
import Jframe.LoginUserJFrame;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.UIManager;

/**
 *
 * @author pengu73
 */
public class QuanLyPhongHoc {

     public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new LoginUserJFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setTitle("Login");
           
               
            }
        });
    }

    
}
