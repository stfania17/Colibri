/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CONECCIÓN_SQL.modelo_clientes;
import VISTA.Vista_ingreso_cliente;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class ControlRegistroCliente {
    
    private Vista_ingreso_cliente cliente;
    private modelo_clientes modelo;

    public ControlRegistroCliente(Vista_ingreso_cliente cliente) {
        this.cliente = cliente;
        cliente.setTitle("CLIENTES");
        cliente.setVisible(true);
    }
    
    public void iniciaControl() { 
        cliente.getBut_aceptar().addActionListener(l -> crearCliente());
        
    }
    
    public void crearCliente(){
        Instant instant = cliente.getDtcFechaNacimiento().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fecha = Date.valueOf(zdt.toLocalDate());
        
        String codigo = cliente.getTxt_id().getText();
        String nombre = cliente.getTxt_nombres().getText();
        String apellido = cliente.getTxt_apellidos().getText();
        String direccion = cliente.getTxt_direccion().getText();
        String telefono = cliente.getTxt_telefono().getText();
        String correo = cliente.getTxt_correo().getText();
        //String precio = cliente.getPrecio().getValue().toString();
   
        modelo.setCodigo(codigo);
        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        modelo.setDireccion(direccion);
        modelo.setTelefono(telefono);
        modelo.setCorreo(correo);
        modelo.setFechanacimiento(fecha);
        
        if (modelo.insertar()) {
            JOptionPane.showMessageDialog(cliente, "Cliente Creado Satisfactoriamente");
        } else {
            JOptionPane.showMessageDialog(cliente, "ERROR");
        }
    }
}
