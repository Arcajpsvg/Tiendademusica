/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas;


import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import java.awt.Button;
import java.awt.Component;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.JOptionPane;






/**
 *
 * @author ar_rr
 */
public class Clientes extends javax.swing.JDialog implements MouseListener {

    private static Frame VentanaPrincipal;

    /**
     * Creates new form Clientes
     */
    public Clientes(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        //this.arraydedatos = new ArrayList<datos>;
       
         initComponents();
         this.setTitle("Clientes");
         this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
         this.pack();
         
         
     
       }
        
  /*public void eliminaregistro(JTable jtable) throws SQLException{
        String Base_Datos ="jdbc:mysql://localhost";
        String User = "root";
        String Contrasenna  ="12345";
        String busqueda = "DELETE FROM clientes WHERE id_cliente = ?;";
        int f= jTable1.getSelectedRow();
        String v=jTable1.getValueAt(f, 0).toString();
        ConnectionImpl conexion = null;
        Statement eliminar = (Statement) conexion.createStatement();
        eliminar.executeUpdate("DELETE FROM clientes WHERE id_cliente ="+v+";");
        datosdetabla();
        
  }*/
        
    

    public  void datosdetabla(JTable jtable) throws SQLException {
              //establecemos conexión y realizamos una array para que se puedan mostrar nuestros datos en la JTable. Los insertamos mediante bucles

        String Base_Datos ="jdbc:mysql://localhost";
        String User = "root";
        String Contrasenna  ="12345";
        jtable.setDefaultRenderer(Object.class, new imagenes());
 
        
            

        //jtable.getCellEditor(1, new editor());
        DefaultTableModel modelotabla = new DefaultTableModel(){
            //esto lo hacemos para que no se pueda editar lo dispuesto en la tabla haciendo doble click
            
          @Override
           public boolean isCellEditable(int row, int column){
    	 
              
               if (column == 1 || column == 2 || column ==3){
                   return true;
               }
                 return false;
           }
      /*     public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                JTable target = (JTable)e.getSource();
                int fila = target.getSelectedRow();
                int columna = target.getSelectedColumn();
                borrarActionPerformed(e);
     
  
                }}

            private void borrarActionPerformed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }*/
        };
          
        ResultSet rs = null;
        String [] datostabla = new String [5];
         ConnectionImpl conexion = null;
         Statement prepst = null;
         String busqueda = ("SELECT * FROM clientes");
         

        
        try {
            conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
             prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
        
            modelotabla.addColumn("ID CLIENTE");
            modelotabla.addColumn("NOMBRE");
            modelotabla.addColumn("APELLIDOS");
            modelotabla.addColumn("TELÉFONO");
            modelotabla.addColumn("EDITAR");
            modelotabla.addColumn("BORRAR");
           
        
            rs = prepst.executeQuery(busqueda);
         
           
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
             ResultSet trd = null;
        try {
            conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            rs = prepst.executeQuery(busqueda);
            
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
        JButton editar = new JButton("Editar");
        
        
 
       JButton borrar = new JButton("Borrar");
       editar.setName("Editar");
        borrar.setName("Borrar");
 /*
   
borrar.addMouseListener(new MouseAdapter() {
 
 @Override
 public void mouseClicked(MouseEvent e) {
     System.out.println("Se ha hecho doble click");
     
  if (e.getClickCount() == 2) {
                
		borrarActionPerformed(e);
                
                Statement eliminar = null;
      try {
          datosdetabla(jTable1);
      } catch (SQLException ex) {
          Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
      }
                int f= jTable1.getSelectedRow();
                
                String v=jTable1.getValueAt(f, 0).toString();
                String busqueda = "DELETE FROM clientes WHERE id_cliente ="+v+";";
                String busqueda1 = "DELETE FROM pedidos WHERE cliente_FK ="+v+";";
      try {
          // jTable1.removeRow(f);
          eliminar.addBatch(busqueda);
      } catch (SQLException ex) {
          Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          eliminar.addBatch(busqueda1);
      } catch (SQLException ex) {
          Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          eliminar.executeBatch();
      } catch (SQLException ex) {
          Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
      }
                JOptionPane.showMessageDialog(null, "Registro borrado exitosamente");
	}
      
     
  }
 

            public void borrarActionPerformed(MouseEvent e) {
     try {
         eliminaregistro();
     } catch (SQLException ex) {
         Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
     }

            }
        });*/
      
       while(rs.next()){     
        for(int i=0; i<1; i++){ 
                Object f[] = new Object[6];
                f[0] = rs.getInt("id_cliente");
                f[1] = rs.getString("nombre");
                f[2] = rs.getString("apellidos");        
                f[3] = rs.getString("telefono");
                f[4] = editar;
                f[5] = borrar;
                modelotabla.addRow(f);}
                
          
            
   
            }
                
                
                
                  
   //añadimos datamodel a nuestra jTable
    jTable1.setModel(modelotabla);
            prepst.close();
            conexion.close();
            rs.close();
        
     
       }
    
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_CLIENTE", "NOMBRE", "APELLIDOS", "TELÉFONO", "EDITAR", "BORRAR"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 1099, 217));

        jLabel1.setText("INTRODUCIR DATOS PARA AÑADIR REGISTRO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 22, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 56, 302, -1));

        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 59, -1, -1));

        jLabel3.setText("APELLIDOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 114, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 111, 302, -1));

        jLabel4.setText("TELÉFONO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 174, -1, -1));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 171, 302, -1));

        jButton2.setText("AÑADIR");
        jButton2.setMaximumSize(new java.awt.Dimension(79, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(79, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 211, 147, -1));

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 520, 125, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
   
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
      
    
        
        
        
        

        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         //para insertar datos en BD
                                
          conexion();
          
         
    }
      private void conexion(){ 
          //definimos variables y establecemos conexión
          
           String Base_Datos ="jdbc:mysql://localhost";
           String User = "root";
           String Contrasenna  ="12345";
           com.mysql.cj.jdbc.ConnectionImpl conexion;
           Statement prepst;
           
             String nombre = jTextField1.getText();
              String apellidos = jTextField2.getText();
           String telefono = jTextField3.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if((jTextField1.getText().length()==0 && jTextField2.getText().length()==0 && jTextField3.getText().length()== 0 ) || (jTextField1.getText().length()==0 && jTextField2.getText().length()==0) || (jTextField2.getText().length()==0 && jTextField3.getText().length()== 0) ||(jTextField1.getText().length()==0 && jTextField3.getText().length()==0) || (jTextField1.getText().length()==0) || jTextField2.getText().length()==0 || (jTextField3.getText().length()== 0))  {
            JOptionPane.showMessageDialog(null, "Rellene los campos");
        }
        else{
    
        try {
            conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            String insercion = ("INSERT INTO clientes (nombre, apellidos, telefono) VALUES ('"+nombre+"', '"+apellidos+"', '"+telefono+"')");
            prepst.execute(insercion);
            prepst.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        } 
             
        
           
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //para insertar datos en jTable
            datosdetabla(jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int columna;
        int fila;
        columna = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
        fila = evt.getY()/jTable1.getRowHeight();
        if(columna<=jTable1.getColumnCount() && columna >= 0 && fila <= jTable1.getRowCount() && fila >=0){
            
        Object obj = jTable1.getValueAt(fila, columna);
        if(obj instanceof JButton){
            ((JButton)obj).doClick();
             JButton bot = (JButton)obj;
             if(bot.getName().equals("Borrar")){
                try {
                    eliminaregistro();
                } catch (SQLException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             else{
                 try {
                    actualizaregistro();
                } catch (SQLException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // lo realizamos para que solo se puedan introducir números en el campo teléfono
        char v = evt.getKeyChar();
        if(Character.isLetter(v)){
            //emite un sonido al introducir letra
          getToolkit().beep();
          //rechaza la introducción al no ser un número
          evt.consume();
          JOptionPane.showMessageDialog(null, "En este apartado solo puede introducir números");
        }
    }//GEN-LAST:event_jTextField3KeyTyped
  
    
    private void actualizaregistro() throws SQLException{
                String Base_Datos ="jdbc:mysql://localhost";
                String User = "root";
                String Contrasenna  ="12345";
                ConnectionImpl conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
                
          
             Statement actualizar = (Statement) conexion.createStatement();
                actualizar.executeUpdate("use tiendademusica");
               
                ////jTable1.isCellEditable(jTable1.getSelectedRow(), 1);
               // jTable1.isCellEditable(jTable1.getSelectedRow(), 2);
               // jTable1.isCellEditable(jTable1.getSelectedRow(), 3);
                String id =jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                String nombre = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String apellidos = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                String telefono = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                Boolean compro = comprobarTlf(telefono);
                if(!compro){
                 JOptionPane.showMessageDialog(null, "No se permite introducir letras");
                }else{
               
                String sentencia = "UPDATE clientes SET nombre='"+nombre+"', apellidos='"+apellidos+"', telefono='"+telefono+"' WHERE id_cliente='"+id+"';";
                actualizar.executeUpdate(sentencia);
                JOptionPane.showMessageDialog(null, "Registro actualizado");
                actualizar.close();
                conexion.close();
                }
    }       
     private boolean comprobarTlf(String telefono){
	      char c = telefono.charAt(0);
              
        if(Character.isLetter(c)){
          //getToolkit().beep();
                     return false;
                 }

			 else
			    return true;

	 }
    private void eliminaregistro() throws SQLException {
                String Base_Datos ="jdbc:mysql://localhost";
                String User = "root";
                String Contrasenna  ="12345";
                ConnectionImpl conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
                
                Statement eliminar = (Statement) conexion.createStatement();
                eliminar.executeUpdate("use tiendademusica;");
               // datosdetabla(jTable1);
                /*int f= jTable1.getSelectedRow();
                int c = jTable1.getSelectedColumn();
                String v=jTable1.getValueAt(f, c).toString();*/
                String busqueda = "DELETE FROM clientes WHERE id_cliente ="+jTable1.getValueAt(jTable1.getSelectedRow(), 0)+";";
                int v = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                
              //  String busqueda1 = "DELETE FROM pedidos WHERE cliente_FK ="+v+";";
              // jTable1.removeRow(f);
                //eliminar.addBatch(busqueda1);
                eliminar.addBatch(busqueda);
                eliminar.executeBatch();
                JOptionPane.showMessageDialog(null, "Registro borrado exitosamente");
                eliminar.close();
                conexion.close();
            }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     //  new Clientes(VentanaPrincipal, true);

        
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                   
                     
                      
                     

                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes dialog = new Clientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
 
    private void getScreenSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setExtendedState(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String parseString(String text) {
       
        return null;
       
    }

    private void imagenes(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    @Override
    public void mouseClicked(MouseEvent e) {
        int fila= jTable1.getColumnModel().getColumnIndexAtX(e.getX());
       int columna= e.getY()/jTable1.getRowHeight();
        if(columna==jTable1.getSelectedColumn()){
        if(fila<jTable1.getRowCount() && fila >=0 && columna < jTable1.getColumnCount() && columna >=0){
            Object cc = jTable1.getValueAt(fila, columna);
            if(cc instanceof JButton){
              ((JButton)cc).doClick();
              JButton boton = (JButton)cc;
              
            }
        }
        }
    }

   @Override
   public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

