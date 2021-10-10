//ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import CLASES.proveedores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class modelo_proveedores extends proveedores{
    SQConnect connecta =  new SQConnect();
    public modelo_proveedores(String cedula, String apellido, String nombre, String telefono, String direccion, Date fechanacimiento, String codigo, String numero_cuenta) {
        super(codigo, numero_cuenta,cedula, apellido, nombre, telefono, direccion, fechanacimiento);
    }
    public modelo_proveedores(){
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<proveedores> mostrarDatos() {

        try {
            List<proveedores> lista = new ArrayList<proveedores>();
            String sql = "select * from proveedores";
            ResultSet rs = connecta.query(sql);
            while (rs.next()) {
                ////////////////////////////////////////
                proveedores prd = new proveedores();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNumero_cuenta(rs.getString("numero_cuenta"));
                prd.setCedula(rs.getString("cedula"));
                prd.setApellido(rs.getString("apellido"));
                prd.setNombre(rs.getString("nombre"));
                prd.setTelefono(rs.getString("telefono"));
                prd.setDireccion(rs.getString("direccion"));
                prd.setFechanacimiento(rs.getDate("fecha"));
                lista.add(prd);
                ////////////////////////////////////////
            }
            ////////////////////////////////////////////////////////////////////
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_proveedores.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public List<proveedores> mostrarDatos(String ida) {
        String sql = "select * from proveedores where ";
            sql+=" UPPER(codigo) like UPPER('%"+ ida + "%') ";
            ResultSet rs = connecta.consulta(sql);
            List<proveedores> lista = new ArrayList<proveedores>();
        try {
            while (rs.next()) {
                ////////////////////////////////////////
                proveedores prd = new proveedores();
                prd.setCodigo(rs.getString("codigo"));
                prd.setNumero_cuenta(rs.getString("numero_cuenta"));
                prd.setCedula(rs.getString("cedula"));
                prd.setApellido(rs.getString("apellido"));
                prd.setNombre(rs.getString("nombre"));
                prd.setTelefono(rs.getString("telefono"));
                prd.setDireccion(rs.getString("direccion"));
                prd.setFechanacimiento(rs.getDate("fecha"));
                lista.add(prd);
                ////////////////////////////////////////
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(modelo_proveedores.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean insertar(){     
    String nsql="INSERT INTO proveedores(\n" +
"	codigo, numero_cuenta, cedula, apellido, nombre, telefono, direccion, fecha)\n" +
"	VALUES ('"+getCodigo()+"','"+getNumero_cuenta()+"','"+getCedula()+"','"+getApellido()+"','"+getNombre()+"','"+getTelefono()+"','"+getDireccion()+"','"+getFechanacimiento()+"')";
     if (connecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean modificar(String identificador){
        String nsql = "UPDATE proveedores set \"numero_cuenta\"='"+getNumero_cuenta()+"',\"cedula\"='"+getCedula()+"',\"apellido\"='"+getApellido()+"',\"nombre\"='"+getNombre()+"'"
        +",\"telefono\"='"+getTelefono()+"',\"direccion\"='"+getDireccion()+"',\"fecha\"='"+getFechanacimiento()+"'"
         + "WHERE \"codigo\"='"+identificador+"'";
        if(connecta.noQuery(nsql)==null){
            return true;
        } else {
            System.out.println("Error al editar");
            return false;
        }  
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean eliminar(String indentificar){
        String nsql = "delete from proveedores where \"codigo\"='" +indentificar+ "'";
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