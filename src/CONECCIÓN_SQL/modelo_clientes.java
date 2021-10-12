// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import CLASES.clientes;
import CLASES.proveedores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class modelo_clientes extends clientes{    
    SQConnect connecta =  new SQConnect();
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public modelo_clientes(String cedula, String apellido, String nombre, String telefono, String direccion, Date fechanacimiento, String codigo, String correo) {
        super(cedula, apellido, nombre, telefono, direccion, fechanacimiento, codigo, correo);
    }
    public modelo_clientes() {
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<clientes> mostrarDatos() {

        try {
            List<clientes> lista = new ArrayList<clientes>();
            String sql = "select * from clientes";
            ResultSet rs = connecta.query(sql);
            while (rs.next()) {
                ////////////////////////////////////////
                clientes prd = new clientes();
                prd.setCodigo(rs.getString("codigo"));
                prd.setCorreo(rs.getString("correo"));
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
            Logger.getLogger(modelo_clientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public List<clientes> mostrarDatos(String ida) {
        String sql = "select * from clientes where ";
            sql+=" codigo like ('%"+ida+ "%') ";
            sql+=" or cedula like ('%"+ida+ "%') ";
            sql+=" or apellido like ('%"+ida+ "%') ";
            sql+=" or nombre like ('%"+ida+ "%') ";
            ResultSet rs = connecta.consulta(sql);
            List<clientes> lista = new ArrayList<clientes>();
        try {
            while (rs.next()) {
                ////////////////////////////////////////
                clientes prd = new clientes();
                prd.setCodigo(rs.getString("codigo"));
                prd.setCorreo(rs.getString("correo"));
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
            Logger.getLogger(modelo_clientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public boolean insertar(){     
    String nsql="INSERT INTO clientes(\n" +
"	codigo, correo, cedula, apellido, nombre, telefono, direccion, fecha)\n" +
"	VALUES ('"+getCodigo()+"','"+getCorreo()+"','"+getCedula()+"','"+getApellido()+"','"+getNombre()+"','"+getTelefono()+"','"+getDireccion()+"','"+getFechanacimiento()+"')";
     if (connecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean modificar(String identificador){
        String nsql = "UPDATE clientes set \"correo\"='"+getCorreo()+"',\"apellido\"='"+getApellido()+"',\"nombre\"='"+getNombre()+"'"
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
        String nsql = "delete from clientes where \"codigo\"='" +indentificar+ "'";
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