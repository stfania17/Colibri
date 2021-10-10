// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CLASES;

import java.util.Date;

public class clientes extends persona{
    
    String codigo;
    String correo;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public clientes(String cedula, String apellido, String nombre, String telefono, String direccion, Date fechanacimiento, String codigo, String correo) {
        super(cedula, apellido, nombre, telefono, direccion, fechanacimiento);
        this.codigo=codigo;
        this.correo=codigo;
    }
    public clientes(){   
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public String Mostrardatos(){
        return super.Mostrardatos()+"\n|| Codigo Cliente:: "+codigo+" ||"
                + "\n|| Correo: "+correo+" ||";
    }
    
 
    
    

    
    
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//