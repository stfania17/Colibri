// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import CLASES.clientes;
import CLASES.encabezado_factura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_cabeza_factura extends encabezado_factura {
    SQConnect connecta =  new SQConnect();
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public Modelo_cabeza_factura(String codigo, String cod_cliente, Date fecha) {
        super(codigo, cod_cliente, fecha);
    }
    public Modelo_cabeza_factura(){
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<encabezado_factura> mostrarDatos() {

        try {
            List<encabezado_factura> lista = new ArrayList<encabezado_factura>();
            String sql = "select * from encabezado_factura";
            ResultSet rs = connecta.query(sql);
            while (rs.next()) {
                ////////////////////////////////////////
                encabezado_factura prd = new encabezado_factura();
                prd.setCodigo(rs.getString("codigo"));
                prd.setCod_cliente(rs.getString("cod_cliente"));
                prd.setFecha(rs.getDate("fecha"));
                lista.add(prd);
                ////////////////////////////////////////
            }
            ////////////////////////////////////////////////////////////////////
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_cabeza_factura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<encabezado_factura> mostrarDatos(String ida) {
        String sql = "select * from encabezado_factura where ";
            sql+=" UPPER(codigo) like UPPER('%"+ ida + "%') ";
            sql += " OR upper(cod_cliente) like Upper('%" + ida + "%') ";
            ResultSet rs = connecta.consulta(sql);
            List<encabezado_factura> lista = new ArrayList<encabezado_factura>();
        try {
            while (rs.next()) {
                ////////////////////////////////////////
                encabezado_factura prd = new encabezado_factura();
                prd.setCodigo(rs.getString("codigo"));
                prd.setCod_cliente(rs.getString("cod_cliente"));
                prd.setFecha(rs.getDate("fecha"));
                lista.add(prd);
                ////////////////////////////////////////
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_cabeza_factura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean insertar(){     
    String nsql="INSERT INTO encabezado_factura(\n" +
"	codigo, cod_cliente, fecha)\n" +
"	VALUES ('"+getCodigo()+"','"+getCod_cliente()+"','"+getFecha()+"')";
     if (connecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
}
// ESPINOZA ALFONSO DAVID, FABIAN GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//