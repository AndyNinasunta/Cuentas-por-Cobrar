/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DataView.RetencionDAO;
import Model.Retencion;
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

    Retencion retencion;
    RetencionDAO retencionDAO;
    List<Retencion> listaRetenciones;
    List<SelectItem> listaVenta;
    
    public RetencionController() {
        retencion = new Retencion();
        retencionDAO = new RetencionDAO();
        listaRetenciones = new ArrayList<>();
        //listaRetenciones = retencionDAO.obtener_retenciones(3);
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
    
    public void cargarRetenciones(int idVenta){
        listaRetenciones = new ArrayList<>();
        listaRetenciones=retencionDAO.obtener_retenciones(idVenta);
    }

    public void setListaRetenciones(List<Retencion> listaRetenciones) {
        this.listaRetenciones = listaRetenciones;
    }
    
    public List<SelectItem> getListaVentas(int idCliente){
        listaVenta=new ArrayList<>();
        RetencionDAO retenDAO=new RetencionDAO();
        List<Retencion> r=retenDAO.obtener_Ventas(idCliente);
        listaVenta.clear();
        for(Retencion retencion:r){
            SelectItem ventasItem=new SelectItem(retencion.getId_Venta());
            this.listaVenta.add(ventasItem);
        }
        return listaVenta;
    }
}
