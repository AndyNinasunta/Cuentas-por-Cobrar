
package controllers;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.Cartera_X_Edades;
import models.Persona;
import dataviews.Cartera_X_EdadesDAO;
import dataviews.PersonaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

@Named(value = "cartera_X_EdadesController")
@ViewScoped
public class Cartera_X_EdadesController implements Serializable{

    //Se Declaran las clases Cartera_X_Edades y Cartera_X_EdadesDAO
    Cartera_X_Edades cartera_X_Edades;
    Cartera_X_EdadesDAO cartera_X_EdadesDAO;
    
     //Declaro mi lista de la cartera por edades de todos los clientes.
    List<Cartera_X_Edades> lista_Cartera_X_Edades;
    
    //Esta clase nos permitirá reutilizar el codigo para cargar los clientes en
    // el select one.
    Persona persona;
    PersonaDAO personaDAO;
    //Lista con todos los clientes
    List<SelectItem> listaCliente;
    
    //Declaro mi lista con la sumatoria 
    List<Cartera_X_Edades> listaSum_Cartera_X_Edades;
    
    public Cartera_X_EdadesController() {
        //Para que carguen en el data table todas las facturas las cuales 
        //hayan sido pagadas como plan de pagos de todos los clientes.
        cartera_X_EdadesDAO=new Cartera_X_EdadesDAO();
        lista_Cartera_X_Edades=new ArrayList<>();
        lista_Cartera_X_Edades=cartera_X_EdadesDAO.obtenerCarteraxEdades();
        
        //Carga la sumatoria de todas las ventas .
        listaSum_Cartera_X_Edades=new ArrayList<>();
        //Recibe un parámetros que será el id del cliente, en caso de ser -1 (Predeterminado)
        //Se carga la suma de todos los clientes.
        listaSum_Cartera_X_Edades=cartera_X_EdadesDAO.obtenerSumCarteraxEdades(-1);
        
    }
    
    public List<SelectItem> getListaCliente() {
        listaCliente = new ArrayList<>();
        personaDAO = new PersonaDAO();
        List<Persona> p = personaDAO.obtenerNombresClientes();
        listaCliente.clear();
//        for (Persona nombres : p) {
//            SelectItem nombresItem = new SelectItem(nombres.getIdCliente(),nombres.getRazonNombre());
//            this.listaCliente.add(nombresItem); 
//        }
        return listaCliente;
    }
    
    //Getters y Setters de las Listas
    //Inicio
    public List<Cartera_X_Edades> getLista_Cartera_X_Edades() {
        return lista_Cartera_X_Edades;
    }

    public void setLista_Cartera_X_Edades(List<Cartera_X_Edades> lista_Cartera_X_Edades) {
        this.lista_Cartera_X_Edades = lista_Cartera_X_Edades;
    }
    
      public List<Cartera_X_Edades> getListaSum_Cartera_X_Edades() {
        return listaSum_Cartera_X_Edades;
    }

    public void setListaSum_Cartera_X_Edades(List<Cartera_X_Edades> listaSum_Cartera_X_Edades) {
        this.listaSum_Cartera_X_Edades = listaSum_Cartera_X_Edades;
    }
    //FIN
    
}
