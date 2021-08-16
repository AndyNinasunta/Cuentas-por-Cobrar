

import dataviews.RetencionDAO;
import java.util.List;
import models.Retencion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andy2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Retencion retencion = new Retencion();
        RetencionDAO retencionDAO = new RetencionDAO();
        List<Retencion> listaRetenciones = retencionDAO.obtenerRetenciones(3);
        for(Retencion lst : listaRetenciones ){
            System.out.println(lst.getBaseImponible());
            System.out.println(lst.getDescImpuesto());
            System.out.println(lst.getEjerFiscal());
            System.out.println(lst.getFechaEmision());
            System.out.println(lst.getIdCliente());
            System.out.println(lst.getIdRetencion());
            System.out.println(lst.getIdVenta());
            System.out.println(lst.getPorcenRetencion());
            System.out.println(lst.getValorRetenido());
        }
    }

}
