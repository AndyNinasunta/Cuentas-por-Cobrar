package controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import models.Plan_Pago;
import dataviews.Plan_PagoDAO;
import models.Persona;
import dataviews.PersonaDAO;
import java.util.ArrayList;
import java.util.List;

@Named(value = "plan_PagoController")
@ViewScoped
public class Plan_PagoController implements Serializable {

    //Se Declaran las clases Plan_Pago y Plan_PagoDAO
    Plan_Pago plan_Pago;
    Plan_PagoDAO plan_PagoDAO;

    //Objeto Persona y Persona DAO para buscar un cliente
    Persona persona;
    PersonaDAO personaDAO;

    //Lista donde se cargaran los cobros
    List<Plan_Pago> lista_Cobros;

    //Variable con la identificacion;
    String identificacion = "";

    public Plan_PagoController() {

    }

    public void buscarCliente() {

        personaDAO = new PersonaDAO();
        persona = new Persona();
        //Cargamos el nombre del cliente en el input
        persona = personaDAO.obtenerNombreClienteXIdentificacion(identificacion);

        //Este if nos permite verificar si existe o no un cliente.
        if (persona.getIdCliente() == 0) {
            System.out.println("El Cliente NO EXISTE O ESTA INACTIVO ");
        } else {
            // En caso de que exista cargamos sus cobros (Claro si tiene cobros)
            lista_Cobros = new ArrayList<>();
            plan_PagoDAO = new Plan_PagoDAO();
            //Cargamos los cobros de un determinado Cliente.
            lista_Cobros = plan_PagoDAO.obtenerCobrosCliente(persona.getIdCliente());
        }

    }

    //Getters y Setters de las Listas
    //Inicio
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Plan_PagoController(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public List<Plan_Pago> getLista_Cobros() {
        return lista_Cobros;
    }

    //Fin
}
