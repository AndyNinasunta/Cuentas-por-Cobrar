/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.Persona;
import Model.Persona_Juridica;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author andy2
 */
public class Persona_JuridicaDAO extends PersonaDAO implements Serializable {

    Persona_Juridica person_Juridica;
    List<Persona_Juridica> lista_ClientesJuridicos;

    public Persona_JuridicaDAO(Persona_Juridica person_Juridica, List<Persona_Juridica> lista_ClientesJuridicos, Conexion conex, Persona persona, ResultSet result) {
        super(conex, persona, result);
        this.person_Juridica = person_Juridica;
        this.lista_ClientesJuridicos = lista_ClientesJuridicos;
    }

    public Persona_JuridicaDAO() {
        conex = new Conexion();
    }

    public Persona_JuridicaDAO(Persona_Juridica person_Juridica) {
        this.person_Juridica = person_Juridica;
    }

    
    
    //--Ejecutando Funcion (Ingresando Persona Juridica)
    public int insertar_Cliente_Juridico() {
        String sentenciaSQL = "Select Ingresar_Cliente_Juridico "
                + "(" + person_Juridica.getId_Tipo_Idenficacion() + ",'"
                + person_Juridica.getIdentificacion() + "','"
                + person_Juridica.getDireccion() + "','"
                + person_Juridica.getTlf1() + "','"
                + person_Juridica.getTlf2() + "','"
                + person_Juridica.getCorreo() + "','"
                + person_Juridica.getRazon_Social() +"',"
                + person_Juridica.getId_tipoCliente()+")";
        //Verificamos la conexion
        if (conex.isEstado()) {
            //Una vez se asegura que la conexion este correcta.
            //Se ejecuta la sentencia ingresada.
            return conex.ejecutarProcedimiento(sentenciaSQL);
        }
        //Caso contrario: Se retorna -1 indicando que la conexión está
        //en estado Falso
        return -1;
    }

    public int actualizar_Cliente_Juridico() {
        String sentenciaSQL = "Select actualizar_persona_juridica(" + person_Juridica.getId_Cliente() + ","
                + person_Juridica.getId_Tipo_Idenficacion() + ",'"
                + person_Juridica.getIdentificacion() + "','"
                + person_Juridica.getDireccion() + "','"
                + person_Juridica.getTlf1() + "','"
                + person_Juridica.getTlf2() + "','"
                + person_Juridica.getCorreo() + "','"
                + person_Juridica.getRazon_Social() + "',"
                + person_Juridica.getId_tipoCliente() + ")";

        if (conex.isEstado()) {
            //Una vez se asegura que la conexion este correcta.
            //Se ejecuta la sentencia ingresada.
            return conex.modificar(sentenciaSQL);
        }
        //Caso contrario: Se retorna -1 indicando que la conexión está
        //en estado Falso
        return -1;
    }

}
