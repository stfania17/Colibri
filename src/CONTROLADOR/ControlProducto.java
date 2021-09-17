// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Producto;
import MODELO.productos;
import CONECCIÓN_SQL.Dbproductos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
 
public class ControlProducto {
    private Producto produc;
    private productos modelo;
    private Dbproductos modelo1;
    int n;

    public ControlProducto(Producto produc, productos modelo) {
        this.produc = produc;
        this.modelo= modelo;
        produc.setTitle("PRODUCTOS");
        produc.setVisible(true);
    }
    
    public void iniciaControl() { 
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                cargaLista(produc.getTxt_consulta().getText());
            }

        };
        
        produc.getBut_refrescar().addActionListener(l -> cargaLista());
        produc.getBut_crear().addActionListener(l -> cargarDialogo(1));
        produc.getBut_modificar().addActionListener(l -> cargarDialogo(2));
        produc.getBut_eliminar().addActionListener(l -> cargarDialogo(3));
        
        boolean hola = true;

        produc.getBut_aceptar().addActionListener(l -> DefinirMetodo(n));

        //Controlador Buscar
        produc.getTxt_consulta().addKeyListener(kl);
    }
    
    public void DefinirMetodo(int n) {

        if (n == 1) {
            //grabaPersona();
        } else if (n == 2) {
            //editarPersona();
        } else if (n == 3) {
            //eliminarPersona();
        }

    }
    
    private void cargarDialogo(int origen) {
        produc.getDlg_Productos().setSize(600, 600);
        produc.getDlg_Productos().setLocationRelativeTo(produc);

        if (origen == 1) {
            produc.getDlg_Productos().setTitle("CREAR");
            n = 1;
        } else if (origen == 2) {
            produc.getDlg_Productos().setTitle("MODIFICAR");
            n = 2;
        } else {
            produc.getDlg_Productos().setTitle("ELIMINAR");
            n = 3;
        }
        produc.getDlg_Productos().setVisible(true);

    }
    
    private void cargaLista() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        DefaultTableModel tblModel;//Estructura JTbable
        tblModel = (DefaultTableModel) produc.getTbl_rep_producto().getModel();
        tblModel.setNumRows(0);
        List<productos> lista = modelo1.listaProductos();
        lista.stream().forEach(p -> {
            String[] persona = {p.getCodigo(), p.getNombre(), p.getDescripcion(), String.valueOf(p.getExistencias()),
                String.valueOf(p.getE_min()), String.valueOf(p.getE_max()), String.valueOf(p.getPrecio()), p.getCategoria(), p.getCod_proveedor()};
            tblModel.addRow(persona);
        });

    }

    private void cargaLista(String aguja) {
        //Acciones necesarios para extraer los datos MODELO Y Mostrar en la Vista
        DefaultTableModel tblModel; //Estructura JTbable
        tblModel = (DefaultTableModel) produc.getTbl_rep_producto().getModel();
        tblModel.setNumRows(0);
        List<productos> lista = modelo1.listaProducto(aguja);
        lista.stream().forEach(p -> {
            String[] persona = {p.getCodigo(), p.getNombre(), p.getDescripcion(), String.valueOf(p.getExistencias()),
                String.valueOf(p.getE_min()), String.valueOf(p.getE_max()), String.valueOf(p.getPrecio()), p.getCategoria(), p.getCod_proveedor()};
            tblModel.addRow(persona);
        });

    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//