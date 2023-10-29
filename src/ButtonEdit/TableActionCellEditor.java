/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ButtonEdit;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author pengu73
 */
public class TableActionCellEditor extends DefaultCellEditor{
    
    private TableActionButton event;
    
    public TableActionCellEditor(TableActionButton event) {
        super(new JCheckBox());
        this.event=event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelButtonAction action = new PanelButtonAction();
        action.initEven(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
