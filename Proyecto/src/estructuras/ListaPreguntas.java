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
import modelo.Respuesta;
import modelo.ValidadorPregunta;

public class ListaPreguntas {

    private Pregunta[] lista;
    private int cantidadPreguntas = 0;
    private ValidadorPregunta validador = new ValidadorPregunta();

    public ListaPreguntas() {
        this.lista = new Pregunta[15];
    }

    private void agregar(Pregunta pregunta) {

        if (this.cantidadPreguntas == lista.length) {
            this.duplicarLista();
        }

        lista[cantidadPreguntas] = pregunta;

        cantidadPreguntas += 1;
    }

    private void duplicarLista() {
        Pregunta[] listaAux = new Pregunta[lista.length * 2];
        for (int i = 0; i < lista.length; i++) {
            listaAux[i] = lista[i];
        }
        lista = listaAux;
    }

    public int obtenerIdDesdeElUltimoElementoDelaLista() {
        return lista.length;
    }

    public void insertarPregunta(String texto, String categoria, Respuesta respuesta1, Respuesta respuesta2) {
        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(texto, categoria, obtenerIdDesdeElUltimoElementoDelaLista(), respuesta1, respuesta2);
        this.agregar(pregunta);

    }

    public void insertarPregunta(String texto, String categoria, Respuesta respuesta1,
        Respuesta respuesta2, Respuesta respuesta3, Respuesta respuesta4, int opcionCorrecta) {
        PreguntaSeleccionUnica pregunta = new PreguntaSeleccionUnica(texto, categoria, opcionCorrecta, respuesta1, respuesta2, respuesta3, respuesta4);
        this.agregar(pregunta);

    }

    public void insertarPregunta(String texto, String categoria, String respuesta1,
            boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2,
            String respuesta3, boolean valorRespuesta3, String respuesta4,
            boolean valorRespuesta4) {
        PreguntaSeleccionMultiple pregunta = new PreguntaSeleccionMultiple(texto, categoria, respuesta1,
                valorRespuesta1, respuesta2, valorRespuesta2,
                respuesta3, valorRespuesta3, respuesta4, valorRespuesta4);
        this.agregar(pregunta);

    }

    //Recibe como parametro un entero 1, 2 o 3 segun el tipo de pregunta que se desea consultar
    //Retorna un arreglo con unicamente las preguntas de dicho tipo
    public Pregunta[] mostrarPregunta(int tipoPregunta) { //tipoPregunta debe ser 1, 2 o 3
        Pregunta[] lista = {};
        int tamano;

        switch (tipoPregunta) {
            case 1: //Preguntas de verdadero/falso

                PreguntaVerdaderoFalso preguntaEjemplo = null;

                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaVerdaderoFalso) {
                        preguntaEjemplo = pregunta;
                    }
                }

                tamano = (PreguntaVerdaderoFalso) preguntaEjemplo.getContador(); //Este contador es la variable STATIC, no el id de la pregunta en si

                PreguntaVerdaderoFalso[] listaVerdaderoFalso = new PreguntaVerdaderoFalso[tamano];

                int contadorVerdaderoFalso = -1;

                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaVerdaderoFalso) {
                        contadorVerdaderoFalso++;
                        listaVerdaderoFalso[contadorVerdaderoFalso] = (PreguntaVerdaderoFalso) pregunta;
                    }
                }

                lista = listaVerdaderoFalso;

                break;
            case 2: //Preguntas de seleccion unica

                PreguntaSeleccionUnica preguntaEjemplo = null;

                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaSeleccionUnica) {
                        preguntaEjemplo = pregunta;
                    }
                }

                tamano = (PreguntaSeleccionUnica) preguntaEjemplo.getContador(); //Este contador es la variable STATIC, no el id de la pregunta en si

                PreguntaSeleccionUnica[] listaSeleccionunica = new PreguntaSeleccionUnica[tamano];

                int contadorSeleccionUnica = -1;

                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaSeleccionUnica) {
                        contadorSeleccionUnica++;
                        listaSeleccionUnica[contadorSeleccionUnica] = pregunta;
                    }
                }

                lista = listaSeleccionUnica;

                break;
            case 3: //Preguntas de seleccion multiple

                PreguntaSeleccionMultiple preguntaEjemplo = null;

                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaSeleccionMultiple) {
                        preguntaEjemplo = pregunta;
                    }
                }

                tamano = (PreguntaSeleccionMultiple) preguntaEjemplo.getContador(); //Este contador es la variable STATIC, no el id de la pregunta en si

                PreguntaSeleccionMultiple[] listaSeleccionMultiple = new PreguntaSeleccionMultiple[tamano];

                int contadorSeleccionMultiple = -1;

                for (Pregunta pregunta : lista) {
                    if (pregunta instanceof PreguntaSeleccionMultiple) {
                        contadorSeleccionMultiple++;
                        listaSeleccionMultiple[contadorSeleccionMultiple] = pregunta;
                    }
                }

                lista = listaSeleccionMultiple;

                break;
            default:
                break;
        }

        return lista;
    }

    public void actualizarPregunta(int id, String texto, String categoria, boolean respuesta) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] instanceof PreguntaVerdaderoFalso) {
                if (lista[i].getId() == id) {

                    lista[i].setTexto(texto);
                    lista[i].setCategoria(categoria);
                    lista[i].setRespuesta(respuesta);
                }
            }
        }
    }

    public void actualizarPregunta(int id,String texto, String categoria, String respuesta1,
            String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] instanceof PreguntaSeleccionUnica) {
                if (lista[i].getId() == id) {

                    lista[i].setTexto(texto);
                    lista[i].setCategoria(categoria);
                    lista[i].setRespuesta1(respuesta1);
                    lista[i].setRespuesta2(respuesta2);
                    lista[i].setRespuesta3(respuesta3);
                    lista[i].setRespuesta4(respuesta4);
                    lista[i].setOpcionCorrecta(opcionCorrecta);
                }
            }
        }

    }

    public void actualizarPregunta(int id,String texto, String categoria, String respuesta1,
            boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2,
            String respuesta3, boolean valorRespuesta3, String respuesta4,
            boolean valorRespuesta4) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] instanceof PreguntaSeleccionMultiple) {
                if (lista[i].getId() == id) {

                    lista[i].setTexto(texto);
                    lista[i].setCategoria(categoria);
                    lista[i].setRespuesta1(respuesta1);
                    lista[i].setValorRespuesta1(valorRespuesta1);
                    lista[i].setRespuesta2(respuesta2);
                    lista[i].setValorRespuesta2(valorRespuesta2);
                    lista[i].setRespuesta3(respuesta3);
                    lista[i].setValorRespuesta3(valorRespuesta3);
                    lista[i].setRespuesta4(respuesta4);
                    lista[i].setValorRespuesta4(valorRespuesta4);

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

            default:
        }

    }

}
