/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author A19B45923
 */
public class pantalla_facturas extends javax.swing.JFrame {

    DefaultTableModel factura;

    /**
     * Creates new form pantalla_facturas
     */
    public pantalla_facturas() {

        initComponents();

        this.factura = (DefaultTableModel) tabla_factura.getModel();
        Mostrardatos("");
    }

    public final void Mostrardatos(String valor) {
        //Funcion para llenar la jtable de Usuarios desde la BD
        cronopioproject.MyConnection cc = new cronopioproject.MyConnection();
        Connection cn = cronopioproject.MyConnection.getConnection();
        RefrescarTabla();
        factura.addColumn("idFactura");
        factura.addColumn("RNC");
        factura.addColumn("nombre_cliente");
        factura.addColumn("nombre_empleado");
        factura.addColumn("fecha_factura");
        factura.addColumn("total");

        this.tabla_factura.setModel(factura);
        String sql;
        if (valor.equals("")) {
            sql = "SELECT * FROM factura";
        } else {
            sql = "SELECT * FROM factura WHERE nombre_empleado='" + valor + "'";
        }

        String[] datos = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);

                factura.addRow(datos);
            }
            tabla_factura.setModel(factura);
        } catch (SQLException ex) {
            Logger.getLogger(ControlProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }

    public void Limpiar() {
        //Funcion para limpiar los text field existentes
        try {
            txt_idfactura.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }

    public void RefrescarTabla() {
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
            factura.setColumnCount(0);
            factura.setRowCount(0);
            tabla_factura.revalidate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();
        txt_idfactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bt_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_facturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_factura);

        txt_idfactura.setText(" ");
        txt_idfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idfacturaActionPerformed(evt);
            }
        });

        jLabel2.setText("Factura No.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Lista de facturas");

        bt_imprimir.setText("Impriimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        Connection cn = cronopioproject.MyConnection.getConnection();
        try {
            int txtFac;
            txtFac = Integer.parseInt(txt_idfactura.getText());
            JasperReport jr = (JasperReport) JRLoader.loadObject(pantalla_facturas.class.getResource("/reportes/report_Factura.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("id", txtFac);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            Mostrardatos("");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void tabla_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_facturaMouseClicked
        try {

            String idfac = (String) factura.getValueAt(tabla_factura.getSelectedRow(), 0);

            txt_idfactura.setText(idfac);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }//GEN-LAST:event_tabla_facturaMouseClicked

    private void txt_idfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idfacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idfacturaActionPerformed

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
            java.util.logging.Logger.getLogger(pantalla_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantalla_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantalla_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantalla_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pantalla_facturas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_factura;
    private javax.swing.JTextField txt_idfactura;
    // End of variables declaration//GEN-END:variables
}
