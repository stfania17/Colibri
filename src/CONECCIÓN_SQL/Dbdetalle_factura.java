// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import MODELO.detalle_factura;
import MODELO.persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Dbdetalle_factura extends detalle_factura {
    SQConnect connecta =  new SQConnect();
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public Dbdetalle_factura(String codigo, String cod_encabezado, String cod_producto, int cantidad, double precio_final) {
        super(codigo, cod_encabezado, cod_producto, cantidad, precio_final);
    }
    public Dbdetalle_factura(){       
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<detalle_factura> mostrarDatos() {

        try {
            List<detalle_factura> lista = new ArrayList<detalle_factura>();
            String sql = "select * from detalle_factura";
            ResultSet rs = connecta.query(sql);
            while (rs.next()) {
                ////////////////////////////////////////
                detalle_factura prd = new detalle_factura();
                prd.setCodigo(rs.getString("codigo"));
                prd.setCod_encabezado(rs.getString("cod_encabezado"));
                prd.setCod_producto(rs.getString("cod_producto"));
                prd.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                prd.setPrecio_final(Double.parseDouble(rs.getString("precio_final")));                
                lista.add(prd);
                ////////////////////////////////////////
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Dbdetalle_factura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<detalle_factura> mostrarDatos(String ida) {
        String sql = "select * from detalle_factura where ";
            sql+=" UPPER(codigo) like UPPER('%"+ ida + "%') ";
            ResultSet rs = connecta.consulta(sql);
            List<detalle_factura> lista = new ArrayList<detalle_factura>();
        try {
            while (rs.next()) {
                ////////////////////////////////////////
                detalle_factura prd = new detalle_factura();
                prd.setCodigo(rs.getString("codigo"));
                prd.setCod_encabezado(rs.getString("cod_encabezado"));
                prd.setCod_producto(rs.getString("cod_producto"));
                prd.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                prd.setPrecio_final(Double.parseDouble(rs.getString("precio_final")));                
                lista.add(prd);
                ////////////////////////////////////////
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Dbdetalle_factura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean insertar(){     
    String nsql="INSERT INTO detalle_factura(\n" +
"	codigo, cod_encabezado, cod_producto, cantidad, precio_final)\n" +
"	VALUES ('"+getCodigo()+"','"+getCod_encabezado()+"','"+getCod_producto()+"','"+getCantidad()+"','"+getPrecio_final()+"')";
     if (connecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//