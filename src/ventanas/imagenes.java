/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class imagenes extends DefaultTableCellRenderer{

    @Override
   /* public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            JButton boton = (JButton)value;
            if(isSelected){
                boton.setForeground(table.getSelectionForeground());
                boton.setBackground(table.getSelectionBackground());
            }else{
                boton.setForeground(table.getForeground());
                boton.setBackground(UIManager.getColor("Button.background"));
            }
            return boton;
            
        }
        return super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
        
 
 
    }   */
  
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {

        
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            if(isSelected){
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
           return btn;
        }
         
      return super.getTableCellRendererComponent(table, value, isSelected, 
         hasFocus, row, column);
       
        
    }}