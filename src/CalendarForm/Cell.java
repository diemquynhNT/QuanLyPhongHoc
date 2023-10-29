/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalendarForm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Cell extends JButton{
    private Date date;
    private boolean title;
    private boolean isToday;

   
    public Cell(){
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }

    public boolean isTitle() {
        return title;
    }

    public void asTitle() {
        title=true;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
     public void setAsToday() {
         isToday=true;
         setForeground(Color.WHITE);
    }
    
    
    public void currentMonth(boolean act)
    {
        if(act)
        {
            setForeground(Color.BLACK);
        }else
        {
            setForeground(Color.GRAY);

        }
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(title)
        {
            g.setColor(Color.BLACK);
            g.drawLine(0, getHeight()-1, getWidth(), getHeight());
        }
        if(isToday)
        {
            //hien thi ngay hine tai
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.blue);
            int x=getWidth()/2-19;
            int y=getHeight()/2-17;
            g2.fillRoundRect(x, y,35, 35, 100, 100);
            
            
        }
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
