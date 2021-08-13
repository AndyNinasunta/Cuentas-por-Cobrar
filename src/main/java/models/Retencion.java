
package models;

import java.time.LocalDate;

public class Retencion {
    private int idCliente;
    private int idRetencion;
    private int idVenta;
    private int porcenRetencion;
    private LocalDate fechaEmision=LocalDate.now();
    private Double BaseImponible;
    private String descImpuesto;
    private String EjerFiscal;
    private Double valorRetenido;

    public Retencion() {
    }

    public Retencion(int idRetencion, int idVenta, int porcenRetencion, LocalDate fechaEmision, Double BaseImponible, String descImpuesto, String EjerFiscal, Double valorRetenido) {
        this.idRetencion = idRetencion;
        this.idVenta = idVenta;
        this.porcenRetencion = porcenRetencion;
        this.fechaEmision = fechaEmision;
        this.BaseImponible = BaseImponible;
        this.descImpuesto = descImpuesto;
        this.EjerFiscal = EjerFiscal;
        this.valorRetenido = valorRetenido;
    }

    public Retencion(int idVenta, int porcenRetencion, Double BaseImponible, String descImpuesto, String EjerFiscal, Double valorRetenido) {
        this.idVenta = idVenta;
        this.porcenRetencion = porcenRetencion;
        this.BaseImponible = BaseImponible;
        this.descImpuesto = descImpuesto;
        this.EjerFiscal = EjerFiscal;
        this.valorRetenido = valorRetenido;
    }
    
    public Retencion(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdRetencion() {
        return idRetencion;
    }

    public void setIdRetencion(int idRetencion) {
        this.idRetencion = idRetencion;
    }


    public String getEjerFiscal() {
        return EjerFiscal;
    }

    public void setEjerFiscal(String EjerFiscal) {
        this.EjerFiscal = EjerFiscal;
    }

    public Double getBaseImponible() {
        return BaseImponible;
    }

    public void setBaseImponible(Double BaseImponible) {
        this.BaseImponible = BaseImponible;
    }

    public String getDescImpuesto() {
        return descImpuesto;
    }

    public void setDescImpuesto(String descImpuesto) {
        this.descImpuesto = descImpuesto;
    }

    public int getPorcenRetencion() {
        return porcenRetencion;
    }

    public void setPorcenRetencion(int porcenRetencion) {
        this.porcenRetencion = porcenRetencion;
    }

    public Double getValorRetenido() {
        return valorRetenido;
    }

    public void setValorRetenido(Double valorRetenido) {
        this.valorRetenido = valorRetenido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

   
    
    
    
}
