// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import CLASES.persona;
import CLASES.productos;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

public class modelo_productos extends productos{
    SQConnect connecta =  new SQConnect();
    byte[] fota;
    ////////////////////////////////////////////////////////////////////////////
    public modelo_productos(String codigo, String nombre, String descripcion, int existencias, int e_min, int e_max, double precio, String categoria, String cod_proveedor, Image foto,byte[] fota) {
        super(codigo, nombre, descripcion, existencias, e_min, e_max, precio, categoria, cod_proveedor, foto);
        this.fota=fota;
    }
    public modelo_productos(){  
    }

    public byte[] getFota() {
        return fota;
    }
    public void setFota(byte[] fota) {
        this.fota = fota;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private BufferedImage imgBimage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0, null);
        bGR.dispose();
        return bi;
    }
    private Image obtenerImage(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(source);
        } catch (IOException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        try {
            return reader.read(0, param);
        } catch (IOException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarProductos() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosLacteos() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            sql+=" where UPPER(categoria) like 'LACTEOS' ";
            
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosGranos() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            sql+=" where UPPER(categoria) like 'GRANOS' ";
            
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosVerduras() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            sql+=" where UPPER(categoria) like 'VERDURAS' ";
            
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosHierbas() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            sql+=" where UPPER(categoria) like 'HIERBAS' ";
            
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosOtros() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            sql+=" where UPPER(categoria) like 'OTROS' ";
            
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosFrutas() {

        try {

            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            sql+=" where UPPER(categoria) like 'FRUTAS' ";
            
            ResultSet rs = connecta.query(sql);

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                
                lista.add(prd);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatos(String cadena) {

        try {

            String sql = "select * from productos where ";
            sql+=" UPPER(codigo) like UPPER('%"+ cadena + "%')";
            sql+="or UPPER (nombre) like UPPER ('%"+cadena+"%')";
            sql+="or UPPER (cod_proveedor) like UPPER ('%"+cadena+"%')";
            
            
            ResultSet rs = connecta.consulta(sql);
            List<productos> lp = new ArrayList<>();

            byte[] bf;
            while (rs.next()) {
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 

                bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                lp.add(prd);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDato(String ida,String categoria) {
        
        try {
            String sql = "select * from productos where ";
            sql+=" UPPER(categoria) like UPPER('%"+categoria+ "%')";
            sql+="AND UPPER (codigo) like UPPER ('%"+ida+"%')";
            sql+="or UPPER (nombre) like UPPER ('%"+ida+"%')";
            sql+="or UPPER (cod_proveedor) like UPPER ('%"+ida+"%')";

            ResultSet rs = connecta.consulta(sql);
            List<productos> lista = new ArrayList<productos>();

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                lista.add(prd);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatosPorcategoria(String ida,String ede) {
        try {
            String sql = "select * from productos where ";
            sql+=" UPPER(categoria) like UPPER('%"+ida+"%')";
            sql+="AND UPPER(codigo) like UPPER('%"+ ede + "%') ";
            

            ResultSet rs = connecta.consulta(sql);
            List<productos> lista = new ArrayList<productos>();

            byte[] bf;
            while (rs.next()) {
 
                productos prd = new productos();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNombre(rs.getString("nombre"));
                prd.setDescripcion(rs.getString("descripcion"));
                prd.setExistencias(Integer.parseInt(rs.getString("existencias")));
                prd.setE_min(Integer.parseInt(rs.getString("e_min")));
                prd.setE_max(Integer.parseInt(rs.getString("e_max"))); 
                prd.setPrecio(Double.parseDouble(rs.getString("precio")));
                prd.setCategoria(rs.getString("categoria"));
                prd.setCod_proveedor(rs.getString("cod_proveedor")); 
                bf = rs.getBytes("foto");
                 
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    prd.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                lista.add(prd);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public boolean insertar(){     
        
        String foto64 = null;
        try {
            BufferedImage img = imgBimage(getFoto());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);

        } catch (IOException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
    String nsql="INSERT INTO productos(\n" +
"	codigo, nombre, descripcion, existencias, e_min, e_max, precio, categoria, cod_proveedor, foto)\n" +
"	VALUES ('"+getCodigo()+"','"+getNombre()+"','"+getDescripcion()+"','"+getExistencias()+"','"+getE_min()+"','"+getE_max()+"','"+getPrecio()+"','"+getCategoria()+"','"+getCod_proveedor()+"','"+foto64+"')";
        System.out.println(getNombre()+" NOMBRE "+ getCod_proveedor());
        
        if(connecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public boolean modificar(String identificador) throws SQLException{     
        String foto64 = null;
        try {

            BufferedImage img = imgBimage(getFoto());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);

        } catch (IOException ex) {
            Logger.getLogger(modelo_productos.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    ///////////////////////////////////////////////////////    
        String sqla = "UPDATE productos "
                + "SET nombre='" + getNombre() + "', descripcion='"+getDescripcion()+"', existencias='" + getExistencias()
                + "', e_min='" + getE_min() + "', e_max='" + getE_max() + "', precio='" + getPrecio()
                + "', categoria='" + getCategoria() +"' , cod_proveedor='"+getCod_proveedor()+"', foto= '" + foto64 + "'"
                + " WHERE codigo= '" +  identificador+ "'";
        
//        System.out.println(sqla);
//        return connecta.accion(sqla);
        
        if(connecta.noQuery(sqla) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean eliminar(String identificar){
        String nsql = "delete from productos where \"codigo\"='" +identificar+ "'";
        if(connecta.noQuery(nsql)==null){
            return true;
        }else{
            System.out.println("Error eliminar");
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
 
//////////////////////////////////////////////////////////////////////////////// 
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//