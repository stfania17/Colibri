// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
//PROYECTO COLIBRI
package CONTROLADOR;

import CONECCIÓN_SQL.modelo_productos;
import CONECCIÓN_SQL.modelo_proveedores;
import CONECCIÓN_SQL.SQConnect;
import CLASES.persona;
import CLASES.productos;
import CLASES.proveedores;
import static CONTROLADOR.ControlProducto.modelo_produ;
import VISTA.Vista_cliente;
import VISTA.Vista_ingreso;
import VISTA.Vista_login;
import VISTA.Vista_menu_cliente;
import VISTA.Vista_portada;
import VISTA.Vista_producto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ACTIVADOR {
    
public static List<productos> prodi = modelo_produ.mostrarProductos(); 
    public static void main(String[] args) {

//        
//        Vista_portada porta=new Vista_portada();
//        ControladorPortada control=new ControladorPortada(porta);
      Vista_ingreso ingre = new Vista_ingreso();
      ControladorCajero cc = new ControladorCajero(ingre);
        /*Dbproductos modelo =new Dbproductos();      
        Vista_producto produc = new Vista_producto(); 

        ControlProducto producto = new ControlProducto(produc, modelo);       
        producto.iniciaControl();*/
//        //EJECUCUIN LOGIN
//        Vista_login login = new Vista_login();
//        ControladorLogin con = new ControladorLogin(login);
//        Vista_portada login = new Vista_portada();
//        ControladorPortada con = new ControladorPortada(login);
//
//        Vista_menu_cliente mc=new Vista_menu_cliente();
//        ControlMenu cm=new ControlMenu(mc);
    }
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
