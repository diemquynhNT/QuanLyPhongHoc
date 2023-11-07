/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import Model.LichHoc;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ImportExcelLichHocJFrame extends javax.swing.JFrame {

    DefaultTableModel ImportExcelModel;
    public ImportExcelLichHocJFrame() {
        initComponents();
     
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnImport = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 129, 167));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã ", "Môn", "Giáo viên", "Ngày", "Phòng", "Status", "Ca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableData);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 129, 167));
        jLabel2.setText("IMPORT DATA");

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import_1.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(224, 224, 224))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
       ImportExcelModel= (DefaultTableModel)tableData.getModel();
        ImportExcelModel.setNumRows(0);
        FileInputStream excelFIP=null;
        BufferedInputStream excelBIS=null;
        XSSFWorkbook excelImportWorkbook=null;
        //path mac dinh
        String currentDirectoryPath="D:\\";
        JFileChooser file=new JFileChooser(currentDirectoryPath);
        
        //chi lay file excel
        FileNameExtensionFilter typeFile=new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xslm");
        file.setFileFilter(typeFile);
        
        
        int excelChoose= file.showOpenDialog(null);
        
        //if open button is click
        if(excelChoose==JFileChooser.APPROVE_OPTION)
        {
            try {
                File excelFile=file.getSelectedFile();
                excelFIP=new FileInputStream(excelFile);
                excelBIS=new BufferedInputStream(excelFIP);
                excelImportWorkbook =new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet=excelImportWorkbook.getSheetAt(0);
                
                for(int i=1;i<=excelSheet.getLastRowNum();i++)
                {
                    XSSFRow row=excelSheet.getRow(i);
                    XSSFCell cellId=row.getCell(0);
                    XSSFCell cellMonHoc=row.getCell(1);
                    XSSFCell cellIdUser=row.getCell(2);
                    XSSFCell cellNgay=row.getCell(3);
                    XSSFCell cellStatus=row.getCell(5);
                    XSSFCell cellIdPhong=row.getCell(4);
                    XSSFCell cellCa=row.getCell(6);
                    
                    ImportExcelModel.addRow(new Object[] {cellId,cellMonHoc,cellIdUser,cellNgay,cellIdPhong,cellStatus,cellCa});
                }
                
                JOptionPane.showMessageDialog(null, "import thanh cong");
                
            }   catch (FileNotFoundException ex) {
               java.util.logging.Logger.getLogger(ImportExcelLichHocJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           } catch (IOException ex) {
               java.util.logging.Logger.getLogger(ImportExcelLichHocJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }finally {
                try {
                    excelImportWorkbook.close();
                    excelFIP.close();
                    excelBIS.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
            
            
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        int rowCount=ImportExcelModel.getRowCount();
        for (int i = rowCount-1; i>=0; i--) {
            ImportExcelModel.removeRow(i);
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         int rowCount = ImportExcelModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            // Get the data from each column in the JTable row
            String cellId = ImportExcelModel.getValueAt(i, 0).toString();
            String cellMonHoc = ImportExcelModel.getValueAt(i, 1).toString();
            String cellIdUser = ImportExcelModel.getValueAt(i, 2).toString();
            String dateString = ImportExcelModel.getValueAt(i, 3).toString();
            Date cellNgay = null;
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

            try {
                cellNgay = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }   
                
            String cellIdPhong = ImportExcelModel.getValueAt(i, 4).toString();
            String cellStatus =ImportExcelModel.getValueAt(i, 5).toString();
            boolean status = Boolean.parseBoolean(cellStatus);
            String cellCa = ImportExcelModel.getValueAt(i, 6).toString();
            float ca = Float.parseFloat(cellCa);
            
            
            LichHoc lh=new LichHoc(cellId,cellMonHoc,cellIdUser,cellNgay,ca,cellIdPhong,status);
            ConnectDB.MyDatabase.AddLichHoc(lh);
            
        
        }
        JOptionPane.showMessageDialog(null, "Data imported and saved to MySQL");
        
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed
  

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportExcelLichHocJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
