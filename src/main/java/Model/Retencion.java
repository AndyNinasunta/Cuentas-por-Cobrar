/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Retencion {
    private int EjerFiscal;
    private int BaseImponible;
    private String descImpuesto;
    private String porcenRetencion;
    private Double valorRetenido;

    public Retencion() {
    }

    public Retencion(int EjerFiscal, int BaseImponible, String descImpuesto, String porcenRetencion, Double valorRetenido) {
        this.EjerFiscal = EjerFiscal;
        this.BaseImponible = BaseImponible;
        this.descImpuesto = descImpuesto;
        this.porcenRetencion = porcenRetencion;
        this.valorRetenido = valorRetenido;
    }

    public int getEjerFiscal() {
        return EjerFiscal;
    }

    public void setEjerFiscal(int EjerFiscal) {
        this.EjerFiscal = EjerFiscal;
    }

    public int getBaseImponible() {
        return BaseImponible;
    }

    public void setBaseImponible(int BaseImponible) {
        this.BaseImponible = BaseImponible;
    }

    public String getDescImpuesto() {
        return descImpuesto;
    }

    public void setDescImpuesto(String descImpuesto) {
        this.descImpuesto = descImpuesto;
    }

    public String getPorcenRetencion() {
        return porcenRetencion;
    }

    public void setPorcenRetencion(String porcenRetencion) {
        this.porcenRetencion = porcenRetencion;
    }

    public Double getValorRetenido() {
        return valorRetenido;
    }

    public void setValorRetenido(Double valorRetenido) {
        this.valorRetenido = valorRetenido;
    }
    
}
