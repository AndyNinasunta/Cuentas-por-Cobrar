/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author andy2
 */
public class Persona_Juridica extends Persona{
    
    //Declaración de las Variables
    private int id_Cliente;
    private String razon_Social;
    private int id_Tipo_Cliente;

    public Persona_Juridica() {
    }

    public Persona_Juridica(int id_Cliente, String razon_Social, int id_Tipo_Cliente, int id_Tipo_Idenficacion, String direccion, String identificacion, boolean estado, String tlf1, String tlf2, String correo) {
        super(id_Tipo_Idenficacion, direccion, identificacion, estado, tlf1, tlf2, correo);
        this.id_Cliente = id_Cliente;
        this.razon_Social = razon_Social;
        this.id_Tipo_Cliente = id_Tipo_Cliente;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getRazon_Social() {
        return razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social;
    }

    public int getId_Tipo_Cliente() {
        return id_Tipo_Cliente;
    }

    public void setId_Tipo_Cliente(int id_Tipo_Cliente) {
        this.id_Tipo_Cliente = id_Tipo_Cliente;
    }
    
    
    
}
