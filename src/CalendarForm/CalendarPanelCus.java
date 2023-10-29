/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CalendarForm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author pengu73
 */
public class CalendarPanelCus extends javax.swing.JPanel {

    private int month,year;
    public CalendarPanelCus() {
        initComponents();
        thisMonth();
        silde.show(new PanelDate(month,year), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        txNamThang = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        silde = new CalendarForm.PanelSlide();

        setBackground(new java.awt.Color(0, 129, 167));

        jLayeredPane1.setBackground(new java.awt.Color(0, 129, 167));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txNamThang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txNamThang.setForeground(new java.awt.Color(255, 255, 255));
        txNamThang.setText("THANG - NAM");
        jLayeredPane1.add(txNamThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 0, -1, 40));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/previous (1).png"))); // NOI18N
        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, -1, 40));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow-right.png"))); // NOI18N
        btnNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnNext.setContentAreaFilled(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 0, -1, 40));

        silde.setBackground(new java.awt.Color(255, 255, 255));
        silde.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addComponent(silde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(silde, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
         if(month==1)
       {
           month=12;
           year--;
       }
       else
       {
            month--;
       }
       silde.show(new PanelDate(month,year), PanelSlide.AnimateType.TO_RIGHT);
       showMonthYear();
       
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       if(month==12)
       {
           month=1;
           year++;
       }
       else
       {
            month++;
       }
       silde.show(new PanelDate(month,year), PanelSlide.AnimateType.TO_LEFT);
       showMonthYear();
    }//GEN-LAST:event_btnNextActionPerformed

     private void thisMonth()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());   //  today
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
        
    }
    
    private void showMonthYear()
    {
        Calendar ca=Calendar.getInstance();
        ca.set(Calendar.MONTH, month-1);
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.DATE, 1);
        
        SimpleDateFormat df=new SimpleDateFormat("MMMM-yyyy");
        txNamThang.setText(df.format(ca.getTime()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JLayeredPane jLayeredPane1;
    private CalendarForm.PanelSlide silde;
    private javax.swing.JLabel txNamThang;
    // End of variables declaration//GEN-END:variables
}
