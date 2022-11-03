package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public abstract class Pregunta {

    // Variables
    private String textoPregunta;
    private String categoria;
    protected static int id;

    private final String ENTRETENIMIENTO = "Entretenimiento";
    private final String DEPORTE = "Deporte";
    private final String HISTORIA = "Historia";

    //Constructores
    public Pregunta(String textoPregunta, String categoria) {
        this.textoPregunta = textoPregunta;
        this.categoria = categoria;
    }

    public Pregunta() {
        this.textoPregunta = "";
        this.categoria = "";
    }
    // Getters

    public String getTexto() {
        return textoPregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setTexto(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public abstract boolean evaluarRespuesta();

    public abstract String  toFileString();

}
