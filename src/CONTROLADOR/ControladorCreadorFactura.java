// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;
 
import CLASES.carrito;
import CLASES.clientes;
import CLASES.detalle_factura;
import CLASES.encabezado_factura;
import CLASES.productos;
import CONECCIÓN_SQL.Modelo_cabeza_factura;
import CONECCIÓN_SQL.SQConnect;
import CONECCIÓN_SQL.modelo_clientes;
import CONECCIÓN_SQL.modelo_detalle_factura;
import CONECCIÓN_SQL.modelo_productos;
import VISTA.Vista_factura_formulario;
import VISTA.Vista_menu_cliente;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ControladorCreadorFactura {
    ///////////////////////   VISTAS    ////////////////////////////////////////
    public static Vista_factura_formulario ff = new Vista_factura_formulario();
    public static Vista_menu_cliente mc = new Vista_menu_cliente();
    ///////////////////////  VARIABLES    ////////////////////////////////////// 
    public static DefaultTableModel modelo_tabla;
    //////////////////////   SQLss           ///////////////////////////////////
    public static modelo_productos modelo_produ = new modelo_productos();
    public static modelo_clientes modelocliente = new modelo_clientes();
    public static Modelo_cabeza_factura modeloafactura = new Modelo_cabeza_factura();
    public static modelo_detalle_factura modelodetalle = new modelo_detalle_factura();
    ////////////////////       ARRAYLIST     ///////////////////////////////////
    public static ArrayList<carrito> mateos=new ArrayList<carrito>(); 
    public static List<encabezado_factura> listacabeza = modeloafactura.mostrarDatos();  
    public static List<detalle_factura> listadetalle = modelodetalle.mostrarDatos(); 
    public static List<clientes> listaclientes = modelocliente.mostrarDatos();
    public static List<productos> listaproductos = modelo_produ.mostrarProductos();
    ////////////////////////////////////////////////////////////////////////////
    public  ControladorCreadorFactura(Vista_factura_formulario ff){
        mateos=ControlMenu.mateo;
        this.ff=ff;
        mostrar();
        inicarcontrol();
        
        cargartablacarrito(mateos);
        
        cargarfechaycosigo();
        generacodigofactura();
    }
    ///////////////////      PUERTAS       /////////////////////////////////////
    public static void mostrar(){ff.setVisible(true);}
    public static void cerrar(){ff.setVisible(false);}
    public static void salir(){
        cerrar();
        ff.getCodigofactura().setText("");
        ff.getFechafactura().setText("");
        ff.getCodigodelcliente().setText("");
        ff.getJtbuscacliente().setText("");
        
        ControlMenu ccj = new ControlMenu(mc );
    } 
    ////////////////////////////////////////////////////////////////////////////
    public void inicarcontrol(){
        ff.getIngresarcliente().addActionListener(l->abrircreador());
        ff.getCancelarventa().addActionListener(l->cerrar());
        ff.getCrearcliente().addActionListener(l->ingresarproveedor());
        ff.getBuscarcliente().addActionListener(l->buscacliente());
        ff.getGenerarcodigocliente().addActionListener(l->generacodigocliente());
        
        ff.getjButton2().addActionListener(l->{
            try {
                creacabeza();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCreadorFactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControladorCreadorFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ff.getJasparin().addActionListener(l->{
            try {
                abrirjasper();
            } catch (JRException ex) {
                Logger.getLogger(ControladorCreadorFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void abrircreador(){
        ff.getIngresocliente().setVisible(true);
        ff.getIngresocliente().setSize(865, 580);
    }
    ////////////////////////////////////////////////////////////////////////////
    public void creacabeza() throws SQLException, JRException{
        LocalDate local = LocalDate.now();
        Date sqlDate = null;
        sqlDate = Date.valueOf(local);
        
        modeloafactura.setCodigo(ff.getCodigofactura().getText());
        modeloafactura.setFecha(sqlDate);
        modeloafactura.setCod_cliente(queconsumidor());
        
        if(modeloafactura.insertar()){
            creardetalle();
            mermarcantidadoficial();
            JOptionPane.showMessageDialog(ff, "FACTURA CREADA");
        } else {
            JOptionPane.showMessageDialog(ff, "ERROR EN CABEZA");
        }   
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void creardetalle(){
        int suma=0;
        
        for (int i = 0; i <mateos.size(); i++) {
            modelodetalle.setCodigo(generacodigodetalle());
            modelodetalle.setCod_encabezado(ff.getCodigofactura().getText());
            modelodetalle.setCod_producto(mateos.get(i).getCodigo());
            modelodetalle.setCantidad(mateos.get(i).getCantidad());
            modelodetalle.setPrecio_final(sumatotal());
            
            if (modelodetalle.insertar()) {
                
            } else {  
            JOptionPane.showMessageDialog(ff, "ERROR EN DETALLE"); 
            }
        }
    }
    
    public static double sumatotal(){
        double suma=0;
        for (int i = 0; i <mateos.size(); i++) {
            suma=suma+mateos.get(i).getPrecio_final();
        }
        return suma;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void ingresarproveedor(){       
        //////////////////   SI TODO VA BIEN ENTRA ESTO  ///////////////////////
        if(ff.getCedula().getText().equalsIgnoreCase("")||
        ff.getCodigocliente().getText().equalsIgnoreCase("")||
        ff.getApellido().getText().equalsIgnoreCase("")||
        ff.getNombre().getText().equalsIgnoreCase("")||
        ff.getDireccion().getText().equalsIgnoreCase("")||
        ff.getCorreo().getText().equalsIgnoreCase("")||
        ff.getTelefoo().getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"NO HAY DATOS");
        }else{
            
        String cedula=ff.getCedula().getText();
        String codigo=ff.getCodigocliente().getText();
        String apellido=ff.getApellido().getText();
        String nombre=ff.getNombre().getText();
        String direccion=ff.getDireccion().getText();
        String correo=ff.getCorreo().getText();
        String telefono=ff.getTelefoo().getText();
        
        Instant instant = ff.getDtcFechaNacimiento().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fecha = Date.valueOf(zdt.toLocalDate());    
            
        modelocliente.setCodigo(codigo);
        modelocliente.setCedula(cedula);
        modelocliente.setNombre(nombre);
        modelocliente.setApellido(apellido);
        modelocliente.setDireccion(direccion);
        modelocliente.setTelefono(telefono);
        modelocliente.setCorreo(correo);
        modelocliente.setFechanacimiento(fecha);
        
        if (modelocliente.insertar()) {
            JOptionPane.showMessageDialog(ff, "Cliente Creado Satisfactoriamente");
            ff.getIngresocliente().setVisible(false);
            ff.getCodigodelcliente().setText(codigo);
        } else {
            JOptionPane.showMessageDialog(ff, "ERROR");
        }
        }
    
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////   BUSCAR CLIENTE PREVIAMENTE  CREADO  /////////////////////
    public static void  buscacliente(){
        String codigo=ff.getJtbuscacliente().getText();
        
        for (int i = 0; i < listaclientes.size(); i++) {
            if(listaclientes.get(i).getCedula().equalsIgnoreCase(codigo)){
                ff.getCodigodelcliente().setText(listaclientes.get(i).getCodigo()); 
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
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
    modelo_tabla=(DefaultTableModel)ff.tablacarrito.getModel();
    modelo_tabla.setRowCount(0);
    
    for (int i = 0; i < mateos.size(); i++) {
    Object [] fila ={mateos.get(i).getCodigo() ,mateos.get(i).getNombre() , mateos.get(i).getCantidad(),mateos.get(i).getPrecio(),mateos.get(i).getPrecio_final()};
    modelo_tabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }}  
    ////////////////////////////////////////////////////////////////////////////
        /////////////////////////////   GENERADOR DE CODIGO  ///////////////////////
    public static void generacodigofactura(){
       String co="";
       int b=0;
       int  ca=0;
       /////////////////////////////////////////////////////////////////////////
       do{         
       Random r = new Random();
       b=r.nextInt(000000001+999999999)+999999999;
       /////////////////////////////////////////////
       co=Integer.toString(b);
       /////////////////////////////////////////////
       /////////////////////////////////////////////////////////////////////////
       if(comprobarcodigo(co)==false){
       ca+=1;  
       }else{
       ca+=0; 
       }
       //////////////////
       }while(ca!=0);
       //////////////
       ff.getCodigofactura().setText(co);
    }
    public static boolean comprobarcodigo(String ide){
        int aa=0;
        for (int i = 0; i < listacabeza.size(); i++) {
            if(listacabeza.get(i).getCodigo().equalsIgnoreCase(ide)){
                
            aa=+1;   
            }else{
            aa=+0;   
            }}
        if(aa==1){
            return false;
        }else{
            return true;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void generacodigocliente(){
       String co="";
       int b=0;
       int  ca=0;
       /////////////////////////////////////////////////////////////////////////
       do{         
       Random r = new Random();
       b=r.nextInt(000000001+999999999)+999999999;
       /////////////////////////////////////////////
       co=Integer.toString(b);
       /////////////////////////////////////////////
       /////////////////////////////////////////////////////////////////////////
       if(comprobarcodigocliente(co)==false){
       ca+=1;  
       }else{
       ca+=0; 
       }
       //////////////////
       }while(ca!=0);
       //////////////
       ff.getCodigocliente().setText(co);
    }
    public static boolean comprobarcodigocliente(String ide){
        int aa=0;
        for (int i = 0; i < listaclientes.size(); i++) {
            if(listaclientes.get(i).getCodigo().equalsIgnoreCase(ide)){
                
            aa=+1;   
            }else{
            aa=+0;   
            }}
        if(aa==1){
            return false;
        }else{
            return true;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static String generacodigodetalle(){
       String co="";
       int b=0;
       int  ca=0;
       /////////////////////////////////////////////////////////////////////////
       do{         
       Random r = new Random();
       b=r.nextInt(000000001+999999999)+999999999;
       /////////////////////////////////////////////
       co=Integer.toString(b);
       /////////////////////////////////////////////
       /////////////////////////////////////////////////////////////////////////
       if(comprobarcodigodetalle(co)==false){
       ca+=1;  
       }else{
       ca+=0; 
       }
       //////////////////
       }while(ca!=0);
       //////////////
       return co;
    }
    public static boolean comprobarcodigodetalle(String ide){
        int aa=0;
        for (int i = 0; i < listadetalle.size(); i++) {
            if(listadetalle.get(i).getCodigo().equalsIgnoreCase(ide)){
                
            aa=+1;   
            }else{
            aa=+0;   
            }}
        if(aa==1){
            return false;
        }else{
            return true;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mermarcantidadoficial() throws SQLException{
        for (int i = 0; i < mateos.size(); i++) {
            int ca=mateos.get(i).getCantidad();
            String co=mateos.get(i).getCodigo();
            
            for (int j = 0; j < listaproductos.size(); j++) {
            
                if(listaproductos.get(j).getCodigo().equalsIgnoreCase(co)){
                   int ce=listaproductos.get(j).getExistencias();
                   ce=ce-ca;
                   
                   Image ho=listaproductos.get(j).getFoto();
                   /////////////////////////////////////////////////////////////
                   modelo_produ.setCodigo(listaproductos.get(j).getCodigo());
                   modelo_produ.setNombre(listaproductos.get(j).getNombre());
                   modelo_produ.setDescripcion(listaproductos.get(j).getDescripcion());
        
                   modelo_produ.setExistencias(ce);
                   
                   modelo_produ.setE_max(listaproductos.get(j).getE_max());
                   modelo_produ.setE_min(listaproductos.get(j).getE_min());
                   modelo_produ.setCategoria(listaproductos.get(j).getCategoria());
                   modelo_produ.setPrecio(listaproductos.get(j).getPrecio());
                   modelo_produ.setCod_proveedor(listaproductos.get(j).getCod_proveedor());
                   
                   modelo_produ.setFoto(ho);
                   
                   if(modelo_produ.modificar(co)){
                   
                       mateos.get(i).setCantidad(ce);
                   
                   } else {
                   JOptionPane.showMessageDialog(ff, "ERROR");
                   }
                }
                
            }
            
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void abrirjasper() throws JRException{
        SQConnect  hola = new SQConnect();
        
        try {
        JasperReport jr=(JasperReport)JRLoader.loadObject(getClass().getResource("/ARCHIVOS/COLIBRI.jasper"));
        
        Map<String, Object> parametro = new HashMap<String, Object>();
        String aguj="";
           
        aguj=ff.getCodigofactura().getText();

        parametro.put("aguja","%"+aguj+"%");
        parametro.put("parame", "iconocolibrie.jpg");        
        //src\\ICONOS\\
        JasperPrint jp = JasperFillManager.fillReport(jr,parametro,hola.getCon());
        JasperViewer jv = new JasperViewer(jp); 
        jv.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(ControladorCreadorFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static String queconsumidor(){
        String cedula="";
        if(ff.getBcfinal().isSelected()){
        cedula="0000000000"; 
        }else{
        
        cedula=ff.getJtbuscacliente().getText();
        }
        return cedula;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//