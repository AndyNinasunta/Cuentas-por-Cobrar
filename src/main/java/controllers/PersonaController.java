/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DataView.PersonaDAO;
import Model.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "personaController")
@RequestScoped
public class PersonaController implements Serializable {
    
    //Declaro mis clases Persona y PersonaDAO
    Persona persona;
    PersonaDAO personaDAO;
    
    //Declaro mi listaCliente que van hacer cargadas en el datatable
    List<Persona> listaCliente;
    
    //Constructor que instancia mis clases declaradas
    public PersonaController() {
        persona = new Persona();
        personaDAO = new PersonaDAO();
        listaCliente = new ArrayList<>();
        listaCliente = personaDAO.obtener_Todos_Los_Clientes();
        
        for(Persona lst:listaCliente)
        {
            System.out.print(lst.getIdentificacion()+","+lst.getDescr_identificacion()+","+lst.getRazon_nombre()
            +","+lst.getDireccion()+","+lst.getTlf1()+","+lst.getTlf2()+","+lst.getCorreo()+","+lst.getDescr_tipo_Cliente()
            +","+lst.getDescr_Estado());
            
            
        }
    }
    
    public void mostrar() {
        listaCliente = personaDAO.obtener_Todos_Los_Clientes();
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
    
    
}
