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
        rec.getIngresar().addActionListener(l->comprovar());   /// INGRESAR EN SEGUNDO LOGIN
        rec.getSalir1().addActionListener(l->cerralogin());   /// CERRAR EL SEGUNDO LOGINC
        rec.getVisual().addActionListener(l->vercontraseña());  /// VER CONTRASEÑA DEL SEGUNDO LOGIN
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
      rec.getjDialog1().setSize(400,250);
      rec.getjDialog1().setVisible(true);  
    }
    public static void cerralogin(){
        rec.getjDialog1().setVisible(false);
        rec.getMcontraseña().setText("");
        rec.getMusuario().setText("");
    }
    public static void vercontraseña(){
        JOptionPane.showMessageDialog(null,rec.getMcontraseña().getText());
    }
    /////////////////////// SEGUNDO LOGIN DE SEGURIDAD /////////////////////////
    public static void comprovar(){
        String usuario=rec.getMusuario().getText();
        String contraseña=rec.getMcontraseña().getText();
        /////////////////////                           ////////////////////////
        if(usuario.equalsIgnoreCase("MASTER") && contraseña.equalsIgnoreCase("1234")){
            rec.getjDialog1().setVisible(false);  
            rec.getMcontraseña().setText("");
            rec.getMusuario().setText("");
            ingresacajero();
        }else if(!usuario.equalsIgnoreCase("MASTER") || !contraseña.equalsIgnoreCase("1234")){
            JOptionPane.showMessageDialog(null,"INCORRECTO");
        }
    }
    ////////////////////////////////////////////////////////////////////////////   
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//