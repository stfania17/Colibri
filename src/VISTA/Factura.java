// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Factura extends javax.swing.JFrame {

 
    public Factura() {
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

        Dlg_Factura = new javax.swing.JDialog();
        lb_factura = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_numfac = new javax.swing.JLabel();
        lb_facnumero = new javax.swing.JLabel();
        lb_nacimiento = new javax.swing.JLabel();
        lb_dia = new javax.swing.JLabel();
        lb_cedula = new javax.swing.JLabel();
        lb_nombres = new javax.swing.JLabel();
        lb_apellidos = new javax.swing.JLabel();
        lb_telefono = new javax.swing.JLabel();
        lb_fechanac = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        lb_total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_fac = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        but_actualizar = new javax.swing.JButton();
        but_cancelar = new javax.swing.JButton();
        txt_consulta = new javax.swing.JTextField();
        but_consultar = new javax.swing.JButton();
        but_limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_rep_proveedor = new javax.swing.JTable();
        but_atras = new javax.swing.JButton();
        lb_tit_factura = new javax.swing.JLabel();

        lb_factura.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_factura.setForeground(new java.awt.Color(0, 153, 51));
        lb_factura.setText("FACTURA");

        lb_logo.setText("jLabel2");

        lb_numfac.setText("Factura N°:");

        lb_nacimiento.setText("Fecha:");

        lb_cedula.setText("Cedula:");

        lb_nombres.setText("Nombres:");

        lb_apellidos.setText("Apellidos:");

        lb_telefono.setText("Teléfono:");

        lb_fechanac.setText("Fecha_Nac:");

        lb_direccion.setText("Direccion:");

        txt_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaActionPerformed(evt);
            }
        });

        txt_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombresActionPerformed(evt);
            }
        });

        lb_total.setText("Total a Pagar:");

        table_fac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_fac);

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        but_actualizar.setText("Actualizar");

        but_cancelar.setText("Cancelar");

        javax.swing.GroupLayout Dlg_FacturaLayout = new javax.swing.GroupLayout(Dlg_Factura.getContentPane());
        Dlg_Factura.getContentPane().setLayout(Dlg_FacturaLayout);
        Dlg_FacturaLayout.setHorizontalGroup(
            Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                    .addComponent(lb_logo)
                                    .addGap(271, 271, 271)
                                    .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_numfac)
                                        .addComponent(lb_nacimiento)))
                                .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                    .addComponent(lb_factura)
                                    .addGap(148, 148, 148))
                                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                        .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                                .addComponent(lb_nombres)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_nombres))
                                            .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                                .addComponent(lb_cedula)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(125, 125, 125)
                                        .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_fechanac)
                                            .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                                .addComponent(lb_telefono)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                        .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dlg_FacturaLayout.createSequentialGroup()
                                                .addComponent(lb_apellidos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                                                .addComponent(lb_direccion)
                                                .addGap(9, 9, 9)))
                                        .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_direccion)
                                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(18, 18, 18)
                            .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lb_dia, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(lb_facnumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dlg_FacturaLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_total)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32))
                        .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(but_actualizar)
                        .addGap(144, 144, 144)
                        .addComponent(but_cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Dlg_FacturaLayout.setVerticalGroup(
            Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dlg_FacturaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lb_factura)
                .addGap(47, 47, 47)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_logo)
                        .addComponent(lb_numfac))
                    .addComponent(lb_facnumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nacimiento)
                    .addComponent(lb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cedula)
                    .addComponent(lb_telefono)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nombres)
                    .addComponent(lb_fechanac)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_apellidos)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_direccion)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_total)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(Dlg_FacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_actualizar)
                    .addComponent(but_cancelar))
                .addGap(48, 48, 48))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 440));
        setPreferredSize(new java.awt.Dimension(670, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 63, 163, -1));

        but_consultar.setText("Consultar:");
        getContentPane().add(but_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 62, -1, -1));

        but_limpiar.setText("Limpiar");
        getContentPane().add(but_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        tbl_rep_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "COD_CLIENTE", "FECHA", "COD_DETALLE", "COD_ENCABEZADO", "COD_PRODUCTO", "CANTIDAD", "PRECIO_FINAL"
            }
        ));
        jScrollPane1.setViewportView(tbl_rep_proveedor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 144, 750, 230));

        but_atras.setText("Atras");
        getContentPane().add(but_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 402, -1, -1));

        lb_tit_factura.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_tit_factura.setText("FACTURA");
        getContentPane().add(lb_tit_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 21, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

    private void txt_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombresActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    public JDialog getDlg_Factura() {
        return Dlg_Factura;
    }
    public void setDlg_Factura(JDialog Dlg_Factura) {
        this.Dlg_Factura = Dlg_Factura;
    }
    public JButton getBut_actualizar() {
        return but_actualizar;
    }
    public void setBut_actualizar(JButton but_actualizar) {
        this.but_actualizar = but_actualizar;
    }
    public JButton getBut_atras() {
        return but_atras;
    }
    public void setBut_atras(JButton but_atras) {
        this.but_atras = but_atras;
    }
    public JButton getBut_cancelar() {
        return but_cancelar;
    }
    public void setBut_cancelar(JButton but_cancelar) {
        this.but_cancelar = but_cancelar;
    }
    public JButton getBut_consultar() {
        return but_consultar;
    }
    public void setBut_consultar(JButton but_consultar) {
        this.but_consultar = but_consultar;
    }
 
    public JButton getBut_limpiar() {
        return but_limpiar;
    }
    public void setBut_limpiar(JButton but_limpiar) {
        this.but_limpiar = but_limpiar;
    }
 
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }
    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }
    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }
    public JLabel getLb_apellidos() {
        return lb_apellidos;
    }
    public void setLb_apellidos(JLabel lb_apellidos) {
        this.lb_apellidos = lb_apellidos;
    }
    public JLabel getLb_cedula() {
        return lb_cedula;
    }
    public void setLb_cedula(JLabel lb_cedula) {
        this.lb_cedula = lb_cedula;
    }
    public JLabel getLb_dia() {
        return lb_dia;
    }
    public void setLb_dia(JLabel lb_dia) {
        this.lb_dia = lb_dia;
    }
    public JLabel getLb_direccion() {
        return lb_direccion;
    }
    public void setLb_direccion(JLabel lb_direccion) {
        this.lb_direccion = lb_direccion;
    }
    public JLabel getLb_facnumero() {
        return lb_facnumero;
    }
    public void setLb_facnumero(JLabel lb_facnumero) {
        this.lb_facnumero = lb_facnumero;
    }
    public JLabel getLb_factura() {
        return lb_factura;
    }
    public void setLb_factura(JLabel lb_factura) {
        this.lb_factura = lb_factura;
    }
    public JLabel getLb_fechanac() {
        return lb_fechanac;
    }
    public void setLb_fechanac(JLabel lb_fechanac) {
        this.lb_fechanac = lb_fechanac;
    }
    public JLabel getLb_logo() {
        return lb_logo;
    }
    public void setLb_logo(JLabel lb_logo) {
        this.lb_logo = lb_logo;
    }
    public JLabel getLb_nacimiento() {
        return lb_nacimiento;
    }
    public void setLb_nacimiento(JLabel lb_nacimiento) {
        this.lb_nacimiento = lb_nacimiento;
    }
    public JLabel getLb_nombres() {
        return lb_nombres;
    }
    public void setLb_nombres(JLabel lb_nombres) {
        this.lb_nombres = lb_nombres;
    }
    public JLabel getLb_numfac() {
        return lb_numfac;
    }
    public void setLb_numfac(JLabel lb_numfac) {
        this.lb_numfac = lb_numfac;
    }
    public JLabel getLb_telefono() {
        return lb_telefono;
    }
    public void setLb_telefono(JLabel lb_telefono) {
        this.lb_telefono = lb_telefono;
    }
    public JLabel getLb_tit_factura() {
        return lb_tit_factura;
    }
    public void setLb_tit_factura(JLabel lb_tit_factura) {
        this.lb_tit_factura = lb_tit_factura;
    }
    public JLabel getLb_total() {
        return lb_total;
    }
    public void setLb_total(JLabel lb_total) {
        this.lb_total = lb_total;
    }
    public JTable getTable_fac() {
        return table_fac;
    }
    public void setTable_fac(JTable table_fac) {
        this.table_fac = table_fac;
    }
    public JTable getTbl_rep_proveedor() {
        return tbl_rep_proveedor;
    }
    public void setTbl_rep_proveedor(JTable tbl_rep_proveedor) {
        this.tbl_rep_proveedor = tbl_rep_proveedor;
    }
    public JTextField getTxt_apellidos() {
        return txt_apellidos;
    }
    public void setTxt_apellidos(JTextField txt_apellidos) {
        this.txt_apellidos = txt_apellidos;
    }
    public JTextField getTxt_cedula() {
        return txt_cedula;
    }
    public void setTxt_cedula(JTextField txt_cedula) {
        this.txt_cedula = txt_cedula;
    }
    public JTextField getTxt_consulta() {
        return txt_consulta;
    }
    public void setTxt_consulta(JTextField txt_consulta) {
        this.txt_consulta = txt_consulta;
    }
    public JTextField getTxt_direccion() {
        return txt_direccion;
    }
    public void setTxt_direccion(JTextField txt_direccion) {
        this.txt_direccion = txt_direccion;
    }
    public JTextField getTxt_nombres() {
        return txt_nombres;
    }
    public void setTxt_nombres(JTextField txt_nombres) {
        this.txt_nombres = txt_nombres;
    }
    public JTextField getTxt_telefono() {
        return txt_telefono;
    }
    public void setTxt_telefono(JTextField txt_telefono) {
        this.txt_telefono = txt_telefono;
    }
    public JTextField getTxt_total() {
        return txt_total;
    }
    public void setTxt_total(JTextField txt_total) {
        this.txt_total = txt_total;
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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Dlg_Factura;
    private javax.swing.JButton but_actualizar;
    private javax.swing.JButton but_atras;
    private javax.swing.JButton but_cancelar;
    private javax.swing.JButton but_consultar;
    private javax.swing.JButton but_limpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_apellidos;
    private javax.swing.JLabel lb_cedula;
    private javax.swing.JLabel lb_dia;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_facnumero;
    private javax.swing.JLabel lb_factura;
    private javax.swing.JLabel lb_fechanac;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_nacimiento;
    private javax.swing.JLabel lb_nombres;
    private javax.swing.JLabel lb_numfac;
    private javax.swing.JLabel lb_telefono;
    private javax.swing.JLabel lb_tit_factura;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable table_fac;
    private javax.swing.JTable tbl_rep_proveedor;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_consulta;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//