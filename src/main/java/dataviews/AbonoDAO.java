
package dataviews;

import models.Abono;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AbonoDAO implements Serializable {

    List<Abono> listaAbonos;
    Conexion conex;
    Abono abono;
    ResultSet result;

    //Constructor sin parámetros, para iniciar una conexion.
    public AbonoDAO() {
        conex = new Conexion();
    }

    //Constructor que recibe el objeto Abono e inicia una nueva conexion.
    public AbonoDAO(Abono abono) {
        conex = new Conexion();
        this.abono = abono;
    }

    public AbonoDAO(List<Abono> listaAbonos, Conexion conex, Abono abono, ResultSet result) {
        this.listaAbonos = listaAbonos;
        this.conex = conex;
        this.abono = abono;
        this.result = result;
    }

    //Funcion para enlistar todos los abonos de un determinado plan de pago.
    public List<Abono> obtenerAbonos(int idPlanPago){
       listaAbonos=new ArrayList<>();
       
       //verificamos la conexion
       if(conex.isEstado()){
           try{
               /* Se obtiene una TABLA con todos los abonos que se pagaron 
                de un plan de pago correspondiente */
               String sentencia="Select*from obtener_abonos_de_plan_de_pago("+idPlanPago+")";
               result = conex.ejecutarConsulta(sentencia);
               
               //Recorremos la TABLA retornada y la almacenamos en la lista.
                while (result.next()) {
                    
                    listaAbonos.add(new Abono(result.getInt("idabono_r"),
                            result.getString("nombrepago_r"),
                            result.getDouble("totalabono_r"),
                            result.getObject("fechadeabono_r",LocalDate.class)));
                
                }
                
           }
           catch (SQLException ex) {
                /*Enviamos su respectivo mensaje de error a su ves una lista 
                    con valores incorrectos.*/
                System.out.println(ex.getMessage());
                listaAbonos.add(new Abono(-1,
                            "",
                            -1,
                            null));
            } finally {
                
                conex.cerrarConexion();

            }
       }
       return listaAbonos;
    }
  
    
    
    /*Procedimiento para insertar un nuevo abono.
    Nota:Al momento de insertar un nuevo abonos, automaticamente el valor 
    pendiente de el plan de pago se actualiza en el procedimiento de PostGre*/
    public int insertarNuevoAbono(int idPlanPago) {
        /*Se ubica en el siguiente orden: 
        (idplan,idformmadepago,monto a pagar, fecha de pago)*/
        String sentenciaSQL = "Select Ingresar_abono(" + idPlanPago + ","
                + abono.getIdFormaDePago() + "," + abono.getValorAbonado() + ",'"
                + abono.getFechaAbono() + "')";

        //Verificamos la conexion
        if (conex.isEstado()) {

            /*Una vez se asegura que la conexion este correcta.
            Se ejecuta la sentencia ingresada.*/
            return conex.ejecutarProcedimiento(sentenciaSQL);

        }

        return -1;
    }

}
