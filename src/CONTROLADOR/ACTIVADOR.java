// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

 
import CONECCIÓN_SQL.Dbproveedores;
import CONECCIÓN_SQL.SQConnect;
import MODELO.persona;
import MODELO.proveedores;
import VISTA.MenuCliente;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class ACTIVADOR {
    
    public static void main(String[] args) {
        
        MenuCliente menu=new MenuCliente();
        ControlMenu control=new ControlMenu(menu);
        control.iniciaControl();   
        
//    SQConnect pg= new SQConnect();
//    Dbproveedores dbu = new Dbproveedores();
//    List<proveedores> plistas = dbu.mostrarDatos();  
//    ArrayList<proveedores> plista = new ArrayList<proveedores>();  
//    Date dia = new Date();
//     
//    
//    proveedores messi = new proveedores("0987654321","1111122222","1234567890","Alvarez","Yupangui","0987654321","oi",dia);
//    plista.add(messi);
//    System.out.println(plista.get(0));
    
 
//        /////////////////////////////////////////
//        dbu.setCedula(messi.getCedula());
//        dbu.setApellido(messi.getApellido());
//        dbu.setNombre(messi.getNombre());
//        dbu.setTelefono(messi.getTelefono());
//        dbu.setDireccion(messi.getDireccion());
//        dbu.setFechanacimiento(messi.getFechanacimiento());
//        
//        
//        /////////////////////////////////////////
//        if(dbu.insertar()){
//        JOptionPane.showMessageDialog(null,"Datos Guardados.");
//        
//        }else{
//            JOptionPane.showMessageDialog(null,"Error al Guardar.");
//        } 
        
    }
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//