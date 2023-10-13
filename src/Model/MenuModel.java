/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
    private String name;
    private String icon;
    private MenuType type;

    public MenuModel() {
    }

    public MenuModel(String name, String icon, MenuType type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }
    
    
    public Icon toIcon()
    {
        return new ImageIcon(getClass().getResource("/img/"+icon+".png"));
    }
    
    public static enum MenuType
    {
      TITLE,MENU,EMPTY;
    }
}
