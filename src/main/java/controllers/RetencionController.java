/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataviews.PersonaDAO;
import dataviews.RetencionDAO;
import models.Persona;
import models.Retencion;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author PERSONAL
 */
@Named(value = "retencionController")
@RequestScoped
public class RetencionController {

    int idRetencion;
    Retencion retencion;
    RetencionDAO retencionDAO;
    Persona persona;
    List<Retencion> listaRetenciones;  
    List<SelectItem> listaCliente;
    List<SelectItem> listaVenta;
    
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

    public List<SelectItem> getListaVentas(){
        listaVenta=new ArrayList<>();
        this.retencionDAO = new RetencionDAO();
        List<Retencion> r=retencionDAO.obtenerVentas(5);
        for(Retencion lret:r){
            SelectItem ventasItem=new SelectItem(lret.getIdVenta());
            this.listaVenta.add(ventasItem);
        }
        return listaVenta;
    }
    
    public void registrarRetencion() {
        retencionDAO=new RetencionDAO(retencion);
        if(retencionDAO.insertarRetencion(3)>0){
            System.out.println("Se Ingresó Correctamente la retencion.");
        } else {
            System.out.println("No se Registró");
        }
    }
    
    public void actualizarRetencion(){
//        retencion.setIdRetencion(this.idRetencion);
        System.out.println(retencion.getIdRetencion());
        System.out.println(retencion.getBaseImponible());
        System.out.println(retencion.getDescImpuesto());
        System.out.println(retencion.getPorcenRetencion());
        System.out.println(retencion.getFechaEmision());
        System.out.println(retencion.getEjerFiscal());
        System.out.println(retencion.getIdVenta());
//        System.out.println(retencion.getValorRetenido());
        System.out.println(retencion.getIdCliente());
        if(retencionDAO.actualizarRetencion(retencion)>0){
            System.out.println("Se Editó Correctamente");
            //Aqui se ubica codigo para cargar nuevamente la tabla de retenciones
        } else {
            System.out.println("No se Editó");
        }
    }
}
