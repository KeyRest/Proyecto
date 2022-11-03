package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaVerdaderoFalso extends Pregunta {

    private boolean respuesta;
    public static int contador = 0;

    public PreguntaVerdaderoFalso(String textoPregunta, String categoria, boolean respuesta) {
        super(textoPregunta, categoria);
        this.id = contador;
        this.respuesta = respuesta;
        contador++;
    }

    public boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String toFileString() {
        return "";
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public boolean evaluarRespuesta() {
        return false;
    }

    public boolean evaluarRespuesta(boolean respuestaUsuario) {
        boolean valido = false;
        if (respuestaUsuario == this.respuesta) {
            valido = true;
        }
        return valido;
    }

}
