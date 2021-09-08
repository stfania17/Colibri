// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Login;
import VISTA.Portada;


public class ControladorPortada {
    ////////////////////////////////////////////////////////////////////////////
    public static Portada portada = new Portada();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorPortada(Portada porta) {
        this.portada=porta;
        porta.setTitle("PORTADA");
        porta.setVisible(true);
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
        ControladorLogin.mostrar();
        ControladorLogin.iniciarcontrol();
    }
    public static void salir(){
        portada.dispose();
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
//    
//    public ControladorPortada(Portada porta){
//        this.porta=porta;
//        porta.setVisible(true);
//    }
//    
//    
//    
//    public void abrirlogin(Portada porta,Login log){
//        
//        this.log=log;
//        log.setVisible(true);
//        
//    }
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//