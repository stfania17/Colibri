// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;
 
import VISTA.Recepcion;


public class ControladorRecepcion {
    public static Recepcion rec = new Recepcion();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorRecepcion(Recepcion rec) {
        this.rec = rec;
        rec.setTitle("MENU DE PRODUCTOS");
        rec.setVisible(true);
        iniciarocntrol();
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void iniciarocntrol(){
        rec.getCajeros().addActionListener(l->ingresacajero());
        rec.getClientes().addActionListener(l->ingresacliente());
        rec.getSalir().addActionListener(l->regresar());
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){rec.setVisible(true);}
    public static void cerrar(){rec.setVisible(false);}
    public static void regresar(){
        cerrar();
        ControladorLogin.mostrar();
        ControladorLogin.iniciarcontrol();
    }
    public static void ingresacajero(){
        cerrar();
        ControladorCajero.mostrar();
        ControladorCajero.iniciarocntrol();
    }
    public static void ingresacliente(){
        cerrar();
        ControlMenu.mostrar();
        ControlMenu.iniciaControl();
    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//