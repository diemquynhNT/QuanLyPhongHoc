/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing;

import Jframe.HomeJFrame;
import Jframe.LoginUserJFrame;
import Jframe.NhanVienJFrame;
import Jframe.PhongHocJFrame;
import Model.MenuModel;
import Swing.MenuItem;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

 public class ListMenu<E extends Object> extends JList<E>{
     //JList hiển thị một danh sách các phần tử cho người dùng chọn hoặc xem
     //hien thi danh sach menu
    private final DefaultListModel model; // làm mô hình cho thành phần ListMenu
    private int selectedIndex =0;
    
    
    public ListMenu() {
        model=new DefaultListModel(); // nhu List nhung tuong tac voi giao dien, JList 
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    int index=locationToIndex(e.getPoint()); //lay vi tri hien tai khi click
                    System.err.println(index);
                    Object o=model.getElementAt(index);// lay doi tuong tai vi tri index
                    System.err.println(o);
                    if(o instanceof MenuModel){
                        MenuModel menu=(MenuModel)o; //ep kieu
                        if(menu.getType()== MenuModel.MenuType.MENU) {
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
                    if(o instanceof MenuModel){
                        MenuModel menu=(MenuModel)o; 
                        if(menu.getName() =="Trang chủ")
                            jf=new HomeJFrame();
                        else if (menu.getName()=="Lịch học")
                            jf= new Jframe.LoginUserJFrame();
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
                MenuModel data;
                if(o instanceof MenuModel)
                {
                    data=(MenuModel)o;
                }else{
                    data=new MenuModel("",o+"",MenuModel.MenuType.EMPTY);
                }
                MenuItem item=new MenuItem(data);
                item.setSelected(selectedIndex==index);
                return item;
               
            }
            
        
        };
    }
    
    public void addItem(MenuModel data){
        model.addElement(data);
    
    }
    
    
}
