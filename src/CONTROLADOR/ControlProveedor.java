// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CLASES.proveedores;
import VISTA.Vista_proveedor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
 
public class ControlProveedor {
    private Vista_proveedor prove;
    int n;

    public ControlProveedor(Vista_proveedor prove) {
        this.prove = prove;
        prove.setTitle("PROVEEDORES");
        prove.setVisible(true);
    }
   
    public void iniciaControl() { 
        

        prove.getBut_crear().addActionListener(l -> cargarDialogo(2));
        prove.getBut_modificar().addActionListener(l -> cargarDialogo(3));
        
    }
    
    private void cargarDialogo(int origen) {
        prove.getDlg_Proveedor().setSize(600, 600);
        prove.getDlg_Proveedor().setLocationRelativeTo(prove);

        if (origen == 1) {
            prove.getDlg_Proveedor().setTitle("CONSULTAR");
            n = 1;
        } else if (origen == 2) {
            prove.getDlg_Proveedor().setTitle("CREAR");
            n = 2;
        } else if (origen == 3) {
            prove.getDlg_Proveedor().setTitle("MODIFICAR");
            n = 3;
        } else {
            prove.getDlg_Proveedor().setTitle("ELIMINAR");
            n = 4;
        }
        prove.getDlg_Proveedor().setVisible(true);

    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//