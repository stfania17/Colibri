// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Vista_login;
import VISTA.Vista_portada;
import VISTA.Vista_recepcion;

public class ControladorPortada {
    ////////////////////////////////////////////////////////////////////////////
    public static Vista_portada portada = new Vista_portada();
    public static Vista_login log = new Vista_login();
    public static Vista_recepcion rec = new Vista_recepcion();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorPortada(Vista_portada porta) {
        this.portada=porta;
        mostrar();
        porta.setTitle("PORTADA");
        iniciarcontrol();
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void iniciarcontrol(){
        portada.getEntrar().addActionListener(l->entrada());
        portada.getSALIDA().addActionListener(l->salir());
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){portada.setVisible(true);}
    public static void cerrar(){portada.setVisible(false);}
    public static void entrada(){
        cerrar();
        ControladorRecepcion cr = new ControladorRecepcion(rec);
    }
    public static void salir(){
        portada.dispose();
    }
    ////////////////////////////////////////////////////////////////////////////
//    public ControladorPortada(Portada porta){
//        this.porta=porta;
//        porta.setVisible(true);
//    }
//    public void abrirlogin(Portada porta,Login log){
//        this.log=log;
//        log.setVisible(true);
//    }
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//