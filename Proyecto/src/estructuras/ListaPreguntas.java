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
    
    private void duplicarLista(){
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
    
    public Pregunta[] mostrarPregunta(int tipoPregunta){ //tipoPregunta debe ser 1, 2 o 3
        Pregunta[] lista = {};
        
        switch(tipoPregunta){
            case 1: //Preguntas de verdadero/falso
                
                PreguntaVerdaderoFalso preguntaEjemplo;
                
                for (Pregunta pregunta : lista) {            
                    if (pregunta instanceof PreguntaVerdaderoFalso){
                        preguntaEjemplo = pregunta;
                    }
                }
                
                int tamano = (PreguntaVerdaderoFalso) preguntaEjemplo.getContador(); //Este contador es la variable STATIC, no el id de la pregunta en si
                
                PreguntaVerdaderoFalso[] listaVerdaderoFalso = new PreguntaVerdaderoFalso[tamano];
                
                int contadorVerdaderoFalso = -1;
                
                for (Pregunta pregunta : lista) {            
                    if (pregunta instanceof PreguntaVerdaderoFalso){
                        contadorVerdaderoFalso ++;
                        listaVerdaderoFalso[contadorVerdaderoFalso] = (PreguntaVerdaderoFalso) pregunta;
                    }
                }
                
                lista = listaVerdaderoFalso;
                
                break;
            case 2: //Preguntas de seleccion unica
                
                PreguntaSeleccionUnica preguntaEjemplo;
                
                for (Pregunta pregunta : lista) {            
                    if (pregunta instanceof PreguntaSeleccionUnica){
                        preguntaEjemplo = pregunta;
                    }
                }
                
                int tamano = (PreguntaSeleccionUnica) preguntaEjemplo.getContador(); //Este contador es la variable STATIC, no el id de la pregunta en si
                
                PreguntaSeleccionUnica[] listaSeleccionunica = new PreguntaSeleccionUnica[tamano];
                
                int contadorSeleccionUnica = -1;
                
                for (Pregunta pregunta : lista) {            
                    if (pregunta instanceof PreguntaSeleccionUnica){
                        contadorSeleccionUnica ++;
                        listaSeleccionUnica[contadorSeleccionUnica] = pregunta;
                    }
                }
                
                lista = listaSeleccionUnica;
                
                break;
            case 3: //Preguntas de seleccion multiple
                break;
            default:
                break;
        }
        
        return lista;
    }
    
    public void actualizarPregunta(){
        
    }
    
    public void eliminarPregunta(){
        
    }
    
}
