// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Producto;
 
public class ControlProducto {
    private Producto produc;
    int n;

    public ControlProducto(Producto produc) {
        this.produc = produc;
        produc.setTitle("PRODUCTOS");
        produc.setVisible(true);
    }
    
    public void iniciaControl() { 
        produc.getBut_consultar().addActionListener(l -> cargarDialogo(1));
        produc.getBut_crear().addActionListener(l -> cargarDialogo(2));
        produc.getBut_modificar().addActionListener(l -> cargarDialogo(3));
        produc.getBut_eliminar().addActionListener(l -> cargarDialogo(4));
    }
    
    private void cargarDialogo(int origen) {
        produc.getDlg_Productos().setSize(600, 600);
        produc.getDlg_Productos().setLocationRelativeTo(produc);

        if (origen == 1) {
            produc.getDlg_Productos().setTitle("CONSULTAR");
            n = 1;
        } else if (origen == 2) {
            produc.getDlg_Productos().setTitle("CREAR");
            n = 2;
        } else if (origen == 3) {
            produc.getDlg_Productos().setTitle("MODIFICAR");
            n = 3;
        } else {
            produc.getDlg_Productos().setTitle("ELIMINAR");
            n = 4;
        }
        produc.getDlg_Productos().setVisible(true);

    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//