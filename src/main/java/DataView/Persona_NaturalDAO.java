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
    
    public int actualizar_Cliente_Juridico() {
        
        String sentenciaSQL = "Select actualizar_persona_juridica(" + person_Natural.getId_Cliente() + ","
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
            return conex.modificar(sentenciaSQL);
        }
        //Caso contrario: Se retorna -1 indicando que la conexión está
        //en estado Falso
        return -1;
        
    }
    
    
}
