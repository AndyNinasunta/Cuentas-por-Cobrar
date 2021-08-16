/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataviews.PersonaDAO;
import dataviews.Persona_JuridicaDAO;
import dataviews.Persona_NaturalDAO;
import models.Persona;
import models.Persona_Juridica;
import models.Persona_Natural;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.RowEditEvent;

@Named(value = "personaController")
@RequestScoped
public class PersonaController implements Serializable {

    //Declaro mis clases Persona y PersonaDAO
    Persona persona;
    PersonaDAO personaDAO;

    //Declaro mis clases Persona_Natural y Persona_NaturalDAO
    Persona_Natural persona_Natural;
    Persona_NaturalDAO persona_NaturalDAO;

    //Declaro mis clases Persona_Juridica y Persona_JuridicaDAO
    Persona_Juridica persona_Juridica;
    Persona_JuridicaDAO persona_JuridicaDAO;

    //Declaro mi listaCliente que van hacer cargadas en el datatable
    List<Persona> listaCliente;
    int idCliente = 0;

    //Constructor que instancia mis clases declaradas
    @PostConstruct
    public void main() {
        persona = new Persona();
        personaDAO = new PersonaDAO();

        persona_Juridica = new Persona_Juridica();
        persona_Natural = new Persona_Natural();

        listaCliente = new ArrayList<>();
        listaCliente = personaDAO.obtenerTodosLosClientes();

//        persona_Juridica.setRazon_Social("TIA 2");
//        persona_Juridica.setId_tipoCliente(1);
//        persona_Juridica.setIdentificacion("3242342");
//        persona_Juridica.setDireccion("mas alla");
//        persona_Juridica.setId_Tipo_Idenficacion(2);
//        persona_Juridica.setCorreo("HOLA@GMAIL.COM");
//        persona_Juridica.setTlf1("0938472");
//        persona_Juridica.setTlf2("0938472");
//        
//        
//        registrarClienteJuridico();
        //actualizar_Cliente_Juridico();
        //obtener_Un_Cliente_Natural();
//          editarCliente();
    }

