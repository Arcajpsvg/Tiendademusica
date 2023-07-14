/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ar_rr
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    //aquí realizamos la conexión a la base de datos
    
 String Base_Datos ="jdbc:mysql://localhost";
 String User = "root";
 String Contrasenna  ="12345";
 
 
   Statement schm = null;
  com.mysql.cj.jdbc.ConnectionImpl conexion;
  
      {
     try {
         //establecemos conexión, generamos base de datos y tablas correspondientes
         conexion = (com.mysql.cj.jdbc.ConnectionImpl) DriverManager.getConnection(Base_Datos, User, Contrasenna );
         schm = (Statement) conexion.createStatement();
         schm.executeUpdate("use tiendademusica;");
        // String tabla_clientes = ("CREATE TABLE clientes (id_cliente int AUTO_INCREMENT, nombre varchar(20), apellidos varchar(40), telefono varchar(12), PRIMARY KEY (id_cliente));");
         //String tabla_productos = ("CREATE TABLE productos (id_productos int AUTO_INCREMENT, nombre varchar(20), precio decimal, unidades_disponibles int(4), PRIMARY KEY (id_productos));");
       //String tabla_pedidos = ("CREATE TABLE pedidos (id_pedidos int AUTO_INCREMENT, producto_FK INT, cliente_FK INT, fecha date, cantidad int, precio decimal, estado varchar(20),  PRIMARY KEY (id_pedidos), FOREIGN KEY (producto_FK) REFERENCES Productos (id_productos) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (cliente_FK) REFERENCES Clientes (id_cliente) ON DELETE CASCADE ON UPDATE CASCADE);");
        // schm.execute(tabla_clientes);
        // schm.execute(tabla_productos);
      // schm.execute(tabla_pedidos);
       //String borrar_tabla =("DROP TABLE pedidos");
       //schm.executeUpdate(borrar_tabla);
         System.out.println("Creada tabla");
     } catch (SQLException ex) {
         Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     
    DatabaseMetaData dbm;         
  {
     try {
         DatabaseMetaData dbm = (DatabaseMetaData) conexion.getMetaData();
        java.sql.ResultSet tables = dbm.getTables(null, null, "clientes", null); 
  if (tables.next()) { 
      //para comprobar que las tablas se han generado correctamente
      System.out.println("Existe");
 } 
else { 
    System.out.println("No Existe");
}
     } catch (SQLException ex) {
         Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     }
}
  


 /*  {
         
       
     try {
         conexion = (com.mysql.cj.jdbc.ConnectionImpl) DriverManager.getConnection(Base_Datos, User, Contrasenna );
     } catch (SQLException ex) {
         Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     }
             
           /*  esto fue empleado para crear en un inicio la base de datos
     try {
         schm = (Statement) conexion.createStatement();
     } catch (SQLException ex) {
         Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     }
             try {
                  schm.executeUpdate("CREATE DATABASE tiendademusica");
                  System.out.println("Creada la base de datos...");
                schm.close();
                conexion.close();
             } catch (SQLException ex) {
                 Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         
         
           }
        
          
        
         

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        
        //creamos condiciones en la parte gráfica
        initComponents();
        this.setTitle("Tienda de música");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
    }
    
       



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(4000, 3000));
        setResizable(false);

        jButton1.setText("CLIENTES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PRODUCTOS");
        jButton2.setMaximumSize(new java.awt.Dimension(79, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(79, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(79, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("PEDIDOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Instrucciones para acceder al apartado Clientes
        Clientes clientes = new Clientes(this, true);
        clientes.setVisible(true);
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //Instrucciones para acceder al apartado Pedidos
        Pedidos pedidos = new Pedidos(this, true);
        pedidos.setVisible(true);
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Instrucciones para acceder al apartado Productos
        Productos productos = new Productos(this, true);
        productos.setVisible(true);
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
       
    
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables

    
}