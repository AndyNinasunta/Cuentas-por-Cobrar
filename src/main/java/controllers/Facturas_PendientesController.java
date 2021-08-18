package controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.Facturas_Pendientes;
import dataviews.Facturas_PendientesDAO;
import java.util.ArrayList;
import java.util.List;

@Named(value = "facturas_PendientesController")
@ViewScoped
public class Facturas_PendientesController implements Serializable {

    //Declaro mis Facturas_Pendientes y Facturas Pendientes DAO
    Facturas_Pendientes facturas_Pendientes;
    Facturas_PendientesDAO facturas_PendientesDAO;

    //Declaro mi lista de facturas pendientes
    List<Facturas_Pendientes> listaFacturas_Pendientes;

    //Declaro un arreglo con el total de la venta [0] y la cartera pendiente[1]
    double[] totalVentaCartera;

    public Facturas_PendientesController() {
        //Para cargar el data table con los datos de las facturas pendientes.
        facturas_PendientesDAO=new Facturas_PendientesDAO();
        listaFacturas_Pendientes=new ArrayList<>();
        listaFacturas_Pendientes=facturas_PendientesDAO.obtenerFacturasPendientes();
        
        //Para cargar el total de las ventas y la cartera pendiente.
        totalVentaCartera=facturas_PendientesDAO.obtenerTotalVentayCarteraPendiente();
    }

    //Getters y Setters de las Listas
    //Inicio
    
    public List<Facturas_Pendientes> getListaFacturas_Pendientes() {
        return listaFacturas_Pendientes;
    }

    public void setListaFacturas_Pendientes(List<Facturas_Pendientes> listaFacturas_Pendientes) {
        this.listaFacturas_Pendientes = listaFacturas_Pendientes;
    }

    public double[] getTotalVentaCartera() {
        return totalVentaCartera;
    }

    public void setTotalVentaCartera(double[] totalVentaCartera) {
        this.totalVentaCartera = totalVentaCartera;
    }
    //Fin
}
