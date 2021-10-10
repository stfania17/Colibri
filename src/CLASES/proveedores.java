// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CLASES;

import java.util.Date;

 
public class proveedores extends persona{
    
    String codigo;
    String numero_cuenta;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public proveedores(String codigo,String numero_cuenta,String cedula, String apellido, String nombre, String telefono, String direccion, Date fechanacimiento){
        super(cedula, apellido, nombre, telefono, direccion, fechanacimiento);
        this.codigo=codigo;
        this.numero_cuenta=numero_cuenta;
    }
    public proveedores(){
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNumero_cuenta() {
        return numero_cuenta;
    }
    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public String Mostrardatos() {
        return super.Mostrardatos()+"\n || Codigo Proveedores: "+codigo+" ||"
                + "\n|| Numero Cuenta:: "+numero_cuenta+" ||"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//