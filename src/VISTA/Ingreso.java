// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

public class Ingreso extends javax.swing.JFrame {

 
    public Ingreso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_admin = new javax.swing.JLabel();
        lb_reporte = new javax.swing.JLabel();
        but_Rep_Proveedor = new javax.swing.JButton();
        but_Rep_Producto = new javax.swing.JButton();
        but_Rep_Factura = new javax.swing.JButton();
        but_Rep_Cliente = new javax.swing.JButton();
        but_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_admin.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_admin.setText("ADMINISTRADOR");

        lb_reporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_reporte.setForeground(new java.awt.Color(0, 0, 204));
        lb_reporte.setText("REPORTES");

        but_Rep_Proveedor.setText("REPORTES DE PROVEEDORES");
        but_Rep_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Rep_ProveedorActionPerformed(evt);
            }
        });

        but_Rep_Producto.setText("REPORTES DE PRODUCTOS");
        but_Rep_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Rep_ProductoActionPerformed(evt);
            }
        });

        but_Rep_Factura.setText("REPORTES DE FACTURAS");
        but_Rep_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Rep_FacturaActionPerformed(evt);
            }
        });

        but_Rep_Cliente.setText("REPORTES DE CLIENTES");
        but_Rep_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Rep_ClienteActionPerformed(evt);
            }
        });

        but_Salir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(but_Salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(lb_reporte))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_Rep_Producto)
                            .addComponent(but_Rep_Proveedor)
                            .addComponent(but_Rep_Factura)
                            .addComponent(but_Rep_Cliente)
                            .addComponent(lb_admin))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lb_admin)
                .addGap(43, 43, 43)
                .addComponent(lb_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(but_Rep_Proveedor)
                .addGap(18, 18, 18)
                .addComponent(but_Rep_Producto)
                .addGap(18, 18, 18)
                .addComponent(but_Rep_Factura)
                .addGap(18, 18, 18)
                .addComponent(but_Rep_Cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(but_Salir)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_Rep_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_Rep_ProveedorActionPerformed
        Proveedor prove = new Proveedor();
        prove.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_Rep_ProveedorActionPerformed

    private void but_Rep_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_Rep_ProductoActionPerformed
        Producto produc = new Producto();
        produc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_Rep_ProductoActionPerformed

    private void but_Rep_FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_Rep_FacturaActionPerformed
        Factura fact= new Factura();
        fact.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_Rep_FacturaActionPerformed

    private void but_Rep_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_Rep_ClienteActionPerformed
        Cliente clie= new Cliente();
        clie.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_Rep_ClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_Rep_Cliente;
    private javax.swing.JButton but_Rep_Factura;
    private javax.swing.JButton but_Rep_Producto;
    private javax.swing.JButton but_Rep_Proveedor;
    private javax.swing.JButton but_Salir;
    private javax.swing.JLabel lb_admin;
    private javax.swing.JLabel lb_reporte;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//