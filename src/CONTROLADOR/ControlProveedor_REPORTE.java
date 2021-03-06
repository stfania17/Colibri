// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CONECCIÓN_SQL.modelo_proveedores;
import CONECCIÓN_SQL.SQConnect;
import CLASES.proveedores;
import VISTA.Vista_ingreso;
import VISTA.Vista_proveedor;
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
    public static modelo_proveedores modelo_provedores = new modelo_proveedores();
    ///////////////////////    ARRAYLISTS    ///////////////////////////////////
    public static List<proveedores> lista_proveedores = modelo_provedores.mostrarDatos();  
    ///////////////////  INTERFACES     ////////////////////////////////////////
    public static Vista_proveedor prove;
    public static Vista_ingreso ingre = new Vista_ingreso();
    ////////////////////    VARIANTES   ////////////////////////////////////////
    public static int n;
    public static Date fecha = new Date();
    public static LocalDate hola = LocalDate.now();
    public static LocalDate chao = LocalDate.now();
    public static Period periodo;
    //////////////////////   TABLA   ///////////////////////////////////////////
    public static DefaultTableModel modelo;
    ////////////////////////////////////////////////////////////////////////////
    public ControlProveedor_REPORTE(Vista_proveedor prove){
        this.prove=prove;
        mostrar_interfaz();
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
        prove.getTxt_consulta().addKeyListener(ky);
        
        prove.getBut_refrescar().addActionListener(l -> mostrartabla());        /// MOSTRAR TABLA
        prove.getBut_crear().addActionListener(l -> abrirngreso());             /// INGRESAR PROVEEDOR
        prove.getBut_modificar().addActionListener(l -> cargaratosparamodificar());     /// MUESTRA MODIFICAR 
        prove.getBut_limpiar().addActionListener(l->limpiartabla());
        ////////////// ELIMINAR NO DISPONIBLE   //////////////
        prove.getBut_aceptar().addActionListener(l->modificarproveedores());    ///  MODIFICAR 
        prove.getBut_cancelar().addActionListener(l->cerrarcreador());          //CERRAR MODIFICADOR
        prove.getBut_atras().addActionListener(l->salir());                     /// SALIR DEL PROVEEDORbut_atras
        prove.getDLG_GENERARCODIGO().addActionListener(l->generacodi());        /// GENEREAR UN CODIGO
        prove.getDLG_CREAROTRO().addActionListener(l->ingresarproveedor());       /// CREAR PROVEEDOR  
        ////////////////////////////////////////////////////////////////////////
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////      PUERTAS       /////////////////////////////////////
    public static void mostrar_interfaz(){prove.setVisible(true);}
    public static void cerrar(){prove.setVisible(false);}
    public static void salir(){
        cerrar();
        ControladorCajero ccj = new ControladorCajero(ingre);
    } 
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////     CREAR UN NUEVO   PROVEEDOR    /////////////////////
    public static void abrirngreso(){
        Vista_proveedor.getDlg_Proveedor().setSize(950 , 550);
        
        prove.getDLG_GENERARCODIGO().setEnabled(true);
        prove.getDlg_Proveedor().setVisible(true);
        prove.getDLG_CREAROTRO().setEnabled(true);
        prove.getBut_aceptar().setEnabled(false); 
    }
    ////////////////////     INGRESAR DATOS   SOBRE PROVEEDORES   //////////////
    public static void ingresarproveedor(){
        
        if(comprobarcedula(prove.getTxt_id().getText())==true){
        if(comprobarcodigo(prove.getTxt_codifo().getText())==true){
        //////////////////   SI TODO VA BIEN ENTRA ESTO  ///////////////////////
        if(verificarqueestetodobien()==true){
        modelo_provedores.setCodigo(prove.getTxt_codifo().getText());
        modelo_provedores.setNumero_cuenta(prove.getTxt_numcuenta().getText());
        modelo_provedores.setCedula(prove.getTxt_id().getText());
        modelo_provedores.setApellido(prove.getTxt_apellido().getText());
        modelo_provedores.setNombre(prove.getTxt_nombre().getText());
        modelo_provedores.setTelefono(prove.getTxt_telefono().getText());
        modelo_provedores.setDireccion(prove.getTxt_direccion().getText());
        modelo_provedores.setFechanacimiento(prove.getDtcFechaNacimiento().getDate());
        /////////////////////////////////////////
        if(modelo_provedores.insertar()){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        prove.getTbl_rep_proveedor().updateUI();
        }else{
        JOptionPane.showMessageDialog(null,"Error al Guardar.");
        }    
        }else{
        JOptionPane.showMessageDialog(null,"DATOS INCORRECTOS");
        }
        
        }
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
    /////////////////  ABRIRI   EL EDIDAR  /////////////////////////////////////
    public static void cargaratosparamodificar(){
        int fila = prove.getTbl_rep_proveedor().getSelectedRow();
        if (fila == -1) {
        JOptionPane.showMessageDialog(prove, "PRIMERO SELECCIONE UN PROVEEDOR", "HHH", 2);
        }else {
            //Tbl_rep_proveedor
        prove.getDlg_Proveedor().setVisible(true);
        prove.getDLG_GENERARCODIGO().setEnabled(false);
        
        prove.getDlg_Proveedor().setSize(600,600);   
        prove.getBut_aceptar().setEnabled(true);
        prove.getDLG_CREAROTRO().setEnabled(false);
            String codigo = String.valueOf(prove.getTbl_rep_proveedor().getValueAt(fila, 0));
            for (int i = 0; i <lista_proveedores.size(); i++) {
                if(lista_proveedores.get(i).getCodigo().equalsIgnoreCase(codigo)){
                    prove.getTxt_codifo().setText(codigo);
                    
                    prove.getTxt_id().setText(lista_proveedores.get(i).getCedula());
                    prove.getTxt_nombre().setText(lista_proveedores.get(i).getNombre());
                    prove.getTxt_apellido().setText(lista_proveedores.get(i).getApellido());
                    prove.getTxt_telefono().setText(lista_proveedores.get(i).getTelefono());
                    prove.getTxt_direccion().setText(lista_proveedores.get(i).getDireccion());
                    prove.getTxt_numcuenta().setText(lista_proveedores.get(i).getNumero_cuenta());
                }
            }            
        }
    }
    ////////////////     MODIFICAR  DATOS   SOBRE   PROVEEDORES   //////////////
    public static void modificarproveedores(){
        
        if(verificarqueestetodobien()==true){
        modelo_provedores.setCodigo(prove.getTxt_codifo().getText());
        modelo_provedores.setNumero_cuenta(prove.getTxt_numcuenta().getText());
        modelo_provedores.setCedula(prove.getTxt_id().getText());
        modelo_provedores.setApellido(prove.getTxt_apellido().getText());
        modelo_provedores.setNombre(prove.getTxt_nombre().getText());
        modelo_provedores.setTelefono(prove.getTxt_telefono().getText());
        modelo_provedores.setDireccion(prove.getTxt_direccion().getText());
        modelo_provedores.setFechanacimiento(prove.getDtcFechaNacimiento().getDate());
        /////////////////////////////////////////
        if(modelo_provedores.modificar(prove.getTxt_codifo().getText())){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        prove.getTbl_rep_proveedor().updateUI();
        }else{
        JOptionPane.showMessageDialog(null,"Error al Guardar.");
        }     
        }else{
        JOptionPane.showMessageDialog(null,"Datos Incorrectos.");    
        }
         
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////  TABLA AUTOMATICA   //////////////////////////
    public static void mostrartabla(){
    modelo=(DefaultTableModel)prove.getTbl_rep_proveedor().getModel();
    modelo.setRowCount(0);
    
    for (int i = 0; i < lista_proveedores.size(); i++) {
        
    hola=convertToLocalDateViaMilisecond(lista_proveedores.get(i).getFechanacimiento());
    fecha=lista_proveedores.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    
    Object [] fila ={lista_proveedores.get(i).getCodigo(),lista_proveedores.get(i).getApellido(),lista_proveedores.get(i).getNombre(),lista_proveedores.get(i).getTelefono(),lista_proveedores.get(i).getDireccion(),periodo.getYears(),lista_proveedores.get(i).getCedula(),lista_proveedores.get(i).getNumero_cuenta()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
    }
    }
    /////////////////7//  TABLA   POR  CODIGO  /////////////////////////////////
    public static void mostrartablaporvisor(String codei){
  //modelo = (DefaultTableModel) produc.getTbl_rep_producto().getModel();
    modelo=(DefaultTableModel)prove.getTbl_rep_proveedor().getModel();
    modelo.setRowCount(0);
    List<proveedores> per =modelo_provedores.mostrarDatos(codei);
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
    ///////  COMPROVADORES /////////////////////////////////////////////////////
    ///////////////      COMPRBAR QUE LA DECULA SEA ÚNICA      /////////////////
    public static boolean comprobarcedula(String ide){
        int aa=0;
        for (int i = 0; i < lista_proveedores.size(); i++) {
            if(lista_proveedores.get(i).getCedula().equals(ide)){
            aa=aa+1;   
            }else{
            aa=aa+0;   
            }}
        if(aa>0){
            JOptionPane.showMessageDialog(null,"La cedula: "+ide+" \nYa está ocupada");
            return false;
        }else{
            return true;
        }
    }
    ///////////////      COMPRBAR QUE EL CODIGO  SEA ÚNICA      /////////////////
    public static boolean comprobarcodigo(String ide){
        int aa=0;
        for (int i = 0; i < lista_proveedores.size(); i++) {
            if(lista_proveedores.get(i).getCodigo().equals(ide)){
                
            aa=aa+1;   
            }else{
            aa=aa+0;   
            }}
        if(aa>0){
            JOptionPane.showMessageDialog(null,"El codigo: "+ide+" \nYa está ocupado");
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
    ///////////////   VERIFICADOR   DE   DATOS  INGRESADOS  ////////////////////
    public static boolean verificarqueestetodobien(){
        int senal=0; 
        /////////////////////////////////////////////////////////
        if(prove.getTxt_codifo().getText().isEmpty()||prove.getTxt_apellido().getText().isEmpty()||
           prove.getTxt_nombre().getText().isEmpty()||prove.getTxt_direccion().getText().isEmpty()||
           prove.getTxt_id().getText().isEmpty()||prove.getTxt_numcuenta().getText().isEmpty()||
           prove.getTxt_telefono().getText().isEmpty()||prove.getDtcFechaNacimiento().getDate()==null){
            senal=senal+1;
        }else{
            senal=senal+0;
        }
        ///////////////////
        if(senal>0){
            return false;
        }else{
            return true;
        }
        ///////////////////
    }
////////////////////////////////////////////////////////////////////////////////
    public static void limpiartabla(){
        modelo.getDataVector().removeAllElements();
        prove.getTbl_rep_proveedor().updateUI();
    }
    ////////////////////////////////////////////////////////////////////////////
}

// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//