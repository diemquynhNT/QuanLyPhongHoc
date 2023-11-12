
package Jframe;

import ButtonEdit.TableActionButton;
import ButtonEdit.TableActionCellEditor;
import ButtonEdit.TableCellRenderButton;
import CalendarForm.ToDay;
import Model.KhoaHoc;
import Model.LichHoc;
import Model.PhongHoc;
import Model.Users;
import Model.Validation;
import Model.ValidationLichHoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class CreateLichHocJFrame extends javax.swing.JFrame {

    private Date ngayDay;
    String cellValue=null;
    JComboBox<String> comboGV=null;
    JComboBox<String> comboPhong=null;
    JComboBox<String> comboCa=null;
    
    public CreateLichHocJFrame(ToDay ngayChon) {
        initComponents();
        txDay.setText(ngayChon.getDay()+"/"+ngayChon.getMonth()+"/"+ngayChon.getYear());
        this.ngayDay=ChangeToDaytoDate(ngayChon);
        ValidateChangeData();
        showData();
        showComboBox();
        showComboBoxPhong();
        showComboBoxonTable();
        showComboBoxKhoaHoc();
        tabledata.getColumnModel().getColumn(6).setCellRenderer(new TableCellRenderButton());
        ClickUpdate();
       
    }
    private void showComboBoxonTable()
    {
        String[] options = {"true", "false"};
        String[] ca = {"1", "2","3","4"};
        String[] mon = {"TOIEC", "IELTS"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboCa=new JComboBox<>(ca);
        tabledata.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboBox));
        tabledata.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboGV));
        tabledata.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboCa));
        tabledata.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboPhong));

    }
    
    private void ClickUpdate()
    {
          TableActionButton event=new TableActionButton() {
                @Override
                public void onEdit(int row) {
                    System.err.println("edit");
                    String id = tabledata.getValueAt(row, 0).toString();
                    String monHoc = tabledata.getValueAt(row, 1).toString();
                    String phong = tabledata.getValueAt(row, 2).toString();
                    Float soTiet = Float.parseFloat(tabledata.getValueAt(row, 3).toString());
                    String giaoVien = tabledata.getValueAt(row, 4).toString();
                    Boolean status = Boolean.parseBoolean(tabledata.getValueAt(row, 5).toString());
                    System.err.println(id+monHoc+soTiet+phong+status+ngayDay);
                    LichHoc lh=new LichHoc(id,monHoc,giaoVien,ngayDay,soTiet,phong,status);
                    System.err.println(monHoc+phong+soTiet+status);
                    if(ConnectDB.LichHocDAO.ValidateLichHoc(lh))
                    {
                        try {
                            ConnectDB.LichHocDAO.UpdateLichHoc(lh);
                            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công !!!");
                            showData();

                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Trùng lịch học !!! ");
                        showData();
                    }
                }

                @Override
                public void onDelete(int row) {
                    String id = tabledata.getValueAt(row, 0).toString();
                    Boolean status = Boolean.parseBoolean(tabledata.getValueAt(row, 5).toString());
                    if(!status)
                    {
                        ConnectDB.LichHocDAO.DeleteLichHoc(id);
                        JOptionPane.showMessageDialog(rootPane, "Success");
                        showData();
                    }else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Ca con hoc");
                        showData();
                    }
                        
                   
                }

            };
            tabledata.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }
    
    private Date ChangeToDaytoDate(ToDay toDay)
    {
        Calendar ca=Calendar.getInstance();
        ca.set(Calendar.MONTH, toDay.getMonth()-1);
        ca.set(Calendar.YEAR, toDay.getYear());
        ca.set(Calendar.DATE, toDay.getDay());
        Date ngay=ca.getTime();
        return ngay;
    
    }

    private void ValidateChangeData()
    {
        Date ngayHientai=new Date();
        if(ngayDay.compareTo(ngayHientai)<0)
        {
            btThemLichHoc.setVisible(false);
        }
        
    }
 
    private void showData() {
        try {
            ArrayList<LichHoc> list =ConnectDB.LichHocDAO.ListLichHocByDate(ngayDay);
            DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
            model.setRowCount(0);
            for (LichHoc lichHoc : list) {
                //Users u=ConnectDB.UsersDAO.GetUsersById(lichHoc.getIdUser());
                int ca = Math.round(lichHoc.getCa());
                model.addRow(new String[]{lichHoc.getIdLichHoc(),
                        lichHoc.getIdKhoaHoc(), 
                        lichHoc.getIdPhong(),
                        Integer.toString(ca),
                        lichHoc.getIdUser(), 
                        Boolean.toString(lichHoc.isTrangThai())
                
                });
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxPhong = new javax.swing.JComboBox<>();
        JKhoaHoc = new javax.swing.JComboBox<>();
        jComboBoxGV = new javax.swing.JComboBox<>();
        btThemLichHoc = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jCbSoTiet = new javax.swing.JComboBox<>();
        txDay = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 129, 167));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 167)));

        jLabel1.setText("Khóa học");

        jLabel2.setText("Giáo viên");

        jLabel4.setText("Ca học");

        jLabel5.setText("Phòng");

        jComboBoxPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPhongActionPerformed(evt);
            }
        });

        btThemLichHoc.setBackground(new java.awt.Color(0, 129, 167));
        btThemLichHoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btThemLichHoc.setForeground(new java.awt.Color(255, 255, 255));
        btThemLichHoc.setText("Thêm");
        btThemLichHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemLichHocActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 0, 51));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Hủy");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jCbSoTiet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        txDay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txDay.setText("day");

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Khóa", "Phòng", "Ca", "GV", "Status", "Active"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabledata.setRowHeight(40);
        tabledata.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tabledata);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 129, 167));
        jLabel3.setText("LỊCH HỌC");

        jLabel6.setText("Ngày :");

        txSearch.setRequestFocusEnabled(false);
        txSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearchActionPerformed(evt);
            }
        });
        txSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 129, 167));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 129, 167));
        jLabel7.setText("DANH SÁCH LỊCH HỌC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxGV, 0, 186, Short.MAX_VALUE)
                            .addComponent(JKhoaHoc, 0, 186, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jCbSoTiet, 0, 187, Short.MAX_VALUE)
                                .addComponent(jComboBoxPhong, 0, 187, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(btThemLichHoc))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(148, 148, 148))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxGV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btThemLichHoc)
                        .addGap(75, 75, 75)
                        .addComponent(btnBack))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txDay)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemLichHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemLichHocActionPerformed
         // TODO add your handling code here:
        String monHoc = JKhoaHoc.getSelectedItem().toString();
        String giaoVien = jComboBoxGV.getSelectedItem().toString();
        int soTiet = Integer.parseInt(jCbSoTiet.getSelectedItem().toString());
        String phong = jComboBoxPhong.getSelectedItem().toString();
        Random generator = new Random();
        String id="L"+generator.nextInt(99) + 1+generator.nextInt(99) + 1;
        LichHoc lh=new LichHoc(id,monHoc,giaoVien,ngayDay,soTiet,phong,true);
        
        ValidationLichHoc v=new ValidationLichHoc();
        ArrayList<String> err=v.validationLichHoc(lh);
        if(err.size()<1)
        {
            try {
                ConnectDB.LichHocDAO.AddLichHoc(lh);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                showData();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }else
        {
            JOptionPane.showMessageDialog(null, err.toArray());
        }
        
        
    }//GEN-LAST:event_btThemLichHocActionPerformed

    private void jComboBoxPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPhongActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
