// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Vista_ingreso;
import VISTA.Vista_login;
import VISTA.Vista_portada;
import VISTA.Vista_recepcion;
import javax.swing.JOptionPane;


public class ControladorLogin {
    ////////////////////////////////////////////////////////////////////////////
    public static Vista_login log = new Vista_login();
    public static Vista_portada portada = new Vista_portada();
    public static Vista_recepcion rec = new Vista_recepcion();
    public static Vista_ingreso ingre = new Vista_ingreso();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorLogin(Vista_login log){
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
        ControladorRecepcion cp = new ControladorRecepcion(rec);
    }
    public static void ingresar(){
        log.getMusuario().setText("");
        log.getMcontraseña().setText("");
        cerrar();
        ControladorCajero cc = new ControladorCajero(ingre);
    }
    //////////////////////////   COMPROBAR CONTRASEÑA   ////////////////////////
    public static void comprovar(){
        String usuario=log.getMusuario().getText();
        char[] contraseña=log.getMcontraseña().getPassword();
        System.out.println(contraseña);
        String passa="";
        
        for (int i = 0; i <contraseña.length; i++) {
            passa=passa+contraseña[i];
        }
        
        if(usuario.equalsIgnoreCase("MASTER") && passa.equals("1234")){
            ingresar();
        }else if(!usuario.equalsIgnoreCase("MASTER") || !passa.equals("1234")){
            JOptionPane.showMessageDialog(null,"INCORRECTO");
        }
    }
    public static void mostra(){
        char[] contraseña=log.getMcontraseña().getPassword();
        System.out.println(contraseña);
        String passa="";
        
        for (int i = 0; i <contraseña.length; i++) {
            passa=passa+contraseña[i];
        }
        JOptionPane.showMessageDialog(null,""+passa);
    }
    ////////////////////////////////////////////////////////////////////////////
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//