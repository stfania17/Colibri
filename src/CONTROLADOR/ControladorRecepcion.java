// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Vista_ingreso;
import VISTA.Vista_login;
import VISTA.Vista_menu_cliente;
import VISTA.Vista_portada;
import VISTA.Vista_recepcion;
import javax.swing.JOptionPane;

public class ControladorRecepcion {
    ///////////////////////   DATOS A FUNCIONAR ////////////////////////////////
    public static Vista_recepcion rec = new Vista_recepcion();
    public static Vista_menu_cliente mc=new Vista_menu_cliente();
    public static Vista_ingreso ig = new Vista_ingreso();
    public static Vista_login log = new Vista_login();
    public static Vista_portada port = new Vista_portada();
    ////////////  BREQUER            ///////////////////////////////////////////
    public ControladorRecepcion(Vista_recepcion rec) {
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