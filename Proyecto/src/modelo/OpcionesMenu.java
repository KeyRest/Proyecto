/**
 * Esta clase contiene las funciones del menu
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */

package modelo;
import vistas.terminal.Escritor;
import vistas.terminal.Lector;

public class OpcionesMenu {
    Escritor escritor = new Escritor();
    Lector lector = new Lector();
    
    public OpcionesMenu(){
    
    }
    
    public void insertarPregunta(){
        String textoPregunta = "";
        boolean controlTexto = true;
        
        
        
        while(controlTexto == true){
            
            //Texto de la pregunta
            escritor.escribir("INSERTE EL TEXTO DE LA PREGUNTA: ");
            textoPregunta = lector.leerString();
            
            if(textoPregunta.length()){
                
            } else{
                escritor.escribir("ERROR, LA LONGITUD DE LA PREGUNTA DEBE ESTAR ENTRE 4 Y 20 CARACTERES");
            }
        }
        
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