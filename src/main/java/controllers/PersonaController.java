/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DataView.PersonaDAO;
import DataView.Persona_JuridicaDAO;
import DataView.Persona_NaturalDAO;
import Model.Persona;
import Model.Persona_Juridica;
import Model.Persona_Natural;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    
    
    //Constructor que instancia mis clases declaradas
    public PersonaController() {
        persona = new Persona();
        personaDAO = new PersonaDAO();

        persona_Juridica=new Persona_Juridica();
        persona_Natural=new Persona_Natural();
        
        listaCliente = new ArrayList<>();
        listaCliente = personaDAO.obtener_Todos_Los_Clientes();
        
        
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
//        registrar_Cliente_Juridico();
          //actualizar_Cliente_Juridico();
 
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
    
    public void anularCliente(){
        personaDAO =new PersonaDAO(persona);
        if(personaDAO.deshabilitar_cliente()>0){
            System.out.print("Cliente Anulado");
            listaCliente = personaDAO.obtener_Todos_Los_Clientes();
        }else{
               System.out.print("Error al anular");
    }
    }
    
    public void registrar_Cliente_Juridico(){
            persona_JuridicaDAO=new Persona_JuridicaDAO(persona_Juridica);
            if(persona_JuridicaDAO.insertar_Cliente_Juridico()>0){
                System.out.println("Se Ingresó Correctamente el cliente."+persona_Juridica.getRazon_Social());
            } 
    }
     public void registrar_Cliente_Natural(){
         persona_NaturalDAO=new Persona_NaturalDAO(persona_Natural);
            if(persona_NaturalDAO.insertar_Cliente_Natural()>0){
                System.out.println("Se Ingresó Correctamente el cliente."+persona_Natural.getNombre1());
            }
     }
 
     //Al momento de darle click al icono de editar, se ejecuta este procedi.
     public void obtener_Un_Cliente_Juridico(RowEditEvent<Persona_Juridica> event){
         persona_Juridica=event.getObject();
         System.out.println(persona_Juridica.getId_Cliente());
         //Se almacena el id cliente en una variable auxiliar
         persona_Juridica.setId_Cliente(3);
         int aux=persona_Juridica.getId_Cliente();
         persona_JuridicaDAO=new Persona_JuridicaDAO(persona_Juridica);
         //Se obtiene ese cliente por el id
         Persona_Juridica per_juridica= persona_JuridicaDAO.obtener_Cliente_Juridico();
         //Se remplazan los objetos
         persona_Juridica=per_juridica;
         //Ubicamos nuevamente el id de la variable auxiliar
         persona_Juridica.setId_Cliente(aux);
         
         //Se instancia nuevamente la personaJuridicaDAO pero con todos los 
         //datos recopilados
         persona_JuridicaDAO=new Persona_JuridicaDAO(persona_Juridica);
         //actualizar_Cliente_Juridico();
     }
      public void actualizar_Cliente_Juridico(){
          //Cargar los clientes en el objeto existente
      
        if (persona_JuridicaDAO.actualizar_Cliente_Juridico()> 0) {
            System.out.println("Se Editó Correctamente");
            listaCliente = personaDAO.obtener_Todos_Los_Clientes();
        } else {
            System.out.println("No se Editó");
        }
      }

//            mostrarMensajeInformacion("Se Editó Correctamente");
//            listaCliente = clienteDAO.obtenerClientes();
//        } else {
//            mostrarMensajeError("No se Editó");
//        }
     //Orden Razon Social, id tipo ident, direccion, 
                                        //identificacion,estado,tlf1,tlf2,correo,idTipoCliente
     
     
}
