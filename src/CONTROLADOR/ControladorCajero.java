// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CONECCIÓN_SQL.Dbproductos;
import VISTA.Ingreso;
import VISTA.Producto;
import VISTA.Proveedor;
import VISTA.Recepcion;
import javax.swing.JOptionPane;

public class ControladorCajero {
    ///////////////  INTERFACESS   /////////////////////////////////////////////
    public static Ingreso caje = new Ingreso();
    public static Recepcion rec = new Recepcion();
    public static Proveedor prov = new Proveedor();
    public static Producto prod = new Producto();
    //////////////////   MODELOS   /////////////////////////////////////////////
    public static Dbproductos modelo1;
    ////////////////////////////////////////////////////////////////////////////
    public ControladorCajero(Ingreso caje){
        this.caje=caje;
        caje.setSize(500, 500);
        mostrar();
        iniciarcontrol();
    }
    ///////////////////////////   CEREBRO          /////////////////////////////
    public static void iniciarcontrol(){
        caje.getBut_Salir().addActionListener(l->salir());
        caje.getBut_Rep_Proveedor().addActionListener(l->reporteproveedor());   /// ABRIR  PROVEEDOR
        caje.getBut_Rep_Producto().addActionListener(l->asuntoproductos());     /// ABRIR  PRODUCTO
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){caje.setVisible(true);}
    public static void cerrar(){caje.setVisible(false);}
    public static void salir(){
        cerrar();
        ControladorRecepcion cr = new ControladorRecepcion(rec);
    }
    ////////////////      LLEVAME A PROVEEDORES     ////////////////////////////
    public static void reporteproveedor(){
        cerrar();
        ControlProveedor_REPORTE cpr = new ControlProveedor_REPORTE(prov);
    }
    ////////////////////   LLEVAME A   CLIENTES  ///////////////////////////////
    public static void asuntoproductos(){
        cerrar(); //HASTA ACA ESTÁ BIEN
        ControlProducto cpp = new ControlProducto(prod);        
    }    
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//