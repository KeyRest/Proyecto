/**
 *
 * @author maris
 */
package estructuras;

import modelo.Pregunta;
import modelo.PreguntaVerdaderoFalso;
import modelo.PreguntaSeleccionUnica;
import modelo.PreguntaSeleccionMultiple;

public class ListaPreguntas {

    private Pregunta[] lista;
    private int cantidadPreguntas;
    private int contadorSU;
    private int contadorSM;
    private int contadorVF;

    public ListaPreguntas(int contadorSU, int contadorSM, int contadorVF) {
        this.cantidadPreguntas = contadorSU + contadorSM + contadorVF;
        this.lista = new Pregunta[1];
        this.contadorSU = contadorSU;
        this.contadorSM = contadorSM;
        this.contadorVF = contadorVF;
    }

    public Pregunta[] getLista() {
        return lista;
    }

    public void setLista(Pregunta[] lista) {
        this.lista = lista;
    }

    public int getContadorSU() {
        return contadorSU;
    }

    public int getContadorSM() {
        return contadorSM;
    }

    public int getContadorVF() {
        return contadorVF;
    }
    
    

    public void agregar(Pregunta pregunta) {
        
        if (this.cantidadPreguntas == lista.length) {
            this.aumentarLista();
        }
        
        lista[lista.length - 1] = pregunta;
        cantidadPreguntas ++;
    }

    private void aumentarLista() {
        Pregunta[] listaAux = new Pregunta[lista.length +1];
        for (int i = 0; i < lista.length; i++) {
            listaAux[i] = lista[i];
        }
        lista = listaAux;
    }

    public int obtenerIdDesdeElUltimoElementoDelaLista() {
        return lista.length;
    }

    public void insertarPregunta(String texto, String categoria, boolean respuesta, int contador) {
        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(texto, categoria, respuesta, contador);
        this.agregar(pregunta);
    }

    public void insertarPregunta(String texto, String categoria, String respuesta1,
            String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta, int contador) {
        PreguntaSeleccionUnica pregunta = new PreguntaSeleccionUnica(texto, categoria, respuesta1, respuesta2, respuesta3, respuesta4, opcionCorrecta, contador);
        this.agregar(pregunta);
    }

    public void insertarPregunta(String texto, String categoria, String respuesta1,
            boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2,
            String respuesta3, boolean valorRespuesta3, String respuesta4,
            boolean valorRespuesta4, int contador) {
        PreguntaSeleccionMultiple pregunta = new PreguntaSeleccionMultiple(texto, categoria, respuesta1,
                valorRespuesta1, respuesta2, valorRespuesta2,
                respuesta3, valorRespuesta3, respuesta4, valorRespuesta4, contador);
        this.agregar(pregunta);

    }

    //Recibe como parametro un entero 1, 2 o 3 segun el tipo de pregunta que se desea consultar
    //Retorna un arreglo con unicamente las preguntas de dicho tipo
    public Pregunta[] mostrarPregunta(int tipoPregunta) { //tipoPregunta debe ser 1, 2 o 3
        Pregunta[] listaFiltrada = {};
        int tamano;

        switch (tipoPregunta) {
            case 1 -> {
                //Preguntas de verdadero/falso

                tamano = this.getContadorVF(); //Este contador es la variable STATIC, no el id de la pregunta en si
                //System.out.println(tamano);

                PreguntaVerdaderoFalso[] listaVerdaderoFalso = new PreguntaVerdaderoFalso[tamano];

                int contadorVerdaderoFalso = 0;

                for (Pregunta pregunta : this.lista) {
                    if (pregunta instanceof PreguntaVerdaderoFalso) {
                        listaVerdaderoFalso[contadorVerdaderoFalso] = (PreguntaVerdaderoFalso) pregunta;
                        contadorVerdaderoFalso++;
                    }
                }

                listaFiltrada = listaVerdaderoFalso;
            }
            case 2 -> {
                //Preguntas de seleccion unica

                tamano = contadorSU; //Este contador es la variable STATIC, no el id de la pregunta en si

                PreguntaSeleccionUnica[] listaSeleccionUnica = new PreguntaSeleccionUnica[tamano];

                int contadorSeleccionUnica = -1;

                for (Pregunta pregunta : this.lista) {
                    if (pregunta instanceof PreguntaSeleccionUnica) {
                        contadorSeleccionUnica++;
                        listaSeleccionUnica[contadorSeleccionUnica] = (PreguntaSeleccionUnica) pregunta;
                    }
                }

                listaFiltrada = listaSeleccionUnica;
            }
            case 3 -> {
                //Preguntas de seleccion multiple

                tamano = contadorSM; //Este contador es la variable STATIC, no el id de la pregunta en si

                PreguntaSeleccionMultiple[] listaSeleccionMultiple = new PreguntaSeleccionMultiple[tamano];

                int contadorSeleccionMultiple = -1;

                for (Pregunta pregunta : this.lista) {
                    if (pregunta instanceof PreguntaSeleccionMultiple) {
                        contadorSeleccionMultiple++;
                        listaSeleccionMultiple[contadorSeleccionMultiple] = (PreguntaSeleccionMultiple) pregunta;
                    }
                }

                listaFiltrada = listaSeleccionMultiple;
            }
            default -> {
            }
        }

        return listaFiltrada;
    }

