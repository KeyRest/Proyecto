package controlador;

import archivos.EscritorArchivos;
import archivos.LectorArchivos;
import estructuras.ListaPreguntas;
import java.io.IOException;
import modelo.PreguntaVerdaderoFalso;
import vistas.terminal.InterfazMenu;

/**
 * VERSION 1.0
 *
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 */
public class Controlador {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ListaPreguntas lista = new ListaPreguntas();
        InterfazMenu interfaz = new InterfazMenu();
        EscritorArchivos escritor = new EscritorArchivos();
        LectorArchivos lector = new LectorArchivos();
        PreguntaVerdaderoFalso p = new PreguntaVerdaderoFalso("", "", true);
        
        p.setContador(55);
        System.out.println(p.getContador());
        System.out.println("Ya vuelvo");
        String rutaAbsoluta;
        
        lector.open("file.txt");
        rutaAbsoluta = lector.readRuta();
        lector.close();
        
        escritor.open(rutaAbsoluta);
        escritor.escribir("hola");
        escritor.close();
        
        
        //interfaz.iniciarMenu(lista);
        
    }
    
}
