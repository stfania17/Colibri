// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class FACTURA_FORMULARIO extends javax.swing.JFrame {

    /** Creates new form FACTURA_FORMULARIO */
    public FACTURA_FORMULARIO() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotones = new javax.swing.ButtonGroup();
        botonesdepago = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fechafactura = new javax.swing.JLabel();
        codigofactura = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        subtitulo1 = new javax.swing.JLabel();
        bcfinal = new javax.swing.JRadioButton();
        bccondatos = new javax.swing.JRadioButton();
        jtbuscacliente = new javax.swing.JTextField();
        buscarcliente = new javax.swing.JButton();
        ingresarcliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacarrito = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        cancelarventa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btcheque = new javax.swing.JRadioButton();
        bttarjeta = new javax.swing.JRadioButton();
        btefectivo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpnclave = new javax.swing.JPasswordField();
        jpntarjeta = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(" FACTURA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 150, 20));

        fechafactura.setText("FECHA");
        jPanel1.add(fechafactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 220, -1));

        codigofactura.setText("CODIGO  FACTURA");
        jPanel1.add(codigofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 50));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subtitulo1.setText("EL COIGO DE LA FACTURA SE GENERARÁ  DE MANERA AUTOMATICA.");
        jPanel2.add(subtitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        grupobotones.add(bcfinal);
        bcfinal.setText("CONSUMIDOR FINAL");
        jPanel2.add(bcfinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        grupobotones.add(bccondatos);
        bccondatos.setText("DATOS");
        jPanel2.add(bccondatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));
        jPanel2.add(jtbuscacliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, -1));

        buscarcliente.setText("BUSCAR");
        jPanel2.add(buscarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 130, -1));

        ingresarcliente.setText("INGRESAR");
        jPanel2.add(ingresarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 150));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablacarrito.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tablacarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO", "EXISTENCIA"
            }
        ));
        jScrollPane2.setViewportView(tablacarrito);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 90));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 620, 110));

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelarventa.setBackground(new java.awt.Color(255, 0, 0));
        cancelarventa.setText("CANCELAR");
        jPanel4.add(cancelarventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setText("VENDER");
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 620, 70));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonesdepago.add(btcheque);
        btcheque.setText("CHEQUE");
        jPanel5.add(btcheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, -1));

        botonesdepago.add(bttarjeta);
        bttarjeta.setText("TARJETA");
        jPanel5.add(bttarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, -1));

        botonesdepago.add(btefectivo);
        btefectivo.setText("EFECTIVO");
        jPanel5.add(btefectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, -1));

        jLabel2.setText("TARJETA:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 50, 20));

        jLabel3.setText("CLAVE:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 50, 20));
        jPanel5.add(jpnclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 140, -1));
        jPanel5.add(jpntarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 140, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 620, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getCodigofactura() {
        return codigofactura;
    }

    public void setCodigofactura(JLabel codigofactura) {
        this.codigofactura = codigofactura;
    }

    public JLabel getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(JLabel fechafactura) {
        this.fechafactura = fechafactura;
    }
 
    public JRadioButton getBccondatos() {
        return bccondatos;
    }

    public void setBccondatos(JRadioButton bccondatos) {
        this.bccondatos = bccondatos;
    }

    public JRadioButton getBcfinal() {
        return bcfinal;
    }

    public void setBcfinal(JRadioButton bcfinal) {
        this.bcfinal = bcfinal;
    }

    public ButtonGroup getBotonesdepago() {
        return botonesdepago;
    }

    public void setBotonesdepago(ButtonGroup botonesdepago) {
        this.botonesdepago = botonesdepago;
    }

    public JRadioButton getBtcheque() {
        return btcheque;
    }

    public void setBtcheque(JRadioButton btcheque) {
        this.btcheque = btcheque;
    }

    public JRadioButton getBtefectivo() {
        return btefectivo;
    }

    public void setBtefectivo(JRadioButton btefectivo) {
        this.btefectivo = btefectivo;
    }

    public JRadioButton getBttarjeta() {
        return bttarjeta;
    }

    public void setBttarjeta(JRadioButton bttarjeta) {
        this.bttarjeta = bttarjeta;
    }

    public JButton getBuscarcliente() {
        return buscarcliente;
    }

    public void setBuscarcliente(JButton buscarcliente) {
        this.buscarcliente = buscarcliente;
    }

    public JButton getCancelarventa() {
        return cancelarventa;
    }

    public void setCancelarventa(JButton cancelarventa) {
        this.cancelarventa = cancelarventa;
    }

    public ButtonGroup getGrupobotones() {
        return grupobotones;
    }

    public void setGrupobotones(ButtonGroup grupobotones) {
        this.grupobotones = grupobotones;
    }

    public JButton getIngresarcliente() {
        return ingresarcliente;
    }

    public void setIngresarcliente(JButton ingresarcliente) {
        this.ingresarcliente = ingresarcliente;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JPasswordField getJpnclave() {
        return jpnclave;
    }

    public void setJpnclave(JPasswordField jpnclave) {
        this.jpnclave = jpnclave;
    }

    public JPasswordField getJpntarjeta() {
        return jpntarjeta;
    }

    public void setJpntarjeta(JPasswordField jpntarjeta) {
        this.jpntarjeta = jpntarjeta;
    }

    public JTextField getJtbuscacliente() {
        return jtbuscacliente;
    }

    public void setJtbuscacliente(JTextField jtbuscacliente) {
        this.jtbuscacliente = jtbuscacliente;
    }

    public JLabel getSubtitulo1() {
        return subtitulo1;
    }

    public void setSubtitulo1(JLabel subtitulo1) {
        this.subtitulo1 = subtitulo1;
    }

    public JTable getTablacarrito() {
        return tablacarrito;
    }

    public void setTablacarrito(JTable tablacarrito) {
        this.tablacarrito = tablacarrito;
    }
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bccondatos;
    private javax.swing.JRadioButton bcfinal;
    private javax.swing.ButtonGroup botonesdepago;
    private javax.swing.JRadioButton btcheque;
    private javax.swing.JRadioButton btefectivo;
    private javax.swing.JRadioButton bttarjeta;
    private javax.swing.JButton buscarcliente;
    private javax.swing.JButton cancelarventa;
    private javax.swing.JLabel codigofactura;
    private javax.swing.JLabel fechafactura;
    private javax.swing.ButtonGroup grupobotones;
    private javax.swing.JButton ingresarcliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField jpnclave;
    private javax.swing.JPasswordField jpntarjeta;
    private javax.swing.JTextField jtbuscacliente;
    private javax.swing.JLabel subtitulo1;
    public javax.swing.JTable tablacarrito;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//