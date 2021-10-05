// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CONECCIÓN_SQL.Dbproveedores;
import CONECCIÓN_SQL.SQConnect;
import MODELO.proveedores;
import VISTA.Ingreso;
import VISTA.Proveedor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class ControlProveedor_REPORTE {
    //////////////      CONECCIONES SQL     ////////////////////////////////////
    public static SQConnect pg= new SQConnect();
    public static Dbproveedores dbu = new Dbproveedores();
    ///////////////////////    ARRAYLISTS    ///////////////////////////////////
    public static List<proveedores> per = dbu.mostrarDatos();  
    ///////////////////  INTERFACES     ////////////////////////////////////////
    public static Proveedor prove;
    public static Ingreso ingre = new Ingreso();
    ////////////////////    VARIANTES   ////////////////////////////////////////
    public static int n;
    public static Date fecha = new Date();
    public static LocalDate hola = LocalDate.now();
    public static LocalDate chao = LocalDate.now();
    public static Period periodo;
    //////////////////////   TABLA   ///////////////////////////////////////////
    public static DefaultTableModel modelo;
    ////////////////////////////////////////////////////////////////////////////
    public ControlProveedor_REPORTE(Proveedor prove){
        this.prove=prove;
        mostrar();
        mostrartabla();
        iniciarcontrol();
    }
    //////////////////    CEREBRO    ///////////////////////////////////////////
    public static void iniciarcontrol() { 
        KeyListener ky = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyPressed(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String codei=prove.getTxt_consulta().getText();
            mostrartablaporvisor(codei);
            }
        };
        //////////////////////////////////////////////////////////////////////// 
//        ERROR ALFONSO CONSULTAR
//        Proveedor.getTxt_consulta.addKeyListener(ky);
        
        prove.getBut_consultar().addActionListener(l -> mostrartabla());        /// MOSTRAR TABLA
        prove.getBut_crear().addActionListener(l -> abrirngreso());             /// INGRESAR PROVEEDOR
        prove.getBut_modificar().addActionListener(l -> muestramodifica());     /// MUESTRA MODIFICAR 
        ////////////// ELIMINAR NO DISPONIBLE   //////////////
        prove.getBut_aceptar().addActionListener(l->modificarproveedores());    ///  MODIFICAR 
        prove.getBut_cancelar().addActionListener(l->cerrarcreador());          //CERRAR MODIFICADOR
        prove.getBut_atras().addActionListener(l->salir());                     /// SALIR DEL PROVEEDORbut_atras
        prove.getDLG_GENERARCODIGO().addActionListener(l->generacodi());        /// GENEREAR UN CODIGO
        prove.getDLG_CREAROTRO().addActionListener(l->ingresarproveedor());       /// CREAR PROVEEDOR  
        prove.getBut_limpiar().addActionListener(l->blanqueartabla());
        
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////      PUERTAS       /////////////////////////////////////
    public static void mostrar(){prove.setVisible(true);}
    public static void cerrar(){prove.setVisible(false);}
    public static void salir(){
        cerrar();
        ControladorCajero ccj = new ControladorCajero(ingre);
    } 
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////     CREAR UN NUEVO   PROVEEDOR    /////////////////////
    public static void abrirngreso(){
        Proveedor.getDlg_Proveedor().setSize(500 , 500);
        
        prove.getDLG_GENERARCODIGO().setEnabled(true);
        Proveedor.getDlg_Proveedor().setVisible(true);
        Proveedor.getBut_aceptar().setEnabled(false); 
    }
    ////////////////////     INGRESAR DATOS   SOBRE PROVEEDORES   //////////////
    public static void ingresarproveedor(){       
        if(comprobarcedula(prove.getTxt_id().getText())==true){
        //////////////////   SI TODO VA BIEN ENTRA ESTO  ///////////////////////
        if(//prove.getTxt_codifo().getText().equalsIgnoreCase("")||
        prove.getTxt_apellido().getText().equalsIgnoreCase("")||
        prove.getTxt_nombre().getText().equalsIgnoreCase("")||
        prove.getTxt_direccion().getText().equalsIgnoreCase("")||
        prove.getTxt_id().getText().equalsIgnoreCase("")||
        prove.getTxt_numcuenta().getText().equalsIgnoreCase("")||
        prove.getTxt_telefono().getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"NO HAY DATOS");
        }else{
        dbu.setCodigo(prove.getTxt_codifo().getText());
        dbu.setNumero_cuenta(prove.getTxt_numcuenta().getText());
        dbu.setCedula(prove.getTxt_id().getText());
        dbu.setApellido(prove.getTxt_apellido().getText());
        dbu.setNombre(prove.getTxt_nombre().getText());
        dbu.setTelefono(prove.getTxt_telefono().getText());
        dbu.setDireccion(prove.getTxt_direccion().getText());
        dbu.setFechanacimiento(prove.getDtcFechaNacimiento().getDate());
        /////////////////////////////////////////
        if(dbu.insertar()){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        }else{
        JOptionPane.showMessageDialog(null,"Error al Guardar.");
        }}
    }
    }
    ////////////////    SALIR DE CREADOR DE PROVEEROES  ////////////////////////
    public static void cerrarcreador(){
        prove.getDlg_Proveedor().setVisible(false);   
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////     MODIFICAR  PROVEEDORES   //////////////////////////////
    ////////////////////     MOSTRAR   EL  MOFICIADOR   ////////////////////////
    public static void muestramodifica(){
        prove.getDlg_Proveedor().setVisible(true);
        cargaratosparamodificar();
        prove.getDLG_GENERARCODIGO().setEnabled(false);
        
        prove.getDlg_Proveedor().setSize(600,600);   
        prove.getBut_aceptar().setEnabled(true);
        prove.getDLG_CREAROTRO().setEnabled(false);
    }   
    /////////////////  ABRIRI   EL EDIDAR  /////////////////////////////////////
    public static void cargaratosparamodificar(){
        int fila = prove.getTbl_rep_proveedor().getSelectedRow();
        if (fila == -1) {
        JOptionPane.showMessageDialog(prove, "PRIMERO SELECCIONE UN PROVEEDOR", "HHH", 2);
        }else {                                       //Tbl_rep_proveedor
            String codigo = String.valueOf(prove.getTbl_rep_proveedor().getValueAt(fila, 0));
            for (int i = 0; i <per.size(); i++) {
                if(per.get(i).getCodigo().equalsIgnoreCase(codigo)){
                    prove.getTxt_codifo().setText(codigo);
                    
                    prove.getTxt_id().setText(per.get(i).getCedula());
                    prove.getTxt_nombre().setText(per.get(i).getNombre());
                    prove.getTxt_apellido().setText(per.get(i).getApellido());
                    prove.getTxt_telefono().setText(per.get(i).getTelefono());
                    prove.getTxt_direccion().setText(per.get(i).getDireccion());
                    prove.getTxt_numcuenta().setText(per.get(i).getNumero_cuenta());
                }
            }            
        }
    }
    ////////////////     MODIFICAR  DATOS   SOBRE   PROVEEDORES   //////////////
    public static void modificarproveedores(){
        if(prove.getTxt_codifo().getText().equalsIgnoreCase("")||
        prove.getTxt_apellido().getText().equalsIgnoreCase("")||
        prove.getTxt_nombre().getText().equalsIgnoreCase("")||
        prove.getTxt_direccion().getText().equalsIgnoreCase("")||
        prove.getTxt_id().getText().equalsIgnoreCase("")||
        prove.getTxt_numcuenta().getText().equalsIgnoreCase("")||
        prove.getTxt_telefono().getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"NO HAY DATOS");
        }else{
        dbu.setCodigo(prove.getTxt_codifo().getText());
        dbu.setNumero_cuenta(prove.getTxt_numcuenta().getText());
        dbu.setCedula(prove.getTxt_id().getText());
        dbu.setApellido(prove.getTxt_apellido().getText());
        dbu.setNombre(prove.getTxt_nombre().getText());
        dbu.setTelefono(prove.getTxt_telefono().getText());
        dbu.setDireccion(prove.getTxt_direccion().getText());
        dbu.setFechanacimiento(prove.getDtcFechaNacimiento().getDate());
        /////////////////////////////////////////
        if(dbu.modificar(prove.getTxt_codifo().getText())){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        
        }else{
        JOptionPane.showMessageDialog(null,"Error al Guardar.");
        }}  
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////  TABLA AUTOMATICA   //////////////////////////
    public static void mostrartabla(){
    modelo=(DefaultTableModel)prove.getTbl_rep_proveedor().getModel();
    modelo.setRowCount(0);
    
    for (int i = 0; i < per.size(); i++) {
        
    hola=convertToLocalDateViaMilisecond(per.get(i).getFechanacimiento());
    fecha=per.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    
    Object [] fila ={per.get(i).getCodigo(),per.get(i).getApellido(),per.get(i).getNombre(),per.get(i).getTelefono(),per.get(i).getDireccion(),periodo.getYears(),per.get(i).getCedula(),per.get(i).getNumero_cuenta()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
    }
    }
    /////////////////7//  TABLA   POR  CODIGO  /////////////////////////////////
    public static void mostrartablaporvisor(String codei){
  //modelo = (DefaultTableModel) produc.getTbl_rep_producto().getModel();
    modelo=(DefaultTableModel)prove.getTbl_rep_proveedor().getModel();
    modelo.setRowCount(0);
    List<proveedores> per =dbu.mostrarDatos(codei);
    ////////////////////////////////////////////////////////////////////////////
    for (int i = 0; i < per.size(); i++) {
    hola=convertToLocalDateViaMilisecond(per.get(i).getFechanacimiento());
    fecha=per.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    Object [] fila ={per.get(i).getCodigo(),per.get(i).getApellido(),per.get(i).getNombre(),per.get(i).getTelefono(),per.get(i).getDireccion(),periodo.getYears(),per.get(i).getCedula(),per.get(i).getNumero_cuenta()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////   GENERADOR DE CODIGO  ///////////////////////
    public static void generacodi(){
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
       prove.getTxt_codifo().setText(co);
    }
    //////////////////////////////  BLANQUEAR   LA TABLA  //////////////////////
    public static void blanqueartabla(){
        prove.getTbl_rep_proveedor();
    }
    ///////  COMPROVADORES /////////////////////////////////////////////////////
    ///////////////      COMPRBAR QUE LA DECULA SEA ÚNICA      /////////////////
    public static boolean comprobarcedula(String ide){
        int aa=0;
        for (int i = 0; i < per.size(); i++) {
            if(per.get(i).getCedula().equalsIgnoreCase(ide)){
            aa=+1;   
            }else{
            aa=+0;   
            }}
        if(aa==1){
            JOptionPane.showMessageDialog(null,"La cedula: "+ide+" \nYa está ocupada");
            return false;
        }else{
            return true;
        }
    }
    ///////////////      COMPRBAR QUE EL CODIGO  SEA ÚNICA      /////////////////
    public static boolean comprobarcodigo(String ide){
        int aa=0;
        for (int i = 0; i < per.size(); i++) {
            if(per.get(i).getCodigo().equalsIgnoreCase(ide)){
                
            aa=+1;   
            }else{
            aa=+0;   
            }}
        if(aa==1){
            JOptionPane.showMessageDialog(null,"El coigo: "+ide+" \nYa está ocupado");
            return false;
        }else{
            return true;
        }
    }
    ///////////////   TRANSFORMAR   FECHA A EDAD   /////////////////////////////
    public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
    return Instant.ofEpochMilli(dateToConvert.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }
    ////////////////////////////////////////////////////////////////////////////
}

// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//