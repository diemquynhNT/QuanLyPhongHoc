
package Jframe;


import ButtonEdit.TableActionButton;
import ButtonEdit.TableActionCellEditor;
import ButtonEdit.TableCellRenderButton;
import CalendarForm.ToDay;
import Model.LichHoc;
import Model.PhongHoc;
import Model.Users;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class CreateLichHocJFrame extends javax.swing.JFrame {

    private Date ngayDay;
    String cellValue=null;
    JComboBox<String> comboGV=null;
    JComboBox<String> comboPhong=null;
    JComboBox<String> comboCa=null;
    public CreateLichHocJFrame(ToDay ngayChon) {
//        this.setSize(500, 300);
//        this.setResizable(false);
        initComponents();
        txDay.setText(ngayChon.getDay()+"/"+ngayChon.getMonth()+"/"+ngayChon.getYear());
        this.ngayDay=ChangeToDaytoDate(ngayChon);
        ValidateChangeData();
        showData();
        showComboBox();
        showComboBoxPhong();
        showComboBoxonTable();
        
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
                    if(ConnectDB.MyDatabase.ValidateLichHoc(lh))
                    {
                        try {
                            ConnectDB.MyDatabase.UpdateLichHoc(lh);
                            JOptionPane.showMessageDialog(rootPane, "Success");
                            showData();

                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Trung");
                        showData();
                    }
                }

                @Override
                public void onDelete(int row) {
                    String id = tabledata.getValueAt(row, 0).toString();
                    Boolean status = Boolean.parseBoolean(tabledata.getValueAt(row, 5).toString());
                    if(!status)
                    {
                        ConnectDB.MyDatabase.DeleteLichHoc(id);
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
            ArrayList<LichHoc> list =ConnectDB.MyDatabase.ListLichHocByDate(ngayDay);
            DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
            model.setRowCount(0);
            for (LichHoc lichHoc : list) {
                model.addRow(new String[]{lichHoc.getIdLichHoc(),
                        lichHoc.getMonHoc(), 
                        lichHoc.getIdPhong(),
                        Float.toString(lichHoc.getSoTiet()),
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
        jMonHoc = new javax.swing.JComboBox<>();
        jComboBoxGV = new javax.swing.JComboBox<>();
        btThemLichHoc = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jCbSoTiet = new javax.swing.JComboBox<>();
        txDay = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 129, 167));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 167)));

        jLabel1.setText("Môn học");

        jLabel2.setText("giáo viên");

        jLabel4.setText("SoTiet");

        jLabel5.setText("Phong");

        jComboBoxPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPhongActionPerformed(evt);
            }
        });

        jMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán 1", "Toán 2", "Văn 1", "Văn 2", " " }));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxGV, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jCbSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnBack)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btThemLichHoc)
                        .addGap(75, 75, 75)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txDay)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDay)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jCbSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btThemLichHoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
        String monHoc = jMonHoc.getSelectedItem().toString();
        String giaoVien = jComboBoxGV.getSelectedItem().toString();
        int soTiet = Integer.parseInt(jCbSoTiet.getSelectedItem().toString());
        String phong = jComboBoxPhong.getSelectedItem().toString();
        Random generator = new Random();
        String id="L"+generator.nextInt(99) + 1;
        LichHoc lh=new LichHoc(id,monHoc,giaoVien,ngayDay,soTiet,phong,true);
        if(ConnectDB.MyDatabase.ValidateLichHoc(lh))
        {
           
            try {
                ConnectDB.MyDatabase.AddLichHoc(lh);
                JOptionPane.showMessageDialog(rootPane, "Success");
                showData();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
            }
        }else
        {
            JOptionPane.showMessageDialog(rootPane, "Trung");
        }
        
        
    }//GEN-LAST:event_btThemLichHocActionPerformed

    private void jComboBoxPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPhongActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JFrame frame = new CalendarFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                 this.setVisible(false);


    }//GEN-LAST:event_btnBackActionPerformed

 
//    public static void main(String args[]) {
//       
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateLichHocJFrame().setVisible(true);
//            }
//        });
//    }
    
    private void showComboBox() {
        ArrayList<Users> listgv=ConnectDB.MyDatabase.findAllUsers();
        comboGV = new JComboBox<>();

        for(Users i : listgv)
        {
          
            jComboBoxGV.addItem(i.getIdUser());
            comboGV.addItem(i.getIdUser());
        }
       
    }
     private void showComboBoxPhong() {
      ArrayList<PhongHoc> listphong=ConnectDB.MyDatabase.findAllPhongHoc();
      comboPhong=new JComboBox<>();
        for(PhongHoc i : listphong)
        {
            jComboBoxPhong.addItem(i.getIdPhongHoc());
            comboPhong.addItem(i.getIdPhongHoc());
            
        }
       
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThemLichHoc;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> jCbSoTiet;
    private javax.swing.JComboBox<String> jComboBoxGV;
    private javax.swing.JComboBox<String> jComboBoxPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> jMonHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabledata;
    private javax.swing.JLabel txDay;
    // End of variables declaration//GEN-END:variables

    
}
