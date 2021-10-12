// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONTROLADOR;

import CLASES.detalle_factura;
import CLASES.encabezado_factura;
import CONECCIÓN_SQL.Modelo_cabeza_factura;
import CONECCIÓN_SQL.SQConnect;
import CONECCIÓN_SQL.modelo_detalle_factura;
import VISTA.Vista_factura;
import VISTA.Vista_ingreso;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRFontNotFoundException;


public class Control_reporte_factura {
    ////////////////////   VISTAS   ///////////////////////////////////
    public static Vista_factura vista_fac = new Vista_factura();
    public static Vista_ingreso caje = new Vista_ingreso();
    ///////////////////////   MODELOS  SQL     /////////////////////////////////
    public static Modelo_cabeza_factura modeloafactura = new Modelo_cabeza_factura();
    public static modelo_detalle_factura modelodetalle = new modelo_detalle_factura();
    ///////////////////////   TABLA    /////////////////////////////////////////
    public static DefaultTableModel modalotabla;
    ///////////////////    ARRAYS                         //////////////////////
    public static List<encabezado_factura> listacabeza = modeloafactura.mostrarDatos(); 
    public static List<detalle_factura> listadetalle = modelodetalle.mostrarDatos();
    
    ///////////////////////   VARIABLES    ///////////////////////////
    public static int n;
    ///////////////////////    BREQUER    /////////////////////////
    public Control_reporte_factura(Vista_factura fac) {
        this.vista_fac  = fac;
        fac.setTitle("PROVEEDORES");
        mostrar();
        inicarcontrol();
        /////////////  TABLAS  /////////////////////////////////////////////
        llenartablacabeza();
        llenartabladetallefactura();
    }
    
    public void inicarcontrol(){
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
            String codigocabeza=vista_fac.getBuscacabeza().getText();
            String codigodetalle=vista_fac.getBuscadetalle().getText();
            
            mostrartablacabezaporvisor(codigocabeza);
            mostrartabladetallesporvisor(codigodetalle);
            }
            
        };
        vista_fac.getBuscacabeza().addKeyListener(ky);
        vista_fac.getBuscadetalle().addKeyListener(ky);
        
        vista_fac.getBut_limpiar().addActionListener(l-> limpiartabla());
        vista_fac.getBut_atras().addActionListener(l->salir()); 
        vista_fac.getBut_consultar().addActionListener(l->refrscaramabs());
        
        
        vista_fac.getFacturasjasper().addActionListener(l->{
            try {
                abrirjasper();
            } catch (JRException ex) {
                Logger.getLogger(Control_reporte_factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////    PUERTAS    /////////////////////////////////////
    public static void mostrar(){vista_fac.setVisible(true);}
    public static void cerrar(){vista_fac.setVisible(false);}
    public static void salir(){
        cerrar();  
        ControladorCajero cc = new ControladorCajero(caje);
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void llenartablacabeza(){
        modalotabla=(DefaultTableModel)vista_fac.getCabezafactura().getModel();
        modalotabla.setRowCount(0);
        
        for (int i = 0; i < listacabeza.size(); i++) {
        Object [] fila ={i,listacabeza.get(i).getCodigo(),listacabeza.get(i).getCod_cliente(),
        listacabeza.get(i).getFecha()};
        modalotabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
        }
    }
    ////////////////////////////////////////////////////////////////////////////       
    public static void llenartabladetallefactura(){
        modalotabla=(DefaultTableModel)vista_fac.getTabladetalles().getModel();
        modalotabla.setRowCount(0);
        
        for (int i = 0; i < listadetalle.size(); i++) {
        Object [] fila ={i,listadetalle.get(i).getCodigo(),listadetalle.get(i).getCod_encabezado(),
        listadetalle.get(i).getCod_producto(),listadetalle.get(i).getCantidad(),listadetalle.get(i).getPrecio_final()};        
        modalotabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
        }
    }
    ////////////////////////////////////////////////////////////////////////////   
    ////////////////////////////////////////////////////////////////////////////
    /////////////////7//  TABLA   POR  CODIGO  /////////////////////////////////
    public static void mostrartablacabezaporvisor(String codei){
    modalotabla=(DefaultTableModel)vista_fac.getCabezafactura().getModel();
    modalotabla.setRowCount(0);
    List<encabezado_factura> listacabeza = modeloafactura.mostrarDatos(codei);
    
    DefaultTableModel modalota=(DefaultTableModel)vista_fac.getTabladetalles().getModel();
    modalota.setRowCount(0);
    ////////////////////////////////////////////////////////////////////////////
    for (int i = 0; i < listacabeza.size(); i++) {
    Object [] fila ={i+1,listacabeza.get(i).getCodigo(),listacabeza.get(i).getCod_cliente(),
    listacabeza.get(i).getFecha()};
    modalotabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
    ////////////////////////////////////////////////////////////////////////////      
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mostrartabladetallesporvisor(String codei){
    modalotabla=(DefaultTableModel)vista_fac.getTabladetalles().getModel();
    modalotabla.setRowCount(0);
    List<detalle_factura> listadetalle = modelodetalle.mostrarDatos(codei);
    ////////////////////////////////////////////////////////////////////////////
    for (int i = 0; i < listadetalle.size(); i++) {
    Object [] fila ={i+1,listadetalle.get(i).getCodigo(),listadetalle.get(i).getCod_encabezado(),
    listadetalle.get(i).getCod_producto(),listadetalle.get(i).getCantidad(),listadetalle.get(i).getPrecio_final()};        
    modalotabla.addRow(fila); //AGREGAR LAS FILAS A LA TABLA DE LA INTERFAZ.
    }
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void mermarcantidadoficial(){
        
    }
    ////////////////////////////////////////////////////////////////////////////
    public static void refrscaramabs(){
        llenartablacabeza();
        llenartabladetallefactura();
    }
    ////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////// 
    public static void limpiartabla(){
        modalotabla.getDataVector().removeAllElements();
        vista_fac.getCabezafactura().updateUI();
        vista_fac.getTabladetalles().updateUI();           
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void abrirjasper() throws JRException{
        SQConnect  hola = new SQConnect();
        
        try {
        JasperReport jr=(JasperReport)JRLoader.loadObject(getClass().getResource("/ARCHIVOS/COLIBRI.jasper"));
        
        Map<String, Object> parametro = new HashMap<String, Object>();
        String aguj="";
        aguj=vista_fac.getBuscacabeza().getText();  
        parametro.put("aguja","%"+aguj+"%");
        
        JasperPrint jp = JasperFillManager.fillReport(jr,parametro,hola.getCon());
        JasperViewer jv = new JasperViewer(jp); 
        jv.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(Control_reporte_factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
////////////////////////////////////////////////////////////////////////////////
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//