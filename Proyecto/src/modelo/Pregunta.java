package modelo;

/**
 * Esta clase consiste en el objeto abstracto Pregunta, que solo sirve como
 * superclase
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740,
 * Jeaustin Castro López C21912
 */
public abstract class Pregunta {

    // Variables
    protected String textoPregunta;
    protected String categoria;
    protected int id;
    protected String tipo;

    private final String ENTRETENIMIENTO = "Entretenimiento";
    private final String DEPORTE = "Deporte";
    private final String HISTORIA = "Historia";

    /**
     * Construye una pregunta
     *
     * @param tipo El tipo de la pregunta
     * @param textoPregunta El texto de la pregunta
     * @param categoria La categoría de la pregunta
     */
    public Pregunta(String tipo, String textoPregunta, String categoria) {
        this.tipo = tipo;
        this.textoPregunta = textoPregunta;
        this.categoria = categoria;
    }

    /**
     * Constructor vacío
     */
    public Pregunta() {

    }

    /**
     * Retorna el texto de la pregunta
     *
     * @return El texto de la pregunta
     */
    public String getTexto() {
        return textoPregunta;
    }

    /**
     * Retorna la categoría de la pregunta
     *
     * @return La categoría de la pregunta
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Retorna el id de la pregunta
     *
     * @return El Id de la pregunta
     */
    public int getId() {
        return id;
    }
    
    /**
     * Asigna el texto a la pregunta
     *
     * @param textoPregunta El texto a asignar
     */
    public void setTexto(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    /**
     * Asigna la categoría a la pregunta
     *
     * @param categoria La categoría a asignar
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @return True o False, dependiendo si fue respuesta correcta
     */
    public abstract boolean evaluarRespuesta();

    /**
     * Método que convierte los datos de la pregunta en una hilera de texto
     * para ser leída y escrita en archivos de texto
     *
     * @return La hilera de texto con los datos de la pregunta
     */
    public abstract String toFileString();

}
