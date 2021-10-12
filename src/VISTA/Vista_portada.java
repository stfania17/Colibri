// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

 
public class Vista_portada extends javax.swing.JFrame {

 
    public Vista_portada() {
        initComponents();
        Vista_portada.this.setBackground(new Color(0,0,0,0));
        
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
        jEImagePanel2 = new LIB.JEImagePanel();
        entrar = new javax.swing.JButton();
        SALIDA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jEImagePanel1 = new LIB.JEImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelRound1.setBackground(new java.awt.Color(190, 235, 118));
        jPanelRound1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(null);

        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/31b204b86b31bfdd540ab7d81e3778e0.jpg"))); // NOI18N

        entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/INGRESAR VERDE-PhotoRoom.png"))); // NOI18N
        entrar.setBorder(null);
        entrar.setBorderPainted(false);
        entrar.setContentAreaFilled(false);
        entrar.setFocusPainted(false);
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        SALIDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/SALIR VERDE-PhotoRoom.png"))); // NOI18N
        SALIDA.setBorder(null);
        SALIDA.setBorderPainted(false);
        SALIDA.setContentAreaFilled(false);
        SALIDA.setFocusPainted(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/SA-PhotoRoom.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel2Layout = new javax.swing.GroupLayout(jEImagePanel2);
        jEImagePanel2.setLayout(jEImagePanel2Layout);
        jEImagePanel2Layout.setHorizontalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEImagePanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
            .addGroup(jEImagePanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SALIDA)
                    .addComponent(entrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jEImagePanel2Layout.setVerticalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEImagePanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(entrar)
                .addGap(36, 36, 36)
                .addComponent(SALIDA)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanelRound1.add(jEImagePanel2);
        jEImagePanel2.setBounds(300, 0, 330, 490);

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Portada.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jPanelRound1.add(jEImagePanel1);
        jEImagePanel1.setBounds(0, 0, 310, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entrarActionPerformed

    public JButton getSALIDA() {
        return SALIDA;
    }

    public void setSALIDA(JButton SALIDA) {
        this.SALIDA = SALIDA;
    }

    public JButton getEntrar() {
        return entrar;
    }

    public void setEntrar(JButton entrar) {
        this.entrar = entrar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton SALIDA;
    public javax.swing.JButton entrar;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel2;
    private javax.swing.JLabel jLabel1;
    private LIB.JPanelRound jPanelRound1;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//