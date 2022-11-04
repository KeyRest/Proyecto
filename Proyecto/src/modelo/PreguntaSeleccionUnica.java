package modelo;

/**
 * Esta clase consiste en el objeto PreguntaSeleccionUnica
 * Tiene cuatro opciones, solo una es correcta
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */
public class PreguntaSeleccionUnica extends PreguntaCuatroOpciones {

    private int opcionCorrecta;
    private int contador;

    /** Construye una pregunta de selección única
     *
     */
    public PreguntaSeleccionUnica(){
        
    }
    
    /** Construye una pregunta de selección única
     *
     * @param textoPregunta El texto de la pregunta
     * @param categoria La categoría de la pregunta
     * @param respuesta1 La respuesta 1 de la pregunta
     * @param respuesta2 La respuesta 2 de la pregunta
     * @param respuesta3 La respuesta 3 de la pregunta
     * @param respuesta4 La respuesta 4 de la pregunta
     * @param opcionCorrecta La opción correcta de la pregunta
     * @param contador El contador de la pregunta
     */
    public PreguntaSeleccionUnica(String textoPregunta, String categoria, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta, int contador) {
        super("SU",textoPregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4);
        this.opcionCorrecta = opcionCorrecta;
        this.id = contador+1;        
    }

    /** Retorna la opción correcta
     *
     * @return La opción correcta
     */
    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    /** Asigna la opción correcta
     *
     * @param opcionCorrecta La opción correcta
     */
    public void setOpcionCorrecta(int opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    /** Retorna el contador
     *
     * @return El contador
     */
    public int getContador() {
        return contador;
    }

    /** Método que convierte los datos de la pregunta en una hilera de texto
     * para ser leída y escrita en archivos de texto
     *
     * @return La hilera de texto con los datos de la pregunta
     */
    @Override
    public String toFileString() {
        return tipo + "-" + id + "-" + textoPregunta + "-" + categoria + "-" + respuesta1 + "-" + respuesta2 + "-" + respuesta3 + "-" + respuesta4 + "-" + opcionCorrecta;
    }

    /** Evalúa si la respuesta es correcta
     *
     * @return True o False, dependiendo si fue respuesta correcta
     */
    @Override
    public boolean evaluarRespuesta() {
        return false;
    }

    /** Evalúa si la respuesta es correcta
     *
     * @param opcionUsuario La opción del usuario
     * @return True o False, dependiendo si fue respuesta correcta
     */
    public boolean evaluarRespuesta(int opcionUsuario) {
        boolean valido = false;

        if (opcionUsuario == opcionCorrecta) {
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
        
        switch(this.categoria){
            case "1" -> categoriaEnTexto = "Deporte";
            case "2" -> categoriaEnTexto = "Entrenamiento";
            case "3" -> categoriaEnTexto = "Historia";
        }
        
        return "TEXTO PREGUNTA = " + this.textoPregunta + "\nCATEGORÍA = " + categoriaEnTexto + "\n"
                + "OPCION 1 = " + this.respuesta1 + "\nOPCION 2 = " + this.respuesta2 + "\nOPCION 3 = " + this.respuesta3
                + "\nOPCION 4 = " + this.respuesta4 + "\nOPCION CORRECTA = " + this.opcionCorrecta;
    }

}
