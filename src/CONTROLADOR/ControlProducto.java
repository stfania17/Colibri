// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import VISTA.Vista_producto;
import CLASES.productos;
import CONECCIÓN_SQL.modelo_productos;
import CONECCIÓN_SQL.modelo_proveedores;
import CONECCIÓN_SQL.Render;
import CLASES.proveedores;
import VISTA.Vista_ingreso;
import java.awt.Image;
 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
 
public class ControlProducto {
    //////////////////     TRAER INTERFACES   ////////////////////////////
    public static Vista_producto vista_produ;
    public static Vista_ingreso vista_menucajero = new Vista_ingreso();
    /////////////////////////////////    SQLs   //////////////////////////////
    public static modelo_productos modelo_produ = new modelo_productos();
    public static modelo_proveedores modelo_provedo = new modelo_proveedores();
    ///////////////////////   TABLA   //////////////////////////////////////////
    public static DefaultTableModel modelo_tabla;
    /////////////////////    VARIANTES    //////////////////////////
    public static int n;
    public static String ruta="";
    ///////////////////////////   ARRRALISTS  //////////////////////////////////
    public static List<proveedores> per = modelo_provedo.mostrarDatos();  
    public static List<productos> prodi = modelo_produ.mostrarProductos();  
  
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public ControlProducto(Vista_producto produc) {
        this.vista_produ = produc;
        mostrar_interfaz();
        cargaLista();
        llenarcuadrocedulas();
        iniciaControl();
    }
   
