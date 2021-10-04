// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ingreso extends javax.swing.JFrame {

 
    public Ingreso() {
        initComponents();
        Ingreso.this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRound1 = new LIB.JPanelRound();
        jEImagePanel1 = new LIB.JEImagePanel();
        jEImagePanel2 = new LIB.JEImagePanel();
        but_Salir = new javax.swing.JButton();
        but_Rep_Producto = new javax.swing.JButton();
        but_Rep_Proveedor = new javax.swing.JButton();
        but_Rep_Cliente = new javax.swing.JButton();
        but_Rep_Factura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(870, 519));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(870, 519));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setToolTipText("");
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(null);

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Ingreso.png"))); // NOI18N
        jEImagePanel1.setLayout(null);
        jPanelRound1.add(jEImagePanel1);
        jEImagePanel1.setBounds(0, 0, 370, 520);

        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/31b204b86b31bfdd540ab7d81e3778e0.jpg"))); // NOI18N
        jEImagePanel2.setLayout(null);

        but_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/SALIR VERDE-PhotoRoom.png"))); // NOI18N
        but_Salir.setBorder(null);
        but_Salir.setBorderPainted(false);
        but_Salir.setContentAreaFilled(false);
        but_Salir.setFocusPainted(false);
        jEImagePanel2.add(but_Salir);
        but_Salir.setBounds(340, 450, 150, 40);

        but_Rep_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte prODUCTOS.png"))); // NOI18N
        but_Rep_Producto.setBorder(null);
        but_Rep_Producto.setBorderPainted(false);
        but_Rep_Producto.setContentAreaFilled(false);
        but_Rep_Producto.setFocusPainted(false);
        but_Rep_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_Rep_ProductoActionPerformed(evt);
            }
        });
        jEImagePanel2.add(but_Rep_Producto);
        but_Rep_Producto.setBounds(110, 130, 310, 70);

        but_Rep_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte proveedores.png"))); // NOI18N
        but_Rep_Proveedor.setBorder(null);
        but_Rep_Proveedor.setBorderPainted(false);
        but_Rep_Proveedor.setContentAreaFilled(false);
        but_Rep_Proveedor.setFocusPainted(false);
        jEImagePanel2.add(but_Rep_Proveedor);
        but_Rep_Proveedor.setBounds(110, 40, 310, 70);

        but_Rep_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte CLIENTES.png"))); // NOI18N
        but_Rep_Cliente.setBorder(null);
        but_Rep_Cliente.setBorderPainted(false);
        but_Rep_Cliente.setContentAreaFilled(false);
        but_Rep_Cliente.setFocusPainted(false);
        jEImagePanel2.add(but_Rep_Cliente);
        but_Rep_Cliente.setBounds(110, 310, 310, 70);

        but_Rep_Factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte FACTURAS .png"))); // NOI18N
        but_Rep_Factura.setBorder(null);
        but_Rep_Factura.setBorderPainted(false);
        but_Rep_Factura.setContentAreaFilled(false);
        but_Rep_Factura.setFocusPainted(false);
        jEImagePanel2.add(but_Rep_Factura);
        but_Rep_Factura.setBounds(110, 220, 310, 70);

        jPanelRound1.add(jEImagePanel2);
        jEImagePanel2.setBounds(360, 0, 510, 520);

        getContentPane().add(jPanelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_Rep_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_Rep_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_Rep_ProductoActionPerformed

    public JButton getBut_Rep_Cliente() {
        return but_Rep_Cliente;
    }
    public void setBut_Rep_Cliente(JButton but_Rep_Cliente) {
        this.but_Rep_Cliente = but_Rep_Cliente;
    }
    //but_Rep_Proveedor
    public JButton getBut_Rep_Factura() {
        return but_Rep_Factura;
    }
    public void setBut_Rep_Factura(JButton but_Rep_Factura) {
        this.but_Rep_Factura = but_Rep_Factura;
    }

    public JButton getBut_Rep_Producto() {
        return but_Rep_Producto;
    }
    public void setBut_Rep_Producto(JButton but_Rep_Producto) {
        this.but_Rep_Producto = but_Rep_Producto;
    }

    public JButton getBut_Rep_Proveedor() {
        return but_Rep_Proveedor;
    }
    public void setBut_Rep_Proveedor(JButton but_Rep_Proveedor) {
        this.but_Rep_Proveedor = but_Rep_Proveedor;
    }

    public JButton getBut_Salir() {
        return but_Salir;
    }
    public void setBut_Salir(JButton but_Salir) {
        this.but_Salir = but_Salir;
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
  
////////////////////////////////////////////////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_Rep_Cliente;
    private javax.swing.JButton but_Rep_Factura;
    private javax.swing.JButton but_Rep_Producto;
    private javax.swing.JButton but_Rep_Proveedor;
    private javax.swing.JButton but_Salir;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel2;
    private LIB.JPanelRound jPanelRound1;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//