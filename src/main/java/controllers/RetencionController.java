
package controllers;

import dataviews.PersonaDAO;
import dataviews.RetencionDAO;
import java.io.Serializable;
import models.Persona;
import models.Retencion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;


@Named(value = "retencionController")
@ViewScoped
public class RetencionController implements Serializable{

    int idRetencion;
    Retencion retencion;
    RetencionDAO retencionDAO;
    Persona persona;
    List<Retencion> listaRetenciones;  
    List<SelectItem> listaCliente;
    List<SelectItem> listaVenta;

    int idFactura=0;
    
    public RetencionController() {
        retencion = new Retencion();
        retencionDAO = new RetencionDAO();
        listaRetenciones = new ArrayList<>();
        listaRetenciones = retencionDAO.obtenerRetenciones(3);
    }

    public Retencion getRetencion() {
        return retencion;
    }

    public void setRetencion(Retencion retencion) {
        this.retencion = retencion;
    }

    public List<Retencion> getListaRetenciones() {
        return listaRetenciones;
    }
    
    public void cargarRetenciones(Retencion ret){
        this.retencion = ret;
        idRetencion = ret.getIdRetencion();
        System.out.println("Id Retencion: " + ret.getIdRetencion());
    }

    public void setListaRetenciones(List<Retencion> listaRetenciones) {
        this.listaRetenciones = listaRetenciones;
    }
    
    
    
    public List<SelectItem> getListaCliente() {
        listaCliente = new ArrayList<>();
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> p = personaDAO.obtenerNombresClientes();
        listaCliente.clear();
        for (Persona nombres : p) {
            SelectItem nombresItem = new SelectItem(nombres.getIdCliente(),nombres.getRazonNombre());
            this.listaCliente.add(nombresItem); 
        }
        return listaCliente;
    }

    public void setListaCliente(List<SelectItem> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
 
    public List<SelectItem> getListaVentas(){
        listaVenta=new ArrayList<>();
        this.retencionDAO = new RetencionDAO();
        System.out.println("idFactura: " + idFactura);
        List<Retencion> r=retencionDAO.obtenerVentas(idFactura);
        for(Retencion lret:r){
            SelectItem ventasItem=new SelectItem(lret.getIdVenta());
            this.listaVenta.add(ventasItem);
        }
        return listaVenta;
    }
    
    public void registrarRetencion() {
        retencionDAO=new RetencionDAO(retencion);
        if(retencionDAO.insertarRetencion(5,3)>0){
            mostrarMensajeInformacion("Se Registró Correctamente");
            listaRetenciones = retencionDAO.obtenerRetenciones(3);
        } else {
            mostrarMensajeError("No se Registró Correctamente");
        }
    }
    
    public void actualizarRetencion(){
        retencionDAO=new RetencionDAO(retencion);
        if(retencionDAO.actualizarRetencion(retencion,5)>0){
            mostrarMensajeInformacion("Se Editó Correctamente");
            //Aqui se ubica codigo para cargar nuevamente la tabla de retenciones
            listaRetenciones = retencionDAO.obtenerRetenciones(3);
        } else {
            mostrarMensajeError("No se Editó Correctamente");
        }
    }
    
    //Metodos para mostrar mensajes de Información y Error
    public void mostrarMensajeInformacion(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Exito", mensaje);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void mostrarMensajeError(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error", mensaje);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    //Metodo para obtener las Facturas de un cliente
    public void cargarFacturas(){
        listaVenta=new ArrayList<>();
        this.retencionDAO = new RetencionDAO();
        List<Retencion> r=retencionDAO.obtenerVentas(5);
        for(Retencion lret:r){
            SelectItem ventasItem=new SelectItem(lret.getIdVenta());
            this.listaVenta.add(ventasItem);
        }
    }
}
