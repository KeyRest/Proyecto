package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaSeleccionUnica extends PreguntaCuatroOpciones {

    private int opcionCorrecta;
    public static int contador = 0;

    public PreguntaSeleccionUnica(String textoPregunta, String categoria, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int opcionCorrecta) {
        super(textoPregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4);
        this.opcionCorrecta = opcionCorrecta;
        this.id = contador;
        contador++;
    }

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(int opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public String toFileString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
