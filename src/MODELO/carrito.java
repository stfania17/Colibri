// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package MODELO;

// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ// 
public class carrito {
////////////////////////////////////////////////////////////////////////////////    
    String codigo;
    String nombre;
    int cantidad;
    double precio;
    double precio_final;
////////////////////////////////////////////////////////////////////////////////
    public carrito(String codigo, String nombre, int cantidad, double precio, double precio_final) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precio_final = precio_final;
    }
    public carrito(){ 
    }
////////////////////////////////////////////////////////////////////////////////
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
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrecio_final() {
        return precio_final;
    }
    public void setPrecio_final(double precio_final) {
        this.precio_final = precio_final;
    }
////////////////////////////////////////////////////////////////////////////////
    public String MonstrarDatos() {
        return "|| Carrito || " 
            +"\n|| Codigo= "+codigo+" ||"
            +"\n|| Nombre= "+nombre+" || "
            +"\n|| Cantidad= "+cantidad+" ||"
            +"\n|| Precio= "+precio+" || "
            +"\n|| Precio Final=" + precio_final +" ||";
    }
////////////////////////////////////////////////////////////////////////////////
public double preciofinal(double cantidad, double precio){
    precio_final=cantidad*precio;
    return precio_final;
}    
////////////////////////////////////////////////////////////////////////////////    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//