    public static void iniciaControl() { 
        KeyListener kl = new KeyListener() {
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
            mostrarDatos(vista_produ.getTxt_consulta().getText());
//          cargaLista(vista_produ.getTxt_consulta().getText());
            }
 
        };
        //but_cancelar
        vista_produ.getBut_refrescar().addActionListener(l -> cargaLista());         ///  CARGAR LA TABLA
        vista_produ.getBut_crear().addActionListener(l -> cargarDialogo(1));         ///  CREAR UN PRODUCTO
        vista_produ.getBut_modificar().addActionListener(l -> cargarDialogo(2));     ///  MODIFICAR PRODUCTO
//        vista_produ.getBut_eliminar().addActionListener(l -> EliminarProducto());    ///  ELIMINAR  PRODUCTO
        vista_produ.getjButton1().addActionListener(l->generacodi());
        vista_produ.getBut_cancelar().addActionListener(l->vista_produ.getDlg_Productos().setVisible(false));
        //crearproducto
        boolean hola = true;
        vista_produ.getCrearproducto().addActionListener(l -> {
            try {
                
                if(verificarqueestetodobien()==true){
                DefinirMetodo(1);    
                }else{
                    JOptionPane.showMessageDialog(null,"Datos Incompletos");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });     /// EFECTUAR CREACIÓN
        vista_produ.getEDITAR().addActionListener(l->{
            try {
                
                
                if(verificarqueestetodobien()==true){
                DefinirMetodo(2);    
                }else{
                    JOptionPane.showMessageDialog(null,"Datos Incompletos");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });              /// EFECTUAR EDICION
        //Controlador Buscar
        vista_produ.getTxt_consulta().addKeyListener(kl);                            /// KEYLISTENER
        vista_produ.getBut_atras().addActionListener(l->salir_interfaz());                    /// SALIR
        /////////// EXAMINAR FOTO  //////////////////////////////77
        vista_produ.getExaminarfoto().addActionListener(l->examinarFoto());
        vista_produ.getBut_limpiar().addActionListener(l->limpiartabla());
        vista_produ.getBuscarpor().addActionListener(l->mostrardatosporoton()); 
        vista_produ.getVer().addActionListener(l->vernombres());
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void DefinirMetodo(int n) throws SQLException {
        if (n == 1) {
        grabaProducto();
        } else if (n == 2) {     
        editarProducto();
        } else if (n == 3) {
        EliminarProducto();
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void cargarDialogo(int origen) {
        vista_produ.getDlg_Productos().setSize(690, 530);
        vista_produ.getDlg_Productos().setLocationRelativeTo(vista_produ);
         
        if (origen == 1) { /////////   CREACION
            vista_produ.getCrearproducto().setEnabled(true);
            vista_produ.getEDITAR().setEnabled(false); 
            vista_produ.getjButton1().setEnabled(true);
            vista_produ.getDlg_Productos().setTitle("CREAR");
            //n = 1;
            vista_produ.getDlg_Productos().setVisible(true);
        } else if (origen == 2) {  //////////  EDITAR
            modificarProducto();
            vista_produ.getCrearproducto().setEnabled(false);
            vista_produ.getEDITAR().setEnabled(true); 
            vista_produ.getjButton1().setEnabled(false);
            vista_produ.getDlg_Productos().setTitle("MODIFICAR");
            //n = 2;
            vista_produ.getDlg_Productos().setVisible(true);
        } 
    }
    ////////////////////   TABLA    NORMAL   ///////////////////////////////////
    public static void cargaLista(){
        //Acciones necesarias para extraer los datos MODELO y Mostrar en la vista
        //Estructura JTbable
        vista_produ.getTbl_rep_producto().setDefaultRenderer(Object.class, new Render());
        vista_produ.getTbl_rep_producto().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
 
        modelo_tabla = (DefaultTableModel) vista_produ.getTbl_rep_producto().getModel();
        //tblModel.setNumRows(0);

        int ncols = 1;
        Holder<Integer> i = new Holder<>(0);
        prodi.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            
            vista_produ.getTbl_rep_producto().setValueAt(p.getCodigo(), i.value, 0); 
            vista_produ.getTbl_rep_producto().setValueAt(p.getNombre(), i.value, 1);
            vista_produ.getTbl_rep_producto().setValueAt(p.getDescripcion(), i.value, 2);
            vista_produ.getTbl_rep_producto().setValueAt(p.getExistencias(), i.value, 3);
            vista_produ.getTbl_rep_producto().setValueAt(p.getE_max(), i.value, 4);
            vista_produ.getTbl_rep_producto().setValueAt(p.getE_min(), i.value, 5);
            vista_produ.getTbl_rep_producto().setValueAt(p.getPrecio(), i.value, 6);
            vista_produ.getTbl_rep_producto().setValueAt(p.getCategoria(), i.value, 7);
            vista_produ.getTbl_rep_producto().setValueAt(p.getCod_proveedor(), i.value, 8);
            
            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                vista_produ.getTbl_rep_producto().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista_produ.getTbl_rep_producto().setValueAt(null, i.value, 9);
            }
            i.value++;
         System.out.println(prodi.size());
        }  ///AQUPI TERMINA 
        );
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrardatosporoton(){
        limpiartabla();
        String ida=vista_produ.getTxt_consulta().getText();
        mostrarDatos(ida);
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////     TABLA    CON AGUJA  ////////////////////////////
    public static void mostrarDatos(String ida) {
        vista_produ.getTbl_rep_producto().setDefaultRenderer(Object.class, new Render());
        vista_produ.getTbl_rep_producto().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
//system
        modelo_tabla = (DefaultTableModel) vista_produ.getTbl_rep_producto().getModel();
        //tblModel.setNumRows(0);
        List<productos> lista = modelo_produ.mostrarDatos(ida);
        
        int ncols = 1;
        
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            modelo_tabla.addRow(new Object[ncols]);
            // vista.getTxtNombres().setText(vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1));
            vista_produ.getTbl_rep_producto().setValueAt(p.getCodigo(), i.value, 0);
            vista_produ.getTbl_rep_producto().setValueAt(p.getNombre(), i.value, 1);
            vista_produ.getTbl_rep_producto().setValueAt(p.getDescripcion(), i.value, 2);
            vista_produ.getTbl_rep_producto().setValueAt(p.getExistencias(), i.value, 3);
            vista_produ.getTbl_rep_producto().setValueAt(p.getE_max(), i.value, 4);
            vista_produ.getTbl_rep_producto().setValueAt(p.getE_min(), i.value, 5);
            vista_produ.getTbl_rep_producto().setValueAt(p.getPrecio(), i.value, 6);
            vista_produ.getTbl_rep_producto().setValueAt(p.getCategoria(), i.value, 7);
            vista_produ.getTbl_rep_producto().setValueAt(p.getCod_proveedor(), i.value, 8);
            
            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                renderer.setIcon(icon);
                vista_produ.getTbl_rep_producto().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista_produ.getTbl_rep_producto().setValueAt(null, i.value, 9);
            }
            i.value++;
 
        });
    }
    ////////////////////////    CREAR     PRODUCTO   ///////////////////////////
    public static void grabaProducto() {
        ////////////////////////////////////////////////////////////////////////
        if(controlarvalores()==false){
            JOptionPane.showMessageDialog(vista_produ,"VALORES NUMERIOS INCORRECTOS");
        }else if(controlarvalores()==true){
        String codigo = vista_produ.getTxt_cod().getText();
        String nombre = vista_produ.getTxt_nombre().getText();
        String descripcion = vista_produ.getTxt_descripcion().getText();
        String existencia = vista_produ.getExistencia().getValue().toString();
        String e_minima = vista_produ.getExi_min().getValue().toString();
        String e_maxima = vista_produ.getExi_max().getValue().toString();
        String precio = vista_produ.getPrecio().getValue().toString();
        String categoria = vista_produ.getTxt_categoria().getSelectedItem().toString();
        String codigoproveedor = vista_produ.getCbx_codProvee().getSelectedItem().toString();
        ////////////////////////////////////////////////////////////////////////
        modelo_produ.setCodigo(codigo);
        modelo_produ.setNombre(nombre);
        modelo_produ.setDescripcion(descripcion);
        modelo_produ.setExistencias(Integer.parseInt(existencia));
        modelo_produ.setE_min(Integer.parseInt(e_minima));
        modelo_produ.setE_max(Integer.parseInt(e_maxima));
        modelo_produ.setPrecio(Double.parseDouble(precio));
        modelo_produ.setCategoria(categoria);
        modelo_produ.setCod_proveedor(codigoproveedor);
        
        ImageIcon ic = (ImageIcon) vista_produ.getLblFoto().getIcon();
        modelo_produ.setFoto(ic.getImage());
        
        if (modelo_produ.insertar()) {
            JOptionPane.showMessageDialog(vista_produ, "Producto Creado Satisfactoriamente");
            vista_produ.getDlg_Productos().setVisible(false);
            cargaLista();
        } else {
            JOptionPane.showMessageDialog(vista_produ, "ERROR");
        }
        }
    }
    ///////////////////   EDITAR   PRODUCTO   //////////////////////////////////
    public static void editarProducto() throws SQLException {
        String codigo = vista_produ.getTxt_cod().getText();
        String nombre = vista_produ.getTxt_nombre().getText();
        String descripcion = vista_produ.getTxt_descripcion().getText();
        String existencia = vista_produ.getExistencia().getValue().toString();
        String e_minima = vista_produ.getExi_min().getValue().toString();
        String e_maxima = vista_produ.getExi_max().getValue().toString();
        String precio = vista_produ.getPrecio().getValue().toString();
        String categoria = vista_produ.getTxt_categoria().getSelectedItem().toString();
        String codigoproveedor = vista_produ.getCbx_codProvee().getSelectedItem().toString();
        
         
        modelo_produ.setNombre(nombre);
        modelo_produ.setDescripcion(descripcion);
        modelo_produ.setExistencias(Integer.parseInt(existencia));
        modelo_produ.setE_min(Integer.parseInt(e_minima));
        modelo_produ.setE_max(Integer.parseInt(e_maxima));
        modelo_produ.setPrecio(Double.parseDouble(precio));
        modelo_produ.setCategoria(categoria);
        modelo_produ.setCod_proveedor(codigoproveedor);
          
        ImageIcon ic = (ImageIcon) vista_produ.getLblFoto().getIcon();
        modelo_produ.setFoto(ic.getImage());
        
        int resultado = JOptionPane.showConfirmDialog(vista_produ, "ESTA SEGURO QUE LOS DATOS INGRESADOS SON CORRECTOS", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resultado == JOptionPane.YES_NO_OPTION) {
            if (modelo_produ.modificar(codigo)) {
            JOptionPane.showMessageDialog(vista_produ, "Producto Modificado Satisfactoriamente");
            vista_produ.getDlg_Productos().setVisible(false);
            cargaLista();
            } else {

            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////  ELIMINAR    PRODUCTO   ////////////////////////////////
    public static void EliminarProducto() {
        modelo_productos producto = new modelo_productos();
        int fila = vista_produ.getTbl_rep_producto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista_produ, "PRIMERO SELECCIONE UN PRODUCTO", "ESTEFANIA MUNOZ", 2);
        } else {
            int op = op = JOptionPane.showOptionDialog(null, "ESTA SEGIRO QUE DESEA ELIMNAR ESTE PRODUCTO", "ESTEFANIA MUNOZ",
                    JOptionPane.YES_NO_CANCEL_OPTION, 2, null, new Object[]{"SI", "NO",}, null);
            if (op == 0) {
                String id = String.valueOf(vista_produ.getTbl_rep_producto().getValueAt(fila, 0));
                if (producto.eliminar(id)) {
                    mostrarDatos("");
                    JOptionPane.showMessageDialog(vista_produ, "PRODUCTO ELIMINADO SATISFACTORIAMNETE", "ESTEFANIA MUNOZ", 1);
                    vista_produ.getDlg_Productos().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(vista_produ, "ERROR");
                }
            } else {
                JOptionPane.showMessageDialog(vista_produ, "ACCION CANCELADA", "ESTEFANIA MUNOZ", 1);
            }
        }
    }
    /////////////////  ABRIRI   EL EDIDAR  /////////////////////////////////////
    public static void modificarProducto() {
        int fila = vista_produ.getTbl_rep_producto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista_produ, "PRIMERO SELECCIONE UN PRODUCTO", "ESTEFANIA MUNOZ", 2);
        }else {
            String id = String.valueOf(vista_produ.getTbl_rep_producto().getValueAt(fila, 0));
            for (int i = 0; i <prodi.size(); i++) {
                if(prodi.get(i).getCodigo().equalsIgnoreCase(id)){
                    vista_produ.getTxt_cod().setText(id);
                    vista_produ.getTxt_nombre().setText(prodi.get(i).getNombre());
                    vista_produ.getTxt_descripcion().setText(prodi.get(i).getDescripcion());
                }
            }            
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////    PUERTAS     /////////////////////////////////
    public static void mostrar_interfaz(){vista_produ.setVisible(true);}
    public static void cerrar_interfaz(){vista_produ.setVisible(false);}
    public static void salir_interfaz(){
        cerrar_interfaz();
        limpiartabla();
        vista_produ.getCbx_codProvee().removeAllItems();
        ControladorCajero ccj = new ControladorCajero(vista_menucajero);
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void examinarFoto() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        
        if (estado == JFileChooser.APPROVE_OPTION) {
            ruta=jfc.getSelectedFile().getAbsolutePath();
            try {
                
                Image miImagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista_produ.getLblFoto().getWidth(),
                        vista_produ.getLblFoto().getHeight(),
                        Image.SCALE_DEFAULT);
                
                Icon icono = new ImageIcon(miImagen);
                vista_produ.getLblFoto().setIcon(icono);
                vista_produ.getLblFoto().updateUI();
                vista_produ.getLblFoto().setText("");
            } catch (IOException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    protected void llenarcuadrocedulas(){        
        ////////////////////
        for (int i = 0; i < per.size(); i++) {
        String codigo=per.get(i).getCodigo();
        vista_produ.getCbx_codProvee().insertItemAt(codigo, i);
        }
    }
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
       vista_produ.getTxt_cod().setText(co);
    }
    ///////  COMPROVADORES /////////////////////////////////////////////////////
    ///////////////      COMPRBAR QUE EL CODIGO  SEA ÚNICA      ////////////////
    public static boolean comprobarcodigo(String ide){
        int aa=0;
        for (int i = 0; i < per.size(); i++) {
            if(per.get(i).getCodigo().equals(ide)){
                
            aa=aa+1;   
            }else{
            aa=aa+0;   
            }}
        if(aa==1){
            JOptionPane.showMessageDialog(null,"El coigo: "+ide+" \nYa está ocupado");
            return false;
        }else{
            return true;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////   VERIFICADOR   DE   DATOS  INGRESADOS  ////////////////////
    public static boolean verificarqueestetodobien(){
        int senal=0;

        String existencia = vista_produ.getExistencia().getValue().toString();
        String e_minima = vista_produ.getExi_min().getValue().toString();
        String e_maxima = vista_produ.getExi_max().getValue().toString();
        String precio = vista_produ.getPrecio().getValue().toString();
        
        String categoria = vista_produ.getTxt_categoria().getSelectedItem().toString();
        String codigoproveedor = vista_produ.getCbx_codProvee().getSelectedItem().toString();
        String foto=vista_produ.getLblFoto().getText();
        
        if(vista_produ.getTxt_cod().getText().isEmpty()||vista_produ.getTxt_nombre().getText().isEmpty()||
        vista_produ.getTxt_descripcion().getText().isEmpty()||categoria.equalsIgnoreCase("SELECIONE")||
        foto.equals("IMAGEN")){
        senal=senal+1;
        }else{
        senal=senal+0;
        }
        
        if(senal>0){
            return false;
        }else{
            return true;
        }
    }
    //////////////////////////////////////////////////////////////////////////// 
    public static void limpiartabla(){
        modelo_tabla.getDataVector().removeAllElements();
        vista_produ.getTbl_rep_producto().updateUI();
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void vernombres(){
        String cedula=vista_produ.getCbx_codProvee().getSelectedItem().toString();
        if(cedula.equals("SELECIONES")){
            vista_produ.getApellidoaqui().setText("SIN");
            vista_produ.getNombreaqui().setText("DATOS");
        }else{
            for (int i = 0; i < per.size(); i++) {
                if(per.get(i).getCodigo().equals(cedula)){
                vista_produ.getApellidoaqui().setText(per.get(i).getApellido());
                vista_produ.getNombreaqui().setText(per.get(i).getNombre());        
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static boolean controlarvalores(){
        int valor=0;
        int existencia = Integer.parseInt(vista_produ.getExistencia().getValue().toString());
        int e_minima = Integer.parseInt(vista_produ.getExi_min().getValue().toString());
        int e_maxima = Integer.parseInt(vista_produ.getExi_max().getValue().toString());
 
        
        if (e_minima>e_maxima||existencia>e_maxima||existencia<e_minima){
            return false;
        }else{
            return true;
        }
        
    }
    ////////////////////////////////////////////////////////////////////////////
    
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//