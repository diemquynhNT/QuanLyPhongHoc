/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CalendarForm;

import Jframe.CreateLichHocJFrame;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author pengu73
 */
public class PanelDate extends javax.swing.JLayeredPane {

    private int month,year;
    
    public PanelDate(int month,int year) {
        initComponents();
        this.month=month;
        this.year=year;
        init();
    }
    private void init()
       {
           mon.asTitle();
           tue.asTitle();
           wed.asTitle();
           thur.asTitle();
           fri.asTitle();
           sat.asTitle();
           sun.asTitle();
           setDate();

       }
     
    
    private void setDate()
    {
        Calendar calendar=Calendar.getInstance();
        
        //set ngay, thang, nam
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, 1);
        
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1; //=>thứ tự của ngày bắt đầu của tháng trong tuan
        calendar.add(Calendar.DATE, -startDay);//=>trỏ tới ngày đầu tiên của tuần trước ngày đầu tiên của tháng
        //=> hiển thị tuần trước ngày đầu tiên của tháng trên lịch
        ToDay today=getToDay();
        System.err.println("today"+today.getYear()+today.getMonth()+today.getDay());
        for(Component com:getComponents())// => getComponents trả về một mảng chứa tất cả các thành phần con của Panel đó.
        {
            Cell cell=(Cell) com;
            if(!cell.isTitle())//title=false
            {
                cell.setText(calendar.get(Calendar.DATE)+" ");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH)==month-1);//set mau cho thang hien tai
                ToDay curDay=new ToDay(calendar.get(Calendar.DATE),
                                calendar.get(Calendar.MONTH)+1,
                                calendar.get(Calendar.YEAR));
               
