package modelo;

/**
 * Esta clase consiste en el objeto PreguntaVerdaderoFalso Tiene dos posibles
 * respuestas, verdadero o falso
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740,
 * Jeaustin Castro López C21912
 */
public class PreguntaVerdaderoFalso extends Pregunta {

    private boolean respuesta;

    /**
     * Construye una pregunta de verdadero falso
     *
     */
    public PreguntaVerdaderoFalso() {

    }

    /**
     * Construye una pregunta de verdadero falso
     *
     * @param textoPregunta
     * @param categoria
     * @param respuesta
     * @param contador
     */
    public PreguntaVerdaderoFalso(String textoPregunta, String categoria, boolean respuesta, int contador) {
        super("VF", textoPregunta, categoria);
        this.id = contador + 1;
        this.respuesta = respuesta;
    }

    /**
     * Retorna la respuesta
     *
     * @return La respuesta
     */
    public boolean getRespuesta() {
        return respuesta;
    }

    /**
     * Asigna la respuesta
     *
     * @param respuesta respuesta
     */
    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * Método que convierte los datos de la pregunta en una hilera de texto para
     * ser leída y escrita en archivos de texto
     *
     * @return La hilera de texto con los datos de la pregunta
     */
    @Override
    public String toFileString() {
        return tipo + "-" + id + "-" + textoPregunta + "-" + categoria + "-" + respuesta;
    }

    /**
     * Evalúa si la respuesta es correcta
     *
     * @return True o False, dependiendo si la respuesta es correcta o no
     */
    @Override
    public boolean evaluarRespuesta() {
        return false;
    }

    /**
     * Evalúa si la respuesta es correcta
     *
     * @param respuestaUsuario La respuesta
     * @return True o False, dependiendo si la respuesta es correcta o no
     */
    public boolean evaluarRespuesta(boolean respuestaUsuario) {
        boolean valido = false;
        if (respuestaUsuario == this.respuesta) {
            valido = true;
        }
        return valido;
    }

    /**
     * Método que imprime datos cuando se imprime el objeto
     *
     * @return Un cuerpo de texto con los datos de la pregunta
     */
    @Override
    public String toString() {
        String categoriaEnTexto = "";

        switch (this.categoria) {
            case "1" ->
                categoriaEnTexto = "Deporte";
            case "2" ->
                categoriaEnTexto = "Entretenimiento";
            case "3" ->
                categoriaEnTexto = "Historia";
        }

        return "TEXTO PREGUNTA= " + this.textoPregunta + "\n" + "CATEGORÍA= " + categoriaEnTexto + "\nw"
                + "RESPUESTA= " + this.respuesta;
    }

}
