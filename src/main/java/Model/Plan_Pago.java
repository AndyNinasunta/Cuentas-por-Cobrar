/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author andy2
 */
public class Plan_Pago implements Serializable{

    //Declaración de las Variables
    int id_Cliente;
    String fecha_Facturacion;
    int dias_Credito;
    String fecha_Vencimiento;
    String nombre_Del_Cliente;
    int id_factura;
    double valor_Total_Factura;
    double valor_Pendiente;
    String fecha_Ultimo_Pago;
    int id_Estado_Factura;
    String estado_Factura;
    int diasMora;
    
    public Plan_Pago() {
    }
    
    //Constructor para almacenar las facturas pendientes

    public Plan_Pago(String fecha_Facturacion, int dias_Credito, String fecha_Vencimiento, String nombre_Del_Cliente, int id_factura, double valor_Total_Factura, double valor_Pendiente, String fecha_Ultimo_Pago, String estado_Factura, int diasMora) {
        this.fecha_Facturacion = fecha_Facturacion;
        this.dias_Credito = dias_Credito;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.nombre_Del_Cliente = nombre_Del_Cliente;
        this.id_factura = id_factura;
        this.valor_Total_Factura = valor_Total_Factura;
        this.valor_Pendiente = valor_Pendiente;
        this.fecha_Ultimo_Pago = fecha_Ultimo_Pago;
        this.estado_Factura = estado_Factura;
        this.diasMora = diasMora;
    }

    
 
    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getFecha_Facturacion() {
        return fecha_Facturacion;
    }

    public void setFecha_Facturacion(String fecha_Facturacion) {
        this.fecha_Facturacion = fecha_Facturacion;
    }

    public String getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }

    public String getNombre_Del_Cliente() {
        return nombre_Del_Cliente;
    }

    public void setNombre_Del_Cliente(String nombre_Del_Cliente) {
        this.nombre_Del_Cliente = nombre_Del_Cliente;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public double getValor_Total_Factura() {
        return valor_Total_Factura;
    }

    public void setValor_Total_Factura(double valor_Total_Factura) {
        this.valor_Total_Factura = valor_Total_Factura;
    }

    public double getValor_Pendiente() {
        return valor_Pendiente;
    }

    public void setValor_Pendiente(double valor_Pendiente) {
        this.valor_Pendiente = valor_Pendiente;
    }

    public String getFecha_Ultimo_Pago() {
        return fecha_Ultimo_Pago;
    }

    public void setFecha_Ultimo_Pago(String fecha_Ultimo_Pago) {
        this.fecha_Ultimo_Pago = fecha_Ultimo_Pago;
    }

    public int getId_Estado_Factura() {
        return id_Estado_Factura;
    }

    public void setId_Estado_Factura(int id_Estado_Factura) {
        this.id_Estado_Factura = id_Estado_Factura;
    }

    public String getEstado_Factura() {
        return estado_Factura;
    }

    public void setEstado_Factura(String estado_Factura) {
        this.estado_Factura = estado_Factura;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
    }
    
    
    
    
}
