// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package MODELO;

import java.util.Date;

public class encabezado_factura {
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    String codigo;
    String cod_cliente;
    Date fecha;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public encabezado_factura(String codigo, String cod_cliente, Date fecha) {
        this.codigo = codigo;
        this.cod_cliente = cod_cliente;
        this.fecha = fecha;
    }
    public encabezado_factura(){
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCod_cliente() {
        return cod_cliente;
    }
    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public String MostrarInformacion() {
        return "|| Encabezado Factura ||" 
            +"\n|| Codigo= " + codigo + " ||"
            +"\n|| Cod_cliente= " + cod_cliente + " ||"
            +"\n|| Fecha=" + fecha +" ||";
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//