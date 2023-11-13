/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;
import static ConnectDB.MyDatabase.myconnect;
import Model.PhongHoc;
import Model.Users;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author pengu73
 */
public class PhongHocJFrame extends javax.swing.JFrame {

    Boolean trangThai;
    public PhongHocJFrame() {
        initComponents();
        showDataTable();
    }
    public void getClear()
    {
        jID.setText("");
        jSoGhe.setText("");
        jThietBi.setText("");
        jSoTang.setSelectedIndex(0);
        jtrangThai.setSelectedIndex(0);
        
    }
  
    
    private void showDataTable() {
        try {
            String status;
            ArrayList<PhongHoc> list =ConnectDB.LichHocDAO.findAllPhongHoc();
            DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
            model.setRowCount(0);
            for (PhongHoc item : list) {
                if(item.isTrangThaiSuDung())
                    status="Đang sử dụng";
                else status="Ngưng sử dụng";
                model.addRow(new String[]{item.getIdPhongHoc(),
                        Integer.toString(item.getSoTang()), 
                        Integer.toString(item.getSoGhe()), 
                        item.getThietBi(),
                        status
                });
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    private ArrayList<String> CheckPhongHoc(PhongHoc ph )
    {
        ArrayList<String> err=new ArrayList<>();
        PhongHoc phong=ConnectDB.PhongHocDAO.GetPhongHocById(ph.getIdPhongHoc());
        if(ph.getIdPhongHoc().isEmpty())
            err.add("Id trống!!!");
        if(phong.getIdPhongHoc()!=null)
            err.add("Mã phòng đã tồn tại!!!");
        return err;
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        Tim = new javax.swing.JButton();
        jID = new javax.swing.JTextField();
        jSoGhe = new javax.swing.JTextField();
        jSoTang = new javax.swing.JComboBox<>();
        jThietBi = new javax.swing.JTextField();
        jtrangThai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jSreach = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 129, 167));
        jPanel2.setPreferredSize(new java.awt.Dimension(926, 499));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("SỐ TẦNG");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("SỐ GHẾ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("THIẾT BỊ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("TRẠNG THÁI");

        jLabel2.setBackground(new java.awt.Color(0, 129, 167));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 129, 167));
        jLabel2.setText("QUẢN LÝ PHÒNG HỌC");

        Them.setBackground(new java.awt.Color(0, 129, 167));
        Them.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Them.setForeground(new java.awt.Color(255, 255, 255));
        Them.setText("THÊM");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Xoa.setBackground(new java.awt.Color(255, 0, 0));
        Xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Xoa.setForeground(new java.awt.Color(255, 255, 255));
        Xoa.setText("XÓA");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(255, 255, 102));
        Sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sua.setText("SỬA");
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        Tim.setBackground(new java.awt.Color(0, 129, 167));
        Tim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tim.setForeground(new java.awt.Color(255, 255, 255));
        Tim.setText("TÌM");
        Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimActionPerformed(evt);
            }
        });

        jSoGhe.setText("0");

        jSoTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jtrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang sử dụng", "Ngưng sử dụng" }));

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Số tầng", "Số ghế", "Thiết bị", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabledata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledataMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabledataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabledata);

        btnSearch.setBackground(new java.awt.Color(0, 129, 167));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jSreach.setText("Nhập thông tin");
        jSreach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSreachKeyReleased(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 129, 167));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(btnClear)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addGap(43, 43, 43)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSoTang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSoGhe)
                                        .addComponent(jThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jSoTang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSoGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnClear)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Them)
                                    .addComponent(Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Tim)
                                    .addComponent(Sua))
                                .addGap(151, 151, 151))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        Connection con = ConnectDB.MyDatabase.myconnect();
        PreparedStatement ps;
        ResultSet rs;
        String id=jID.getText();
        PhongHoc phong=ConnectDB.PhongHocDAO.GetPhongHocById(id);
        if(phong!=null)
        {
            jID.setText(id);
            int sg=phong.getSoGhe();
            jSoGhe.setText(String.valueOf(sg));
            jSoTang.setSelectedItem(phong.getSoTang());
            Boolean trangthai=phong.isTrangThaiSuDung();
            if(trangthai)
            {
                jtrangThai.setSelectedItem("Đang sử dụng");
            }else {
             jtrangThai.setSelectedItem("Ngưng sử dụng");
            }
            jThietBi.setText(phong.getThietBi());
        }else{
            JOptionPane.showMessageDialog(this,"Không tìm thấy !!!");
        }
        
    }//GEN-LAST:event_TimActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        Connection con =ConnectDB.MyDatabase.myconnect();
        PreparedStatement ps;
        ResultSet rs;
        String id = jID.getText();
        int Sotang = Integer.parseInt(jSoTang.getSelectedItem().toString());
        int Soghe = Integer.parseInt(jSoGhe.getText());
        String trangthaiSuDung = jtrangThai.getSelectedItem().toString();
        if(trangthaiSuDung=="Đang sử dụng")
            trangThai=true;
        else trangThai=false;
        String Thietbi = jThietBi.getText();
        
        String query = "UPDATE phonghoc "
               + "SET soTang = ?, "
               + "soGhe = ?, "
               + "trangThaiSuDung = ?, "
               + "thietBi = ? WHERE idPhongHoc = ?";
            try{
                    ps = con.prepareStatement(query);
                    ps.setInt(1,Sotang);
                    ps.setInt(2, Soghe);
                    ps.setBoolean(3, trangThai);
                    ps.setString(4, Thietbi);
                    ps.setString(5,id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Cập nhật thành công");
                    showDataTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,"Error" + e);
                }
    }//GEN-LAST:event_SuaActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        Connection con = myconnect();
        PreparedStatement ps;
        ResultSet rs;
        String query ="delete from phonghoc where idPhongHoc=? and trangThaiSuDung=0";
        String id = jID.getText();
        PhongHoc phong=ConnectDB.PhongHocDAO.GetPhongHocById(id);
        if(!phong.isTrangThaiSuDung())
        {
            try {
            ps = con.prepareStatement(query);
            ps.setString(1,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Delete new row success");
            showDataTable();
            getClear();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Error"+e);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Phòng đang sử dụng !!!");
        }
        
       
    }//GEN-LAST:event_XoaActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        Connection con = myconnect();
        PreparedStatement ps;
        ResultSet rs;
        
        String id = jID.getText();
        int Sotang = Integer.parseInt(jSoTang.getSelectedItem().toString());
        int Soghe = Integer.parseInt(jSoGhe.getText());
        String trangthaiSuDung = jtrangThai.getSelectedItem().toString();
        if(trangthaiSuDung=="Đang sử dụng")
            trangThai=true;
        else trangThai=false;
        String Thietbi = jThietBi.getText();
        PhongHoc ph=new PhongHoc(id, Sotang, Soghe, true, Thietbi);
        ArrayList<String> err=CheckPhongHoc(ph);
        
        if(err.size()<1)
        {
            String query = "INSERT INTO phonghoc(idPhongHoc,soTang,soGhe,trangThaiSuDung,thietBi)"
                + "values(?,?,?,?,?)";
            try{
                ps=con.prepareStatement(query);
                ps.setString(1,id);
                ps.setInt(2,Sotang);
                ps.setInt(3,Soghe);
                ps.setBoolean(4, trangThai);
                ps.setString(5,Thietbi);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(this,"Thêm thành công");
                getClear();
                showDataTable();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this,"Error"+e);
            }
        }else{
            JOptionPane.showMessageDialog(this,err);
        }
        
    }//GEN-LAST:event_ThemActionPerformed

    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
         JFrame jf= new Jframe.HomeJFrame();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        this.setVisible(false);

    }//GEN-LAST:event_btnBackActionPerformed
    
   
    private void setDataToForm()
    {
       DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
       String id=model.getValueAt(tabledata.getSelectedRow(), 0).toString();
       PhongHoc phong=ConnectDB.PhongHocDAO.GetPhongHocById(id);
       
       jID.setText(phong.getIdPhongHoc());
       int sg=phong.getSoGhe();
       jSoGhe.setText(String.valueOf(sg));
        System.err.println(phong.getSoTang());
       jSoTang.setSelectedItem(String.valueOf(phong.getSoTang()));
       Boolean trangthai=phong.isTrangThaiSuDung();
       if(trangthai)
       {
           jtrangThai.setSelectedItem("Đang sử dụng");
       }else {
        jtrangThai.setSelectedItem("Ngưng sử dụng");
       }
       jThietBi.setText(phong.getThietBi());
       
    }
    private void tabledataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledataMouseClicked
         setDataToForm();
    }//GEN-LAST:event_tabledataMouseClicked

    private void tabledataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledataMousePressed
         setDataToForm();
    }//GEN-LAST:event_tabledataMousePressed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        getClear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jSreachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSreachKeyReleased
        SearchData();
    }//GEN-LAST:event_jSreachKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SearchData();
    }//GEN-LAST:event_btnSearchActionPerformed
    private void SearchData()
    {
        String searchText = jSreach.getText();
        DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tabledata.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jf=new PhongHocJFrame();
                jf.setVisible(true);
                jf.setTitle("Quản lý phòng học");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JButton Xoa;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSoGhe;
    private javax.swing.JComboBox<String> jSoTang;
    private javax.swing.JTextField jSreach;
    private javax.swing.JTextField jThietBi;
    private javax.swing.JComboBox<String> jtrangThai;
    private javax.swing.JTable tabledata;
    // End of variables declaration//GEN-END:variables
}
