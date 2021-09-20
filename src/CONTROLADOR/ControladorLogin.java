// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Login;
import javax.swing.JOptionPane;


public class ControladorLogin {
    ////////////////////////////////////////////////////////////////////////////
    public static Login log = new Login();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorLogin(Login log){
        this.log=log;
        log.setTitle("LOGGIN");
        log.setVisible(true);
        iniciarcontrol();
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
        ControladorPortada.mostrar();
        ControladorPortada.iniciarcontrol();
    }
    public static void ingresar(){
        log.getMusuario().setText("");
        log.getMcontraseña().setText("");
        cerrar();
        ControladorRecepcion.mostrar();
        ControladorRecepcion.iniciarocntrol();
    }
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