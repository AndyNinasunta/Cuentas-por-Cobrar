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
public class Persona {
    
    //Declaración de las Variables
    private int id_Tipo_Idenficacion;
    private String direccion;
    private String identificacion;
    private boolean estado;
    private String tlf1;
    private String tlf2;
    private String correo;

    public Persona() {
    }

    public Persona(int id_Tipo_Idenficacion, String direccion, String identificacion, boolean estado, String tlf1, String tlf2, String correo) {
        this.id_Tipo_Idenficacion = id_Tipo_Idenficacion;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.estado = estado;
        this.tlf1 = tlf1;
        this.tlf2 = tlf2;
        this.correo = correo;
    }
    
    public int getId_Tipo_Idenficacion() {
        return id_Tipo_Idenficacion;
    }

    public void setId_Tipo_Idenficacion(int id_Tipo_Idenficacion) {
        this.id_Tipo_Idenficacion = id_Tipo_Idenficacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTlf1() {
        return tlf1;
    }

    public void setTlf1(String tlf1) {
        this.tlf1 = tlf1;
    }

    public String getTlf2() {
        return tlf2;
    }

    public void setTlf2(String tlf2) {
        this.tlf2 = tlf2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
