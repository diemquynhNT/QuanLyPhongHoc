/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing;

import Jframe.HomeJFrame;
import Jframe.LoginUserJFrame;
import Jframe.NhanVienJFrame;
import Jframe.PhongHocJFrame;
import Model.MenuName;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

 public class ListMenu<E extends Object> extends JList<E>{
     //hien thi danh sach menu
    private final DefaultListModel model; // làm mô hình cho thành phần ListMenu
    private int selectedIndex =0;
    
    
    public ListMenu() {
        model=new DefaultListModel(); // lưu trữ dữ liệu cho danh sách ListMenu hiển thị
        setModel(model);//gan model cho listmenu =>ListMenu se dung DefaultListModel de luu tru
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    int index=locationToIndex(e.getPoint()); //lay vi tri hien tai khi click
                    System.err.println(index);
                    Object o=model.getElementAt(index);// lay doi tuong tai vi tri index
                    System.err.println(o);
                    if(o instanceof MenuName){
                        MenuName menu=(MenuName)o; //ep kieu
                        if(menu.getType()== MenuName.MenuType.MENU) {
                               selectedIndex=index;
                            }
                    }else{
                        selectedIndex=index;
                    }
                    repaint();
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    int index=locationToIndex(e.getPoint()); 
                    Object o=model.getElementAt(index);// lay doi tuong tai vi tri index
                    JFrame jf=new JFrame();
                    if(o instanceof MenuName){
                        MenuName menu=(MenuName)o; 
                        if(menu.getName() =="Trang chủ")
                            jf=new HomeJFrame();
                        else if (menu.getName()=="Lịch học")
                            {
                                jf= new Jframe.CalendarFrame();
                                jf.setMaximumSize(new Dimension(100, 100));
                            }
                        else if (menu.getName()=="Phòng học")
                            jf= new PhongHocJFrame();
                        else if (menu.getName()=="Logout")
                            jf=new LoginUserJFrame();
                        else if (menu.getName()=="Nhân viên")
                            jf=new NhanVienJFrame();
                        Container container = (Container) e.getSource();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(container);
                        frame.setVisible(false);
                        jf.setVisible(true);
                        jf.setLocationRelativeTo(null);
                    }
                 }
            }
            
        });
         
    }
    //hien thi danh sach menu
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, 
                    Object o, int index, boolean selected, boolean focus) {
                MenuName data;
                if(o instanceof MenuName)
                {
                    data=(MenuName)o;
                }else{
                    data=new MenuName("",o+"",MenuName.MenuType.EMPTY);
                }
                MenuItem item=new MenuItem(data);
                item.setSelected(selectedIndex==index);
                return item;
            }
        };
    }
    
    public void addItem(MenuName data){
        model.addElement(data);
    
    }
    
    
}
