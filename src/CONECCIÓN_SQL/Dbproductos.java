// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import MODELO.persona;
import MODELO.productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dbproductos extends productos{
    SQConnect connecta =  new SQConnect();
    ////////////////////////////////////////////////////////////////////////////
    public Dbproductos(String codigo, String nombre, String descripcion, int existencias, int e_min, int e_max, double precio, String categoria, String cod_proveedor) {
        super(codigo, nombre, descripcion, existencias, e_min, e_max, precio, categoria, cod_proveedor);
    }
    public Dbproductos(){  
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarProductos() {

        try {
            List<productos> lista = new ArrayList<productos>();
            String sql = "select * from productos";
            ResultSet rs = connecta.query(sql);
            while (rs.next()) {
                ////////////////////////////////////////
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
                lista.add(prd);
                ////////////////////////////////////////
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Dbproductos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<productos> mostrarDatos(String ida) {
        String sql = "select * from productos where ";
            sql+=" UPPER(codigo) like UPPER('%"+ ida + "%') ";
            ResultSet rs = connecta.consulta(sql);
            List<productos> lista = new ArrayList<productos>();
        try {
            while (rs.next()) {
                ////////////////////////////////////////
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
                lista.add(prd);
                ////////////////////////////////////////
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Dbproductos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean insertar(){     
    String nsql="INSERT INTO productos(\n" +
"	codigo, nombre, descripcion, existencias, e_min, e_max, precio, categoria, cod_proveedor)\n" +
"	VALUES ('"+getCodigo()+"','"+getNombre()+"','"+getDescripcion()+"','"+getExistencias()+"','"+getE_min()+"','"+getE_max()+"','"+getPrecio()+"','"+getCategoria()+"','"+getCod_proveedor()+"')";
        System.out.println(getNombre()+" NOMBRE "+ getCod_proveedor());
    if (connecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean modificar(String identificador){
        String nsql = "UPDATE productos set \"nombre\"='"+getNombre()+"',\"descripcion\"='"+getDescripcion()+"',\"existencias\"='"+getExistencias()+"'"
        +",\"e_min\"='"+getE_min()+"',\"e_max\"='"+getE_max()+",\"precio\"='"+getPrecio()+",\"categoria\"='"+getCategoria()+"'"
        +",\"cod_proveedor\"='"+getCod_proveedor()
        + "WHERE \"codigo\"='"+identificador+"'";
        if(connecta.noQuery(nsql)==null){
            return true;
        }else{
            System.out.println("Error al editar");
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
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//