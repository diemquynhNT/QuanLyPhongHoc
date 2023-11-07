
package Jframe;

import Model.LichHoc;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


public class HomeJFrame extends javax.swing.JFrame {

    DefaultTableModel model;
    public HomeJFrame() {
        initComponents();
        menu1.initMoving(HomeJFrame.this);
        FetchData();
        
        //chay thoi gian
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                   try{
                       Thread.sleep(1000);
                   }
                   catch(Exception ex)
                   {
                       System.err.println(ex);
                   }
                   Date date=new Date();
                    SimpleDateFormat timeline =new SimpleDateFormat("hh:mm:ss");
                    SimpleDateFormat dateFormat=new SimpleDateFormat("EEEE,dd/MM/yyyy");
                    txDate.setText(dateFormat.format(date));
                    String time=timeline.format(date);
                    txTime.setText(time.split(" ")[0]);
                    txTime.setText(time.split(" ")[1]);
                    
                    
                }
            }
            
        }).start();
        
        
        
      
        
    }
     private void FetchData() {
         try {
        ArrayList<LichHoc> listSP =ConnectDB.MyDatabase.ListLichHocByDate(new Date());
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (LichHoc lichHoc : listSP) {
            model.addRow(new String[]{lichHoc.getIdLichHoc(),
                    lichHoc.getIdKhoaHoc(),
                    lichHoc.getIdPhong(),
                    String.valueOf(lichHoc.getCa()),
                    lichHoc.getIdUser(),
                    String.valueOf(lichHoc.isTrangThai())
            });
        }
    } catch (Exception ex) {
        System.out.println(ex);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menu1 = new Swing.Menu();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        comboxCa = new javax.swing.JComboBox<>();
        btnFilterCa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txTime = new javax.swing.JLabel();
        panelInforUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txType = new javax.swing.JLabel();
        txDate = new javax.swing.JLabel();
        card1 = new Swing.Card();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomePage\n");

        mainPanel.setBackground(new java.awt.Color(207, 232, 236));

        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu1MouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Khóa", "Phòng", "Ca", "GV", "Status"
            }
        ));
        jScrollPane1.setViewportView(table);

        comboxCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4", " ", " " }));
        comboxCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxCaActionPerformed(evt);
            }
        });

        btnFilterCa.setText("Tìm");
        btnFilterCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterCaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txTime.setText("12:00:00");

        panelInforUser.setBackground(new java.awt.Color(0, 129, 167));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Xin chào, Admin !!");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin.png"))); // NOI18N

        javax.swing.GroupLayout panelInforUserLayout = new javax.swing.GroupLayout(panelInforUser);
        panelInforUser.setLayout(panelInforUserLayout);
        panelInforUserLayout.setHorizontalGroup(
            panelInforUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInforUserLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        panelInforUserLayout.setVerticalGroup(
            panelInforUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInforUserLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelInforUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        txType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txType.setText("PM");

        txDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txDate.setText("Wed 12/8/2023");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDate, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInforUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelInforUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(487, 487, 487)
                                .addComponent(comboxCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFilterCa))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilterCa)
                    .addComponent(comboxCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseClicked
     
    }//GEN-LAST:event_menu1MouseClicked

    private void comboxCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxCaActionPerformed

    private void btnFilterCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterCaActionPerformed
      
        String comboxValue=comboxCa.getSelectedItem().toString();
        if(comboxValue=="All")
        {
            FetchData();
        }
        else{
            try {
            Float ca=Float.parseFloat(comboxValue);
            ArrayList<LichHoc> listLH =ConnectDB.MyDatabase.GetListPhongHocTheoCaNgay(ca,new Date());
            model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (LichHoc lichHoc : listLH) {
                model.addRow(new String[]{lichHoc.getIdLichHoc(),
                        lichHoc.getIdKhoaHoc(),
                        lichHoc.getIdPhong(),
                        String.valueOf(lichHoc.getCa()),
                        lichHoc.getIdUser(),
                        String.valueOf(lichHoc.isTrangThai())
                });
            }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
        
    }//GEN-LAST:event_btnFilterCaActionPerformed

    private Date getToday()
    {
        LocalDate today = LocalDate.now();
        return new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new HomeJFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilterCa;
    private Swing.Card card1;
    private javax.swing.JComboBox<String> comboxCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private Swing.Menu menu1;
    private javax.swing.JPanel panelInforUser;
    private javax.swing.JTable table;
    private javax.swing.JLabel txDate;
    private javax.swing.JLabel txTime;
    private javax.swing.JLabel txType;
    // End of variables declaration//GEN-END:variables

   
}
