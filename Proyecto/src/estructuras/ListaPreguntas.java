package estructuras;

import modelo.Pregunta;
import modelo.PreguntaVerdaderoFalso;
import modelo.PreguntaSeleccionUnica;
import modelo.PreguntaSeleccionMultiple;

/**
 * Esta clase gestiona el array de preguntas, así como todas sus operaciones
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740,
 * Jeaustin Castro López C21912
 */
public class ListaPreguntas {

    //Atributos
    private Pregunta[] lista;
    private int cantidadPreguntas;
    private int contadorSU;
    private int contadorSM;
    private int contadorVF;

    /**
     * Construye una lista de preguntas
     *
     * @param contadorSU el contador de preguntas de selección única que ya
     * existen
     * @param contadorSM el contador de preguntas de selección múltiple que ya
     * existen
     * @param contadorVF el contador de preguntas de verdadero o falso que ya
     * existen
     */
    public ListaPreguntas(int contadorSU, int contadorSM, int contadorVF) {
        this.cantidadPreguntas = contadorSU + contadorSM + contadorVF;
        this.lista = new Pregunta[1];
        this.contadorSU = contadorSU;
        this.contadorSM = contadorSM;
        this.contadorVF = contadorVF;
    }

    /**
     * Retorna la lista de preguntas
     *
     * @return lista La lista de preguntas
     */
    public Pregunta[] getLista() {
        return lista;
    }

    /**
     * Asigna un arreglo de preguntas como la lista
     *
     * @param lista El arreglo que se va a asignar a la lista
     */
    public void setLista(Pregunta[] lista) {
        this.lista = lista;
    }

    /**
     * Retorna el contador de preguntas de selección única
     *
     * @return contadorSU el contador de preguntas de selección única
     */
    public int getContadorSU() {
        return contadorSU;
    }

    /**
     * Retorna el contador de preguntas de selección múltiple
     *
     * @return contadorSM el contador de preguntas de selección múltiple
     */
    public int getContadorSM() {
        return contadorSM;
    }

    /**
     * Retorna el contador de preguntas de verdadero o falso
     *
     * @return contadorSU el contador de preguntas de verdadero o falso
     */
    public int getContadorVF() {
        return contadorVF;
    }

    /**
     * Agrega una pregunta a la lista
     *
     * @param pregunta La pregunta que se va a agregar
     */
    public void agregar(Pregunta pregunta) {

        if (this.cantidadPreguntas == lista.length) {
            this.aumentarLista();
        }

        lista[lista.length - 1] = pregunta;
        cantidadPreguntas++;
    }

    /**
     * Aumenta en uno el tamaño del arreglo lista
     *
     */
    private void aumentarLista() {
        Pregunta[] listaAux = new Pregunta[lista.length + 1];
        for (int i = 0; i < lista.length; i++) {
            listaAux[i] = lista[i];
        }
        lista = listaAux;
    }

    /**
     * Retorna el contador de preguntas de selección única
     *
     * @return id El Id del último elemento de la lista
     */
    public int obtenerIdDesdeElUltimoElementoDelaLista() {
        int id = lista.length;
        return id;
    }

    /**
     * Inserta una pregunta, en este caso, una pregunta de verdadero o falso
     *
     * @param texto El texto de la pregunta a insertar
     * @param categoria La categoria de la pregunta a insertar
     * @param respuesta La respuesta, booleana, de la pregunta a insertar
     * @param contador El contador que es usado para calcular el id de la
     * pregunta
     *
     */
    public void insertarPregunta(String texto, String categoria, boolean respuesta, int contador) {
        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(texto, categoria, respuesta, contador);
        this.agregar(pregunta);
    }

    /**
     * Inserta una pregunta, en este caso, una pregunta de selección única
     *
     * @param texto El texto de la pregunta a insertar
     * @param categoria La categoria de la pregunta a insertar
     * @param respuesta1 El texto de la respuesta1
     * @param respuesta2 El texto de la respuesta 2
     * @param respuesta3 El texto de la respuesta 3
     * @param respuesta4 El texto de la respuesta 4
     * @param opcionCorrecta La opcion correcta, del 1 al 4
     * @param contador El contador que es usado para calcular el id de la
     * pregunta orrecta
     *
     *
     */
    public void insertarPregunta(String texto, String categoria, String respuesta1,
            String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta, int contador) {
        PreguntaSeleccionUnica pregunta = new PreguntaSeleccionUnica(texto, categoria, respuesta1, respuesta2, respuesta3, respuesta4, opcionCorrecta, contador);
        this.agregar(pregunta);
    }

