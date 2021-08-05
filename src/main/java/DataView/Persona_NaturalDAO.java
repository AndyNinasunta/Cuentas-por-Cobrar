/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.Persona;
import Model.Persona_Natural;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andy2
 */
public class Persona_NaturalDAO extends PersonaDAO implements Serializable {
    
    Persona_Natural person_Natural;
    List<Persona_Natural> lista_ClientesNaturales;

    public Persona_NaturalDAO(Persona_Natural person_Natural, List<Persona_Natural> lista_ClientesNaturales, Conexion conex, Persona persona, ResultSet result) {
        super(conex, persona, result);
        this.person_Natural = person_Natural;
        this.lista_ClientesNaturales = lista_ClientesNaturales;
    }

    public Persona_NaturalDAO() {
        conex = new Conexion();
    }

    public Persona_NaturalDAO(Persona_Natural person_Natural) {
        this.person_Natural = person_Natural;
    }

    

    
    public int insertar_Cliente_Natural(){ 
        String sentenciaSQL="Select Ingresar_Cliente_Natural " //Es un Procedimiento Almacenado
                + "("+person_Natural.getId_Tipo_Idenficacion()+",'"
                +person_Natural.getIdentificacion()+"','"
                +person_Natural.getNombre1()+"','"
                +person_Natural.getNombre2()+"','"
                +person_Natural.getApellido1()+"','"
                +person_Natural.getApellidos2()+"','"
                +person_Natural.getDireccion()+"','"
                +person_Natural.getTlf1()+"','"
                +person_Natural.getTlf2()+"','"
                +person_Natural.getCorreo()+"','"
                +person_Natural.getSexo()+"','"
                +person_Natural.getGenero()+"','"
                +person_Natural.getFecha_nacimiento()+"',"
                +person_Natural.getId_tipoCliente()+")";
        

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
    
    public int actualizar_Cliente_Natural() {
        
        String sentenciaSQL = "Select actualizar_persona_natural(" + person_Natural.getId_Cliente() + ","
                + person_Natural.getId_Tipo_Idenficacion() + ",'"
                + person_Natural.getIdentificacion() + "','"
                + person_Natural.getDireccion() + "','"
                + person_Natural.getTlf1() + "','"
                + person_Natural.getTlf2() + "','"
                + person_Natural.getCorreo() + "','"
                + person_Natural.getNombre1()+ "','"
                + person_Natural.getNombre2()+ "','"
                + person_Natural.getApellido1()+ "','"
                + person_Natural.getApellidos2()+ "','"
                + person_Natural.getSexo()+ "','"
                + person_Natural.getGenero()+ "','"
                + person_Natural.getFecha_nacimiento()+ "',"
                + person_Natural.getId_tipoCliente() + ")";
    
//--Ejecutando Funcion (Actualizar Persona Natural)
//Select actualizar_persona_natural(2,1,'1250599436','Parr. Nicolas Infante Días',
//'0988152065',null,'andy2000-09@hotmail.com','Andy','Joel','Ninasunta','Rodríguez','M','Hetero','10/09/2000',1)
        
        
        if (conex.isEstado()) {
            //Una vez se asegura que la conexion este correcta.
            //Se ejecuta la sentencia ingresada.
            return conex.ejecutarProcedimiento(sentenciaSQL);
        }
        //Caso contrario: Se retorna -1 indicando que la conexión está
        //en estado Falso
        return -1;
        
    }
    
    public Persona_Natural obtener_Cliente_Natural() {
        Persona_Natural p_natural=new Persona_Natural();
        if (conex.isEstado()) {
            try {
                String sentencia = "Select idcliente,Per.idtipoidentificacion,identificacion,nombre1,nombre2,apellido1\n" +
                        ",apellido2,fecha_nacimiento,sexo,genero, direccion, estado,telefono1,telefono2,correo1\n" +
                        ", Cl.idtipocliente \n" +
                        "from Persona Per\n" +
                        "inner join persona_natural PerN on Per.id_persona=PerN.id_persona\n" +
                        "inner join clientes Cl on PerN.idpersonanatural=Cl.idpersonanatural\n" +
                        "where idcliente="+person_Natural.getId_Cliente();
                result = conex.ejecutarConsulta(sentencia);
                while (result.next()) {//Orden: sexo,genero, nombre1, nombre2,apellido1,apellido2,
                    //fecha_nacimiento, idTipo Identifica, direccion, identificacion, estado, tlf1, tlf2, correo , 
                    //IdTipoCliente
                     p_natural= new Persona_Natural(
                                                result.getString("sexo"),
                                                result.getString("genero"),
                                                result.getString("nombre1"),
                                                result.getString("nombre2"),
                                                result.getString("apellido1"),
                                                result.getString("apellido2"),
                                                result.getString("fecha_nacimiento"),
                                                result.getInt("idtipoidentificacion"),
                                                result.getString("direccion"),
                                                result.getString("identificacion"),
                                                result.getBoolean("estado"),
                                                result.getString("telefono1"),
                                                result.getString("telefono2"),
                                                result.getString("correo1"),
                                                result.getInt("idtipocliente"));
                }
            } catch (SQLException ex) {
                p_natural=new Persona_Natural("","","","","","","",-1,"","",false,"","","",-1);
            } finally {
                conex.cerrarConexion();
            }
        }
        return p_natural;
    }
    
}
