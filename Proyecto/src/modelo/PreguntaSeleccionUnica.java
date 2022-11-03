package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaSeleccionUnica extends PreguntaCuatroOpciones {

    private int opcionCorrecta;
    public int contador;

    public PreguntaSeleccionUnica(){
        
    }
    
    public PreguntaSeleccionUnica(String textoPregunta, String categoria, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta, int contador) {
        super("SU",textoPregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4);
        this.opcionCorrecta = opcionCorrecta;
        this.id = contador+1;        
    }

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(int opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }
     public int getContador() {
        return contador;
    }


    @Override
    public String toFileString() {
        return tipo + "-" + id + "-" + textoPregunta + "-" + categoria + "-" + respuesta1 + "-" + respuesta2 + "-" + respuesta3 + "-" + respuesta4 + "-" + opcionCorrecta;
    }

    @Override
    public boolean evaluarRespuesta() {
        return false;
    }

    public boolean evaluarRespuesta(int opcionUsuario) {
        boolean valido = false;

        if (opcionUsuario == opcionCorrecta) {
            valido = true;
        }
        return valido;
    }

}
