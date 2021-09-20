// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

 
import CONECCIÓN_SQL.Dbproductos;
import CONECCIÓN_SQL.Dbproveedores;
import CONECCIÓN_SQL.SQConnect;
import MODELO.persona;
import MODELO.proveedores;
import VISTA.Cliente;
import VISTA.Login;
import VISTA.MenuCliente;
import VISTA.Portada;
import VISTA.Producto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class ACTIVADOR {
    
    public static void main(String[] args) {
        
        Portada porta=new Portada();
        
        ControladorPortada control=new ControladorPortada(porta);
        control.iniciarcontrol();
        /*Dbproductos modelo =new Dbproductos();      
        Producto produc = new Producto();       
        ControlProducto producto = new ControlProducto(produc, modelo);       
        producto.iniciaControl();*/

    }
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//