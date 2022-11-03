package controlador;

import estructuras.ListaPreguntas;
import vistas.terminal.InterfazMenu;

/**
 * VERSION 1.0
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */
public class Controlador {

    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaPreguntas lista = new ListaPreguntas();
        InterfazMenu interfaz = new InterfazMenu();
        
        interfaz.iniciarMenu(lista);
        
        System.out.println("");
        System.out.println("dasdasd");
    }
    
}