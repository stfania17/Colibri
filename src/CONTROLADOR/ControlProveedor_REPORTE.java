// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CONECCIÓN_SQL.Dbproveedores;
import CONECCIÓN_SQL.SQConnect;
import MODELO.proveedores;
import VISTA.Proveedor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class ControlProveedor_REPORTE {
    
    public static SQConnect pg= new SQConnect();
    public static Dbproveedores dbu = new Dbproveedores();
 
    public static Proveedor prove = new Proveedor();
    public static int n;
    public static Date fecha = new Date();
    
    public static LocalDate hola = LocalDate.now();
    public static LocalDate chao = LocalDate.now();
    public static Period periodo;
    public static DefaultTableModel modelo;
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrar(){prove.setVisible(true);}
    public static void cerrar(){prove.setVisible(false);}
    ////////////////////////////////////////////////////////////////////////////
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
        prove.getBut_consultar().addActionListener(l -> mostrartabla());
        prove.getBut_crear().addActionListener(l -> ingresarproveedor());
        prove.getBut_modificar().addActionListener(l -> muestramodifica());
        prove.getBut_eliminar().addActionListener(l -> cargarDialogo(4));
        prove.getBut_aceptar().addActionListener(l->modificarproveedores());
        prove.getBut_cancelar().addActionListener(l->prove.getDlg_Proveedor().setVisible(false));
        prove.getBut_atras().addActionListener(l->salir());
    }
    
    public static void salir(){
        cerrar();
        ControladorCajero.mostrar();
        ControladorCajero.iniciarocntrol();
    } 
    
    public static void ingresarproveedor(){
        int lero=0;
                
        Random r = new Random();
        lero=r.nextInt(000000001+999999999)+999999999;

        dbu.setCodigo(Integer.toString(lero));
        dbu.setNumero_cuenta("1111122222");
        dbu.setCedula("1111111112");
        dbu.setApellido("TAPIA");
        dbu.setNombre("MARIAS");
        dbu.setTelefono("0987654321");
        dbu.setDireccion("SAN BARTOLO");
        dbu.setFechanacimiento(fecha);
        /////////////////////////////////////////
        if(dbu.insertar()){
        JOptionPane.showMessageDialog(null,"Datos Guardados.");
        
        }else{
        JOptionPane.showMessageDialog(null,"Error al Guardar.");
        }    
    
    }
    
    public static void modificarproveedores(){
        if(prove.getTxt_codifo().getText().equalsIgnoreCase("")||prove.getTxt_apellido().getText().equalsIgnoreCase("")||
           prove.getTxt_nombre().getText().equalsIgnoreCase("")||prove.getTxt_direccion().getText().equalsIgnoreCase("")||
           prove.getTxt_id().getText().equalsIgnoreCase("")||prove.getTxt_numcuenta().getText().equalsIgnoreCase("")||
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
        }
        }  
    }
    
    public static boolean comprobarcedula(String ide){
        List<proveedores> per = dbu.mostrarDatos();  
        for (int i = 0; i < per.size(); i++) {
           if(per.get(i).getCedula().equalsIgnoreCase(ide)){
               return false;
           }else{
               return true;
           }
        }
        return true;
    }

    public static void muestramodifica(){
        prove.getDlg_Proveedor().setVisible(true);
        prove.getDlg_Proveedor().setSize(600,600);   
    }
            
    public static void mostrartabla(){
    modelo=(DefaultTableModel)Proveedor.tbl_rep_proveedor.getModel();
    modelo.setRowCount(0);
    
    List<proveedores> per = dbu.mostrarDatos();  
    for (int i = 0; i < per.size(); i++) {
    hola=convertToLocalDateViaMilisecond(per.get(i).getFechanacimiento());
    fecha=per.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    Object [] fila ={per.get(i).getCedula(),per.get(i).getApellido(),per.get(i).getNombre(),per.get(i).getTelefono(),per.get(i).getDireccion(),periodo.getYears(),per.get(i).getCodigo(),per.get(i).getNumero_cuenta()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrartablaporvisor(String codei){
    modelo=(DefaultTableModel)Proveedor.tbl_rep_proveedor.getModel();
    modelo.setRowCount(0);
    List<proveedores> per =dbu.mostrarDatos(codei);
    
    for (int i = 0; i < per.size(); i++) {
    hola=convertToLocalDateViaMilisecond(per.get(i).getFechanacimiento());
    fecha=per.get(i).getFechanacimiento();  ///CARGAR LA FECHA DEL SQL A UN DATE.
    periodo=Period.between(hola,chao); //CALCULAR EL TIEMPO ENTRE FECHAS
    Object [] fila ={per.get(i).getCedula(),per.get(i).getApellido(),per.get(i).getNombre(),per.get(i).getTelefono(),per.get(i).getDireccion(),periodo.getYears(),per.get(i).getCodigo(),per.get(i).getNumero_cuenta()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargarDialogo(int origen) {
        
        prove.getDlg_Proveedor().setSize(600, 600);
        prove.getDlg_Proveedor().setLocationRelativeTo(prove);

        if (origen == 1) {
            prove.getDlg_Proveedor().setTitle("CONSULTAR");
            n = 1;
        } else if (origen == 2) {
            prove.getDlg_Proveedor().setTitle("CREAR");
            n = 2;
        } else if (origen == 3) {
            prove.getDlg_Proveedor().setTitle("MODIFICAR");
            n = 3;
        } else {
            prove.getDlg_Proveedor().setTitle("ELIMINAR");
            n = 4;
        }
        prove.getDlg_Proveedor().setVisible(true);

    }
    ////////////////////////////////////////////////////////////////////////////
    public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
    return Instant.ofEpochMilli(dateToConvert.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }
    ////////////////////////////////////////////////////////////////////////////
}

// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//