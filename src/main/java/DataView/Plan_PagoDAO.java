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

    public Plan_PagoDAO() {
    }

    public Plan_PagoDAO(Plan_Pago plan_pago) {
        this.plan_pago = plan_pago;
    }

    public Plan_PagoDAO(Conexion conex, Plan_Pago plan_pago, ResultSet result) {
        this.conex = conex;
        this.plan_pago = plan_pago;
        this.result = result;
    }

    //Método para en enlistar las facturas pendientes.
    public List<Plan_Pago> obtener_Facturas_Pendientes() {
        lista_facturaspendientes = new ArrayList<>();
        if (conex.isEstado()) {
            try {
                String sentencia = "Select*from Obtener_Facturas_Pendientes()";
                result = conex.ejecutarConsulta(sentencia);
                while (result.next()) {
                    lista_facturaspendientes.add(new Plan_Pago(result.getString("fechacredito_r"),
                            result.getInt("diasdecredito_r"),
                            result.getString("fechavencimiento_r"),
                            result.getString("nombre_clientes_r"),
                            result.getInt("id_venta_r"),
                            result.getDouble("valortotalfactura_r"),
                            result.getDouble("valorpendiente_r"),
                            result.getString("fechapagofinal_r"),
                            result.getString("descripcionestado_r"),
                            result.getInt("diasmora_r")));
                }
            } catch (SQLException ex) {
                // return lista_facturaspendientes;
            } finally {

                conex.cerrarConexion();
            }
        }
        return lista_facturaspendientes;
    }

    public double[] obtener_Total_Venta_y_Cartera_Pendiente() {
        double[] t_venta_cartera_p = {0, 0};
        if (conex.isEstado()) {
            try {
                String sentencia = "Select sum(valortotalfactura) as total_venta"
                        + ", sum(valorpendiente) as cartera_pendiente "
                        + "from plan_de_pago";
                result = conex.ejecutarConsulta(sentencia);
                result.next();
                t_venta_cartera_p[0] = result.getDouble("total_venta");
                t_venta_cartera_p[1] = result.getDouble("total_venta");
            } catch (SQLException ex) {
                return t_venta_cartera_p;
            } finally {
                conex.cerrarConexion();
            }

        }
        return t_venta_cartera_p;
    }
}
