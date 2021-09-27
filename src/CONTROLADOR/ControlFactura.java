// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Factura;
 
public class ControlFactura {
    private Factura fac;
    int n;

    public ControlFactura(Factura fac) {
        this.fac = fac;
        fac.setTitle("PROVEEDORES");
        fac.setVisible(true);
    }
  
    public void iniciaControl() { 
        fac.getBut_consultar().addActionListener(l -> cargarDialogo(1));
         
    }
    
    private void cargarDialogo(int origen) {
        fac.getDlg_Factura().setSize(600, 600);
        fac.getDlg_Factura().setLocationRelativeTo(fac);

        if (origen == 1) {
            fac.getDlg_Factura().setTitle("CONSULTAR");
            n = 1;
        } else if (origen == 2) {
            fac.getDlg_Factura().setTitle("MODIFICAR");
            n = 2;
        } else if (origen == 3) {
            fac.getDlg_Factura().setTitle("ELIMINAR");
            n = 3;
        } 
        fac.getDlg_Factura().setVisible(true);

    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//