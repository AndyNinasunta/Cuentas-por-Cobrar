
package dataviews;

import models.Plan_Pago;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plan_PagoDAO implements Serializable {

    List<Plan_Pago> lista_cobros;
    Conexion conex;
    Plan_Pago plan_pago;
    ResultSet result;

    //Constructor sin parametros, para iniciar una conexion.
    public Plan_PagoDAO() {
        conex = new Conexion();
    }

    //Constructor que recibe el objeto Plan_Pago e inicia una nueva conexion.
    public Plan_PagoDAO(Plan_Pago planPago) {
        conex = new Conexion();
        this.plan_pago = planPago;
    }

    public Plan_PagoDAO(Conexion conex, Plan_Pago planPago, ResultSet result) {
        this.conex = conex;
        this.plan_pago = planPago;
        this.result = result;
    }
    
    //Procedimiento para insertar un nuevo Plan de Pago.
    public int insertarPlanDePago() {
        /*--Se ubica en el siguiente orden 
        (idVenta,dias de credito,fecha de credito,
        valor total de la factura,intereses)*/
        String sentenciaSQL = "Select ingresar_plan_de_pago(" + plan_pago.getIdFactura()
                + "," + plan_pago.getDiasCredito()
                + ",'" + plan_pago.getFechaFacturacion()
                + "'," + plan_pago.getValorTotalFactura() + "," + plan_pago.getIntereses() + ")";

        //Verificamos la conexion
        if (conex.isEstado()) {

            /*Una vez se asegura que la conexion este correcta.
            Se ejecuta la sentencia ingresada.*/
            return conex.ejecutarProcedimiento(sentenciaSQL);

        }

        return -1;
    }

    //Modificar/Actualizar un Plan de pago, retorna 1 o -1 dependiendo 
    //si la función ejecuta correctamente. Nota: Solo se pueden modificar planes
    // de pago que no tengan abonos.
    public int actualizarPlanDePago(int idPlanDePago) {
        String sentenciaSQL = "Select actualizar_plan_de_pago(" + idPlanDePago + ","
                + plan_pago.getIdFactura()
                + "," + plan_pago.getDiasCredito()
                + ",'" + plan_pago.getFechaFacturacion()
                + "'," + plan_pago.getValorTotalFactura() + ","
                + plan_pago.getIntereses() + ")";

        //Verificamos la conexion
        if (conex.isEstado()) {

            //Una vez se asegura que la conexion este correcta.
            //Se ejecuta la sentencia ingresada.
            return conex.ejecutarProcedimiento(sentenciaSQL);

        }
        //Caso contrario: Se retorna -1 indicando que la conexión está
        //en estado Falso
        return -1;
    }

    /*Funcion para devolver el valor pendiente de cobro de un determinado plan*/
    public double obtenerValorPendiente() {
        double valorPendiente = 0;

        try {
            /*El valor pendiente de un plan se lo obtiene sumando todos los 
            los montos de los abonos menos el total de la factura.
             */
            String sentencia = "Select * from "
                    + "Obtener_Valor_Pendiente_de_un_plan"
                    + "(" + plan_pago.getIdFactura() + ")";
            result = conex.ejecutarConsulta(sentencia);

            result.next();

            //Almacenamos el valor obtenido en la variable
            valorPendiente = result.getDouble(1);

        } catch (SQLException ex) {
            //Si hay algun error o el valor es nulo, se retorna -1.
            return -1;

        } finally {

            conex.cerrarConexion();

        }

        return valorPendiente;
    }

    //Funcion que devuelve una lista con los cobros de un cliente
    public List<Plan_Pago> obtenerCobrosCliente(int idCliente){
        lista_cobros=new ArrayList<>();
        
        //verificamos la conexion
        if (conex.isEstado()) {
            try {
                /* Se obtiene una TABLA con todas las facturas que se pagaron a
                credito, con sus respectivo datos calculados como la 
                fecha de vencimiento =fecha actual+diascredito */
                String sentencia = "select*from obtener_cobros_x_cliente("+idCliente+")";
                result = conex.ejecutarConsulta(sentencia);

                //Recorremos la TABLA retornada y la almacenamos en la lista.
                while (result.next()) {

                    lista_cobros.add(
                            new Plan_Pago(result.getObject("fechacredito_i", LocalDate.class),
                                    result.getInt("diasdecredito_i"),
                                    result.getObject("fechavencimiento_i", LocalDate.class),
                                    result.getInt("idventa_i"),
                                    result.getDouble("valortotalfactura_i"),
                                    result.getDouble("saldopendiente_i"), 
                                    result.getDouble("totalabonos_i"), 
                                    result.getString("descripcionestado_i"),
                                    result.getInt("diasmora_i")));
                }
            } catch (SQLException ex) {
                /*Enviamos su respectivo mensaje de error a su ves una lista 
                    con valores incorrectos.*/
                System.out.println(ex.getMessage());
                lista_cobros.add(
                        new Plan_Pago(null,-1,null, -1, -1, -1,-1,"", -1));
            } finally {

                conex.cerrarConexion();

            }
        }
        return lista_cobros;
    }

    
}