                boolean checkNgay=today.checkToDay(curDay);
                if(checkNgay)
                {
                    cell.setAsToday();
                }
                cell.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new CreateLichHocJFrame(curDay);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        frame.setTitle("Quản lý lịch học");

                        
                    }
                    
                
                });
                
                calendar.add(Calendar.DATE, 1);// tang them 1 ngay
                
            }
                
        }
        
        
    }
    
 
    
   private ToDay getToDay() {
        LocalDate today = LocalDate.now();
        return new ToDay(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mon = new CalendarForm.Cell();
        tue = new CalendarForm.Cell();
        wed = new CalendarForm.Cell();
        thur = new CalendarForm.Cell();
        fri = new CalendarForm.Cell();
        sat = new CalendarForm.Cell();
        sun = new CalendarForm.Cell();
        cell8 = new CalendarForm.Cell();
        cell9 = new CalendarForm.Cell();
        cell10 = new CalendarForm.Cell();
        cell11 = new CalendarForm.Cell();
        cell12 = new CalendarForm.Cell();
        cell13 = new CalendarForm.Cell();
        cell14 = new CalendarForm.Cell();
        cell15 = new CalendarForm.Cell();
        cell16 = new CalendarForm.Cell();
        cell17 = new CalendarForm.Cell();
        cell18 = new CalendarForm.Cell();
        cell19 = new CalendarForm.Cell();
        cell20 = new CalendarForm.Cell();
        cell21 = new CalendarForm.Cell();
        cell22 = new CalendarForm.Cell();
        cell23 = new CalendarForm.Cell();
        cell24 = new CalendarForm.Cell();
        cell25 = new CalendarForm.Cell();
        cell26 = new CalendarForm.Cell();
        cell27 = new CalendarForm.Cell();
        cell28 = new CalendarForm.Cell();
        cell29 = new CalendarForm.Cell();
        cell30 = new CalendarForm.Cell();
        cell31 = new CalendarForm.Cell();
        cell32 = new CalendarForm.Cell();
        cell33 = new CalendarForm.Cell();
        cell34 = new CalendarForm.Cell();
        cell35 = new CalendarForm.Cell();
        cell36 = new CalendarForm.Cell();
        cell37 = new CalendarForm.Cell();
        cell38 = new CalendarForm.Cell();
        cell39 = new CalendarForm.Cell();
        cell40 = new CalendarForm.Cell();
        cell41 = new CalendarForm.Cell();
        cell42 = new CalendarForm.Cell();
        cell43 = new CalendarForm.Cell();
        cell44 = new CalendarForm.Cell();
        cell45 = new CalendarForm.Cell();
        cell46 = new CalendarForm.Cell();
        cell47 = new CalendarForm.Cell();
        cell48 = new CalendarForm.Cell();
        cell49 = new CalendarForm.Cell();

        setLayout(new java.awt.GridLayout(7, 7));

        mon.setForeground(new java.awt.Color(255, 0, 51));
        mon.setText("CN");
        mon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        add(mon);

        tue.setText("T2");
        tue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(tue);

        wed.setText("T3");
        wed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wedActionPerformed(evt);
            }
        });
        add(wed);

        thur.setText("T4");
        thur.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(thur);

        fri.setText("T5");
        fri.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(fri);

        sat.setText("T6");
        sat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(sat);

        sun.setForeground(new java.awt.Color(51, 51, 51));
        sun.setText("T7");
        sun.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(sun);
        add(cell8);
        add(cell9);
        add(cell10);
        add(cell11);
        add(cell12);
        add(cell13);
        add(cell14);
        add(cell15);
        add(cell16);
        add(cell17);
        add(cell18);
        add(cell19);
        add(cell20);
        add(cell21);
        add(cell22);
        add(cell23);
        add(cell24);
        add(cell25);
        add(cell26);
        add(cell27);
        add(cell28);
        add(cell29);
        add(cell30);
        add(cell31);
        add(cell32);
        add(cell33);
        add(cell34);
        add(cell35);
        add(cell36);
        add(cell37);
        add(cell38);
        add(cell39);
        add(cell40);
        add(cell41);
        add(cell42);
        add(cell43);
        add(cell44);
        add(cell45);
        add(cell46);
        add(cell47);
        add(cell48);
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents

    private void wedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wedActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CalendarForm.Cell cell10;
    private CalendarForm.Cell cell11;
    private CalendarForm.Cell cell12;
    private CalendarForm.Cell cell13;
    private CalendarForm.Cell cell14;
    private CalendarForm.Cell cell15;
    private CalendarForm.Cell cell16;
    private CalendarForm.Cell cell17;
    private CalendarForm.Cell cell18;
    private CalendarForm.Cell cell19;
    private CalendarForm.Cell cell20;
    private CalendarForm.Cell cell21;
    private CalendarForm.Cell cell22;
    private CalendarForm.Cell cell23;
    private CalendarForm.Cell cell24;
    private CalendarForm.Cell cell25;
    private CalendarForm.Cell cell26;
    private CalendarForm.Cell cell27;
    private CalendarForm.Cell cell28;
    private CalendarForm.Cell cell29;
    private CalendarForm.Cell cell30;
    private CalendarForm.Cell cell31;
    private CalendarForm.Cell cell32;
    private CalendarForm.Cell cell33;
    private CalendarForm.Cell cell34;
    private CalendarForm.Cell cell35;
    private CalendarForm.Cell cell36;
    private CalendarForm.Cell cell37;
    private CalendarForm.Cell cell38;
    private CalendarForm.Cell cell39;
    private CalendarForm.Cell cell40;
    private CalendarForm.Cell cell41;
    private CalendarForm.Cell cell42;
    private CalendarForm.Cell cell43;
    private CalendarForm.Cell cell44;
    private CalendarForm.Cell cell45;
    private CalendarForm.Cell cell46;
    private CalendarForm.Cell cell47;
    private CalendarForm.Cell cell48;
    private CalendarForm.Cell cell49;
    private CalendarForm.Cell cell8;
    private CalendarForm.Cell cell9;
    private CalendarForm.Cell fri;
    private CalendarForm.Cell mon;
    private CalendarForm.Cell sat;
    private CalendarForm.Cell sun;
    private CalendarForm.Cell thur;
    private CalendarForm.Cell tue;
    private CalendarForm.Cell wed;
    // End of variables declaration//GEN-END:variables
}
