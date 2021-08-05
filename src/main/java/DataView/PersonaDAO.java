/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.Persona;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy2
 */
public class PersonaDAO implements Serializable {

    Conexion conex;
    Persona persona;
    ResultSet result;
    List<Persona> lista_Personas;

    public PersonaDAO(Conexion conex, Persona persona, ResultSet result) {
        this.conex = conex;
        this.persona = persona;
        this.result = result;
    }

    public PersonaDAO() {
        conex = new Conexion();
    }

    public PersonaDAO(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> obtener_Todos_Los_Clientes() {
        lista_Personas = new ArrayList<>();
//        lista_Personas.add(new Persona(1,"123434535","Cedula","Alexander Vega","Valencia","0989098998","0988080908","Alexander@hotmail.com","Persona Natural","true"));
//        lista_Personas.add(new Persona(2,"123434535","Cedula","Alexander Vega","Valencia","0989098998","0988080908","Alexander@hotmail.com","Persona Natural","true"));
        if (conex.isEstado()) {
            try {
                String sentencia = "Select * from Mostrar_Todos_los_Clientes()";
                result = conex.ejecutarConsulta(sentencia);
                while (result.next()) {
                    lista_Personas.add(new Persona(result.getInt("id"),
                            result.getString("identificacion"),
                            result.getString("tipo_identificacion"),
                            result.getString("razon_nombres"),
                            result.getString("direccion_r"),
                            result.getString("tlf1"),
                            result.getString("tlf2"),
                            result.getString("correo1_r"),
                            result.getString("tipo_cliente_r"),
                            result.getString("estado_r")));

                }
            } catch (SQLException ex) {
                lista_Personas.add(new Persona(-1, "-", "-", "-", "-", "-", "-", "-", "-", "-"));
            } finally {
                conex.cerrarConexion();
            }
        }
        return lista_Personas;
    }

    public int deshabilitar_cliente() {
        String sentencia = "select Anular_Cliente(" + persona.getId_Cliente() + ")";
        if (conex.isEstado()) {
            return conex.ejecutarProcedimiento(sentencia);
        }
        return -1;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
