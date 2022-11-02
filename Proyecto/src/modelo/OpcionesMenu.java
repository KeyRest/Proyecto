/**
 * Esta clase contiene las funciones del menu
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */

package modelo;
import vistas.terminal.Escritor;
import vistas.terminal.Lector;

public class OpcionesMenu {
    
    public OpcionesMenu(){
    
    }
    
    public void insertarPregunta(String texto, String categoria, boolean respuesta){
        PreguntaVerdaderoFalso pregunta =new PreguntaVerdaderoFalso(texto, categoria, respuesta);
        
    }
    
    public void insertarPregunta(String texto, String categoria, String respuesta, 
                                String incorrecta1, String incorrecta2, String incorrecta3){
        PreguntaSeleccionUnica pregunta =new PreguntaSeleccionUnica(texto, categoria, respuesta, 
                                             incorrecta1, incorrecta2, incorrecta3);
        
    }
    
    public void insertarPregunta(String texto, String categoria, String opcion1, 
                                boolean valor1, String opcion2, boolean valor2, 
                                String opcion3, boolean valor3, String opcion4,
                                boolean valor4){
        PreguntaSeleccionMultiple pregunta =new PreguntaSeleccionMultiple(texto, categoria, opcion1,
                                                valor1, opcion2, valor2, 
                                                opcion3, valor3, opcion3, valor4);
        
    }
    
    public void mostrarPregunta(){
        
    }
    
    public void actualizarPregunta(){
        
    }
    
    public void eliminarPregunta(){
        
    }
    
    public void salir(){
        
    }
    
}