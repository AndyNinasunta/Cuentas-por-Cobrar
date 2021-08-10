package DataView;

import Model.Retencion;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RetencionDAO implements Serializable {

    Conexion conex;
    Retencion retencion;
    ResultSet result;
    List<Retencion> lista_Retencion;

    public RetencionDAO(Conexion conex, ResultSet result, List<Retencion> lista_Retencion) {
        this.conex = conex;
        this.result = result;
        this.lista_Retencion = lista_Retencion;
    }

    public RetencionDAO() {
        this.conex = conex;
    }

    public RetencionDAO(Retencion retencion) {
        this.retencion = retencion;
    }

    public List<Retencion> obtener_retenciones(int idCliente) {
        lista_Retencion = new ArrayList<>();
        if (conex.isEstado()) {
            try {
                String sentencia = "Select *from Obtener_Retenciones(" + idCliente + ")";
                result = conex.ejecutarConsulta(sentencia);
                while (result.next()) {
                    lista_Retencion.add(new Retencion(result.getInt("idretencion_r"),
                            result.getInt("idventa_r"),
                            result.getInt("porcentaje_r"),
                            result.getObject("fechaemision_r", LocalDate.class),
                            result.getDouble("baseimponible_r"),
                            result.getString("descripcion_r"),
                            result.getString("ejerciciofiscal_r"),
                            result.getDouble("total_r")));//result.getObject("fecha_nacimiento", LocalDate.class)
                }
            } catch (SQLException ex) {
                lista_Retencion.add(new Retencion(-1, -1, 0, null, 0.0, "", "", 0.0));
            } finally {
                conex.cerrarConexion();
            }
        }
        return lista_Retencion;
    }

    public List<Retencion> obtener_Ventas(int idCliente) {
        lista_Retencion = new ArrayList<>();
        if (conex.isEstado()) {
            try {
                String sentencia ="select*from obtener_idfacturas_de_Cliente("+idCliente+")";
                result = conex.ejecutarConsulta(sentencia);
                while (result.next()) {
                    lista_Retencion.add(new Retencion(result.getInt("idventa_r")));
                }
            }catch (SQLException ex) {
                lista_Retencion.add(new Retencion(-1));
            } finally {
                conex.cerrarConexion();
            }
        }
        return lista_Retencion;
    }
}
