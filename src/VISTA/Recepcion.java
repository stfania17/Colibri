// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Recepcion extends javax.swing.JFrame {

 
    public Recepcion() {
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

        titulo = new javax.swing.JLabel();
        clientes = new javax.swing.JButton();
        cajeros = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setText("RECEPCION");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 83, 24));

        clientes.setText("CLIENTES");
        getContentPane().add(clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 73, 110, 31));

        cajeros.setText("CAJEROS");
        getContentPane().add(cajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 31));

        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 131, 81, 35));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    public JButton getCajeros() {
        return cajeros;
    }

    public void setCajeros(JButton cajeros) {
        this.cajeros = cajeros;
    }

    public JButton getClientes() {
        return clientes;
    }

    public void setClientes(JButton clientes) {
        this.clientes = clientes;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }
 
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cajeros;
    private javax.swing.JButton clientes;
    private javax.swing.JButton salir;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//