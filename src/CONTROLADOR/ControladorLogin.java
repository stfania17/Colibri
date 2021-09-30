// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Login;
import VISTA.Portada;
import VISTA.Recepcion;
import javax.swing.JOptionPane;


public class ControladorLogin {
    ////////////////////////////////////////////////////////////////////////////
    public static Login log = new Login();
    public static Portada portada = new Portada();
    public static Recepcion rec = new Recepcion();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorLogin(Login log){
        this.log=log;
        mostrar();
        iniciarcontrol();
        log.setTitle("LOGGIN");
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void iniciarcontrol(){
        log.getIngresar().addActionListener(l->comprovar());
        log.getSalir().addActionListener(l->regresar());
        log.getVisual().addActionListener(l->mostra());
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){log.setVisible(true);}
    public static void cerrar(){log.setVisible(false);}
    public static void regresar(){
        log.getMusuario().setText("");
        log.getMcontraseña().setText("");
        cerrar();
        ControladorPortada cp = new ControladorPortada(portada);
    }
    public static void ingresar(){
        log.getMusuario().setText("");
        log.getMcontraseña().setText("");
        cerrar();
        ControladorRecepcion cr = new ControladorRecepcion(rec);
    }
    //////////////////////////   COMPROBAR CONTRASEÑA   ////////////////////////
    public static void comprovar(){
        String usuario=log.getMusuario().getText();
        String contraseña=log.getMcontraseña().getText();
        
        if(usuario.equalsIgnoreCase("MASTER") && contraseña.equalsIgnoreCase("1234")){
            ingresar();
        }else if(!usuario.equalsIgnoreCase("MASTER") || !contraseña.equalsIgnoreCase("1234")){
            JOptionPane.showMessageDialog(null,"INCORRECTO");
        }
    }
    public static void mostra(){
        String contraseña=log.getMcontraseña().getText();
        JOptionPane.showMessageDialog(null,""+contraseña);
    }
    ////////////////////////////////////////////////////////////////////////////
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//