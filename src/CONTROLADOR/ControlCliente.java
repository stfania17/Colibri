// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Cliente;


public class ControlCliente {
    private Cliente clie;
    int n;

    public ControlCliente(Cliente clie) {
        this.clie = clie;
        clie.setTitle("PROVEEDORES");
        clie.setVisible(true);
    }
    
    public void iniciaControl() { 
        clie.getBut_consultar().addActionListener(l -> cargarDialogo(1));
        clie.getBut_modificar().addActionListener(l -> cargarDialogo(2));
        clie.getBut_eliminar().addActionListener(l -> cargarDialogo(3));
    }
    
    private void cargarDialogo(int origen) {
        clie.getDlg_Cliente().setSize(600, 600);
        clie.getDlg_Cliente().setLocationRelativeTo(clie);

        if (origen == 1) {
            clie.getDlg_Cliente().setTitle("CONSULTAR");
            n = 1;
        } else if (origen == 2) {
            clie.getDlg_Cliente().setTitle("MODIFICAR");
            n = 2;
        } else if (origen == 3) {
            clie.getDlg_Cliente().setTitle("ELIMINAR");
            n = 3;
        } 
        clie.getDlg_Cliente().setVisible(true);

    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//