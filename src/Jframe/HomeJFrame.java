
package Jframe;

import Model.LichHoc;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class HomeJFrame extends javax.swing.JFrame {

    DefaultTableModel model;
    public HomeJFrame() {
        initComponents();
        menu1.initMoving(HomeJFrame.this);
        FetchData();
        DisplayData();
        //chay thoi gian
        new Thread(new Runnable(){
            @Override
            public void run() {//luồng mới sẽ thực hiện khi được khởi động
                while (true) {//vo han
                   try{
                       Thread.sleep(1000);
                   }
                   catch(Exception ex)
                   {
                       System.err.println(ex);
                   }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd/MM/yyyy");
                    String time = tf.format(date);
                    System.err.println(time);
                    txTime.setText(time.split(" ")[0]);//phần đầu tiên của thoi gina
                    txType.setText(time.split(" ")[1]);
                    txDate.setText(df.format(date));
                }
            }
        }).start();
    }
     private void FetchData() {
         try {
        ArrayList<LichHoc> listSP =ConnectDB.LichHocDAO.ListLichHocByDate(new Date());
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
    private void DisplayData() {
        txSoCa.setText(String.valueOf(ConnectDB.LichHocDAO.CountLichHocToDay(new Date())));
        txCaDangHoc.setText(String.valueOf(ConnectDB.LichHocDAO.CountLichHocToDayByStatus(new Date(),true)));
        txCaHuy.setText(String.valueOf(ConnectDB.LichHocDAO.CountLichHocToDayByStatus(new Date(),false)));

        
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
        jLabel2 = new javax.swing.JLabel();
        txSoCa = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txCaDangHoc = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txCaHuy = new javax.swing.JLabel();
        card3 = new Swing.Card();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnXepPhong = new javax.swing.JButton();

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

        btnFilterCa.setBackground(new java.awt.Color(0, 129, 167));
        btnFilterCa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFilterCa.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Số ca học ");

        txSoCa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txSoCa.setForeground(new java.awt.Color(255, 255, 255));
        txSoCa.setText("10");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ca học  ");

        txCaDangHoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txCaDangHoc.setForeground(new java.awt.Color(255, 255, 255));
        txCaDangHoc.setText("10");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ca đã hủy  ");

        txCaHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txCaHuy.setForeground(new java.awt.Color(255, 255, 255));
        txCaHuy.setText("10");

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txCaHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCaDangHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txSoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txCaDangHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txCaHuy))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Số phòng");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("10");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Phòng hoạt động ");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("10");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Phòng hủy");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("0");

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        txSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 129, 167));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        btnSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSearchKeyReleased(evt);
            }
        });

        btnXepPhong.setBackground(new java.awt.Color(0, 129, 167));
        btnXepPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXepPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnXepPhong.setText("Xếp phòng");
        btnXepPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXepPhongActionPerformed(evt);
            }
        });

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
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(btnXepPhong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                        .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch)))
                                .addGap(18, 18, 18)
                                .addComponent(comboxCa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFilterCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFilterCa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboxCa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnXepPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            ArrayList<LichHoc> listLH =ConnectDB.LichHocDAO.GetListPhongHocTheoCaNgay(ca,new Date());
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSearchKeyReleased
        SearchData();
    }//GEN-LAST:event_btnSearchKeyReleased

    private void txSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyReleased
      SearchData();
    }//GEN-LAST:event_txSearchKeyReleased

    private void btnXepPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXepPhongActionPerformed
                JFrame frame = new ChoosePhong();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setTitle("Xếp phòng");
                this.setVisible(false);
    }//GEN-LAST:event_btnXepPhongActionPerformed
    private void SearchData()
    {
        String searchText = txSearch.getText();
        model = (DefaultTableModel) table.getModel();
        //dung TableRowSorter de sap xep
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }
    private Date getToday()
    {
        LocalDate today = LocalDate.now();
        return new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new HomeJFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setTitle("HomePage");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilterCa;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnXepPhong;
    private Swing.Card card1;
    private Swing.Card card3;
    private javax.swing.JComboBox<String> comboxCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private Swing.Menu menu1;
    private javax.swing.JPanel panelInforUser;
    private javax.swing.JTable table;
    private javax.swing.JLabel txCaDangHoc;
    private javax.swing.JLabel txCaHuy;
    private javax.swing.JLabel txDate;
    private javax.swing.JTextField txSearch;
    private javax.swing.JLabel txSoCa;
    private javax.swing.JLabel txTime;
    private javax.swing.JLabel txType;
    // End of variables declaration//GEN-END:variables

  

   
}
