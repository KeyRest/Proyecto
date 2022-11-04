package modelo;

/**
 * Esta clase consiste en las preguntas que tienen cuatro posibles opciones para elegir, es abstracta
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */
public abstract class PreguntaCuatroOpciones extends Pregunta {

    protected String respuesta1;
    protected String respuesta2;
    protected String respuesta3;
    protected String respuesta4;

    /**
     * Construye una pregunta de cuatro opciones
     *
     */
    public PreguntaCuatroOpciones(){
        
    }
    
    /**
     * Construye una pregunta de cuatro opciones
     *
     * @param tipo El tipo de la pregunta
     * @param textoPregunta El texto de la pregunta
     * @param categoria La categoría de la pregunta
     * @param respuesta1 La respuesta 1 de la pregunta
     * @param respuesta2 La respuesta 2 de la pregunta
     * @param respuesta3 La respuesta 3 de la pregunta
     * @param respuesta4 La respuesta 4 de la pregunta
     */
    public PreguntaCuatroOpciones(String tipo,String textoPregunta, String categoria, String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
        super(tipo,textoPregunta, categoria);
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
    }

    /**
     * Retorna la respuesta 1
     *
     * @return La respuesta 1
     */
    public String getRespuesta1() {
        return respuesta1;
    }

    /**
     * Asigna la respuesta 1
     *
     * @param respuesta1 La respuesta 1 a asignar
     */
    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    /**
     * Retorna la respuesta 2
     *
     * @return La respuesta 2
     */
    public String getRespuesta2() {
        return respuesta2;
    }

    /**
     * Asigna la respuesta 2
     *
     * @param respuesta2 La respuesta 2 a asignar
     */
    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    /**
     * Retorna la respuesta 3
     *
     * @return La respuesta 3
     */
    public String getRespuesta3() {
        return respuesta3;
    }

    /**
     * Asigna la respuesta 3
     *
     * @param respuesta3 La respuesta 3 a asignar
     */
    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    /**
     * Retorna la respuesta 4
     *
     * @return La respuesta 4
     */
    public String getRespuesta4() {
        return respuesta4;
    }

    /**
     * Asigna la respuesta 4
     *
     * @param respuesta4 La respuesta 4 a asignar
     */
    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @return True o False, dependiendo si fue respuesta correcta
     */
    @Override
    public abstract String toFileString();

    /**
     * Método que convierte los datos de la pregunta en una hilera de texto
     * para ser leída y escrita en archivos de texto
     *
     * @return La hilera de texto con los datos de la pregunta
     */
    @Override
    public abstract boolean evaluarRespuesta();
}
