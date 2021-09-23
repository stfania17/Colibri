// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CONECCIÓN_SQL.Dbproductos;
import VISTA.Ingreso;
import VISTA.Producto;

public class ControladorCajero {
    public static Ingreso caje = new Ingreso();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorCajero(Ingreso caje){
        this.caje=caje;
        caje.setTitle("CAJERO");
        caje.setVisible(true);   
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public static void iniciarocntrol(){
        caje.getBut_Salir().addActionListener(l->salir());
        caje.getBut_Rep_Proveedor().addActionListener(l->reporteproveedor());
        //caje.getBut_Rep_Producto().addActionListener(1->reporteproducto());
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){caje.setVisible(true);}
    public static void cerrar(){caje.setVisible(false);}
    public static void salir(){
        cerrar();
        ControladorRecepcion.mostrar();
        ControladorRecepcion.iniciarocntrol();
    }
        public static void reporteproveedor(){
        cerrar();
        ControlProveedor_REPORTE.mostrar();
        ControlProveedor_REPORTE.iniciarcontrol();
        
    }
    
        public void reporteproducto(){
            Dbproductos modelo =new Dbproductos();      
            Producto produc = new Producto();
            ControlProducto control= new ControlProducto(produc,modelo);
            control.iniciaControl();
        }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//