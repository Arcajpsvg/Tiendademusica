/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public abstract class botones extends AbstractCellEditor implements TableCellEditor {
 
      protected final JButton button;
      private Object object;
     /**
47       * override this method to intercept the action when the button is pressed on the specified row
48       *
49       * @param row the view row index of the clicked button
50       * @param column the view row index of the clicked button
51       */
   public abstract void onButtonCellAction(int row, int column);
  
   public botones() {
         button = new JButton();
         button.setOpaque(true);
         button.setBorder(new LineBorder(Color.BLACK)); // why ?? because it is overriden by getTableCellEditorComponent
         button.addActionListener(new ActionListener() {
             @Override
        public void actionPerformed(ActionEvent e) {
                 cancelCellEditing();
                int rowIndex = -1;
               int colIndex = -1;
              if (e.getActionCommand() != null) {
                   String[] args = e.getActionCommand().split(",");
                   try {
                        rowIndex = Integer.valueOf(args[0]);
                         colIndex = Integer.valueOf(args[1]);
                    } catch (NumberFormatException nfe) {
                     } catch (IndexOutOfBoundsException iob) {
                      }
               }
               onButtonCellAction(rowIndex, colIndex);
              }
         });
     }
 
     @Override
     public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
         TableCellRenderer renderer = table.getCellRenderer(row, column);
         if (renderer instanceof TableCellRenderer) {
             JButton render = (JButton) renderer.getTableCellRendererComponent(table, value, isSelected, isSelected, row, column);
            button.setText(render.getText());
             button.setIcon(render.getIcon());
             button.setBorder(render.getBorder());
             button.setBackground(render.getBackground());
             button.setOpaque(render.isOpaque());
         }
         button.setActionCommand(String.valueOf(row) + "," + String.valueOf(column));
         this.object = value;
         return button;
     }
  
   @Override
     public Object getCellEditorValue() {
        return object;
    }
 }