//        JFrame frame = new CalendarFrame();
//                frame.setVisible(true);
//                frame.setLocationRelativeTo(null);
                 this.setVisible(false);


    }//GEN-LAST:event_btnBackActionPerformed

    private void txSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText = txSearch.getText();
        DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tabledata.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyReleased
       String searchText = txSearch.getText();
        DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tabledata.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }//GEN-LAST:event_txSearchKeyReleased

 
//    public static void main(String args[]) {
//       
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateLichHocJFrame().setVisible(true);
//            }
//        });
//    }
    
       private void showComboBox() {
        ArrayList<Users> listgv = ConnectDB.UsersDAO.findAllTeacher();
        comboGV=new JComboBox<>();
        for (Users user : listgv) {
            jComboBoxGV.addItem(user.getIdUser()); 
            comboGV.addItem(user.getIdUser());
        }
}


     private void showComboBoxKhoaHoc() {
        ArrayList<KhoaHoc> list=ConnectDB.MyDatabase.fillAllKhoaHoc();
        for(KhoaHoc i : list)
        {
            JKhoaHoc.addItem(i.getIdKhoaHoc());
        }
    }
     private void showComboBoxPhong() {
      ArrayList<PhongHoc> listphong=ConnectDB.LichHocDAO.findAllPhongHoc();
      comboPhong=new JComboBox<>();
        for(PhongHoc i : listphong)
        {
            jComboBoxPhong.addItem(i.getIdPhongHoc());
            comboPhong.addItem(i.getIdPhongHoc());
            
        }
       
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JKhoaHoc;
    private javax.swing.JButton btThemLichHoc;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> jCbSoTiet;
    private javax.swing.JComboBox<String> jComboBoxGV;
    private javax.swing.JComboBox<String> jComboBoxPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabledata;
    private javax.swing.JLabel txDay;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables

    
}
