/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel{
    
    public TableHeader(String text)
    {
        super(text);
        setOpaque(false);
        setBackground(Color.WHITE);
        setFont(new Font("sansserif",1,12));
        setForeground(new Color(102,102,102));
        setBorder(new EmptyBorder(10,5,10,5));
    }
}
