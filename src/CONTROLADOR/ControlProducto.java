// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Producto;
import MODELO.productos;
import CONECCIÓN_SQL.Dbproductos;
import CONECCIÓN_SQL.Dbproveedores;
import MODELO.proveedores;
import VISTA.Ingreso;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class ControlProducto {
    //////////////////     TRAER INTERFACES   ////////////////////////////
    public static Producto produc;
    public static Ingreso ingre = new Ingreso();
    /////////////////////////////////    SQLs   //////////////////////////////
    public static Dbproductos modelo1 = new Dbproductos();
    public static Dbproveedores dbu = new Dbproveedores();
    ///////////////////////   TABLA   //////////////////////////////////////////
    public static DefaultTableModel modelo;
    /////////////////////    VARIANTES    //////////////////////////
    public static int n;
    ///////////////////////////   ARRRALISTS  //////////////////////////////////
    public static List<proveedores> per = dbu.mostrarDatos();  
    public static List<productos> prodi = modelo1.mostrarProductos();  
 
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public ControlProducto(Producto produc) {
        this.produc = produc;
        mostrar();
        cargaLista();
        buscarcedula();
        iniciaControl();
    }
    
    public static void iniciaControl() { 
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyPressed(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            cargaLista(produc.getTxt_consulta().getText());
            }

        };
        //but_cancelar
        produc.getBut_refrescar().addActionListener(l -> cargaLista());         ///  CARGAR LA TABLA
        produc.getBut_crear().addActionListener(l -> cargarDialogo(1));         ///  CREAR UN PRODUCTO
        produc.getBut_modificar().addActionListener(l -> cargarDialogo(2));     ///  MODIFICAR PRODUCTO
        produc.getBut_eliminar().addActionListener(l -> EliminarProducto());    ///  ELIMINAR  PRODUCTO
        produc.getjButton1().addActionListener(l->generacodi());
        produc.getBut_cancelar().addActionListener(l->produc.getDlg_Productos().setVisible(false));
        //crearproducto
        boolean hola = true;
        produc.getCrearproducto().addActionListener(l -> DefinirMetodo(1));     /// EFECTUAR CREACIÓN
        produc.getEDITAR().addActionListener(l->DefinirMetodo(2));              /// EFECTUAR EDICION
        //Controlador Buscar
        produc.getTxt_consulta().addKeyListener(kl);                            /// KEYLISTENER
        produc.getBut_atras().addActionListener(l->salir());                    /// SALIR
    }
    
    public static void DefinirMetodo(int n) {
        if (n == 1) {
        grabaProducto();
        } else if (n == 2) {     
        editarProducto();
        } else if (n == 3) {
        EliminarProducto();
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargarDialogo(int origen) {
        produc.getDlg_Productos().setSize(700, 520);
        produc.getDlg_Productos().setLocationRelativeTo(produc);
         
        if (origen == 1) { /////////   CREACION
            produc.getCrearproducto().setEnabled(true);
            produc.getEDITAR().setEnabled(false); 
            produc.getjButton1().setEnabled(true);
            produc.getDlg_Productos().setTitle("CREAR");
            //n = 1;
            produc.getDlg_Productos().setVisible(true);
        } else if (origen == 2) {  //////////  EDITAR
            modificarProducto();
            produc.getCrearproducto().setEnabled(false);
            produc.getEDITAR().setEnabled(true); 
            produc.getjButton1().setEnabled(false);
            produc.getDlg_Productos().setTitle("MODIFICAR");
            //n = 2;
            produc.getDlg_Productos().setVisible(true);
        } 
    }
    ////////////////////   TABLA    NORMAL   ///////////////////////////////////
    public static void cargaLista() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        modelo = (DefaultTableModel) produc.getTbl_rep_producto().getModel();
        modelo.setNumRows(0);
        
        List<productos> lista = modelo1.mostrarProductos();
        
        lista.stream().forEach(p -> {
        String[] persona = {p.getCodigo(), p.getNombre(), p.getDescripcion(), String.valueOf(p.getExistencias()),
        String.valueOf(p.getE_min()), String.valueOf(p.getE_max()), String.valueOf(p.getPrecio()), p.getCod_proveedor(), p.getCategoria()};
        modelo.addRow(persona);
        });

    }
    ///////////////////////     TABLA    CON AGUJA  ////////////////////////////
    public static void cargaLista(String aguja) {
        //Acciones necesarios para extraer los datos MODELO Y Mostrar en la Vista
        DefaultTableModel tblModel; //Estructura JTbable
        tblModel = (DefaultTableModel) produc.getTbl_rep_producto().getModel();
        tblModel.setNumRows(0);
        List<productos> lista = modelo1.mostrarDatos(aguja);
        lista.stream().forEach(p -> {
            String[] persona = {p.getCodigo(), p.getNombre(), p.getDescripcion(), String.valueOf(p.getExistencias()),
                String.valueOf(p.getE_min()), String.valueOf(p.getE_max()), String.valueOf(p.getPrecio()), p.getCod_proveedor(), p.getCategoria()};
            tblModel.addRow(persona);
        });

    }
    ////////////////////////    CREAR     PRODUCTO   ///////////////////////////
    public static void grabaProducto() {
        String codigo = produc.getTxt_cod().getText();
        String nombre = produc.getTxt_nombre().getText();
        String descripcion = produc.getTxt_descripcion().getText();
        String existencia = produc.getExistencia().getValue().toString();
        String e_minima = produc.getExi_min().getValue().toString();
        String e_maxima = produc.getExi_max().getValue().toString();
        String precio = produc.getPrecio().getValue().toString();
        String categoria = produc.getTxt_categoria().getSelectedItem().toString();
        String codigoproveedor = produc.getCbx_codProvee().getSelectedItem().toString();
        
        modelo1.setCodigo(codigo);
        modelo1.setNombre(nombre);
        modelo1.setDescripcion(descripcion);
        modelo1.setExistencias(Integer.parseInt(existencia));
        modelo1.setE_min(Integer.parseInt(e_minima));
        modelo1.setE_max(Integer.parseInt(e_maxima));
        modelo1.setPrecio(Double.parseDouble(precio));
        modelo1.setCategoria(categoria);
        modelo1.setCod_proveedor(codigoproveedor);
        
        if (modelo1.insertar()) {
            JOptionPane.showMessageDialog(produc, "Producto Creado Satisfactoriamente");
            produc.getDlg_Productos().setVisible(false);
            cargaLista();
        } else {
            JOptionPane.showMessageDialog(produc, "ERROR");
        }
    }
    ///////////////////   EDITAR   PRODUCTO   ///////////////////////////////////
    public static void editarProducto() {
        String codigo = produc.getTxt_cod().getText();
        String nombre = produc.getTxt_nombre().getText();
        String descripcion = produc.getTxt_descripcion().getText();
        String existencia = produc.getExistencia().getValue().toString();
        String e_minima = produc.getExi_min().getValue().toString();
        String e_maxima = produc.getExi_max().getValue().toString();
        String precio = produc.getPrecio().getValue().toString();
        String categoria = produc.getTxt_categoria().getSelectedItem().toString();
        String codigoproveedor = produc.getCbx_codProvee().getSelectedItem().toString();
        
         
        modelo1.setNombre(nombre);
        modelo1.setDescripcion(descripcion);
        modelo1.setExistencias(Integer.parseInt(existencia));
        modelo1.setE_min(Integer.parseInt(e_minima));
        modelo1.setE_max(Integer.parseInt(e_maxima));
        modelo1.setPrecio(Double.parseDouble(precio));
        modelo1.setCategoria(categoria);
        modelo1.setCod_proveedor(codigoproveedor);

        if (modelo1.modificar(codigo)) {
            JOptionPane.showMessageDialog(produc, "Producto Creado Satisfactoriamente");
            produc.getDlg_Productos().setVisible(false);
            cargaLista();
        } else {
            JOptionPane.showMessageDialog(produc, "ERROR");
        }
    }
    ///////////////////  ELIMINAR    PRODUCTO   ////////////////////////////////
    public static void EliminarProducto() {
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
    /////////////////  ABRIRI   EL EDIDAR  /////////////////////////////////////
    public static void modificarProducto() {
        int fila = produc.getTbl_rep_producto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(produc, "PRIMERO SELECCIONE UN PRODUCTO", "ESTEFANIA MUNOZ", 2);
        }else {
            String id = String.valueOf(produc.getTbl_rep_producto().getValueAt(fila, 0));
            for (int i = 0; i <prodi.size(); i++) {
                if(prodi.get(i).getCodigo().equalsIgnoreCase(id)){
                    produc.getTxt_cod().setText(id);
                    produc.getTxt_nombre().setText(prodi.get(i).getNombre());
                    produc.getTxt_descripcion().setText(prodi.get(i).getDescripcion());
                }
            }            
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){produc.setVisible(true);}
    public static void cerrar(){produc.setVisible(false);}
    public static void salir(){
        cerrar();
        ControladorCajero ccj = new ControladorCajero(ingre);
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    protected void buscarcedula(){        
        ////////////////////
        for (int i = 0; i < per.size(); i++) {
        String codigo=per.get(i).getCodigo();
        produc.getCbx_codProvee().insertItemAt(codigo, i);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////   GENERADOR DE CODIGO  ///////////////////////
    public static void generacodi(){
       String co="";
       int b=0;
       int  ca=0;
       /////////////////////////////////////////////////////////////////////////
       do{         
       Random r = new Random();
       b=r.nextInt(000000001+999999999)+999999999;
       /////////////////////////////////////////////
       co=Integer.toString(b);
       /////////////////////////////////////////////
       /////////////////////////////////////////////////////////////////////////
       if(comprobarcodigo(co)==false){
       ca+=1;  
       }else{
       ca+=0; 
       }
       //////////////////
       }while(ca!=0);
       //////////////
       produc.getTxt_cod().setText(co);
    }
    ///////  COMPROVADORES /////////////////////////////////////////////////////
    ///////////////      COMPRBAR QUE EL CODIGO  SEA ÚNICA      ////////////////
    public static boolean comprobarcodigo(String ide){
        int aa=0;
        for (int i = 0; i < per.size(); i++) {
            if(per.get(i).getCodigo().equalsIgnoreCase(ide)){
                
            aa=+1;   
            }else{
            aa=+0;   
            }}
        if(aa==1){
            JOptionPane.showMessageDialog(null,"El coigo: "+ide+" \nYa está ocupado");
            return false;
        }else{
            return true;
        }
    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//