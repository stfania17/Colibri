// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package VISTA;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Vista_menu_cliente extends javax.swing.JFrame {

    public Vista_menu_cliente() {
        initComponents();
        Vista_menu_cliente.this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dlg_Productos = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jEImagePanel3 = new LIB.JEImagePanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelRound2 = new LIB.JPanelRound();
        categoriaseccion = new javax.swing.JLabel();
        categoriatabla = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SALIR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buscarpor = new javax.swing.JButton();
        CARRITO = new javax.swing.JDialog();
        jPanelRound3 = new LIB.JPanelRound();
        titulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacarrito = new javax.swing.JTable();
        contador = new javax.swing.JSpinner();
        dejarlo = new javax.swing.JButton();
        CANCELAR = new javax.swing.JButton();
        comprar = new javax.swing.JButton();
        jEImagePanel4 = new LIB.JEImagePanel();
        jPanelRound1 = new LIB.JPanelRound();
        jEImagePanel1 = new LIB.JEImagePanel();
        jEImagePanel2 = new LIB.JEImagePanel();
        but_granos = new javax.swing.JButton();
        but_verduras = new javax.swing.JButton();
        but_frutas = new javax.swing.JButton();
        but_hierbas = new javax.swing.JButton();
        but_carrito = new javax.swing.JButton();
        but_salir = new javax.swing.JButton();
        but_lacteos = new javax.swing.JButton();
        but_otros = new javax.swing.JButton();

        Dlg_Productos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Dlg_Productos.setMinimumSize(new java.awt.Dimension(940, 550));
        Dlg_Productos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("COLIBRÍ");
        Dlg_Productos.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 40, 1));
        Dlg_Productos.getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jButton1.setText("Añadir al Carrito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Dlg_Productos.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("PROVEEDOR");
        Dlg_Productos.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        jEImagePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Productos Dlg.png"))); // NOI18N
        jEImagePanel3.setLayout(null);
        Dlg_Productos.getContentPane().add(jEImagePanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 540));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "PROVEEDOR", "DESCRIPCION", "PRECIO", "EXISTENCIA", "FOTO"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Dlg_Productos.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 224, 540, 230));

        jPanelRound2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound2.setOpaque(true);
        jPanelRound2.setLayout(null);
        jPanelRound2.add(categoriaseccion);
        categoriaseccion.setBounds(740, 100, 130, 0);

        categoriatabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRound2.add(categoriatabla);
        categoriatabla.setBounds(710, 100, 150, 20);

        jLabel5.setText("Apellido:");
        jPanelRound2.add(jLabel5);
        jLabel5.setBounds(510, 180, 41, 20);

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRound2.add(jLabel8);
        jLabel8.setBounds(550, 180, 138, 20);

        jLabel6.setText("Teléfono:");
        jPanelRound2.add(jLabel6);
        jLabel6.setBounds(710, 180, 46, 20);

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRound2.add(jLabel9);
        jLabel9.setBounds(760, 180, 138, 20);

        jLabel4.setText("Nombre:");
        jPanelRound2.add(jLabel4);
        jLabel4.setBounds(340, 180, 41, 20);

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRound2.add(jLabel7);
        jLabel7.setBounds(380, 180, 120, 20);

        SALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/REGRESAR ICO.png"))); // NOI18N
        SALIR.setBorder(null);
        SALIR.setBorderPainted(false);
        SALIR.setContentAreaFilled(false);
        SALIR.setFocusPainted(false);
        jPanelRound2.add(SALIR);
        SALIR.setBounds(720, 460, 180, 60);

        jLabel2.setText("Código:");
        jPanelRound2.add(jLabel2);
        jLabel2.setBounds(350, 60, 37, 20);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanelRound2.add(jTextField1);
        jTextField1.setBounds(400, 60, 110, 20);

        buscarpor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/search.png"))); // NOI18N
        jPanelRound2.add(buscarpor);
        buscarpor.setBounds(520, 60, 49, 30);

        Dlg_Productos.getContentPane().add(jPanelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 540));

        CARRITO.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        CARRITO.setResizable(false);
        CARRITO.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRound3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound3.setOpaque(true);
        jPanelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titulo.setText("CARRITO");
        jPanelRound3.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        tablacarrito.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tablacarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane2.setViewportView(tablacarrito);

        jPanelRound3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 490, 110));

        contador.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        jPanelRound3.add(contador, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 51, -1));

        dejarlo.setText("DEJAR PRODUCTO");
        jPanelRound3.add(dejarlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 150, -1));

        CANCELAR.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/REGRESAR ICO.png"))); // NOI18N
        CANCELAR.setBorder(null);
        CANCELAR.setBorderPainted(false);
        CANCELAR.setContentAreaFilled(false);
        CANCELAR.setFocusPainted(false);
        CANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELARActionPerformed(evt);
            }
        });
        jPanelRound3.add(CANCELAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, -1));

        comprar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        comprar.setText("EFECTUAR  COMPRA");
        jPanelRound3.add(comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jEImagePanel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Carrito dlg.png"))); // NOI18N
        jEImagePanel4.setLayout(null);
        jPanelRound3.add(jEImagePanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 310));

        CARRITO.getContentPane().add(jPanelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 310));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1340, 738));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/PRODUCTOS.png"))); // NOI18N
        jEImagePanel1.setLayout(null);
        jPanelRound1.add(jEImagePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 482, 690));

        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/1.jpg"))); // NOI18N

        but_granos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/GRANOS ICO.png"))); // NOI18N
        but_granos.setBorder(null);
        but_granos.setBorderPainted(false);
        but_granos.setContentAreaFilled(false);
        but_granos.setFocusPainted(false);

        but_verduras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/VERDURAS ICO.png"))); // NOI18N
        but_verduras.setBorder(null);
        but_verduras.setBorderPainted(false);
        but_verduras.setContentAreaFilled(false);
        but_verduras.setFocusPainted(false);
        but_verduras.setMaximumSize(new java.awt.Dimension(3149, 2009));
        but_verduras.setMinimumSize(new java.awt.Dimension(3149, 2009));
        but_verduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_verdurasActionPerformed(evt);
            }
        });

        but_frutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/FRUTAS ICO.png"))); // NOI18N
        but_frutas.setBorder(null);
        but_frutas.setBorderPainted(false);
        but_frutas.setContentAreaFilled(false);
        but_frutas.setFocusPainted(false);

        but_hierbas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/HIERBAS ICO.png"))); // NOI18N
        but_hierbas.setBorder(null);
        but_hierbas.setBorderPainted(false);
        but_hierbas.setContentAreaFilled(false);
        but_hierbas.setFocusPainted(false);

        but_carrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/CARRITO ICO.png"))); // NOI18N
        but_carrito.setBorder(null);
        but_carrito.setBorderPainted(false);
        but_carrito.setContentAreaFilled(false);
        but_carrito.setFocusPainted(false);

        but_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/SALIR VERDE-PhotoRoom.png"))); // NOI18N
        but_salir.setBorder(null);
        but_salir.setBorderPainted(false);
        but_salir.setContentAreaFilled(false);
        but_salir.setFocusPainted(false);

        but_lacteos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/LACTEOS ICO.png"))); // NOI18N
        but_lacteos.setBorder(null);
        but_lacteos.setBorderPainted(false);
        but_lacteos.setContentAreaFilled(false);
        but_lacteos.setFocusPainted(false);
        but_lacteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_lacteosActionPerformed(evt);
            }
        });

        but_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/OTROS ICO.png"))); // NOI18N
        but_otros.setBorder(null);
        but_otros.setBorderPainted(false);
        but_otros.setContentAreaFilled(false);
        but_otros.setFocusPainted(false);

        javax.swing.GroupLayout jEImagePanel2Layout = new javax.swing.GroupLayout(jEImagePanel2);
        jEImagePanel2.setLayout(jEImagePanel2Layout);
        jEImagePanel2Layout.setHorizontalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEImagePanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jEImagePanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(but_salir))
                    .addGroup(jEImagePanel2Layout.createSequentialGroup()
                        .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_granos)
                            .addComponent(but_verduras, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_frutas)
                            .addComponent(but_hierbas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_lacteos)
                            .addComponent(but_otros)
                            .addComponent(but_carrito))))
                .addGap(53, 53, 53))
        );
        jEImagePanel2Layout.setVerticalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEImagePanel2Layout.createSequentialGroup()
                .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEImagePanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_verduras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but_frutas)))
                    .addGroup(jEImagePanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(but_carrito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(but_lacteos)))
                .addGap(116, 116, 116)
                .addGroup(jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_hierbas)
                    .addComponent(but_granos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_otros))
                .addGap(134, 134, 134)
                .addComponent(but_salir)
                .addGap(69, 69, 69))
        );

        jPanelRound1.add(jEImagePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        getContentPane().add(jPanelRound1);
        jPanelRound1.setBounds(0, 0, 1320, 690);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_lacteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_lacteosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_lacteosActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void but_verdurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_verdurasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_verdurasActionPerformed

    private void CANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CANCELARActionPerformed

    public JButton getBuscarpor() {
        return buscarpor;
    }

    public void setBuscarpor(JButton buscarpor) {
        this.buscarpor = buscarpor;
    }

    public JLabel getCategoriaseccion() {
        return categoriaseccion;
    }

    public void setCategoriaseccion(JLabel categoriaseccion) {
        this.categoriaseccion = categoriaseccion;
    }

    public JLabel getCategoriatabla() {
        return categoriatabla;
    }

    public void setCategoriatabla(JLabel categoriatabla) {
        this.categoriatabla = categoriatabla;
    }

 

    
    
    public JSpinner getContador() {
        return contador;
    }

    public void setContador(JSpinner contador) {
        this.contador = contador;
    }

    public JButton getCANCELAR() {
        return CANCELAR;
    }

    public void setCANCELAR(JButton CANCELAR) {
        this.CANCELAR = CANCELAR;
    }

    public JDialog getCARRITO() {
        return CARRITO;
    }

    public void setCARRITO(JDialog CARRITO) {
        this.CARRITO = CARRITO;
    }

    public JButton getComprar() {
        return comprar;
    }

    public void setComprar(JButton comprar) {
        this.comprar = comprar;
    }

    public JButton getDejarlo() {
        return dejarlo;
    }

    public void setDejarlo(JButton dejarlo) {
        this.dejarlo = dejarlo;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getTablacarrito() {
        return tablacarrito;
    }

    public void setTablacarrito(JTable tablacarrito) {
        this.tablacarrito = tablacarrito;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JButton getSALIR() {
        return SALIR;
    }

    public void setSALIR(JButton SALIR) {
        this.SALIR = SALIR;
    }

    public JDialog getDlg_Productos() {
        return Dlg_Productos;
    }

    public void setDlg_Productos(JDialog Dlg_Productos) {
        this.Dlg_Productos = Dlg_Productos;
    }

    public JButton getBut_carrito() {
        return but_carrito;
    }

    public void setBut_carrito(JButton but_carrito) {
        this.but_carrito = but_carrito;
    }

    public JButton getBut_frutas() {
        return but_frutas;
    }

    public void setBut_frutas(JButton but_frutas) {
        this.but_frutas = but_frutas;
    }

    public JButton getBut_granos() {
        return but_granos;
    }

    public void setBut_granos(JButton but_granos) {
        this.but_granos = but_granos;
    }

    public JButton getBut_hierbas() {
        return but_hierbas;
    }

    public void setBut_hierbas(JButton but_hierbas) {
        this.but_hierbas = but_hierbas;
    }

    public JButton getBut_lacteos() {
        return but_lacteos;
    }

    public void setBut_lacteos(JButton but_lacteos) {
        this.but_lacteos = but_lacteos;
    }

    public JButton getBut_otros() {
        return but_otros;
    }

    public void setBut_otros(JButton but_otros) {
        this.but_otros = but_otros;
    }

    public JButton getBut_verduras() {
        return but_verduras;
    }

    public void setBut_verduras(JButton but_verduras) {
        this.but_verduras = but_verduras;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JSpinner getjSpinner1() {
        return jSpinner1;
    }

    public void setjSpinner1(JSpinner jSpinner1) {
        this.jSpinner1 = jSpinner1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JButton getBut_salir() {
        return but_salir;
    }

    public void setBut_salir(JButton but_salir) {
        this.but_salir = but_salir;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CANCELAR;
    public javax.swing.JDialog CARRITO;
    private javax.swing.JDialog Dlg_Productos;
    private javax.swing.JButton SALIR;
    public javax.swing.JButton buscarpor;
    public javax.swing.JButton but_carrito;
    private javax.swing.JButton but_frutas;
    private javax.swing.JButton but_granos;
    private javax.swing.JButton but_hierbas;
    private javax.swing.JButton but_lacteos;
    private javax.swing.JButton but_otros;
    private javax.swing.JButton but_salir;
    private javax.swing.JButton but_verduras;
    private javax.swing.JLabel categoriaseccion;
    private javax.swing.JLabel categoriatabla;
    public javax.swing.JButton comprar;
    private javax.swing.JSpinner contador;
    public javax.swing.JButton dejarlo;
    private javax.swing.JButton jButton1;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel2;
    private LIB.JEImagePanel jEImagePanel3;
    private LIB.JEImagePanel jEImagePanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    private LIB.JPanelRound jPanelRound3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable tablacarrito;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//