    public void mostrar() {
        listaCliente = personaDAO.obtenerTodosLosClientes();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public List<Persona> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Persona> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Persona_Natural getPersona_Natural() {
        return persona_Natural;
    }

    public void setPersona_Natural(Persona_Natural persona_Natural) {
        this.persona_Natural = persona_Natural;
    }

    public Persona_Juridica getPersona_Juridica() {
        return persona_Juridica;
    }

    public void setPersona_Juridica(Persona_Juridica persona_Juridica) {
        this.persona_Juridica = persona_Juridica;
    }
    
     public void cargarClientes(Persona persona){
         idCliente = persona.getIdCliente();
         if (personaDAO.identificar_cliente(idCliente).equals("J")) {
             System.out.println("Entra al if");
             this.persona_Juridica.setIdentificacion("000923029");
             System.out.println(persona_Juridica.getIdentificacion());
         }
//        this.persona = personaj;
//        idCliente = personaj.getIdCliente();
//        System.out.println("Id Cliente: " + personaj.getIdCliente());
//        System.out.println("Nombre Cliente: " + personaj.getRazonNombre());
    }

    //Método que retorna los clientes Juridicos
    public void inactivarCliente(int id) {
        System.out.println(id);
        if (personaDAO.deshabilitarCliente(id) > 0) {
            System.out.print("Cliente inactivo");
            listaCliente = personaDAO.obtenerTodosLosClientes();
        } else {
            System.out.print("Error al inactivar cliente");
        }
    }
    
    public void activarCliente(int id) {
        System.out.println(id);
        if (personaDAO.habilitarCliente(id) > 0) {
            System.out.print("Cliente Activado");
            listaCliente = personaDAO.obtenerTodosLosClientes();
        } else {
            System.out.print("Error al activar cliente");
        }
    }
    

    public String registrarClienteJuridico() {
        System.out.println(persona_Juridica.getRazonSocial());
        persona_JuridicaDAO = new Persona_JuridicaDAO(persona_Juridica);
//        persona_Juridica.setIdentificacion("1297742873");
//        persona_Juridica.setRazon_Social("Maria Flores INC");
//        persona_Juridica.setId_Tipo_Idenficacion(2);
//        persona_Juridica.setCorreo("mariaflor@hotmail.com");
//        persona_Juridica.setTlf1("0985353454");
//        persona_Juridica.setTlf2("");
//        persona_Juridica.setDireccion("Calle Segundo Bolaños");
//        persona_Juridica.setId_tipoCliente(1);
        
        if (persona_JuridicaDAO.insertarClienteJuridico() > 0) {
            System.out.println("Si se ejecuta if");
            System.out.println("Se Ingresó Correctamente el cliente." + persona_Juridica.getRazonSocial());
            return "MantenimientoCliente"; 
        }
        else{
            System.out.println("No se Ingresó el Cliente Juridico.");
        }
        return "MantenimientoCliente";
    }

    public String registrarClienteNatural() {
        persona_NaturalDAO = new Persona_NaturalDAO(persona_Natural);
        if (persona_NaturalDAO.insertarClienteNatural() > 0) {
            System.out.println("Se Ingresó Correctamente el cliente." + persona_Natural.getNombre1());
            return "MantenimientoCliente";
        }
        else{
            System.out.println("No se Ingresó el Cliente Natural.");
        }
        return "MantenimientoCliente";
    }

    public void editarCliente(int idCliente) {
        if (personaDAO.identificar_cliente(idCliente).equals("J")) {
//            obtenerUnClienteJuridico(idCliente);
            System.out.println("Es Juridico");
        } else if (personaDAO.identificar_cliente(idCliente).equals("N")) {
            obtenerUnClienteNatural(idCliente);
            System.out.println("Es Natural");
        } else {
            System.out.println("Falló inesperadamente...");
        }

    }

    //Al momento de darle click al icono de editar, se ejecuta este procedi.
    public void obtenerUnClienteJuridico(RowEditEvent<Persona_Juridica> event) {
        persona_Juridica = event.getObject();
        System.out.println(persona_Juridica.getIdCliente());
        //Se almacena el id cliente en una variable auxiliar
        int aux = persona_Juridica.getIdCliente();
        persona_JuridicaDAO = new Persona_JuridicaDAO(persona_Juridica);
        //Se obtiene ese cliente por el id
        Persona_Juridica per_juridica = persona_JuridicaDAO.obtenerClienteJuridico();
        //Se remplazan los objetos
        persona_Juridica = per_juridica;
        //Ubicamos nuevamente el id de la variable auxiliar
        persona_Juridica.setIdCliente(aux);

        //Se instancia nuevamente la personaJuridicaDAO pero con todos los 
        //datos recopilados
        persona_JuridicaDAO = new Persona_JuridicaDAO(persona_Juridica);
    }

    public void actualizarClienteJuridico() {
        if (persona_JuridicaDAO.actualizarClienteJuridico() > 0) {
            System.out.println("Se Editó Correctamente");
            listaCliente = personaDAO.obtenerTodosLosClientes();
        } else {
            System.out.println("No se Editó");
        }
    }

    public void obtenerUnClienteNatural(int id) {
        persona_Natural.setIdCliente(id);
        System.out.println(persona_Natural.getIdCliente());

        //Se almacena el id cliente en una variable auxiliar
        int aux = persona_Natural.getIdCliente();
        persona_NaturalDAO = new Persona_NaturalDAO(persona_Natural);

        //Se obtiene ese cliente por el id
        Persona_Natural per_Natural = persona_NaturalDAO.obtenerClienteNatural();

        //Se remplazan los objetos
        persona_Natural = per_Natural;

        //Ubicamos nuevamente el id de la variable auxiliar
        persona_Natural.setIdCliente(aux);
        System.out.println(persona_Natural.getIdentificacion());
        //Se instancia nuevamente la personaJuridicaDAO pero con todos los 
        //datos recopilados
        persona_NaturalDAO = new Persona_NaturalDAO(persona_Natural);

    }

    public void actualizarClienteNatural() {
        if (persona_NaturalDAO.actualizarClienteNatural() > 0) {
            System.out.println("Se Editó Correctamente");
            listaCliente = personaDAO.obtenerTodosLosClientes();
        } else {
            System.out.println("No se Editó");
        }

    }

}
