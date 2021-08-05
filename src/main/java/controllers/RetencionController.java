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
    public RetencionController() {
        retencion = new Retencion();
        retencionDAO = new RetencionDAO();
        listaRetenciones = new ArrayList<>();
        listaRetenciones = retencionDAO.obtener_retenciones();
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

    public void setListaRetenciones(List<Retencion> listaRetenciones) {
        this.listaRetenciones = listaRetenciones;
    }
    
}
