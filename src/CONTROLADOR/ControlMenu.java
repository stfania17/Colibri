//proyecto colibri muñoz gutama matute
package CONTROLADOR;

import CONECCIÓN_SQL.modelo_productos;
import CONECCIÓN_SQL.modelo_proveedores;
import CONECCIÓN_SQL.SQConnect;
import CLASES.productos;
import CLASES.proveedores;
import CLASES.carrito;
import CLASES.provionalarrryamenu;
import CONECCIÓN_SQL.Render;
import VISTA.Vista_factura_formulario;
import VISTA.Vista_menu_cliente;
import VISTA.Vista_producto;
import VISTA.Vista_recepcion;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
 
public class ControlMenu{ 
    //////////////////////     ARRAYS       ////////////////////////////////////  
    public static ArrayList<provionalarrryamenu> provicionalgranos = new ArrayList<provionalarrryamenu>();
    public static ArrayList<provionalarrryamenu> provicionalverduras = new ArrayList<provionalarrryamenu>();
    public static ArrayList<provionalarrryamenu> provicionallacteos = new ArrayList<provionalarrryamenu>();
    public static ArrayList<provionalarrryamenu> provicionalfrutas = new ArrayList<provionalarrryamenu>();
    public static ArrayList<provionalarrryamenu> provicionalotros = new ArrayList<provionalarrryamenu>();
    public static ArrayList<provionalarrryamenu> provicionalhierbas = new ArrayList<provionalarrryamenu>();
    ////////////////////
    public static ArrayList<provionalarrryamenu> provicionali = new ArrayList<provionalarrryamenu>();
    ////////////////////
    ////////////////////////////  HOLA MARIA
    ////////////////////////////////////////////////////////////////////////////
    public static ArrayList<carrito> mateo=new ArrayList<carrito>();
    public static ArrayList<productos> pra = new ArrayList<productos>();  
    ///////////////////////  VARIABLES    ////////////////////////////////////// 
    public static DefaultTableModel modelo_tabla;
    public static int n=0;
    public static int posicion=0;
    public static int posicion2=0;
    /////////////////////    CLASES   //////////////////////////////////////////  
    public static provionalarrryamenu proda= new provionalarrryamenu();
    ///////////////////  VISTAS   ////////////////////////////////////////////// 
    public static Vista_menu_cliente menu = new Vista_menu_cliente();
    public static Vista_recepcion rec = new Vista_recepcion();
    public static Vista_factura_formulario ff = new Vista_factura_formulario();
    //////////////////////      SQL      /////////////////////////////////////// 
    public static SQConnect pg= new SQConnect();
    public static modelo_productos modelo_produ = new modelo_productos();
    public static modelo_proveedores dba = new modelo_proveedores();
    //////////////////////      ARRAY SQL    /////////////////////////////////// 
    public static List<productos> per = modelo_produ.mostrarProductos();
    public static List<proveedores> prov = dba.mostrarDatos();
    
