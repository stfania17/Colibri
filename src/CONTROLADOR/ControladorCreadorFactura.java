// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;
 
import MODELO.carrito;
import VISTA.FACTURA_FORMULARIO;
import VISTA.MenuCliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControladorCreadorFactura {
    ///////////////////////   VISTAS    ////////////////////////////////////////
    public static FACTURA_FORMULARIO ff = new FACTURA_FORMULARIO();
    public static MenuCliente mc = new MenuCliente();
    ///////////////////////  VARIABLES    ////////////////////////////////////// 
    public static DefaultTableModel modelo;
    ////////////////////////////////////////////////////////////////////////////
    public static ArrayList<carrito> mateos=new ArrayList<carrito>();
    ////////////////////////////////////////////////////////////////////////////
    public  ControladorCreadorFactura(FACTURA_FORMULARIO ff){
        mateos=ControlMenu.mateo;
        this.ff=ff;
        mostrar();
        inicarcontrol();
        cargartablacarrito(mateos);
    }
    ///////////////////      PUERTAS       /////////////////////////////////////
    public static void mostrar(){ff.setVisible(true);}
    public static void cerrar(){ff.setVisible(false);}
    public static void salir(){
        cerrar();
        ControlMenu ccj = new ControlMenu(mc );
    } 
    ////////////////////////////////////////////////////////////////////////////
    public void inicarcontrol(){
        
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void cargartablacarrito(ArrayList<carrito> mateos){
    modelo=(DefaultTableModel)ff.tablacarrito.getModel();
    modelo.setRowCount(0);
    
    for (int i = 0; i < mateos.size(); i++) {
    Object [] fila ={mateos.get(i).getCodigo() ,mateos.get(i).getNombre() , mateos.get(i).getCantidad(),mateos.get(i).getPrecio(),mateos.get(i).getPrecio_final()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }}  
    ////////////////////////////////////////////////////////////////////////////
    
    
    
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//