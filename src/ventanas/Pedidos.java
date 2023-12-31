/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.ResultSetImpl;
import java.awt.Toolkit;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.UIManager.getInt;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ar_rr
 */
public class Pedidos extends javax.swing.JDialog {

    /**
     * Creates new form Pedidos
     */
    public Pedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Pedidos");
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
         this.pack();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID PEDIDO", "CANTIDAD", "PRODUCTO", "PRECIO", "CLIENTE", "APELLIDOS", "FECHA", "ESTADO", "ACCIONES"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 297, 1098, 202));

        jLabel1.setText("INTRODUCIR DATOS PARA AÑADIR REGISTRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 22, -1, -1));

        jLabel2.setText("Nº PRODUCTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 61, -1, -1));

        jLabel3.setText("CANTIDAD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 95, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 58, 230, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 92, 230, -1));

        jLabel4.setText("Nº CLIENTE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 129, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 126, 230, -1));

        jLabel6.setText("ESTADO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 169, -1, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 166, 230, -1));

        jButton1.setText("AÑADIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 206, 147, -1));

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 520, 125, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try{ conexion();
     }catch (NumberFormatException ex){ // handling  exception
            JOptionPane.showMessageDialog(null, "Acción no permitida. Revise los valores de los campos.");
        }{
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            datosdetabla(jTable1);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
                } catch (java.sql.SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             else{
                 try {
                    actualizaregistro();
                } catch (java.sql.SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        }
        }
    }//GEN-LAST:event_jTable1MouseClicked
    @SuppressWarnings("empty-statement")
      private void conexion(){   
          //definimos variables y establecemos conexión
          
           String Base_Datos ="jdbc:mysql://localhost";
           String User = "root";
           String Contrasenna  ="12345";
           com.mysql.cj.jdbc.ConnectionImpl conexion;
           Statement prepst;
           com.mysql.cj.jdbc.result.ResultSetImpl rs;
           
            int producto = parseInt(jTextField1.getText());
            
            int cliente = parseInt(jTextField3.getText());
           int cantidad = parseInt(jTextField2.getText());
           int cantidad_restante;
           double precio_final;
           int num_cantidad = 0;
           double num_precio = 0;
           String estado = jTextField5.getText();
      if((jTextField5.getText().length()==0 ))  {
            JOptionPane.showMessageDialog(null, "Rellene los campos");
        }
        else{     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        try {
            conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            String calculo_cantidad = ("SELECT unidades_disponibles FROM productos WHERE id_productos= "+producto);
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(calculo_cantidad);
            while(rs.next()){
            num_cantidad = rs.getInt("unidades_disponibles");
            }
             System.out.println(num_cantidad);
             if(cantidad>num_cantidad){
                JOptionPane.showMessageDialog(null, "No se puede realizar la operación");
                }else{
            cantidad_restante= num_cantidad - cantidad;
               System.out.println(cantidad_restante);
               String calculo_precio =("SELECT precio FROM productos WHERE id_productos= "+producto+"");
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(calculo_precio);
            while(rs.next()){
                num_precio = rs.getDouble("precio");
            }
            System.out.println(num_precio);
            precio_final = num_precio * cantidad; 
            //esto lo hacemos para que nos salga un JPane si el código de cliente que hemos introducido no existe
            int n_cliente =0;
            String client =("SELECT * FROM clientes WHERE id_cliente= "+cliente+";");
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(client);
            while(rs.next()){
                n_cliente = rs.getInt("id_cliente");
            }
            System.out.println(n_cliente);
            if(n_cliente==0){
                
                JOptionPane.showMessageDialog(null, "Este cliente no existe");
            }
            conexion.setAutoCommit(false);
           
            //String insercion1 = ("INSERT INTO pedidos (producto_FK, cliente_FK, fecha, cantidad, precio, estado) VALUES ("+producto+","+cliente+", "+fechasql+", "+cantidad+", "+precio_final+", '"+estado+"') " );
            prepst.addBatch("INSERT INTO pedidos (producto_FK, cliente_FK, fecha, cantidad, precio, estado) VALUES ("+producto+","+cliente+", (NOW()), "+cantidad+", "+precio_final+", '"+estado+"')");
            prepst.addBatch("UPDATE productos SET unidades_disponibles= "+cantidad_restante+" WHERE id_productos= "+producto+";");                                                                                                                                                                                                                                                                                                                                                                                                                                  
            prepst.executeBatch();
            conexion.commit();
            System.out.println(producto);
            System.out.println(cliente);
            System.out.println(cantidad);
            System.out.println(precio_final);
            System.out.println(estado);

             }
            
            
            //prepst.executeUpdate(insercion);
            prepst.close();
            conexion.close();
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }}}
     
        public  void datosdetabla(JTable jtable) throws java.sql.SQLException {
                  //establecemos conexión y realizamos una array para que se puedan mostrar nuestros datos en la JTable. Los insertamos mediante bucles
        String Base_Datos ="jdbc:mysql://localhost";
        String User = "root";
        String Contrasenna  ="12345";
       DefaultTableModel modelotabla = new DefaultTableModel(){
            //esto lo hacemos para que no se pueda editar lo dispuesto en la tabla haciendo doble click
          @Override
           public boolean isCellEditable(int row, int column){
    	    if (column == 7){
                   return true;
               }
                 return false;
    }};
        java.sql.ResultSet rs = null;
        String [] datostabla = new String [10];
         ConnectionImpl conexion = null;
         Statement prepst = null;
         String busqueda = ("SELECT * FROM pedidos");
        
        try {
            conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
             prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            jTable1.setDefaultRenderer(Object.class, new imagenes());
           
            modelotabla.addColumn("ID PEDIDO");
            modelotabla.addColumn("PRODUCTO");
            modelotabla.addColumn("NOMBRE CLIENTE");
            modelotabla.addColumn("APELLIDOS CLIENTE");
            modelotabla.addColumn("FECHA");
            modelotabla.addColumn("CANTIDAD");
            modelotabla.addColumn("PRECIO");
            modelotabla.addColumn("ESTADO");
            modelotabla.addColumn("EDITAR");
            modelotabla.addColumn("BORRAR");
           
            
        
            rs = prepst.executeQuery(busqueda);
       
           
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //para conseguir el nombre del producto
            String producto = null;
            String busquedap="SELECT * FROM productos JOIN pedidos ON productos.id_productos = pedidos.producto_FK";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busquedap);
            while(rs.next()){
            producto = rs.getString("nombre");
            }
          
      
                 //para conseguir el nombre del cliente
       
           
         
        //para conseguir los apellidos del cliente
            String apellidos = null;
            String busqueda3="SELECT * FROM clientes JOIN pedidos ON clientes.id_cliente = pedidos.cliente_FK";;
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda3);
            while(rs.next()){
            apellidos = rs.getString("apellidos");
            }
            
  //           java.sql.ResultSet trd = null;
        try {
            conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            rs = prepst.executeQuery(busqueda);
            
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       JButton editar = new JButton("Editar");
       JButton borrar = new JButton("Borrar");
       editar.setName("Editar");
        borrar.setName("Borrar");
              
    
         while(rs.next()){ 
           //nombre = rs.getString("producto_FK");
            for(int i=0; i<1; i++){ 
                Object f[] = new Object[10];
                f[0] = rs.getInt("id_pedidos");
                f[1] = extraerProducto(rs.getInt("id_pedidos"));
                        //rs.getString("producto_FK");
                f[2] =  extraerCliente(rs.getInt("id_pedidos"));
                        //rs.getInt("cliente_FK");
                f[3]= extraerApellidosCliente(rs.getInt("id_pedidos"));
                f[4] = LocalDate.parse(rs.getString("fecha"));
                f[5] = rs.getInt("cantidad");
                f[6] = Double.valueOf(rs.getString("precio"));
                f[7] = rs.getString("estado");
                f[8] = editar;
                f[9] = borrar;
                modelotabla.addRow(f);
                            

            }
        }
               
       
              
        
      // }
   /* while (rs.next()) {
                numero = rs.getInt("id_pedidos");
                producto = rs.getInt("producto_FK");
                cliente = rs.getInt("cliente_FK");
                fecha = parseLocalDate(rs.getString("fecha"));
                cantidad = rs.getInt("cantidad");
                precio = parseDouble(rs.getString("precio"));
                estado = rs.getString("estado");
            }*/
   
    //añadimos datamodel a nuestra jTable
    jTable1.setModel(modelotabla);
            prepst.close();
            conexion.close();
      //      trd.close();
        
     
  }                                 

    /**
     * @param args the command line arguments
     */
                                        
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pedidos dialog = new Pedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
    private void actualizaregistro() throws java.sql.SQLException{
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
              
                String estado = jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString();
               
                String sentencia = "UPDATE pedidos SET estado='"+estado+"' WHERE id_pedidos='"+id+"';";
                actualizar.executeUpdate(sentencia);
                JOptionPane.showMessageDialog(null, "Registro actualizado");
                actualizar.close();
                conexion.close();
    
    }                
    private void eliminaregistro() throws java.sql.SQLException {
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
                String busqueda = "DELETE FROM pedidos WHERE id_pedidos ="+jTable1.getValueAt(jTable1.getSelectedRow(), 0)+";";
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
  private Object extraerCliente(int id_pedidos) throws SQLException{ 
      
            String Base_Datos ="jdbc:mysql://localhost";
            String User = "root";
            String Contrasenna  ="12345";
            com.mysql.cj.jdbc.ConnectionImpl conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            Statement prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            com.mysql.cj.jdbc.result.ResultSetImpl rs;
            int resultado_cliente=0;
            String nombre_cliente=null;
            System.out.println(id_pedidos);
            String busqueda1= "SELECT cliente_FK FROM pedidos WHERE id_pedidos = '"+id_pedidos+"';";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda1);
            while(rs.next()){
                resultado_cliente = rs.getInt("cliente_FK");
            }
            String busqueda2="SELECT nombre FROM clientes JOIN pedidos ON clientes.id_cliente="+resultado_cliente+";";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda2);
            while(rs.next()){
                nombre_cliente = rs.getString("nombre");
            }
         System.out.println(nombre_cliente); 
         
        return nombre_cliente;
        
}
private Object extraerApellidosCliente(int id_pedidos) throws SQLException{ 
      
            String Base_Datos ="jdbc:mysql://localhost";
            String User = "root";
            String Contrasenna  ="12345";
            com.mysql.cj.jdbc.ConnectionImpl conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            Statement prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            com.mysql.cj.jdbc.result.ResultSetImpl rs;
            int resultado_cliente=0;
            String apellidos_cliente=null;
            System.out.println(id_pedidos);
            String busqueda1= "SELECT cliente_FK FROM pedidos WHERE id_pedidos = '"+id_pedidos+"';";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda1);
            while(rs.next()){
                resultado_cliente = rs.getInt("cliente_FK");
            }
            String busqueda2="SELECT apellidos FROM clientes JOIN pedidos ON clientes.id_cliente="+resultado_cliente+";";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda2);
            while(rs.next()){
                apellidos_cliente = rs.getString("apellidos");
            }
         System.out.println(apellidos_cliente); 
         
        return apellidos_cliente;
        
}

private Object extraerProducto(int id_pedidos) throws SQLException{ 
      
            String Base_Datos ="jdbc:mysql://localhost";
            String User = "root";
            String Contrasenna  ="12345";
            com.mysql.cj.jdbc.ConnectionImpl conexion = (com.mysql.cj.jdbc.ConnectionImpl) java.sql.DriverManager.getConnection(Base_Datos, User, Contrasenna );
            Statement prepst = (Statement) conexion.createStatement();
            prepst.executeUpdate("use tiendademusica;");
            com.mysql.cj.jdbc.result.ResultSetImpl rs;
            int resultado_producto=0;
            String producto=null;
            String busqueda1= "SELECT producto_FK FROM pedidos WHERE id_pedidos = '"+id_pedidos+"';";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda1);
            while(rs.next()){
                resultado_producto = rs.getInt("producto_FK");
            }
            String busqueda2="SELECT nombre FROM productos JOIN pedidos ON productos.id_productos="+resultado_producto+";";
            rs= (com.mysql.cj.jdbc.result.ResultSetImpl) prepst.executeQuery(busqueda2);
            while(rs.next()){
                producto = rs.getString("nombre");
            }
         System.out.println(producto); 
         
        return producto;
        
}
}

