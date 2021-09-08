// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 
public class Proveedor extends javax.swing.JFrame {


    public Proveedor() {
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

        Dlg_Proveedor = new javax.swing.JDialog();
        lb_tituloprov = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        lb_nombres = new javax.swing.JLabel();
        lb_apellidos = new javax.swing.JLabel();
        lb_telefono = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        lb_codigo = new javax.swing.JLabel();
        lb_cuenta = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_codifo = new javax.swing.JTextField();
        txt_numcuenta = new javax.swing.JTextField();
        dtcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        but_aceptar = new javax.swing.JButton();
        but_cancelar = new javax.swing.JButton();
        but_eliminar = new javax.swing.JButton();
        but_modificar = new javax.swing.JButton();
        but_crear = new javax.swing.JButton();
        but_consultar = new javax.swing.JButton();
        but_limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_rep_proveedor = new javax.swing.JTable();
        but_atras = new javax.swing.JButton();
        lb_tit_proveedor = new javax.swing.JLabel();
        txt_consulta = new javax.swing.JTextField();

        lb_tituloprov.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_tituloprov.setForeground(new java.awt.Color(102, 0, 0));
        lb_tituloprov.setText("REGISTRO DE PROVEEDOR");

        lb_id.setText("Id:");

        lb_nombres.setText("Nombres:");

        lb_apellidos.setText("Apellidos:");

        lb_telefono.setText("Teléfono:");

        lb_direccion.setText("Dirección:");

        lb_fecha.setText("Fecha de nacimiento:");

        lb_codigo.setText("Cod_Proveedor:");

        lb_cuenta.setText("N° cuenta:");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        but_aceptar.setText("Aceptar");

        but_cancelar.setText("Cancelar");

        javax.swing.GroupLayout Dlg_ProveedorLayout = new javax.swing.GroupLayout(Dlg_Proveedor.getContentPane());
        Dlg_Proveedor.getContentPane().setLayout(Dlg_ProveedorLayout);
        Dlg_ProveedorLayout.setHorizontalGroup(
            Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                        .addComponent(lb_telefono)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                        .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                                .addComponent(lb_apellidos)
                                .addGap(66, 66, 66)
                                .addComponent(txt_apellido))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Dlg_ProveedorLayout.createSequentialGroup()
                                .addComponent(lb_codigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_codifo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Dlg_ProveedorLayout.createSequentialGroup()
                                .addComponent(lb_direccion)
                                .addGap(65, 65, 65)
                                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_telefono)
                                    .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                                        .addComponent(txt_direccion)
                                        .addGap(1, 1, 1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Dlg_ProveedorLayout.createSequentialGroup()
                                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Dlg_ProveedorLayout.createSequentialGroup()
                                        .addComponent(lb_fecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dtcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Dlg_ProveedorLayout.createSequentialGroup()
                                        .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_nombres)
                                            .addComponent(lb_id))
                                        .addGap(66, 66, 66)
                                        .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                                .addComponent(lb_cuenta)
                                .addGap(57, 57, 57)
                                .addComponent(txt_numcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(248, 248, 248))))
            .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(lb_tituloprov))
                    .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(but_aceptar)
                        .addGap(164, 164, 164)
                        .addComponent(but_cancelar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Dlg_ProveedorLayout.setVerticalGroup(
            Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dlg_ProveedorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lb_tituloprov)
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nombres)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_apellidos)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_telefono)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_direccion)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_fecha)
                    .addComponent(dtcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_codigo)
                    .addComponent(txt_codifo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cuenta)
                    .addComponent(txt_numcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(Dlg_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_aceptar)
                    .addComponent(but_cancelar))
                .addGap(29, 29, 29))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(667, 438));
        setPreferredSize(new java.awt.Dimension(667, 438));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        but_eliminar.setText("Eliminar");
        getContentPane().add(but_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 62, -1, -1));

        but_modificar.setText("Modificar");
        getContentPane().add(but_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 62, -1, -1));

        but_crear.setText("Crear");
        getContentPane().add(but_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 62, -1, -1));

        but_consultar.setText("Consultar:");
        getContentPane().add(but_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 62, -1, -1));

        but_limpiar.setText("Limpiar");
        getContentPane().add(but_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 103, -1, -1));

        tbl_rep_proveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_rep_proveedor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 144, 587, 230));

        but_atras.setText("Atras");
        getContentPane().add(but_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 393, -1, -1));

        lb_tit_proveedor.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_tit_proveedor.setText("PROVEEDORES");
        getContentPane().add(lb_tit_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 21, -1, -1));
        getContentPane().add(txt_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 63, 163, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    public JDialog getDlg_Proveedor() {
        return Dlg_Proveedor;
    }

    public void setDlg_Proveedor(JDialog Dlg_Proveedor) {
        this.Dlg_Proveedor = Dlg_Proveedor;
    }

    public JButton getBut_aceptar() {
        return but_aceptar;
    }

    public void setBut_aceptar(JButton but_aceptar) {
        this.but_aceptar = but_aceptar;
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

    public JButton getBut_crear() {
        return but_crear;
    }

    public void setBut_crear(JButton but_crear) {
        this.but_crear = but_crear;
    }

    public JButton getBut_eliminar() {
        return but_eliminar;
    }

    public void setBut_eliminar(JButton but_eliminar) {
        this.but_eliminar = but_eliminar;
    }

    public JButton getBut_limpiar() {
        return but_limpiar;
    }

    public void setBut_limpiar(JButton but_limpiar) {
        this.but_limpiar = but_limpiar;
    }

    public JButton getBut_modificar() {
        return but_modificar;
    }

    public void setBut_modificar(JButton but_modificar) {
        this.but_modificar = but_modificar;
    }

    public JDateChooser getDtcFechaNacimiento() {
        return dtcFechaNacimiento;
    }

    public void setDtcFechaNacimiento(JDateChooser dtcFechaNacimiento) {
        this.dtcFechaNacimiento = dtcFechaNacimiento;
    }

    

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLb_apellidos() {
        return lb_apellidos;
    }

    public void setLb_apellidos(JLabel lb_apellidos) {
        this.lb_apellidos = lb_apellidos;
    }

    public JLabel getLb_codigo() {
        return lb_codigo;
    }

    public void setLb_codigo(JLabel lb_codigo) {
        this.lb_codigo = lb_codigo;
    }

    public JLabel getLb_cuenta() {
        return lb_cuenta;
    }

    public void setLb_cuenta(JLabel lb_cuenta) {
        this.lb_cuenta = lb_cuenta;
    }

    public JLabel getLb_direccion() {
        return lb_direccion;
    }

    public void setLb_direccion(JLabel lb_direccion) {
        this.lb_direccion = lb_direccion;
    }

    public JLabel getLb_fecha() {
        return lb_fecha;
    }

    public void setLb_fecha(JLabel lb_fecha) {
        this.lb_fecha = lb_fecha;
    }

    public JLabel getLb_id() {
        return lb_id;
    }

    public void setLb_id(JLabel lb_id) {
        this.lb_id = lb_id;
    }

    public JLabel getLb_nombres() {
        return lb_nombres;
    }

    public void setLb_nombres(JLabel lb_nombres) {
        this.lb_nombres = lb_nombres;
    }

    public JLabel getLb_telefono() {
        return lb_telefono;
    }

    public void setLb_telefono(JLabel lb_telefono) {
        this.lb_telefono = lb_telefono;
    }

    public JLabel getLb_tit_proveedor() {
        return lb_tit_proveedor;
    }

    public void setLb_tit_proveedor(JLabel lb_tit_proveedor) {
        this.lb_tit_proveedor = lb_tit_proveedor;
    }

    public JLabel getLb_tituloprov() {
        return lb_tituloprov;
    }

    public void setLb_tituloprov(JLabel lb_tituloprov) {
        this.lb_tituloprov = lb_tituloprov;
    }

    public JTable getTbl_rep_proveedor() {
        return tbl_rep_proveedor;
    }

    public void setTbl_rep_proveedor(JTable tbl_rep_proveedor) {
        this.tbl_rep_proveedor = tbl_rep_proveedor;
    }

    public JTextField getTxt_apellido() {
        return txt_apellido;
    }

    public void setTxt_apellido(JTextField txt_apellido) {
        this.txt_apellido = txt_apellido;
    }

    public JTextField getTxt_codifo() {
        return txt_codifo;
    }

    public void setTxt_codifo(JTextField txt_codifo) {
        this.txt_codifo = txt_codifo;
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

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public JTextField getTxt_numcuenta() {
        return txt_numcuenta;
    }

    public void setTxt_numcuenta(JTextField txt_numcuenta) {
        this.txt_numcuenta = txt_numcuenta;
    }

    public JTextField getTxt_telefono() {
        return txt_telefono;
    }

    public void setTxt_telefono(JTextField txt_telefono) {
        this.txt_telefono = txt_telefono;
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
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Dlg_Proveedor;
    private javax.swing.JButton but_aceptar;
    private javax.swing.JButton but_atras;
    private javax.swing.JButton but_cancelar;
    private javax.swing.JButton but_consultar;
    private javax.swing.JButton but_crear;
    private javax.swing.JButton but_eliminar;
    private javax.swing.JButton but_limpiar;
    private javax.swing.JButton but_modificar;
    private com.toedter.calendar.JDateChooser dtcFechaNacimiento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_apellidos;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_cuenta;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nombres;
    private javax.swing.JLabel lb_telefono;
    private javax.swing.JLabel lb_tit_proveedor;
    private javax.swing.JLabel lb_tituloprov;
    private javax.swing.JTable tbl_rep_proveedor;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_codifo;
    private javax.swing.JTextField txt_consulta;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numcuenta;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//