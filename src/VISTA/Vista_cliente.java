// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import LIB.FSTexFieldMD;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

 
public class Vista_cliente extends javax.swing.JFrame {

 
    public Vista_cliente() {
        initComponents();
        Vista_cliente.this.setBackground(new Color(0,0,0,0));
        txt_id.addKeyListener(new VALIDACIONES.Numeros());
        txt_telefono.addKeyListener(new VALIDACIONES.Numeros());
        //new ImageIcon(getClass().getResource("src\\ICONOS\\iconocolibrie.jpg"));
setIconImage(new ImageIcon(getClass().getResource("/ICONOS/iconocolibrie.jpg")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dlg_Cliente = new javax.swing.JDialog();
        lb_id = new javax.swing.JLabel();
        lb_nombres = new javax.swing.JLabel();
        lb_apellido = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        lb_telefono = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        lb_correo = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        dtcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jPanelRound2 = new LIB.JPanelRound();
        jEImagePanel3 = new LIB.JEImagePanel();
        but_actualizar = new javax.swing.JButton();
        but_crear = new javax.swing.JButton();
        but_cancelar = new javax.swing.JButton();
        generarcodigocliente = new javax.swing.JButton();
        codigocliente = new javax.swing.JLabel();
        jPanelRound1 = new LIB.JPanelRound();
        jEImagePanel1 = new LIB.JEImagePanel();
        jEImagePanel2 = new LIB.JEImagePanel();
        but_atras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        but_modificar = new javax.swing.JButton();
        but_limpiar = new javax.swing.JButton();
        txt_consulta = new LIB.FSTexFieldMD();
        agregarcliente = new javax.swing.JButton();
        but_refrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        Dlg_Cliente.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_id.setText("Id:");
        Dlg_Cliente.getContentPane().add(lb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        lb_nombres.setText("Nombres:");
        Dlg_Cliente.getContentPane().add(lb_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        lb_apellido.setText("Apellidos:");
        Dlg_Cliente.getContentPane().add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        lb_direccion.setText("Dirección:");
        Dlg_Cliente.getContentPane().add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        lb_telefono.setText("Teléfono:");
        Dlg_Cliente.getContentPane().add(lb_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        lb_fecha.setText("F. Nacimiento:");
        Dlg_Cliente.getContentPane().add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));

        lb_correo.setText("Correo:");
        Dlg_Cliente.getContentPane().add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idKeyTyped(evt);
            }
        });
        Dlg_Cliente.getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, -1));

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });
        Dlg_Cliente.getContentPane().add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 193, -1));

        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyTyped(evt);
            }
        });
        Dlg_Cliente.getContentPane().add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 193, -1));

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        Dlg_Cliente.getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 193, -1));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        Dlg_Cliente.getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 193, -1));

        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoKeyTyped(evt);
            }
        });
        Dlg_Cliente.getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 193, -1));
        Dlg_Cliente.getContentPane().add(dtcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 193, -1));

        jPanelRound2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound2.setOpaque(true);
        jPanelRound2.setLayout(null);

        jEImagePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Datos cliente.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel3Layout = new javax.swing.GroupLayout(jEImagePanel3);
        jEImagePanel3.setLayout(jEImagePanel3Layout);
        jEImagePanel3Layout.setHorizontalGroup(
            jEImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jEImagePanel3Layout.setVerticalGroup(
            jEImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jPanelRound2.add(jEImagePanel3);
        jEImagePanel3.setBounds(0, 0, 450, 620);

        but_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/ACTUALIZAR 2 ICO.png"))); // NOI18N
        but_actualizar.setBorder(null);
        but_actualizar.setBorderPainted(false);
        but_actualizar.setContentAreaFilled(false);
        but_actualizar.setFocusPainted(false);
        jPanelRound2.add(but_actualizar);
        but_actualizar.setBounds(680, 420, 165, 50);

        but_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/CREAR ICO 2.png"))); // NOI18N
        but_crear.setBorder(null);
        but_crear.setBorderPainted(false);
        but_crear.setContentAreaFilled(false);
        but_crear.setFocusPainted(false);
        but_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_crearActionPerformed(evt);
            }
        });
        jPanelRound2.add(but_crear);
        but_crear.setBounds(480, 420, 170, 50);

        but_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/REGRESAR ICO.png"))); // NOI18N
        but_cancelar.setBorder(null);
        but_cancelar.setBorderPainted(false);
        but_cancelar.setContentAreaFilled(false);
        but_cancelar.setFocusPainted(false);
        jPanelRound2.add(but_cancelar);
        but_cancelar.setBounds(570, 490, 180, 60);

        generarcodigocliente.setText("GENERAR");
        jPanelRound2.add(generarcodigocliente);
        generarcodigocliente.setBounds(510, 370, 79, 23);

        codigocliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRound2.add(codigocliente);
        codigocliente.setBounds(630, 370, 180, 23);

        Dlg_Cliente.getContentPane().add(jPanelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 620));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1375, 580));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(null);

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/CLIENTES.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jPanelRound1.add(jEImagePanel1);
        jEImagePanel1.setBounds(0, 0, 450, 580);

        jEImagePanel2.setToolTipText("");
        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/recepcion.png"))); // NOI18N
        jEImagePanel2.setLayout(null);

        but_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/REGRESAR ICO.png"))); // NOI18N
        but_atras.setBorder(null);
        but_atras.setBorderPainted(false);
        but_atras.setContentAreaFilled(false);
        but_atras.setFocusPainted(false);
        jEImagePanel2.add(but_atras);
        but_atras.setBounds(715, 497, 180, 60);

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "EDAD", "CODIGO CLIENTE", "CORREO"
            }
        ));
        jScrollPane1.setViewportView(tabla_clientes);

        jEImagePanel2.add(jScrollPane1);
        jScrollPane1.setBounds(16, 253, 895, 189);

        but_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/MODIFICAR ICO.png"))); // NOI18N
        but_modificar.setBorderPainted(false);
        but_modificar.setContentAreaFilled(false);
        but_modificar.setFocusPainted(false);
        jEImagePanel2.add(but_modificar);
        but_modificar.setBounds(402, 139, 163, 50);

        but_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/LIMPIAR ICO.png"))); // NOI18N
        but_limpiar.setBorder(null);
        but_limpiar.setBorderPainted(false);
        but_limpiar.setContentAreaFilled(false);
        but_limpiar.setFocusPainted(false);
        jEImagePanel2.add(but_limpiar);
        but_limpiar.setBounds(571, 139, 165, 50);

        txt_consulta.setForeground(new java.awt.Color(0, 0, 0));
        txt_consulta.setBordeColorFocus(new java.awt.Color(0, 102, 51));
        txt_consulta.setColorTransparente(true);
        txt_consulta.setPlaceholder("CODIGO CLIENTE - CEDULA - NOMBRE");
        txt_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_consultaKeyTyped(evt);
            }
        });
        jEImagePanel2.add(txt_consulta);
        txt_consulta.setBounds(16, 147, 312, 42);

        agregarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/CREAR ICO 2.png"))); // NOI18N
        agregarcliente.setBorder(null);
        agregarcliente.setBorderPainted(false);
        agregarcliente.setContentAreaFilled(false);
        agregarcliente.setFocusPainted(false);
        agregarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarclienteActionPerformed(evt);
            }
        });
        jEImagePanel2.add(agregarcliente);
        agregarcliente.setBounds(746, 139, 165, 50);

        but_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/ACTUALIZAR ICO.png"))); // NOI18N
        but_refrescar.setBorderPainted(false);
        but_refrescar.setContentAreaFilled(false);
        but_refrescar.setFocusPainted(false);
        jEImagePanel2.add(but_refrescar);
        but_refrescar.setBounds(346, 139, 50, 50);

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscador:"));
        jEImagePanel2.add(jLabel1);
        jLabel1.setBounds(10, 120, 330, 80);

        jPanelRound1.add(jEImagePanel2);
        jEImagePanel2.setBounds(450, 0, 930, 580);

        getContentPane().add(jPanelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_crearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_crearActionPerformed

    private void agregarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarclienteActionPerformed

    private void txt_consultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_consultaKeyTyped
        if(txt_consulta.getText().length()>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 50 DIGITOS");
        }
    }//GEN-LAST:event_txt_consultaKeyTyped

    private void txt_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyTyped
        if(txt_id.getText().length()>=10){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 10 DIGITOS");
        }
    }//GEN-LAST:event_txt_idKeyTyped

    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
        if(txt_nombres.getText().length()>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 50 DIGITOS");
        }
    }//GEN-LAST:event_txt_nombresKeyTyped

    private void txt_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyTyped
        if(txt_apellidos.getText().length()>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 50 DIGITOS");
        }
    }//GEN-LAST:event_txt_apellidosKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        if(txt_direccion.getText().length()>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 50 DIGITOS");
        }
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        if(txt_telefono.getText().length()>=10){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 10 DIGITOS");
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        if(txt_correo.getText().length()>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"SOLO HASTA 50 DIGITOS");
        }
    }//GEN-LAST:event_txt_correoKeyTyped

    public JButton getAgregarcliente() {
        return agregarcliente;
    }

    public void setAgregarcliente(JButton agregarcliente) {
        this.agregarcliente = agregarcliente;
    }

    public JButton getBut_refrescar() {
        return but_refrescar;
    }

    public void setBut_refrescar(JButton but_refrescar) {
        this.but_refrescar = but_refrescar;
    }

    
    
    
    public JButton getBut_crear() {
        return but_crear;
    }

    public void setBut_crear(JButton but_crear) {
        this.but_crear = but_crear;
    }

    public JLabel getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(JLabel codigocliente) {
        this.codigocliente = codigocliente;
    }

    public JButton getGenerarcodigocliente() {
        return generarcodigocliente;
    }

    public void setGenerarcodigocliente(JButton generarcodigocliente) {
        this.generarcodigocliente = generarcodigocliente;
    }

    public JTable getTabla_clientes() {
        return tabla_clientes;
    }

    public void setTabla_clientes(JTable tabla_clientes) {
        this.tabla_clientes = tabla_clientes;
    }

    public JDialog getDlg_Cliente() {
        return Dlg_Cliente;
    }
    public void setDlg_Cliente(JDialog Dlg_Cliente) {
        this.Dlg_Cliente = Dlg_Cliente;
    }
    public JButton getBut_atras() {
        return but_atras;
    }
    public void setBut_atras(JButton but_atras) {
        this.but_atras = but_atras;
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
    public JButton getBut_actualizar() {
        return but_actualizar;
    }
    public void setBut_actualizar(JButton but_actualizar) {
        this.but_actualizar = but_actualizar;
    }
    public JButton getBut_cancelar() {
        return but_cancelar;
    }
    public void setBut_cancelar(JButton but_cancelar) {
        this.but_cancelar = but_cancelar;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }
    public JLabel getLb_apellido() {
        return lb_apellido;
    }
    public void setLb_apellido(JLabel lb_apellido) {
        this.lb_apellido = lb_apellido;
    }
   
    public JLabel getLb_correo() {
        return lb_correo;
    }
    public void setLb_correo(JLabel lb_correo) {
        this.lb_correo = lb_correo;
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
 

    public JTextField getTxt_apellidos() {
        return txt_apellidos;
    }

    public void setTxt_apellidos(JTextField txt_apellidos) {
        this.txt_apellidos = txt_apellidos;
    }

    public FSTexFieldMD getTxt_consulta() {
        return txt_consulta;
    }

    public void setTxt_consulta(FSTexFieldMD txt_consulta) {
        this.txt_consulta = txt_consulta;
    }



    public JTextField getTxt_correo() {
        return txt_correo;
    }

    public void setTxt_correo(JTextField txt_correo) {
        this.txt_correo = txt_correo;
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

    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Dlg_Cliente;
    private javax.swing.JButton agregarcliente;
    private javax.swing.JButton but_actualizar;
    private javax.swing.JButton but_atras;
    private javax.swing.JButton but_cancelar;
    private javax.swing.JButton but_crear;
    private javax.swing.JButton but_limpiar;
    private javax.swing.JButton but_modificar;
    private javax.swing.JButton but_refrescar;
    private javax.swing.JLabel codigocliente;
    private com.toedter.calendar.JDateChooser dtcFechaNacimiento;
    private javax.swing.JButton generarcodigocliente;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel2;
    private LIB.JEImagePanel jEImagePanel3;
    private javax.swing.JLabel jLabel1;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nombres;
    private javax.swing.JLabel lb_telefono;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField txt_apellidos;
    private LIB.FSTexFieldMD txt_consulta;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//