    public static List<productos> pro_lac = modelo_produ.mostrarDatosLacteos();
    public static List<productos> pro_gran = modelo_produ.mostrarDatosGranos();
    public static List<productos> pro_otros = modelo_produ.mostrarDatosOtros();
    public static List<productos> pro_verd = modelo_produ.mostrarDatosVerduras();
    public static List<productos> pro_frut = modelo_produ.mostrarDatosFrutas();
    public static List<productos> pro_hierb = modelo_produ.mostrarDatosHierbas();
    ////////////////////////   BREQUER  ////////////////////////////////////////   
    public ControlMenu(Vista_menu_cliente menu) {
        this.menu = menu;
        ////////////  TABLAS AUTOMATICAS   ///////////////////
        crearmenuprovicional();
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
        provicionalgranos.clear();
        provicionallacteos.clear();
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
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
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
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
             
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
            }
    };
        //vista.getBtnRefrescar().addActionListener(l -> cargaLista());
        KeyListener ka = new KeyListener() {
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
            mostrartablaporvisor(menu.getCategoriatabla().getText(),menu.getjTextField1().getText());
            }
        };
        ////////////////////////////////////////////////////////////////////
        menu.getjTable1().addMouseListener(ky);
        menu.getjTextField1().addKeyListener(ka);
        ////////////////////////////////////SELECTOR DE CATEGORIAS
        menu.getBut_verduras().addActionListener(l -> cargarDialogo(1));
        menu.getBut_frutas().addActionListener(l -> cargarDialogo(2));
        menu.getBut_lacteos().addActionListener(l -> cargarDialogo(3));  /// UNICO QUE TENEMOS
        menu.getBut_granos().addActionListener(l -> cargarDialogo(4));
        menu.getBut_hierbas().addActionListener(l -> cargarDialogo(5));
        menu.getBut_otros().addActionListener(l -> cargarDialogo(6));
        //////////////////////////////// SALIDAS
        menu.getBut_salir().addActionListener(l->salir());
        menu.getSALIR().addActionListener(l->menu.getDlg_Productos().dispose());
        menu.getComprar().addActionListener(l->realizarfactura());
        ////////////////////////////////
        ////////////////////////////////
        menu.getjButton1().addActionListener(l->cargarcarrito());
        menu.getCANCELAR().addActionListener(l->menu.getCARRITO().setVisible(false));
        menu.getBut_carrito().addActionListener(l->abrircarrito());
        ///////////////////////////////// 
        menu.getDejarlo().addActionListener(l->dejarproducto());  /// DEJAR UN PRODUCTO
        menu.getBuscarpor().addActionListener(l->mostrardatosporoton());
    }
    ////////////////  MOSTRAR  MENU SEGUN SU CONTENIDO /////////////////////////
    public static void cargarDialogo(int origen) {
        menu.getDlg_Productos().setSize(1050, 540);
        menu.getDlg_Productos().setLocationRelativeTo(menu);

        if (origen == 1) {
            menu.getDlg_Productos().setTitle("Verduras");
            menu.getCategoriatabla().setText("Verduras");
            cargaVerduras();
            
            n = 1;
        } else if (origen == 2) {
            menu.getDlg_Productos().setTitle("Frutas");
            menu.getCategoriatabla().setText("Frutas");
            cargaFrutas();
            n = 2;
        } else if (origen == 3) {
            menu.getDlg_Productos().setTitle("Lacteos");
            menu.getCategoriatabla().setText("Lacteos");
            cargaLacteos();
            n = 3;
        } else if (origen == 4) {
            menu.getDlg_Productos().setTitle("Granos");
            menu.getCategoriatabla().setText("Granos");
            cargaGranos();
            n = 4;
        } else if (origen == 5) {
            menu.getDlg_Productos().setTitle("Hierbas");
            menu.getCategoriatabla().setText("Hierbas");
            cargaHierbas();
            n = 5;
        } else{
            menu.getDlg_Productos().setTitle("Otros");
            menu.getCategoriatabla().setText("Otros");
            cargaOtros();
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
        menu.getCARRITO().setSize(825,330);
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
            JOptionPane.showMessageDialog(menu,"PRODUCTO AGREGADO."); 
            
            limpiartabla();
            
            cargaGranos();
            cargaHierbas();
            cargaOtros();
            cargaLacteos();
            cargaVerduras();
            cargaFrutas();
            
            
            //// AGREGADO A LO QUE YA HABIA, AHORA VEREMOS UNO NUEVO  //////
            }else if(buscarsiexiste(cedu)==false){ 
            /////para los recien llegados
            double pf=canta*provicionali.get(posicion).getPrecio();

            carrito julia= new carrito(cedu,provicionali.get(posicion).getNombre(),canta,provicionali.get(posicion).getPrecio(), pf);  
            mateo.add(julia);

            mermarcantidad(cedu,canta);
            JOptionPane.showMessageDialog(menu,"PRODUCTO AGREGADO.");     
            }
            }else{
            double pf=canta*provicionali.get(posicion).getPrecio();
                
            carrito julia= new carrito(cedu,provicionali.get(posicion).getNombre(),canta,provicionali.get(posicion).getPrecio(), pf);  
            mateo.add(julia);

            mermarcantidad(cedu,canta);
            JOptionPane.showMessageDialog(null,"PRODUCTO AGREGADO.");     
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
    modelo_tabla=(DefaultTableModel)menu.tablacarrito.getModel();
    modelo_tabla.setRowCount(0);
  
    for (int i = 0; i < mateo.size(); i++) {
    Object [] fila ={mateo.get(i).getCodigo() ,mateo.get(i).getNombre() , mateo.get(i).getCantidad(),mateo.get(i).getPrecio(),mateo.get(i).getPrecio_final()};
    modelo_tabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.      
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
            JOptionPane.showMessageDialog(null,"PRODUCTO RETIRADO.");  
            
            if(mateo.get(i).getCantidad()==0){
                mateo.remove(i);
            }
            
                for (int j = 0; j < provicionali.size(); j++) {
                    if(provicionali.get(j).getCodigo().equalsIgnoreCase(cedu)){
                        int b=provicionali.get(j).getExistencias()+canta;
                        provicionali.get(j).setExistencias(b);
                    }
                }
            
            modelo_tabla.getDataVector().removeAllElements();
            menu.tablacarrito.updateUI();
            cargartablacarrito();
            
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
    public static void crearmenuprovicional(){ 
        for (int i = 0; i < per.size(); i++) {
        proda= new provionalarrryamenu(per.get(i).getCodigo(),per.get(i).getNombre(),per.get(i).getCod_proveedor(),per.get(i).getDescripcion(), per.get(i).getCategoria(),per.get(i).getPrecio(),per.get(i).getExistencias(),per.get(i).getFoto());
        provicionali.add(proda);        
     }}
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////  MOTRAR  TABLA POR MEDIO DE  INICIAL  /////////////////////////
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
            se=se+1;     
            }else{
            se=se+0;  
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
    /////////////////////     TABLAS           /////////////////////////////////
    /////////////////////   CREA SEGÚN CATEGORIA    ////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void cargaGranos() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        menu.getjTable1().setDefaultRenderer(Object.class, new Render());
        menu.getjTable1().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        modelo_tabla = (DefaultTableModel) menu.getjTable1().getModel();
        //tblModel.setNumRows(0);
        
        List<productos> lista = modelo_produ.mostrarDatosGranos();        
        
        int ncols = modelo_tabla.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            menu.getjTable1().setValueAt(p.getCodigo(), i.value, 0);
            menu.getjTable1().setValueAt(p.getNombre(), i.value, 1);
            menu.getjTable1().setValueAt(p.getCod_proveedor(), i.value, 2);            
            menu.getjTable1().setValueAt(p.getDescripcion(), i.value, 3);
            menu.getjTable1().setValueAt(p.getPrecio(), i.value, 4);
            
            for (int j = 0; j < provicionali.size(); j++) {
                if(provicionali.get(j).getCodigo().equals(p.getCodigo())){
            menu.getjTable1().setValueAt(provicionali.get(j).getExistencias(), i.value, 5);        
                } 
            }

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.getjTable1().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.getjTable1().setValueAt(null, i.value, 6);
            }
            i.value++;

        });
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargaVerduras() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        menu.getjTable1().setDefaultRenderer(Object.class, new Render());
        menu.getjTable1().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        modelo_tabla = (DefaultTableModel) menu.getjTable1().getModel();
        //tblModel.setNumRows(0);
        
        List<productos> lista = modelo_produ.mostrarDatosVerduras();

        int ncols = modelo_tabla.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            menu.getjTable1().setValueAt(p.getCodigo(), i.value, 0);
            menu.getjTable1().setValueAt(p.getNombre(), i.value, 1);
            menu.getjTable1().setValueAt(p.getCod_proveedor(), i.value, 2);            
            menu.getjTable1().setValueAt(p.getDescripcion(), i.value, 3);
            menu.getjTable1().setValueAt(p.getPrecio(), i.value, 4);
            
            for (int j = 0; j < provicionali.size(); j++) {
                if(provicionali.get(j).getCodigo().equals(p.getCodigo())){
            menu.getjTable1().setValueAt(provicionali.get(j).getExistencias(), i.value, 5);        
                } 
            }

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.getjTable1().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.getjTable1().setValueAt(null, i.value, 6);
            }
            i.value++;

        });
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargaFrutas() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        menu.getjTable1().setDefaultRenderer(Object.class, new Render());
        menu.getjTable1().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        modelo_tabla = (DefaultTableModel) menu.getjTable1().getModel();
        //tblModel.setNumRows(0); 
        List<productos> lista = modelo_produ.mostrarDatosFrutas();
        
        int ncols = modelo_tabla.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            menu.getjTable1().setValueAt(p.getCodigo(), i.value, 0);
            menu.getjTable1().setValueAt(p.getNombre(), i.value, 1);
            menu.getjTable1().setValueAt(p.getCod_proveedor(), i.value, 2);            
            menu.getjTable1().setValueAt(p.getDescripcion(), i.value, 3);
            menu.getjTable1().setValueAt(p.getPrecio(), i.value, 4);
            
            for (int j = 0; j < provicionali.size(); j++) {
                if(provicionali.get(j).getCodigo().equals(p.getCodigo())){
            menu.getjTable1().setValueAt(provicionali.get(j).getExistencias(), i.value, 5);        
                } 
            }

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.getjTable1().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.getjTable1().setValueAt(null, i.value, 6);
            }
            i.value++;
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargaLacteos() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        menu.getjTable1().setDefaultRenderer(Object.class, new Render());
        menu.getjTable1().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        modelo_tabla = (DefaultTableModel) menu.getjTable1().getModel();
        //tblModel.setNumRows(0); 
        List<productos> lista = modelo_produ.mostrarDatosLacteos();
        
        int ncols = modelo_tabla.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            menu.getjTable1().setValueAt(p.getCodigo(), i.value, 0);
            menu.getjTable1().setValueAt(p.getNombre(), i.value, 1);
            menu.getjTable1().setValueAt(p.getCod_proveedor(), i.value, 2);            
            menu.getjTable1().setValueAt(p.getDescripcion(), i.value, 3);
            menu.getjTable1().setValueAt(p.getPrecio(), i.value, 4);
            
            for (int j = 0; j < provicionali.size(); j++) {
                if(provicionali.get(j).getCodigo().equals(p.getCodigo())){
            menu.getjTable1().setValueAt(provicionali.get(j).getExistencias(), i.value, 5);        
                } 
            }

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.getjTable1().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.getjTable1().setValueAt(null, i.value, 6);
            }
            i.value++;
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargaOtros() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        menu.getjTable1().setDefaultRenderer(Object.class, new Render());
        menu.getjTable1().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        modelo_tabla = (DefaultTableModel) menu.getjTable1().getModel();
        //tblModel.setNumRows(0); 
        List<productos> lista = modelo_produ.mostrarDatosOtros();
        
        int ncols = modelo_tabla.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            menu.getjTable1().setValueAt(p.getCodigo(), i.value, 0);
            menu.getjTable1().setValueAt(p.getNombre(), i.value, 1);
            menu.getjTable1().setValueAt(p.getCod_proveedor(), i.value, 2);            
            menu.getjTable1().setValueAt(p.getDescripcion(), i.value, 3);
            menu.getjTable1().setValueAt(p.getPrecio(), i.value, 4);
            
            for (int j = 0; j < provicionali.size(); j++) {
                if(provicionali.get(j).getCodigo().equals(p.getCodigo())){
            menu.getjTable1().setValueAt(provicionali.get(j).getExistencias(), i.value, 5);        
                } 
            }

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.getjTable1().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.getjTable1().setValueAt(null, i.value, 6);
            }
            i.value++;
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargaHierbas() {
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        menu.getjTable1().setDefaultRenderer(Object.class, new Render());
        menu.getjTable1().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        modelo_tabla = (DefaultTableModel) menu.getjTable1().getModel();
        //tblModel.setNumRows(0); 
        List<productos> lista = modelo_produ.mostrarDatosHierbas();
        
        int ncols = modelo_tabla.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            menu.getjTable1().setValueAt(p.getCodigo(), i.value, 0);
            menu.getjTable1().setValueAt(p.getNombre(), i.value, 1);
            menu.getjTable1().setValueAt(p.getCod_proveedor(), i.value, 2);            
            menu.getjTable1().setValueAt(p.getDescripcion(), i.value, 3);
            menu.getjTable1().setValueAt(p.getPrecio(), i.value, 4);
            
            for (int j = 0; j < provicionali.size(); j++) {
                if(provicionali.get(j).getCodigo().equals(p.getCodigo())){
            menu.getjTable1().setValueAt(provicionali.get(j).getExistencias(), i.value, 5);        
                } 
            }

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.getjTable1().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.getjTable1().setValueAt(null, i.value, 6);
            }
            i.value++;
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrartablaporvisor(String ctaegoria, String ide) {
        menu.jTable1.setDefaultRenderer(Object.class, new Render());
        menu.jTable1.setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        //system
        modelo_tabla = (DefaultTableModel) menu.jTable1.getModel();
        String categoria=menu.getCategoriatabla().getText();
 
        List<productos> lista= modelo_produ.mostrarDatosPorcategoria(categoria,ide);
        
        int ncols = 1;
        
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
 
            menu.jTable1.setValueAt(p.getCodigo(), i.value, 0);
            menu.jTable1.setValueAt(p.getNombre(), i.value, 1);
            menu.jTable1.setValueAt(p.getCod_proveedor(), i.value, 2);
            menu.jTable1.setValueAt(p.getDescripcion(), i.value, 3);
            menu.jTable1.setValueAt(p.getExistencias(), i.value, 4);
            menu.jTable1.setValueAt(p.getPrecio(), i.value, 5);

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                menu.jTable1.setValueAt(new JLabel(icon), i.value, 6);
            } else {
                menu.jTable1.setValueAt(null, i.value, 6);
            }
            i.value++;
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrardatosporoton(){
        limpiartabla();
        String ida=menu.getjTextField1().getText();
        mostrartablaporvisor(menu.getCategoriatabla().getText(),ida);
    }
    //////////////////////////////////////////////////////////////////////////// 
    public static void limpiartabla(){
        modelo_tabla.getDataVector().removeAllElements();
        menu.getjTable1().updateUI();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /////////////////   VAMOS    A   LA   FACTURA///////////////////////////////
    public static void realizarfactura(){
        menu.getCARRITO().setVisible(false);
        ControladorCreadorFactura ccf = new ControladorCreadorFactura(ff);
    }
    
    
    
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//