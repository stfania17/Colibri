// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;
 
import MODELO.carrito;
import VISTA.FACTURA_FORMULARIO;
import VISTA.MenuCliente;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControladorCreadorFactura {
    ///////////////////////   VISTAS    ////////////////////////////////////////
    public static FACTURA_FORMULARIO ff = new FACTURA_FORMULARIO();
    public static MenuCliente mc = new MenuCliente();
    ///////////////////////  VARIABLES    ////////////////////////////////////// 
    public static DefaultTableModel modelo;
    ////////////////////////////////////////////////////////////////////////////
    public static ArrayList<carrito> mateos=new ArrayList<carrito>();
    ////////////////////////////////////////////////////////////////////////////
    public  ControladorCreadorFactura(FACTURA_FORMULARIO ff){
        mateos=ControlMenu.mateo;
        this.ff=ff;
        mostrar();
        inicarcontrol();
        cargartablacarrito(mateos);
        cargarfechaycosigo();
    }
    ///////////////////      PUERTAS       /////////////////////////////////////
    public static void mostrar(){ff.setVisible(true);}
    public static void cerrar(){ff.setVisible(false);}
    public static void salir(){
        cerrar();
        ControlMenu ccj = new ControlMenu(mc );
    } 
    ////////////////////////////////////////////////////////////////////////////
    public void inicarcontrol(){
        ff.getCancelarventa().addActionListener(l->cerrar());
    }
    ////////////////////////////////////////////////////////////////////////////
    /////////////////   FUNCIONES AUTOMATICAS DE LA TABLA  /////////////////////
    public static void cargarfechaycosigo(){
        
        LocalDate local = LocalDate.now();
        Date sqlDate = null;
        sqlDate = Date.valueOf(local);
//        Instant instant = sqlDate.toInstant();
//        ZoneId zid = ZoneId.of("America/Guayaquil");
//        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
//        Date fecha = Date.valueOf(zdt.toLocalDate());
        
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        
        ff.getFechafactura().setText(""+formatofecha.format(sqlDate));
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargartablacarrito(ArrayList<carrito> mateos){
    modelo=(DefaultTableModel)ff.tablacarrito.getModel();
    modelo.setRowCount(0);
    
    for (int i = 0; i < mateos.size(); i++) {
    Object [] fila ={mateos.get(i).getCodigo() ,mateos.get(i).getNombre() , mateos.get(i).getCantidad(),mateos.get(i).getPrecio(),mateos.get(i).getPrecio_final()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }}  
    ////////////////////////////////////////////////////////////////////////////
    
    
    
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//