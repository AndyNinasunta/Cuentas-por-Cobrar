/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.Retencion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PERSONAL
 */
public class RetencionDAO {
    
    Retencion retencion;
    ResultSet result;
    List<Retencion> lista_Retencion;
    
    
     public List<Retencion> obtener_retenciones() {
        lista_Retencion = new ArrayList<>();
        lista_Retencion.add(new Retencion(2021,2100,"Renta","%10",210.0));
        lista_Retencion.add(new Retencion(2021,240,"Iva","%8",19.2));
        lista_Retencion.add(new Retencion(2021,20000,"Divisa","%90",18000.0));
        
        return lista_Retencion;
    }
}
