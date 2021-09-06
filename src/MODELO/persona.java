// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package MODELO;

import java.util.Date;

 
public class persona {
    
    String cedula;
    String apellido;
    String nombre;
    String telefono;
    String direccion;
    Date fechanacimiento;

    public persona(String cedula, String apellido, String nombre, String telefono, String direccion, Date fechanacimiento) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechanacimiento = fechanacimiento;
    }
    public persona(){     
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String Mostrardatos() {
        return "|| PERSONA" + 
             "\n|| Cedula= " + cedula + " ||"
            +"\n|| Apellido= " + apellido + " ||"
            +"\n|| Nombre= "+ nombre +" ||"
            +"\n|| Telefono= " + telefono + " ||"
            +"\n|| Direccion= " + direccion + " ||"
            +"\n|| Fecha nacimiento= " + fechanacimiento +" ||";
    }
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//