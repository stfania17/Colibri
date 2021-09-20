// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Ingreso;

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
        
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//