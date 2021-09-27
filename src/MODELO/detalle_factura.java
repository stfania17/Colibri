// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package MODELO;

 
public class detalle_factura {
    
    String codigo;
    String cod_encabezado;
    String cod_producto;
    int cantidad;
    double precio_final;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public detalle_factura(String codigo, String cod_encabezado, String cod_producto, int cantidad, double precio_final) {
        this.codigo = codigo;
        this.cod_encabezado = cod_encabezado;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.precio_final = precio_final;
    }
    public detalle_factura(){
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCod_encabezado() {
        return cod_encabezado;
    }
    public void setCod_encabezado(String cod_encabezado) {
        this.cod_encabezado = cod_encabezado;
    }
    public String getCod_producto() {
        return cod_producto;
    }
    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio_final() {
        return precio_final;
    }
    public void setPrecio_final(double precio_final) {
        this.precio_final = precio_final;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String MostrarInformacion() {
        return "|| Detalle Factura ||" 
              +"\n|| Codigo= " + codigo + " ||"
              +"\n|| Cod_encabezado= " + cod_encabezado + " ||"
              +"\n|| Cod_producto=  " + cod_producto + " ||"
              +"\n|| Cantidad= " + cantidad + " ||"
              +"\n|| Precio_final=" + precio_final +" ||";
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//