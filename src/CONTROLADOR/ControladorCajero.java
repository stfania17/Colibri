// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CONECCIÓN_SQL.modelo_productos;
import VISTA.Vista_cliente;
import VISTA.Vista_factura;
import VISTA.Vista_ingreso;
import VISTA.Vista_producto;
import VISTA.Vista_proveedor;
import VISTA.Vista_recepcion;
import javax.swing.JOptionPane;

public class ControladorCajero {
    ///////////////  INTERFACESS   /////////////////////////////////////////////
    public static Vista_ingreso caje = new Vista_ingreso();
    public static Vista_recepcion rec = new Vista_recepcion();
    public static Vista_proveedor prov = new Vista_proveedor();
    public static Vista_producto prod = new Vista_producto();
    public static Vista_factura vista_fac = new Vista_factura();
    public static Vista_cliente vista_cli = new Vista_cliente();
    //////////////////   MODELOS   /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public ControladorCajero(Vista_ingreso caje){
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
        
        caje.getBut_Rep_Factura().addActionListener(l->facturas());
        caje.getBut_Rep_Cliente().addActionListener(l->clientes());
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
    ////////////////////   LLVAME  A FACTURAS     //////////////////////////////
    public static void facturas(){
        cerrar();
        Control_reporte_factura cf = new Control_reporte_factura(vista_fac ); 
    }
    //////////////////////////    LLEVAME   A   CLIENTES   /////////////////////
    public static void clientes(){
        cerrar();
        ControlCliente ccl = new ControlCliente(vista_cli );
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//