    public void actualizarPregunta(int id, String texto, String categoria, boolean respuesta) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] instanceof PreguntaVerdaderoFalso) {
                if (lista[i].getId() == id) {

                    lista[i].setTexto(texto);
                    lista[i].setCategoria(categoria);
                    ((PreguntaVerdaderoFalso) lista[i]).setRespuesta(respuesta);
                }
            }
        }
    }

    public void actualizarPregunta(int id, String texto, String categoria, String respuesta1,
            String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] instanceof PreguntaSeleccionUnica) {
                if (lista[i].getId() == id) {

                    lista[i].setTexto(texto);
                    lista[i].setCategoria(categoria);
                    ((PreguntaSeleccionUnica) lista[i]).setRespuesta1(respuesta1);
                    ((PreguntaSeleccionUnica) lista[i]).setRespuesta2(respuesta2);
                    ((PreguntaSeleccionUnica) lista[i]).setRespuesta3(respuesta3);
                    ((PreguntaSeleccionUnica) lista[i]).setRespuesta4(respuesta4);
                    ((PreguntaSeleccionUnica) lista[i]).setOpcionCorrecta(opcionCorrecta);
                }
            }
        }

    }

    public void actualizarPregunta(int id, String texto, String categoria, String respuesta1,
            boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2,
            String respuesta3, boolean valorRespuesta3, String respuesta4,
            boolean valorRespuesta4) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] instanceof PreguntaSeleccionMultiple) {
                if (lista[i].getId() == id) {

                    lista[i].setTexto(texto);
                    lista[i].setCategoria(categoria);
                    ((PreguntaSeleccionMultiple) lista[i]).setRespuesta1(respuesta1);
                    ((PreguntaSeleccionMultiple) lista[i]).setValorRespuesta1(valorRespuesta1);
                    ((PreguntaSeleccionMultiple) lista[i]).setRespuesta2(respuesta2);
                    ((PreguntaSeleccionMultiple) lista[i]).setValorRespuesta2(valorRespuesta2);
                    ((PreguntaSeleccionMultiple) lista[i]).setRespuesta3(respuesta3);
                    ((PreguntaSeleccionMultiple) lista[i]).setValorRespuesta3(valorRespuesta3);
                    ((PreguntaSeleccionMultiple) lista[i]).setRespuesta4(respuesta4);
                    ((PreguntaSeleccionMultiple) lista[i]).setValorRespuesta4(valorRespuesta4);

                }
            }
        }

    }

    public void eliminarPregunta(int tipoPregunta, int id) {
        switch (tipoPregunta) {

            case 1:
                for (int i = 0; i < lista.length; i++) {
                    if (lista[i] instanceof PreguntaVerdaderoFalso) {
                        if (lista[i].getId() == id) {
                            lista[i] = null;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < lista.length; i++) {
                    if (lista[i] instanceof PreguntaSeleccionUnica) {
                        if (lista[i].getId() == id) {
                            lista[i] = null;
                        }
                    }
                }
                break;

            case 3:
                for (int i = 0; i < lista.length; i++) {
                    if (lista[i] instanceof PreguntaSeleccionMultiple) {
                        if (lista[i].getId() == id) {
                            lista[i] = null;
                        }
                    }
                }
                break;

        }
    }

}
