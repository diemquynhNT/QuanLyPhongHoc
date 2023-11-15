
package Jframe;

import static ConnectDB.MyDatabase.myconnect;
import Model.Role;
import Model.TaiKhoan;
import java.sql.*;
import Model.Users;
import Model.Validation;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.mindrot.jbcrypt.BCrypt;

public class UserJFrame extends javax.swing.JFrame {

    Boolean status;
    Connection con;
    public UserJFrame() {
        initComponents();
        con=ConnectDB.MyDatabase.myconnect();
        showDataTable();
        showDataRole();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfEmailU = new javax.swing.JTextField();
        tfNumberU = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txChuyenNghanh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRole = new javax.swing.JComboBox<>();
        JTrangThai = new javax.swing.JComboBox<>();
        jTrinhDo = new javax.swing.JComboBox<>();
        txDiaChi = new javax.swing.JTextField();
        jGioiTinh = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        tfNameU = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txIdUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        JSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 129, 167));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 129, 167));
        jLabel3.setText("Họ tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 129, 167));
        jLabel4.setText("Email");

        tfEmailU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailUActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 129, 167));
        jLabel5.setText("SĐT");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 129, 167));
        jLabel6.setText("Giới tính");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 129, 167));
        jLabel2.setText("Role");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 129, 167));
        jLabel7.setText("Trạng thái");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 129, 167));
        jLabel8.setText("Trình Độ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 129, 167));
        jLabel9.setText("Địa chỉ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 129, 167));
        jLabel10.setText("Chuyên Nghành");

        JTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Nghỉ việc" }));

        jTrinhDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cao Đẳng", "Đại Học" }));
        jTrinhDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTrinhDoActionPerformed(evt);
            }
        });

        jGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 129, 167));
        jLabel12.setText("Ngày sinh");

        tfNameU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameUActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 129, 167));
        jLabel13.setText("Id");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Họ tên", "Email", "SĐT", "Role", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jButton1.setBackground(new java.awt.Color(0, 129, 167));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back (1).png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 129, 167));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 204, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 0, 51));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setToolTipText("");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 129, 167));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnTaiKhoan.setBackground(new java.awt.Color(0, 129, 167));
        btnTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiKhoan.setText("Tạo tài khoản");
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        JSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 129, 167));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(7, 29, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txChuyenNghanh, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txIdUser)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfNumberU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfEmailU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfNameU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClear))
                                    .addComponent(jButton1))
                                .addGap(16, 16, 16))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTaiKhoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txIdUser)
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch)
                            .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNameU, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfEmailU, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNumberU, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRole, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txChuyenNghanh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnClear))
                        .addGap(32, 32, 32)
                        .addComponent(jButton1)
                        .addContainerGap(13, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailUActionPerformed

    }//GEN-LAST:event_tfEmailUActionPerformed

    public void getClear()
    {
        tfNameU.setText("");
        txIdUser.setText("");
        tfEmailU.setText("");
        tfNumberU.setText("");
        txDiaChi.setText("");
        jGioiTinh.setSelectedIndex(0);
        JTrangThai.setSelectedIndex(0);
        jTrinhDo.setSelectedIndex(0);
        jRole.setSelectedIndex(0);
        txChuyenNghanh.setText("");
        txChuyenNghanh.setText("");
        
    }
  
    
    private void showDataTable() {
        try {
            ArrayList<Users> list =ConnectDB.UsersDAO.findAllUsers();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (Users item : list) {
                model.addRow(new String[]{item.getIdUser(),
                        item.getHoTen(), 
                        item.getEmail(),
                        item.getSdt(),
                        item.getIdRole(),
                        Boolean.toString(item.isTrangThai())
                });
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
     private void showDataRole() {
       ArrayList<Role> list=ConnectDB.RoleDAO.findAllRole();
        for(Role i : list)
        {
            jRole.addItem(i.getIdRole());
        }
    }
    private Users getUsers()
    {
        Users u=new Users();
        String role = jRole.getSelectedItem().toString();
        String hoTen = tfNameU.getText();
        String email = tfEmailU.getText();
        String phone = tfNumberU.getText();
        String gioiTinh = jGioiTinh.getSelectedItem().toString();
        String trangThai = JTrangThai.getSelectedItem().toString();
        if(trangThai=="Đang làm")
            status=true;
        else status=false;
        String id=txIdUser.getText();
        String diaChi = txDiaChi.getText();
        String chuyenNghanh = txChuyenNghanh.getText();
        String trinhDo = jTrinhDo.getSelectedItem().toString();
        java.util.Date ngay = jDateNgaySinh.getDate(); 
        java.sql.Date ngaySinh;
        if(ngay==null)
        {
          ngaySinh=null;
        
        }else{
            ngaySinh = new java.sql.Date(ngay.getTime());
        }
         u=new Users(id, hoTen, email, phone, gioiTinh, status, role, ngaySinh, diaChi, chuyenNghanh, trinhDo);
        return u;
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        getClear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        PreparedStatement ps;
        ResultSet rs;
            Random generator = new Random();
            String id="u"+generator.nextInt(99) + 1+generator.nextInt(99) + 1;
            Users u=getUsers();
            u.setIdUser(id);
            //check
            Validation v=new Validation();
            ArrayList<String> err=v.validateUsers(u);//
            err=v.CheckData(u);
            
            if(err.size()>0)
            {
                JOptionPane.showMessageDialog(null, err.toArray());
            
            }else{
                java.sql.Date ngaySinh = new java.sql.Date(u.getNgaySinh().getTime());
                String query = "INSERT INTO users(idUser,hoTen,idRole,email,phone,gioiTinh,trangThai,DiaChi,ChuyenNghanh,TrinhDo,ngaySinh) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                try{
                    ps = con.prepareStatement(query);
                    ps.setString(1, u.getIdUser());
                    ps.setString(2,u.getHoTen());
                    ps.setString(3, u.getIdRole());
                    ps.setString(4, u.getEmail());
                    ps.setString(5, u.getSdt());
                    ps.setString(6,u.getGioiTinh());
                    ps.setBoolean(7, status);
                    ps.setString(8, u.getDiaChi());
                    ps.setString(9, u.getChuyenNghanh());
                    ps.setString(10, u.getTrinhDo());
                    ps.setDate(11, ngaySinh);
                    ps.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this,"Insert new row success");
                    showDataTable();
                    getClear();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,"Error" + e);
                }
            }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        PreparedStatement ps;
        ResultSet rs;
//        String role = jRole.getSelectedItem().toString();
//        String hoTen = tfNameU.getText();
//        String email = tfEmailU.getText();
//        String phone = tfNumberU.getText();
//        String gioiTinh = jGioiTinh.getSelectedItem().toString();
//        String trangThai = JTrangThai.getSelectedItem().toString();
//        if(trangThai=="Đang làm")
//            status=true;
//        else status=false;
//        String id=txIdUser.getText();
//        String diaChi = txDiaChi.getText();
//        String chuyenNghanh = txChuyenNghanh.getText();
//        String trinhDo = jTrinhDo.getSelectedItem().toString();
//        System.err.println(jDateNgaySinh.getDate());
//        java.util.Date ngay = jDateNgaySinh.getDate(); 
        Users u=getUsers();
        Validation v=new Validation();
        ArrayList<String> err=v.validateUsers(u);
        err=v.CheckDataUpdate(u);
        java.sql.Date ngaySinh = new java.sql.Date(u.getNgaySinh().getTime());
            if(err.size()>0)
            {
                JOptionPane.showMessageDialog(null, err.toArray());
                err.clear();
            
            }else{
                String query = "UPDATE users SET "
                        + "hoTen=?,idRole=?,email=?,phone=?,gioiTinh=?,"
                        + "trangThai=?,DiaChi=?,ChuyenNghanh=?,TrinhDo=?,"
                        + "ngaySinh=? WHERE idUser=?";
                try{
                    ps = con.prepareStatement(query);
                    ps.setString(1,u.getHoTen());
                    ps.setString(2, u.getIdRole());
                    ps.setString(3, u.getEmail());
                    ps.setString(4, u.getSdt());
                    ps.setString(5,u.getGioiTinh());
                    ps.setBoolean(6, status);
                    ps.setString(7, u.getDiaChi());
                    ps.setString(8, u.getChuyenNghanh());
                    ps.setString(9, u.getTrinhDo());
                    ps.setDate(10, ngaySinh);
                    ps.setString(11, u.getIdUser());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Cập nhật thành công");
                    showDataTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,"Error" + e);
                }
            }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Connection con = myconnect();
        PreparedStatement ps;
        ResultSet rs;
        String id=txIdUser.getText();
        String trangThai = JTrangThai.getSelectedItem().toString();
        Boolean tinhtrang=ConnectDB.UsersDAO.CheckUsersLichHoc(id);
        if(tinhtrang==true)
        {
            JOptionPane.showMessageDialog(this,"Giaso viên còn lịch dạy !!");
            
        }
        else{
            if(trangThai!="Đang làm")
            {
            String query = "delete from users where idUser = ? and trangThai=0" ;
            try{
                ps = con.prepareStatement(query);
                ps.setString(1,id);
                ps.executeUpdate();
                showDataTable();
                getClear();
                JOptionPane.showMessageDialog(this,"Đã xóa thành công!!!");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error"+ex);
            }
        }else if(trangThai=="Đang làm"){
              JOptionPane.showMessageDialog(this,"Nhân viên còn làm !!!");
        }
        }
        
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        Users u=getUsers();
        Validation v=new Validation();
        ArrayList<String> err=v.validateUsers(u);
        System.err.println(u.getIdUser());
        TaiKhoan tk=ConnectDB.TaiKhoanDAO.GetTaiKhoanById(u.getIdUser());
        try {
            if(err.size()==0)
            {
                if(tk.getIdUser()==null)
                {
                    JFrame jf= new Jframe.TaoTaiKhoan(u.getIdUser(),u.getHoTen());
                    jf.setVisible(true);
                    jf.setLocationRelativeTo(null);
                    jf.setTitle("Tạo tài khoản mới");
                    //this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Đã có tài khoản !!!");
                    JFrame jf= new Jframe.ThongTinTaiKhoanJFrame(u.getIdUser(),u.getHoTen());
                    jf.setVisible(true);
                    jf.setLocationRelativeTo(null);
                    jf.setTitle("Thông tin tài khoản");

                }
            }else{
            JOptionPane.showMessageDialog(null, err.toArray());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText = JSearch.getText();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void JSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JSearchKeyReleased
        String searchText = JSearch.getText();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }//GEN-LAST:event_JSearchKeyReleased

    private void tfNameUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameUActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    setDataToForm();
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
       setDataToForm();
    }//GEN-LAST:event_tableMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame jf= new Jframe.HomeJFrame();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTrinhDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTrinhDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTrinhDoActionPerformed

    private void setDataToForm()
    {
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       String id=model.getValueAt(table.getSelectedRow(), 0).toString();
       Users u=ConnectDB.UsersDAO.GetUsersById(id);
       txIdUser.setText(u.getIdUser());
       tfNameU.setText(u.getHoTen());
       tfEmailU.setText(u.getEmail());
       tfNumberU.setText(u.getSdt());
       jGioiTinh.setSelectedItem(u.getGioiTinh().toString());
       jRole.setSelectedItem(u.getIdRole().toString()); 
       txChuyenNghanh.setText(u.getChuyenNghanh());
       Boolean status=u.isTrangThai();
       if(status)
           JTrangThai.setSelectedItem("Đang làm");
       else
           JTrangThai.setSelectedItem("Nghỉ việc");
       txDiaChi.setText(u.getDiaChi());
       jTrinhDo.setSelectedItem(u.getTrinhDo().toString());
       jDateNgaySinh.setDate(u.getNgaySinh());
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
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jf=new UserJFrame();
                jf.setVisible(true);
                jf.setTitle("Quản lý nhân viên");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JSearch;
    private javax.swing.JComboBox<String> JTrangThai;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JComboBox<String> jGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jRole;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jTrinhDo;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfEmailU;
    private javax.swing.JTextField tfNameU;
    private javax.swing.JTextField tfNumberU;
    private javax.swing.JTextField txChuyenNghanh;
    private javax.swing.JTextField txDiaChi;
    private javax.swing.JLabel txIdUser;
    // End of variables declaration//GEN-END:variables
}
