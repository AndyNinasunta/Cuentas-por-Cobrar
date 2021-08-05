
import DataView.PersonaDAO;
import Model.Persona;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PERSONAL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDAO clientedao = new PersonaDAO();
        List<Persona> clientes = clientedao.obtener_Todos_Los_Clientes();
        System.out.println(clientes.size());
    }
    
}
