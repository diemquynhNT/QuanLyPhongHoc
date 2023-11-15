/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pengu73
 */
public class DisplayItem {
     private String text;
    private String value;

    public DisplayItem(String text, String value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