    /**
     * Inserta una pregunta, en este caso, una pregunta de selección múltiple
     *
     * @param texto El texto de la pregunta a insertar
     * @param categoria La categoria de la pregunta a insertar
     * @param respuesta1 El texto de la respuesta1
     * @param respuesta2 El texto de la respuesta 2
     * @param respuesta3 El texto de la respuesta 3
     * @param respuesta4 El texto de la respuesta 4
     * @param valorRespuesta1 El valor boolean de la respuesta1
     * @param valorRespuesta2 El valor boolean de la respuesta2
     * @param valorRespuesta3 El valor boolean de la respuesta3
     * @param valorRespuesta4 El valor boolean de la respuesta4
     * @param contador El contador que es usado para calcular el id de la
     * pregunta orrecta
     *
     *
     */
    public void insertarPregunta(String texto, String categoria, String respuesta1,
            boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2,
            String respuesta3, boolean valorRespuesta3, String respuesta4,
            boolean valorRespuesta4, int contador) {
        PreguntaSeleccionMultiple pregunta = new PreguntaSeleccionMultiple(texto, categoria, respuesta1,
                valorRespuesta1, respuesta2, valorRespuesta2,
                respuesta3, valorRespuesta3, respuesta4, valorRespuesta4, contador);
        this.agregar(pregunta);

    }

    /**
     * Retorna un arreglo con las preguntas de un solo tipo
     *
     * @param tipoPregunta El tipo de pregunta que se debe mostrar
     * @return listaFiltrada Un arreglo con las preguntas del tipo especificado
     *
     */
    public Pregunta[] mostrarPregunta(int tipoPregunta) { //tipoPregunta debe ser 1, 2 o 3
        Pregunta[] listaFiltrada = {};
        int tamano;

        switch (tipoPregunta) {
            case 1 -> {
                //Preguntas de verdadero/falso

                tamano = contadorVF; //Este contador es la variable STATIC, no el id de la pregunta en si

                PreguntaVerdaderoFalso[] listaVerdaderoFalso = new PreguntaVerdaderoFalso[tamano]; // el tamano es 1 porque no esta funcionando

                int contadorVerdaderoFalso = -1;

                for (Pregunta pregunta : this.lista) {
                    if (pregunta instanceof PreguntaVerdaderoFalso) {
                        contadorVerdaderoFalso++;
                        listaVerdaderoFalso[contadorVerdaderoFalso] = (PreguntaVerdaderoFalso) pregunta;

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

    /**
     * Actualiza una pregunta con los datos especificados, en este caso para una
     * pregunta de verdadero o falso
     *
     * @param id El id de la pregunta que se va a actualizar
     * @param texto El texto nuevo
     * @param categoria La categoría nueva
     * @param respuesta La respuesta nueva
     *
     */
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

    /**
     * Actualiza una pregunta con los datos especificados, en este caso para una
     * pregunta de selección única
     *
     * @param id El id de la pregunta que se va a actualizar
     * @param texto El texto nuevo
     * @param categoria La categoría nueva
     * @param respuesta1 La respuesta 2 nueva
     * @param respuesta2 La respuesta 2 nueva
     * @param respuesta3 La respuesta 3 nueva
     * @param respuesta4 La respuesta 4 nueva
     * @param opcionCorrecta La nueva opción correcta
     *
     */
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

    /**
     * Actualiza una pregunta con los datos especificados, en este caso para una
     * pregunta de selección múltiple
     *
     * @param id El id de la pregunta que se va a actualizar
     * @param texto El texto nuevo
     * @param categoria La categoría nueva
     * @param respuesta1 La respuesta 2 nueva
     * @param respuesta2 La respuesta 2 nueva
     * @param respuesta3 La respuesta 3 nueva
     * @param respuesta4 La respuesta 4 nueva
     * @param valorRespuesta1 El nuevo valor de la respuesta 1
     * @param valorRespuesta2 El nuevo valor de la respuesta 2
     * @param valorRespuesta3 El nuevo valor de la respuesta 3
     * @param valorRespuesta4 El nuevo valor de la respuesta 4
     *
     */
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

    /**
     * Elimina una pregunta
     *
     * @param tipoPregunta El tipo de pregunta que se va a eliminar
     * @param id El id de la pregunta que se va a eliminar
     */
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
