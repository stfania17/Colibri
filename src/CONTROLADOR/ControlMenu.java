//proyecto colibri muñoz gutama matute
package CONTROLADOR;

import CONECCIÓN_SQL.Dbproductos;
import CONECCIÓN_SQL.Dbproveedores;
import CONECCIÓN_SQL.SQConnect;
import MODELO.productos;
import MODELO.proveedores;
import MODELO.carrito;
import MODELO.provionalarrryamenu;
import VISTA.FACTURA_FORMULARIO;
import VISTA.MenuCliente;
import VISTA.Recepcion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class ControlMenu{ 
    //////////////////////     ARRAYS       ////////////////////////////////////  
    public static ArrayList<provionalarrryamenu> provicionali = new ArrayList<provionalarrryamenu>();
    public static ArrayList<carrito> mateo=new ArrayList<carrito>();
    public static ArrayList<productos> pra = new ArrayList<productos>();  
    ///////////////////////  VARIABLES    ////////////////////////////////////// 
    public static DefaultTableModel modelo;
    public static int n=0;
    public static int posicion=0;
    public static int posicion2=0;
    /////////////////////    CLASES   //////////////////////////////////////////  
    public static provionalarrryamenu proda= new provionalarrryamenu();
    ///////////////////  VISTAS   ////////////////////////////////////////////// 
    public static MenuCliente menu = new MenuCliente();
    public static Recepcion rec = new Recepcion();
    public static FACTURA_FORMULARIO ff = new FACTURA_FORMULARIO();
    //////////////////////      SQL      /////////////////////////////////////// 
    public static SQConnect pg= new SQConnect();
    public static Dbproductos dbu = new Dbproductos();
    public static Dbproveedores dba = new Dbproveedores();
    //////////////////////      ARRAY SQL    /////////////////////////////////// 
    public static List<productos> per = dbu.mostrarProductos();
    public static List<proveedores> prov = dba.mostrarDatos();
    ////////////////////////   BREQUER  ////////////////////////////////////////   
    public ControlMenu(MenuCliente menu) {
        this.menu = menu;
        menuprovicional();
        mostrar();
        menu.setTitle("MENU DE PRODUCTOS");
        iniciaControl();
    }
    ////////////////////////////////////////////////////////////////////////////    
    ///////////////////////////////  FUNCIONES BASICAS  ////////////////////////
    public static void mostrar(){menu.setVisible(true);}
    public static void cerrar(){menu.setVisible(false);}
    public static void salir(){
        cerrar();
        provicionali.clear();
        mateo.clear();
        ControladorRecepcion ccr = new ControladorRecepcion(rec);
    } 
    ////////////////////////////////  CEREBRO DEL LUGAR   //////////////////////   
    public static void iniciaControl() {
        MouseListener ky = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
            ////////////////////////////////////////////////////////////////////
            @Override
            public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            int seleciona = menu.jTable1.getSelectedRow();
            if (seleciona != -1){ 
            ////////////////////////////////////////////////////////////////////////    
            String cedu = (String) menu.jTable1.getValueAt(menu.jTable1.getSelectedRow(), 0);
            traerdatosproveedor(cedu);
            }
            }
            ////////////////////////////////////////////////////////////////////
            @Override
            public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    };
        //vista.getBtnRefrescar().addActionListener(l -> cargaLista());
        KeyListener ka = new KeyListener() {
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
            mostrartablaporvisor(menu.getjTextField1().getText());
            }
        };
        ////////////////////////////////////SELECTOR DE CATEGORIAS
        menu.getBut_verduras().addActionListener(l -> cargarDialogo(1));
        menu.getBut_frutas().addActionListener(l -> cargarDialogo(2));
        menu.getBut_lacteos().addActionListener(l -> cargarDialogo(3));  /// UNICO QUE TENEMOS
        menu.getBut_granos().addActionListener(l -> cargarDialogo(4));
        menu.getBut_hierbas().addActionListener(l -> cargarDialogo(5));
        menu.getBut_otros().addActionListener(l -> cargarDialogo(6));
        ////////////////////////////////////////////////////////////////////
        //// 
        menu.getjTable1().addMouseListener(ky);
        menu.getjTextField1().addKeyListener(ka);
        //////////////////////////////// SALIDAS
        menu.getBut_salir().addActionListener(l->salir());
        menu.getSALIR().addActionListener(l->menu.getDlg_Productos().dispose());
        menu.getComprar().addActionListener(l->realizarfactura());
        ////////////////////////////////
        ////////////////////////////////
        ////////////////////////////////
        ////////////////////////////////
        menu.getjButton1().addActionListener(l->cargarcarrito());
        menu.getCANCELAR().addActionListener(l->menu.getCARRITO().setVisible(false));
        menu.getBut_carrito().addActionListener(l->abrircarrito());
        /////////////////////////////////
        menu.getDejarlo().addActionListener(l->dejarproducto());  /// DEJAR UN PRODUCTO
    }
    ////////////////  MOSTRAR  MENU SEGUN SU CONTENIDO /////////////////////////
    public static void cargarDialogo(int origen) {
        menu.getDlg_Productos().setSize(650, 600);
        menu.getDlg_Productos().setLocationRelativeTo(menu);

        if (origen == 1) {
            menu.getDlg_Productos().setTitle("Verduras");
            mostrartabla("Verduras");
            n = 1;
        } else if (origen == 2) {
            menu.getDlg_Productos().setTitle("Frutas");
            mostrartabla("Frutas");
            n = 2;
        } else if (origen == 3) {
            menu.getDlg_Productos().setTitle("Lacteos");
            mostrartabla("Lacteos");
            n = 3;
        } else if (origen == 4) {
            menu.getDlg_Productos().setTitle("Granos");
            mostrartabla("Granos");
            n = 4;
        } else if (origen == 5) {
            menu.getDlg_Productos().setTitle("Hierbas");
            mostrartabla("Hierbas");
            n = 5;
        } else{
            menu.getDlg_Productos().setTitle("Otros");
            mostrartabla("Otros");
            n = 6;
        }
        menu.getDlg_Productos().setVisible(true);
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////   TRAER   NOMBRE DE PERSONA PARA GRAFICAR EN TABLA ////////
    public static String traernombre(String codigopro){
    String name="";
    for (int j = 0; j < prov.size(); j++) {
        if(prov.get(j).getCodigo().equalsIgnoreCase(codigopro)){
        name=prov.get(j).getApellido()+" "+prov.get(j).getNombre();
        }         
    }
    return name;
    } 
    //////////////////  NOS  TRAE EL CODIGO  DEL PROVEEDOR /////////////////////
    ////   PAR TRAER EL CODIGO  DEL PROVEEDOR     //////////////////////////////
    public static String codigoproveedor(String codigopro){
    String name="";
    for (int j = 0; j < per.size(); j++) {
        if(per.get(j).getCodigo().equalsIgnoreCase(codigopro)){
        name=per.get(j).getCod_proveedor();
        }         
    }
    return name;
    }
    //////////////  BUSCA LOS DATOS DEL PROVEEDOR PARA MOSTRAR    //////////////
    public static void traerdatosproveedor(String codigopro){
        for (int j = 0; j < prov.size(); j++) {
        if(prov.get(j).getCodigo().equalsIgnoreCase(codigoproveedor(codigopro))){
        menu.getjLabel7().setText(prov.get(j).getNombre());
        menu.getjLabel8().setText(prov.get(j).getApellido());
        menu.getjLabel9().setText(prov.get(j).getTelefono());
        }}
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    //////////////    ABRIR   LA  INTERAZ DE CARRITO  //////////////////////////
    public static void abrircarrito(){
        menu.getCARRITO().setSize(600, 600);
        menu.getCARRITO().setLocationRelativeTo(menu);
        menu.getCARRITO().setTitle("CARRITO");
        menu.getCARRITO().setVisible(true);
        cargartablacarrito();
    }
    //////////////  CARGAR INFO   AL   CARRITO    //////////////////////////////
    public static void cargarcarrito(){ /// ARREGLAR
        int seleciona = menu.jTable1.getSelectedRow();
        int canta=Integer.parseInt(menu.getjSpinner1().getValue().toString());
        
        if (seleciona != -1){ 
        ////////////////////////////////////////////////////////////////////////    
        String cedu = (String) menu.jTable1.getValueAt(menu.jTable1.getSelectedRow(), 0);
        traerdatosproveedor(cedu);
        
        posicion=buscarposicionenprovicional(cedu);   /// PARA BUSCAR LA INFORMACIÓN.
                                                            /// ENCONTRAMOS LO QUE BUSCAMOS
        if(canta<=provicionali.get(posicion).getExistencias()){  //PARA EXISTENCIA INSUFICIENTES
        //// AHORA EN CASO DE QUE EL CARRO ESTE VACIÓ O NO
        
        //////// EN CASO DE QUE YA HAYA ALGO EN EL CARRRITO, BUSCAREMOS SI YA TENEMOS UN PRODUCTO ////
        if(mateo.size()>0){   
            
        posicion2=buscarposicionencarrito(cedu);     
        //BUSCAREMOS EN LA TABLA
        if(buscarsiexiste(cedu)==true){        
        //SI YA HAY UN PRODUCTO EN TABLA
        //cantiad 
        mermarcantidad(cedu,canta);
        int anter=mateo.get(posicion2).getCantidad();                  // SACAR LA CANTIDAD ANTERIOR
        canta=canta+anter;

            //precio         
            double pf=canta*provicionali.get(posicion).getPrecio();

            ///actualizar
            mateo.get(posicion2).setCantidad(canta);
            mateo.get(posicion2).setPrecio_final(pf);
            JOptionPane.showMessageDialog(menu,"PRODUCTO AGREGADO a lo que ya habia"); 
            //// AGREGADO A LO QUE YA HABIA, AHORA VEREMOS UNO NUEVO  //////
            }else if(buscarsiexiste(cedu)==false){ 
            /////para los recien llegados
            double pf=canta*provicionali.get(posicion).getPrecio();

            carrito julia= new carrito(cedu,provicionali.get(posicion).getNombre(),canta,provicionali.get(posicion).getPrecio(), pf);  
            mateo.add(julia);

            mermarcantidad(cedu,canta);
            JOptionPane.showMessageDialog(menu,"PRODUCTO AGREGADO primer vez");     
            }
            }else{
            double pf=canta*provicionali.get(posicion).getPrecio();
                
            carrito julia= new carrito(cedu,provicionali.get(posicion).getNombre(),canta,provicionali.get(posicion).getPrecio(), pf);  
            mateo.add(julia);

            mermarcantidad(cedu,canta);
            JOptionPane.showMessageDialog(null,"PRODUCTO AGREGADO primero origen");     
            }
                
            
           
        }else{
        JOptionPane.showMessageDialog(null,"EXISTENCIAS INSUFICIENTES.");  
        }          
        
        }else{
        JOptionPane.showMessageDialog(null,"SELECIONES ALGO.");      
        }
    } 
    ///////////////////    CARGAR   TABLA   AL CARRITO  ////////////////////////
    public static void cargartablacarrito(){
    modelo=(DefaultTableModel)menu.tablacarrito.getModel();
    modelo.setRowCount(0);
  
    for (int i = 0; i < mateo.size(); i++) {
    Object [] fila ={mateo.get(i).getCodigo() ,mateo.get(i).getNombre() , mateo.get(i).getCantidad(),mateo.get(i).getPrecio(),mateo.get(i).getPrecio_final()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }}  
    ///////////////////   DEJAR  UN PRODUCTO ///////////////////////////////////
    public static void dejarproducto(){
        int seleciona = menu.tablacarrito.getSelectedRow();
        int canta=Integer.parseInt(menu.getContador().getValue().toString());
 
        if (seleciona != -1){ 
        ////////////////////////////////////////////////////////////////////////    
        String cedu = (String) menu.tablacarrito.getValueAt(menu.tablacarrito.getSelectedRow(), 0);
        traerdatosproveedor(cedu);
        
        for (int i = 0; i < mateo.size(); i++) {
            
        if(mateo.get(i).getCodigo().equalsIgnoreCase(cedu)){
            if(canta<=mateo.get(i).getCantidad()){
            int a=mateo.get(i).getCantidad();
            double pre=mateo.get(i).getPrecio();
            
            a=a-canta;
            pre=pre*a;
            mateo.get(i).setPrecio_final(pre);
            mateo.get(i).setCantidad(a);
            JOptionPane.showMessageDialog(null,"PRODUCTO REITRADO.");  
            
            
                for (int j = 0; j < provicionali.size(); j++) {
                    if(provicionali.get(j).getCodigo().equalsIgnoreCase(cedu)){
                        int b=provicionali.get(j).getExistencias()+canta;
                        provicionali.get(j).setExistencias(b);
                    }
                }
            
            
            
            }else{
            JOptionPane.showMessageDialog(null,"EXISTENCIAS INSUFICIENTES.");  
            } 
        }
        
        }
        
        
        }else{
        JOptionPane.showMessageDialog(null,"SELECIONE ALGO.");      
        }  
    }
    ////////////////////////   MERMAR CANTIDAD   DE DISPONIBILIDAD  ////////////
    public static void mermarcantidad(String codigo, int cantidad){
        for (int i = 0; provicionali.size()>i; i++) {
            if(provicionali.get(i).getCodigo().equalsIgnoreCase(codigo)){
                n=provicionali.get(i).getExistencias();
                n=n-cantidad;
                provicionali.get(i).setExistencias(n);
    }}}
    ////////////////////////////////////////////////////////////////////////////
    //public static
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ///////////////    ESTA   VAINA    CREA  UN MENU PROVICIONAL ///////////////
    ///// ¿Porqué?  NO PREGUNTE Y OBSERVER. ////////////////////////////////////
    public static void menuprovicional(){ 
        for (int i = 0; i < per.size(); i++) {
        proda= new provionalarrryamenu(per.get(i).getCodigo(),per.get(i).getNombre(),per.get(i).getCod_proveedor(),per.get(i).getDescripcion(), per.get(i).getCategoria(),per.get(i).getPrecio(),per.get(i).getExistencias());
        provicionali.add(proda);        
     }}
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////   CREA SEGÚN CATEGORIA    ////////////////////////////
    public static void mostrartabla(String clase){
    modelo=(DefaultTableModel)menu.jTable1.getModel();
    modelo.setRowCount(0);
     
    for (int i = 0; i < provicionali.size(); i++) {
    if(provicionali.get(i).getCategoria().equalsIgnoreCase(clase)){
    String nombres=traernombre(provicionali.get(i).getCod_proveedor());
    Object [] fila ={provicionali.get(i).getCodigo() ,provicionali.get(i).getNombre() , nombres ,provicionali.get(i).getDescripcion() ,provicionali.get(i).getPrecio() ,provicionali.get(i).getExistencias()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }}} 
    ////////////////////////////////////////////////////////////////////////////
    ////////////  MOTRAR  TABLA POR MEDIO DE  INICIAL  /////////////////////////
    public static void mostrartablaporvisor(String codei){
    modelo=(DefaultTableModel)menu.jTable1.getModel();
    modelo.setRowCount(0);
    per =dbu.mostrarDatos(codei);
    
    for (int i = 0; i < per.size(); i++) {
    String nombres=traernombre(per.get(i).getCod_proveedor());
    Object [] fila ={per.get(i).getCodigo() ,per.get(i).getNombre() , nombres ,per.get(i).getDescripcion() ,per.get(i).getPrecio() ,per.get(i).getExistencias()};
    modelo.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////    BUSCAMOS   POSICION DE PRODUCTO  ///////////////////////
    public static int buscarposicionenprovicional(String codigo){
        int posicion=0;
        
        for (int i = 0; i < provicionali.size(); i++) {
            if(provicionali.get(i).getCodigo().equalsIgnoreCase(codigo)){
            posicion=i;        
            }
        }
        return posicion;
    }
    ////////////////    BUSCAMOS   POSICION DE PRODUCTO  ///////////////////////
    public static int buscarposicionencarrito(String codigo){
        int posicion=0;
        
        for (int i = 0; i < mateo.size(); i++) {
            if(mateo.get(i).getCodigo().equalsIgnoreCase(codigo)){
            posicion=i;        
            }
        }
        return posicion;
    }
    ///////////////////   BUSCAMO SI ES QUE EXISTE EN EL ARRAYLIST  ////////////
    public static boolean buscarsiexiste(String codigo){
        int se=0;
        
        for (int i = 0; i < mateo.size(); i++) {
            if(mateo.get(i).getCodigo().equalsIgnoreCase(codigo)){
            JOptionPane.showMessageDialog(null, "TE ENCONTRE EN CARRITO");
            se=se+1;     
            JOptionPane.showMessageDialog(null, "HOLA "+se);
            }else{
            se=se+0;  
            JOptionPane.showMessageDialog(null, "HOLA 0"+se);
            }
        }
        
        if(se>0){
        return true;    
        }else{
        return false;    
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /////////////////   VAMOS    A   LA   FACTURA///////////////////////////////
    public static void realizarfactura(){
        cerrar();
        ControladorCreadorFactura ccf = new ControladorCreadorFactura(ff);
    }
    ////////////////////////////////////////////////////////////////////////////
 

}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//