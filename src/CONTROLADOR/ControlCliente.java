// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CLASES.clientes;
import CONECCIÓN_SQL.SQConnect;
import CONECCIÓN_SQL.modelo_clientes;
import VISTA.Vista_cliente;
import VISTA.Vista_ingreso;
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date; 
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControlCliente {
    ///////////////////////    INTERFACES     //////////////////////////////////
    public static Vista_cliente vista_cli = new Vista_cliente();
    public static Vista_ingreso caje = new Vista_ingreso();
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////   SQLs     ////////////////////////////////////////
    public static SQConnect pg= new SQConnect();
    public static modelo_clientes modelo_cli = new modelo_clientes();
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////   ARRRAYS    //////////////////////////////////
    public static List<clientes> lista_clientes = modelo_cli.mostrarDatos();
    ///////////////   VARIABLES   //////////////////////////////////////////////
    public static int n;
    public static Date fecha = new Date();
    public static LocalDate hola = LocalDate.now();
    public static LocalDate chao = LocalDate.now();
    public static Period periodo;
    //////////////////////   TABLA   ///////////////////////////////////////////
    public static DefaultTableModel modelo_tabla;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////            BREQUER    //////////////////////////////////
    public ControlCliente(Vista_cliente clie) {
        this.vista_cli = clie;
        clie.setTitle("PROVEEDORES");
        mostrar();
        mostrartabla();
        iniciarControl();
    }//but_refrescar
    /////////////////////             CEREBRO    ///////////////////////////////
    public void iniciarControl() { 
        ////////////////////////////////////////////////////////////////////////
        KeyListener ky = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyPressed(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            String codei=vista_cli.getTxt_consulta().getText();
            mostrartablaporvisor(codei);
            }
        };
        //////////////////////////////////////////////////////////////////////// 
        vista_cli.getTxt_consulta().addKeyListener(ky);
        vista_cli.getBut_atras().addActionListener(l->salir());
        
        //////////// PARA INGRESAR UNO NUEVO      //////////////////////////////
        ////////////  ABRIR EL CUADRO    ///////////////////////////////////////
        vista_cli.getAgregarcliente().addActionListener(l->abrirngreso());    
        //////////////////    GENERAR   CÓDIGO      ////////////////////////////
        vista_cli.getGenerarcodigocliente().addActionListener(l->generacodi());
        //////////////////  INGRESAR NUEVO CLIENTE   ///////////////////////////
        vista_cli.getBut_crear().addActionListener(l->ingresarcliente());
        ////////////////////////////////////////////////////////////////////////
        ///////////////  PARA   MODIFICAR   CLIENTE    /////////////////////////
        ////////////////   ABRIR   EL   MODIFICADOR    /////////////////////////
        vista_cli.getBut_modificar().addActionListener(l->cargaratosparamodificar());
        ///////////////    MODIFCAR  AL FLACO     //////////////////////////////
        vista_cli.getBut_actualizar().addActionListener(l->modificarproveedores());
        ////////////////////////////////////////////////////////////////////////
        vista_cli.getBut_refrescar().addActionListener(l->mostrartabla());
        vista_cli.getBut_limpiar().addActionListener(l->limpiartabla());
        vista_cli.getBut_cancelar().addActionListener(l->cerrarelcreador());
  
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////    PUERTAS   //////////////////////////////////
    public static void mostrar(){vista_cli.setVisible(true);}
    public static void cerrar(){vista_cli.setVisible(false);}
    public static void salir(){
        cerrar();  
        ControladorCajero cc = new ControladorCajero(caje);
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void abrirngreso(){
        vista_cli.getDlg_Cliente().setSize(920 , 620);
        
        vista_cli.getGenerarcodigocliente().setEnabled(true);
        vista_cli.getDlg_Cliente().setVisible(true);
        vista_cli.getBut_crear().setEnabled(true);
        vista_cli.getBut_actualizar().setEnabled(false); 
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////  TABLA AUTOMATICA   //////////////////////////
    public static void mostrartabla(){
    modelo_tabla=(DefaultTableModel)vista_cli.getTabla_clientes().getModel();
    modelo_tabla.setRowCount(0);
    
    for (int i = 0; i < lista_clientes.size(); i++) {
        
    hola=convertToLocalDateViaMilisecond(lista_clientes.get(i).getFechanacimiento());
    fecha=lista_clientes.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    
    Object [] fila ={lista_clientes.get(i).getCodigo(),lista_clientes.get(i).getApellido(),lista_clientes.get(i).getNombre(),lista_clientes.get(i).getTelefono(),lista_clientes.get(i).getDireccion(),periodo.getYears(),lista_clientes.get(i).getCedula(),lista_clientes.get(i).getCorreo()};
    modelo_tabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
    }
    }
    /////////////////7//  TABLA   POR  CODIGO  /////////////////////////////////
    public static void mostrartablaporvisor(String codei){
  //modelo = (DefaultTableModel) vista_cli.getTabla_clientes().getModel();
    modelo_tabla=(DefaultTableModel)vista_cli.getTabla_clientes().getModel();
    modelo_tabla.setRowCount(0);
    List<clientes> per =modelo_cli.mostrarDatos(codei);
    ////////////////////////////////////////////////////////////////////////////
    for (int i = 0; i < per.size(); i++) {
    hola=convertToLocalDateViaMilisecond(per.get(i).getFechanacimiento());
    fecha=per.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    Object [] fila ={per.get(i).getCodigo(),per.get(i).getApellido(),per.get(i).getNombre(),per.get(i).getTelefono(),per.get(i).getDireccion(),periodo.getYears(),per.get(i).getCedula(),per.get(i).getCorreo()};
    modelo_tabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void ingresarcliente(){       
        //////////////////   SI TODO VA BIEN ENTRA ESTO  ///////////////////////
        if(verificarqueestetodobien()==false){
        JOptionPane.showMessageDialog(null,"NO HAY DATOS");
        }else{
            
        String cedula=vista_cli.getTxt_id().getText();
        String codigo=vista_cli.getCodigocliente().getText();
        String apellido=vista_cli.getTxt_apellidos().getText();
        String nombre=vista_cli.getTxt_nombres().getText();
        String direccion=vista_cli.getTxt_direccion().getText();
        String correo=vista_cli.getTxt_correo().getText();
        String telefono=vista_cli.getTxt_telefono().getText();
        
//        Instant instant = vista_cli.getDtcFechaNacimiento().getDate().toInstant();
//        ZoneId zid = ZoneId.of("America/Guayaquil");
//        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
//        Date fecha = Date.valueOf(zdt.toLocalDate());    
          
        modelo_cli.setCodigo(codigo);
        modelo_cli.setCedula(cedula);
        modelo_cli.setNombre(nombre);
        modelo_cli.setApellido(apellido);
        modelo_cli.setDireccion(direccion);
        modelo_cli.setTelefono(telefono);
        modelo_cli.setCorreo(correo);
        modelo_cli.setFechanacimiento(vista_cli.getDtcFechaNacimiento().getDate());
        //but_actualizar
        if (modelo_cli.insertar()) {
            JOptionPane.showMessageDialog(vista_cli, "Cliente Creado Satisfactoriamente");
            blanquearingreso();
            vista_cli.getDlg_Cliente().setVisible(false);
            
        } else {
            JOptionPane.showMessageDialog(vista_cli, "ERROR");
        }
        }
    
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /////////////////  ABRIRI   EL EDIDAR  /////////////////////////////////////
    public static void cargaratosparamodificar(){
        int fila = vista_cli.getTabla_clientes().getSelectedRow();
        if (fila == -1) {
        JOptionPane.showMessageDialog(vista_cli, "PRIMERO SELECCIONE UN PROVEEDOR", "MODIFICAR", 2);
        }else {
            //Tabla_clientes
        vista_cli.getDlg_Cliente().setVisible(true);
        vista_cli.getGenerarcodigocliente().setEnabled(false);
        vista_cli.getBut_crear().setEnabled(false);
        
        vista_cli.getDlg_Cliente().setSize(920,620);   //[920, 620]
        vista_cli.getBut_actualizar().setEnabled(true);
//        vista_cli.getDLG_CREAROTRO().setEnabled(false);
            String codigo = String.valueOf(vista_cli.getTabla_clientes().getValueAt(fila, 0));
            for (int i = 0; i <lista_clientes.size(); i++) {
                if(lista_clientes.get(i).getCodigo().equalsIgnoreCase(codigo)){
                    vista_cli.getCodigocliente().setText(codigo);
                    
                    vista_cli.getTxt_id().setText(lista_clientes.get(i).getCedula());
                    vista_cli.getTxt_nombres().setText(lista_clientes.get(i).getNombre());
                    vista_cli.getTxt_apellidos().setText(lista_clientes.get(i).getApellido());
                    vista_cli.getTxt_telefono().setText(lista_clientes.get(i).getTelefono());
                    vista_cli.getTxt_direccion().setText(lista_clientes.get(i).getDireccion());
                    vista_cli.getTxt_correo().setText(lista_clientes.get(i).getCorreo());
                    vista_cli.getDtcFechaNacimiento().setDate(lista_clientes.get(i).getFechanacimiento());
                }
            }            
        }
    }
    ////////////////     MODIFICAR  DATOS   SOBRE   PROVEEDORES   //////////////
    public static void modificarproveedores(){
        
        if(verificarqueestetodobien()==true){
        modelo_cli.setCodigo(vista_cli.getCodigocliente().getText());
        modelo_cli.setCedula(vista_cli.getTxt_id().getText());
        modelo_cli.setApellido(vista_cli.getTxt_apellidos().getText());
        modelo_cli.setNombre(vista_cli.getTxt_nombres().getText());
        modelo_cli.setTelefono(vista_cli.getTxt_telefono().getText());
        modelo_cli.setDireccion(vista_cli.getTxt_direccion().getText());
        modelo_cli.setCorreo(vista_cli.getTxt_correo().getText());
        modelo_cli.setFechanacimiento(vista_cli.getDtcFechaNacimiento().getDate());
        /////////////////////////////////////////
        if(modelo_cli.modificar(vista_cli.getCodigocliente().getText())){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        vista_cli.getTabla_clientes().updateUI();
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
       vista_cli.getCodigocliente().setText(co);
    }
    ///////  COMPROVADORES /////////////////////////////////////////////////////
    ///////////////      COMPRBAR QUE LA DECULA SEA ÚNICA      /////////////////
    public static boolean comprobarcedula(String ide){
        int aa=0;
        for (int i = 0; i < lista_clientes.size(); i++) {
            if(lista_clientes.get(i).getCedula().equals(ide)){
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
        for (int i = 0; i < lista_clientes.size(); i++) {
            if(lista_clientes.get(i).getCodigo().equals(ide)){
                
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
    ////////////////////////////////////////////////////////////////////////////
    ///////////////   TRANSFORMAR   FECHA A EDAD   /////////////////////////////
    public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
    return Instant.ofEpochMilli(dateToConvert.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }
    ////////////////////////////////////////////////////////////////////////////
    public static boolean verificarqueestetodobien(){
        int senal=0; 
        /////////////////////////////////////////////////////////
       if(vista_cli.getCodigocliente().getText().isEmpty()||vista_cli.getTxt_apellidos().getText().isEmpty()||
           vista_cli.getTxt_nombres().getText().isEmpty()||vista_cli.getTxt_direccion().getText().isEmpty()||
           vista_cli.getTxt_id().getText().isEmpty()||vista_cli.getTxt_correo().getText().isEmpty()||
           vista_cli.getTxt_telefono().getText().isEmpty()||vista_cli.getDtcFechaNacimiento().getDate()==null){

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
        modelo_tabla.getDataVector().removeAllElements();
        vista_cli.getTabla_clientes().updateUI();
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void crearalclientefinal(){
        
        modelo_cli.setCodigo("0000000000");
        modelo_cli.setCedula("0000000000");
        modelo_cli.setApellido("FINAL");
        modelo_cli.setNombre("CONSUMIDOR");
        modelo_cli.setTelefono("0000000000");
        modelo_cli.setDireccion("0000000000");
        modelo_cli.setCorreo("0000000000");
        modelo_cli.setFechanacimiento(vista_cli.getDtcFechaNacimiento().getDate());
        /////////////////////////////////////////
        if(modelo_cli.insertar()){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        vista_cli.getTabla_clientes().updateUI();
        blanquearingreso();
        }else{
        JOptionPane.showMessageDialog(null,"Error al Guardar.");
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void blanquearingreso(){
        vista_cli.getTxt_id().setText("");
        vista_cli.getCodigocliente().setText("");
        vista_cli.getTxt_apellidos().setText("");
        vista_cli.getTxt_nombres().setText("");
        vista_cli.getTxt_direccion().setText("");
        vista_cli.getTxt_correo().setText("");
        vista_cli.getTxt_telefono().setText("");
       
        
    }
////////////////////////////////////////////////////////////////////////////////
    public static void cerrarelcreador(){
        blanquearingreso();
        vista_cli.getDlg_Cliente().setVisible(false);
        
        vista_cli.getGenerarcodigocliente().setEnabled(true);
        vista_cli.getBut_crear().setEnabled(true);
        vista_cli.getBut_actualizar().setEnabled(true); 
    }
////////////////////////////////////////////////////////////////////////////////    
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//