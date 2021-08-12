/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.Plan_Pago;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy2
 */
public class Plan_PagoDAO implements Serializable {

    List<Plan_Pago> lista_facturaspendientes;
    Conexion conex;
    Plan_Pago plan_pago;
    ResultSet result;

    //Constructor sin parametros, para iniciar una conexion.
    public Plan_PagoDAO() {
        conex = new Conexion();
    }

    //Constructor que recibe el objeto Plan_Pago, con sus respectivas variables.
    public Plan_PagoDAO(Plan_Pago planPago) {
        conex = new Conexion();
        this.plan_pago = planPago;
    }

    public Plan_PagoDAO(Conexion conex, Plan_Pago planPago, ResultSet result) {
        this.conex = conex;
        this.plan_pago = planPago;
        this.result = result;
    }

    //Método para en enlistar las facturas pendientes.
    public List<Plan_Pago> obtenerFacturasPendientes() {
        lista_facturaspendientes = new ArrayList<>();
        if (conex.isEstado()) {
            try {
                String sentencia = "Select*from Obtener_Facturas_Pendientes()";
                result = conex.ejecutarConsulta(sentencia);
                
                while (result.next()) {
                    
                    lista_facturaspendientes.add(
                            new Plan_Pago(result.getObject("fechacredito_r", LocalDate.class),
                                    result.getInt("diasdecredito_r"),
                                    result.getObject("fechavencimiento_r", LocalDate.class),
                                    result.getString("nombre_clientes_r"),
                                    result.getInt("id_venta_r"),
                                    result.getDouble("valortotalfactura_r"),
                                    result.getDouble("valorpendiente_r"),
                                    result.getObject("fechapagofinal_r", LocalDate.class),
                                    result.getString("descripcionestado_r"),
                                    result.getInt("diasmora_r")));
                    
                }
            } catch (SQLException ex) {
                //lista_facturaspendientes.add(new Plan_Pago(-1,))
                // return lista_facturaspendientes;
            } finally {
                
                conex.cerrarConexion();
                
            }
        }
        return lista_facturaspendientes;
    }

    public double[] obtenerTotalVentayCartera_Pendiente() {
        double[] tVentaCarteraP = {0, 0};
        if (conex.isEstado()) {
            try {
                String sentencia = "Select*From obtener_ventas_y_cartera_pendiente()";
                result = conex.ejecutarConsulta(sentencia);
                result.next();
                tVentaCarteraP[0] = result.getDouble("total_venta_r");
                tVentaCarteraP[1] = result.getDouble("cartera_pendiente_r");
            } catch (SQLException ex) {
                return tVentaCarteraP;
            } finally {
                conex.cerrarConexion();
            }
        }
        return tVentaCarteraP;
    }
}
