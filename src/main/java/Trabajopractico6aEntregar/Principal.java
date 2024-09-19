/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Trabajopractico6aEntregar;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Personal
 */
public class Principal extends javax.swing.JFrame {

    private DefaultTableModel tabla;
    private static ArrayList<Producto> listaDeProducto;

    public Principal() {
        initComponents();
        this.setTitle("Productos");
        this.setSize(800, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jDesktopPane1.setBorder(new ImagenFondo());
        this.tabla = new DefaultTableModel();
        tabla.addColumn("Producto");
        tabla.addColumn("Categoria");
        tabla.addColumn("Precio");
       
        // No permitir la edición de las celdas
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setModel(tabla);
        this.listaDeProducto= new ArrayList<>();
    }

    private void agregarProducto() {

       
        try {
            String nombre = jTextNombre.getText();
            String categoria = (String) jComboBox1.getSelectedItem();
            Double precio = Double.valueOf(jTexPrecio.getText());

            Producto nuevoProducto = new Producto(nombre, categoria, precio);

            if (!productoYaExiste(nuevoProducto)) {
                listaDeProducto.add(nuevoProducto);
                actualizarTabla();  
            } else {
                JOptionPane.showMessageDialog(this, nombre + " ya existe.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos, verifique ", "Error en los datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean productoYaExiste(Producto producto) {
        // Usar equals() y hashCode() para verificar si ya existe el producto
        //Por que no Quiero usar un HasSet y quiero probar este metodo directamente ;
        for (Producto p : listaDeProducto) {
            if (p.equals(producto)) {
                return true;
            }
        }
        return false;
    }

    private void actualizarTabla() {
        Object[] datos = new Object[jTable1.getColumnCount()];

        tabla.setRowCount(0);// esto hace que se limpie el modelo antes de agregar nuevas filas
        for (Producto producto : listaDeProducto) {
            datos[0] = producto.getNombre();
            datos[1] = producto.getCategoria();
            datos[2] = producto.getPrecio();

            tabla.addRow(datos);//agregar una nueva fila con los datos que ingresen
        }
        jTable1.setModel(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLProducto = new javax.swing.JLabel();
        jLGestionDeProductos1 = new javax.swing.JLabel();
        jLprecio = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextNombre = new javax.swing.JTextField();
        jTexPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setBackground(new java.awt.Color(255, 0, 0));
        setForeground(new java.awt.Color(209, 173, 101));

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(213, 160, 78), new java.awt.Color(195, 133, 91), new java.awt.Color(185, 131, 72), new java.awt.Color(176, 142, 65)));

        jLProducto.setBackground(new java.awt.Color(255, 255, 255));
        jLProducto.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLProducto.setForeground(new java.awt.Color(255, 255, 255));
        jLProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/infographics_13345773.png"))); // NOI18N
        jLProducto.setText("Productos");

        jLGestionDeProductos1.setBackground(new java.awt.Color(255, 255, 255));
        jLGestionDeProductos1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLGestionDeProductos1.setForeground(new java.awt.Color(255, 255, 255));
        jLGestionDeProductos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accepted_10764348.png"))); // NOI18N
        jLGestionDeProductos1.setText("  Gestion de productos");

        jLprecio.setBackground(new java.awt.Color(255, 255, 255));
        jLprecio.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLprecio.setForeground(new java.awt.Color(255, 255, 255));
        jLprecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tag_17475426.png"))); // NOI18N
        jLprecio.setText("Precio");

        jLNombre.setBackground(new java.awt.Color(255, 255, 255));
        jLNombre.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/courier_7606482.png"))); // NOI18N
        jLNombre.setText("Nombre");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lácteos", "Carnes", "Pescados y mariscos", "Frutas y verduras", "Panadería", "Cereales y granos", "Bebidas", "Productos congelados", "Snacks y golosinas", "Pastas y fideos", "Conservas", "Salsas y condimentos", "Productos de limpieza", "Higiene personal", "Cosméticos", "Productos para bebés", "Papelería", "Alimentos para mascotas", "Aceites y grasas", "Ferretería y herramientas" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setActionCommand("alimentos,\nlacteos");

        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(220, 220, 131));
        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trolley_10552783.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLGestionDeProductos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLprecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTexPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLGestionDeProductos1)
                .addGap(110, 110, 110))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTexPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addComponent(jTextNombre, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLGestionDeProductos1)
                .addGap(55, 55, 55)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProducto)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNombre)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLprecio)
                    .addComponent(jTexPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarProducto();
        
        jTextNombre.setText("");
        jTexPrecio.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLGestionDeProductos1;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLProducto;
    private javax.swing.JLabel jLprecio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTexPrecio;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}
