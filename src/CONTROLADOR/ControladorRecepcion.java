// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Ingreso;
import VISTA.Login;
import VISTA.MenuCliente;
import VISTA.Portada;
import VISTA.Recepcion;
import javax.swing.JOptionPane;

public class ControladorRecepcion {
    ///////////////////////   DATOS A FUNCIONAR ////////////////////////////////
    public static Recepcion rec = new Recepcion();
    public static MenuCliente mc=new MenuCliente();
    public static Ingreso ig = new Ingreso();
    public static Login log = new Login();
    public static Portada port = new Portada();
    ////////////  BREQUER            ///////////////////////////////////////////
    public ControladorRecepcion(Recepcion rec) {
        this.rec = rec;
        mostrar();
        rec.setTitle("RECEPCION");
        iniciarocntrol();
    }
    ////////////////////   CEREBRO       ///////////////////////////////////////
    public static void iniciarocntrol(){
        rec.getCajeros().addActionListener(l->abrirlogin());  /// abrir login para entrar al sistema cajero
        rec.getClientes().addActionListener(l->ingresacliente());  // Abrir zona de clientes
        rec.getSalir().addActionListener(l->regresar());  /// SALIR PARA PRIMER LOGIN.
        //////////////  PARTES DEL SEGUNDO LOGIN DE SEGURIDAD //////////////////
    }
    //////////////   PUERTAS   /////////////////////////////////////////////////
    public static void mostrar(){rec.setVisible(true);}
    public static void cerrar(){rec.setVisible(false);}
    public static void regresar(){
        cerrar();
        ControladorPortada cl = new ControladorPortada(port);
    }
    ////////////////////////  SECCIÓN   CLIENTE  ///////////////////////////////
    public static void ingresacliente(){
        cerrar();
        ControlMenu cm=new ControlMenu(mc);
    }
    //////////////////  SECCION CAJERO         /////////////////////////////////
    public static void ingresacajero(){
        cerrar();
        ControladorCajero cc = new ControladorCajero(ig);
    }
    ////////////////////   PARA EL LOGIN SEGUNDO ///////////////////////////////
    public static void abrirlogin(){
        cerrar();
        ControladorLogin con = new ControladorLogin(log);  
    }
    /////////////////////// SEGUNDO LOGIN DE SEGURIDAD /////////////////////////
    ////////////////////////////////////////////////////////////////////////////   
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//