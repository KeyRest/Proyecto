/**
 *
 * @author maris
 */
package estructuras;
import modelo.Pregunta;
import modelo.PreguntaVerdaderoFalso;
import modelo.PreguntaSeleccionUnica;
import modelo.PreguntaSeleccionMultiple;
import modelo.PreguntaCuatroOpciones;

public class ListaPreguntas {
    private Pregunta[] lista;
    private int cantidadPreguntas = 0;

    public ListaPreguntas() {
        this.lista = new Pregunta[15];
    }
    
    private void agregar(Pregunta pregunta){
        
        if(this.cantidadPreguntas == lista.length){
            this.duplicarLista();
        }
        
        lista[cantidadPreguntas] = pregunta;
        
        cantidadPreguntas += 1;
    }
    
    public void duplicarLista(){
        Pregunta[] listaAux = new Pregunta[lista.length * 2];
        for (int i = 0; i < lista.length; i++) {
            listaAux[i] = lista[i];
        }
        lista = listaAux;
    }
    
    public void insertarPregunta(String texto, String categoria, boolean respuesta){
        PreguntaVerdaderoFalso pregunta =new PreguntaVerdaderoFalso(texto, categoria, respuesta);
        this.agregar(pregunta);
        
    }
    
    public void insertarPregunta(String texto, String categoria, String respuesta1, 
                                String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta){
        PreguntaSeleccionUnica pregunta =new PreguntaSeleccionUnica(texto, categoria, respuesta1, 
                                             respuesta2, respuesta3, respuesta4, opcionCorrecta);
        this.agregar(pregunta);
        
    }
    
    public void insertarPregunta(String texto, String categoria, String respuesta1, 
                                boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2, 
                                String respuesta3, boolean valorRespuesta3, String respuesta4,
                                boolean valorRespuesta4){
        PreguntaSeleccionMultiple pregunta =new PreguntaSeleccionMultiple(texto, categoria, respuesta1,
                                                valorRespuesta1, respuesta2, valorRespuesta2, 
                                                respuesta3, valorRespuesta3, respuesta4, valorRespuesta4);
        this.agregar(pregunta);
        
    }
    
    public void mostrarPregunta(int tipoPregunta){ //tipoPregunta debe ser 1, 2 o 3
        switch(tipoPregunta){
            case 1: //Preguntas de verdadero/falso
                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaVerdaderoFalso){
                        (PreguntaVerdaderoFalso) pregunta.getContador();
                    }
                }
                break;
            case 2: //Preguntas de seleccion unica
                break;
            case 3: //Preguntas de seleccion multiple
                break;
            default:
                break;
        }
    }
    
    public void actualizarPregunta(){
        
    }
    
    public void eliminarPregunta(){
        
    }
    
}
