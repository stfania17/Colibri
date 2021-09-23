// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;
 
import VISTA.Recepcion;
import javax.swing.JOptionPane;


public class ControladorRecepcion {
    public static Recepcion rec = new Recepcion();
    ////////////////////////////////////////////////////////////////////////////
    public ControladorRecepcion(Recepcion rec) {
        this.rec = rec;
        rec.setTitle("RECEPCION");
        rec.setVisible(true);
        iniciarocntrol();
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void iniciarocntrol(){
        rec.getCajeros().addActionListener(l->abrirlogin());
        rec.getClientes().addActionListener(l->ingresacliente());
        rec.getSalir().addActionListener(l->regresar());
        rec.getIngresar().addActionListener(l->comprovar());
        rec.getSalir1().addActionListener(l->cerralogin());
        rec.getVisual().addActionListener(l->vercontraseña());
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
    
    /*public void ingresocajero(){
        cerrar();
        ControladorCajero cajero=new ControladorCajero();
        cajero.iniciarControl();
    }*/
    
    public static void ingresacliente(){
        cerrar();
        
        ControlMenu.mostrar();
        ControlMenu.iniciaControl();
    }
    public static void abrirlogin(){
      rec.getjDialog1().setSize(500,300);
      rec.getjDialog1().setVisible(true);  
    }
    public static void vercontraseña(){
        JOptionPane.showMessageDialog(null,rec.getMcontraseña().getText());
    }
    public static void cerralogin(){
        rec.getjDialog1().setVisible(false);
        rec.getMcontraseña().setText("");
        rec.getMusuario().setText("");
    }
    public static void comprovar(){
        
        String usuario=rec.getMusuario().getText();
        String contraseña=rec.getMcontraseña().getText();
        
        if(usuario.equalsIgnoreCase("MASTER") && contraseña.equalsIgnoreCase("1234")){
            rec.getjDialog1().setVisible(false);  
            rec.getMcontraseña().setText("");
            rec.getMusuario().setText("");
            ingresacajero();
        }else if(!usuario.equalsIgnoreCase("MASTER") || !contraseña.equalsIgnoreCase("1234")){
            JOptionPane.showMessageDialog(null,"INCORRECTO");
        }
    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//