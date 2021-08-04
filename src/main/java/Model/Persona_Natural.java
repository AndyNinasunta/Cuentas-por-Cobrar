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
public class Persona_Natural extends Persona{
    
    //Declaración de las Variables
    private int id_Cliente;
    private String sexo;
    private String genero;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellidos2;
    private String fecha_nacimiento;
    private int id_Tipo_Cliente;

    
    public Persona_Natural() {
    }

    public Persona_Natural(int id_Cliente, String sexo, String genero, String nombre1, String nombre2, String apellido1, String apellidos2, String fecha_nacimiento, int id_Tipo_Cliente, int id_Tipo_Idenficacion, String direccion, String identificacion, boolean estado, String tlf1, String tlf2, String correo) {
        super(id_Tipo_Idenficacion, direccion, identificacion, estado, tlf1, tlf2, correo);
        this.id_Cliente = id_Cliente;
        this.sexo = sexo;
        this.genero = genero;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellidos2 = apellidos2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_Tipo_Cliente = id_Tipo_Cliente;
    }

    

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellidos2() {
        return apellidos2;
    }

    public void setApellidos2(String apellidos2) {
        this.apellidos2 = apellidos2;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_Tipo_Cliente() {
        return id_Tipo_Cliente;
    }

    public void setId_Tipo_Cliente(int id_Tipo_Cliente) {
        this.id_Tipo_Cliente = id_Tipo_Cliente;
    }

    
}
