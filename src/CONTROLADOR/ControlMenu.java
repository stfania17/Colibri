
package CONTROLADOR;

import VISTA.MenuCliente;
 
public class ControlMenu {
    private MenuCliente menu;
    int n;
    
    public ControlMenu(MenuCliente menu) {
        this.menu = menu;
        menu.setTitle("MENU DE PRODUCTOS");
        menu.setVisible(true);
    }
    
    public void iniciaControl() {
        //vista.getBtnRefrescar().addActionListener(l -> cargaLista());
        menu.getBut_verduras().addActionListener(l -> cargarDialogo(1));
        menu.getBut_frutas().addActionListener(l -> cargarDialogo(2));
        menu.getBut_lacteos().addActionListener(l -> cargarDialogo(3));
        menu.getBut_granos().addActionListener(l -> cargarDialogo(4));
        menu.getBut_hierbas().addActionListener(l -> cargarDialogo(5));
        menu.getBut_otros().addActionListener(l -> cargarDialogo(6));
    }
    
    private void cargarDialogo(int origen) {
        menu.getDlg_Productos().setSize(600, 600);
        menu.getDlg_Productos().setLocationRelativeTo(menu);

        if (origen == 1) {
            menu.getDlg_Productos().setTitle("Verduras");
            n = 1;
        } else if (origen == 2) {
            menu.getDlg_Productos().setTitle("Frutas");
            n = 2;
        } else if (origen == 3) {
            menu.getDlg_Productos().setTitle("Lacteos");
            n = 3;
        } else if (origen == 4) {
            menu.getDlg_Productos().setTitle("Granos");
            n = 4;
        } else if (origen == 5) {
            menu.getDlg_Productos().setTitle("Hiervas");
            n = 5;
        } else{
            menu.getDlg_Productos().setTitle("Otros");
            n = 6;
        }
        menu.getDlg_Productos().setVisible(true);

    }
}
