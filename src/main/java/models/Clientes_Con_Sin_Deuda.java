
package models;

import java.io.Serializable;

//Reporte para los clientes con y sin Deuda
public class Clientes_Con_Sin_Deuda extends Persona implements Serializable{
    //Declaracion de las variables que necesita una Cartera x Edades
    private double valorPendiente;
    
    //Constructor vacio
    public Clientes_Con_Sin_Deuda() {
    }
    
    
    //Constructor con todos los datos necesarios para mostrar los clientes
    //con y sin deuda
    public Clientes_Con_Sin_Deuda(double valorPendiente, int idCliente, String descrIdentificacion, String razonNombre, String direccion, String tlf1, String tlf2, String correo) {
        super(idCliente, descrIdentificacion, razonNombre, direccion, tlf1, tlf2, correo);
        this.valorPendiente = valorPendiente;
    }    
    
    //Declaracion de  Getters y Setters

    public double getValorPendiente() {
        return valorPendiente;
    }

    public void setValorPendiente(double valorPendiente) {
        this.valorPendiente = valorPendiente;
    }
}
