/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import CalendarForm.PanelDate;
import CalendarForm.PanelSlide;
import javax.swing.JFrame;

/**
 *
 * @author pengu73
 */
public class CalendarFrame extends javax.swing.JFrame {
    private int year,month;
    public CalendarFrame() {
        this.setSize(500, 300);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarPanelCus1 = new CalendarForm.CalendarPanelCus();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(calendarPanelCus1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new CalendarFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CalendarForm.CalendarPanelCus calendarPanelCus1;
    // End of variables declaration//GEN-END:variables
}
