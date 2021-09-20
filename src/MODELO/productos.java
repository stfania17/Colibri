// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package MODELO;

 
public class productos {
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    String codigo;
    String nombre;
    String descripcion;
    int existencias;
    int e_min;
    int e_max;
    double precio;
    String categoria;
    String cod_proveedor;
    String foto;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public productos(String codigo, String nombre, String descripcion, int existencias, int e_min, int e_max, double precio, String categoria, String cod_proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.e_min = e_min;
        this.e_max = e_max;
        this.precio = precio;
        this.categoria = categoria;
        this.cod_proveedor = cod_proveedor;
    }
    public productos() {
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    public int getE_min() {
        return e_min;
    }
    public void setE_min(int e_min) {
        this.e_min = e_min;
    }
    public int getE_max() {
        return e_max;
    }
    public void setE_max(int e_max) {
        this.e_max = e_max;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getCod_proveedor() {
        return cod_proveedor;
    }
    public void setCod_proveedor(String cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String MostrarDatos() {
        return "|| Productos "
            +"\n|| Codigo= " + codigo + " ||"
            +"\n|| Nombre= " + nombre + " ||"
            +"\n|| Descripcion= " + descripcion + " ||"
            +"\n|| Existencias= " + existencias + " ||"
            +"\n|| e_min= " + e_min + " ||"
            +"\n|| e_max= " + e_max + " ||"
            +"\n|| Precio= " + precio + " ||"
            +"\n|| Categoria= " + categoria + " ||"
            +"\n|| Cod_proveedor=" + cod_proveedor + '}';
    }
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//