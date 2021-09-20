// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Producto;
import MODELO.productos;
import CONECCIÓN_SQL.Dbproductos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
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
        cargaLista();
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
            grabaProducto();
        } else if (n == 2) {
            editarProducto();
        } else if (n == 3) {
            EliminarProducto();
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
        List<productos> lista = modelo1.mostrarProductos();
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
        List<productos> lista = modelo1.mostrarDatos(aguja);
        lista.stream().forEach(p -> {
            String[] persona = {p.getCodigo(), p.getNombre(), p.getDescripcion(), String.valueOf(p.getExistencias()),
                String.valueOf(p.getE_min()), String.valueOf(p.getE_max()), String.valueOf(p.getPrecio()), p.getCategoria(), p.getCod_proveedor()};
            tblModel.addRow(persona);
        });

    }
    
    private void grabaProducto() {
        String codigo = produc.getTxt_cod().getText();
        String nombre = produc.getTxt_nombre().getText();
        String descripcion = produc.getTxt_descripcion().getText();
        String existencia = produc.getTxt_existencia().getText();
        String e_minima = produc.getTxt_Eminima().getText();
        String e_maxima = produc.getTxt_Emaxima().getText();
        String precio = produc.getTxt_precio().getText();
        String categoria = produc.getTxt_categoria().getText();
        
        Dbproductos producto = new Dbproductos();
        
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setExistencias(Integer.parseInt(existencia));
        producto.setE_min(Integer.parseInt(e_minima));
        producto.setE_max(Integer.parseInt(e_maxima));
        producto.setPrecio(Double.parseDouble(precio));
        producto.setCategoria(categoria);

        if (producto.insertar()) {
            JOptionPane.showMessageDialog(produc, "Producto Creado Satisfactoriamente");
            produc.getDlg_Productos().setVisible(false);
            cargaLista();
        } else {
            JOptionPane.showMessageDialog(produc, "ERROR");
        }
    }
    
    private void editarProducto() {
        String codigo = produc.getTxt_cod().getText();
        String nombre = produc.getTxt_nombre().getText();
        String descripcion = produc.getTxt_descripcion().getText();
        String existencia = produc.getTxt_existencia().getText();
        String e_minima = produc.getTxt_Eminima().getText();
        String e_maxima = produc.getTxt_Emaxima().getText();
        String precio = produc.getTxt_precio().getText();
        String categoria = produc.getTxt_categoria().getText();
        
        Dbproductos producto = new Dbproductos();
        
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setExistencias(Integer.parseInt(existencia));
        producto.setE_min(Integer.parseInt(e_minima));
        producto.setE_max(Integer.parseInt(e_maxima));
        producto.setPrecio(Double.parseDouble(precio));
        producto.setCategoria(categoria);

        if (producto.modificar(codigo)) {
            JOptionPane.showMessageDialog(produc, "Producto Creado Satisfactoriamente");
            produc.getDlg_Productos().setVisible(false);
            cargaLista();
        } else {
            JOptionPane.showMessageDialog(produc, "ERROR");
        }
    }
    
    private void EliminarProducto() {
        Dbproductos producto = new Dbproductos();
        int fila = produc.getTbl_rep_producto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(produc, "PRIMERO SELECCIONE UN PRODUCTO", "ESTEFANIA MUNOZ", 2);
        } else {
            int op = op = JOptionPane.showOptionDialog(null, "ESTA SEGIRO QUE DESEA ELIMNAR ESTE PRODUCTO", "ESTEFANIA MUNOZ",
                    JOptionPane.YES_NO_CANCEL_OPTION, 2, null, new Object[]{"SI", "NO",}, null);
            if (op == 0) {

                String id = String.valueOf(produc.getTbl_rep_producto().getValueAt(fila, 0));
                if (producto.eliminar(id)) {
                    cargaLista("");
                    JOptionPane.showMessageDialog(produc, "PRODUCTO ELIMINADO SATISFACTORIAMNETE", "ESTEFANIA MUNOZ", 1);
                    produc.getDlg_Productos().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(produc, "ERROR");
                }

            } else {
                JOptionPane.showMessageDialog(produc, "ACCION CANCELADA", "ESTEFANIA MUNOZ", 1);
            }
        }

    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//