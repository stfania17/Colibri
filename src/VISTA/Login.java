// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

 
public class Login extends javax.swing.JFrame {

    
    
    public Login() {
        initComponents();
        Login.this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanelRound1 = new LIB.JPanelRound();
        jEImagePanel1 = new LIB.JEImagePanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        musuario = new javax.swing.JTextPane();
        mcontraseña = new javax.swing.JPasswordField();
        visual = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 235));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Inicio.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPanelRound1.add(jEImagePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 370));

        musuario.setBorder(null);
        musuario.setName(""); // NOI18N
        jScrollPane2.setViewportView(musuario);

        jPanelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 170, 30));

        mcontraseña.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelRound1.add(mcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 170, 30));

        visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_eye_24px.png"))); // NOI18N
        visual.setBorder(null);
        visual.setBorderPainted(false);
        visual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualActionPerformed(evt);
            }
        });
        jPanelRound1.add(visual, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 30, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_user_24px.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 30, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_key_24px.png"))); // NOI18N
        jPanelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 30, 30));

        jLabel1.setBackground(new java.awt.Color(102, 255, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/LOGIN-PhotoRoom.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 170, 50));

        salir.setBackground(new java.awt.Color(102, 153, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        salir.setText("SALIR");
        salir.setToolTipText("");
        salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanelRound1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 140, 30));

        ingresar.setBackground(new java.awt.Color(102, 153, 255));
        ingresar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ingresar.setText("INGRESAR");
        ingresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRound1.add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 140, 30));

        getContentPane().add(jPanelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    private void visualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visualActionPerformed

    public JPasswordField getMcontraseña() {
        return mcontraseña;
    }

    public void setMcontraseña(JPasswordField mcontraseña) {
        this.mcontraseña = mcontraseña;
    }
    
    public JButton getIngresar() {
        return ingresar;
    }

    public void setIngresar(JButton ingresar) {
        this.ingresar = ingresar;
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

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextPane getMusuario() {
        return musuario;
    }

    public void setMusuario(JTextPane musuario) {
        this.musuario = musuario;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public JButton getVisual() {
        return visual;
    }

    public void setVisual(JButton visual) {
        this.visual = visual;
    }

   

    
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresar;
    private javax.swing.JDialog jDialog1;
    private LIB.JEImagePanel jEImagePanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField mcontraseña;
    private javax.swing.JTextPane musuario;
    private javax.swing.JButton salir;
    private javax.swing.JButton visual;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
