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
    private int tipoPregunta;
    private static int id;
    
    private final int VERDADERO_FALSO = 0;
    private final int SELECCION_UNICA = 1;
    private final int SELECCION_MULTIPLE = 2;
    
    //Constructores
    public Pregunta(String textoPregunta, String categoria, int tipoPregunta, int id) {
        this.textoPregunta = textoPregunta;
        this.categoria = categoria;
        this.tipoPregunta = tipoPregunta;
        this.id = id;
    }

    public Pregunta() {
        this.textoPregunta = "";
        this.categoria = "";
        this.tipoPregunta = 0;
        this.id = 0;
    }
    // Getters

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTipoPregunta() {
        return tipoPregunta;
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

    public void setTipoPregunta(int tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVERDADERO_FALSO() {
        return VERDADERO_FALSO;
    }

    public int getSELECCION_UNICA() {
        return SELECCION_UNICA;
    }

    public int getSELECCION_MULTIPLE() {
        return SELECCION_MULTIPLE;
    }
    
   

    public abstract void toFileString();

    @Override
    public String toString() {
        return "Pregunta{" + "textoPregunta=" + textoPregunta + ", categoria=" + categoria + ", tipoPregunta=" + tipoPregunta + ", id=" + id + '}';
    }
}
