// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

 
public class Login extends javax.swing.JFrame {

    
    
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        musuario = new javax.swing.JTextPane();
        ingresar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        visual = new javax.swing.JButton();
        mcontraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 235));
        setPreferredSize(new java.awt.Dimension(400, 235));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 255, 0));
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 11, 74, -1));

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 63, 50, -1));

        jLabel3.setText("Contraceña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 108, 61, -1));

        jScrollPane2.setViewportView(musuario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 55, 164, -1));

        ingresar.setText("INGRESAR");
        getContentPane().add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 157, -1, -1));

        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 157, -1, -1));

        visual.setText("0");
        getContentPane().add(visual, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 99, -1, -1));
        getContentPane().add(mcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 99, 164, 23));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField mcontraseña;
    private javax.swing.JTextPane musuario;
    private javax.swing.JButton salir;
    private javax.swing.JButton visual;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//