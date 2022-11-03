package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaVerdaderoFalso extends Pregunta {

    private boolean respuesta;

    public PreguntaVerdaderoFalso(){
        
    }
    
    public PreguntaVerdaderoFalso(String textoPregunta, String categoria, boolean respuesta, int contador) {
        super("VF", textoPregunta, categoria);
        this.id = contador + 1;
        this.respuesta = respuesta;
    }

    public boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toFileString() {
        return tipo + "-" + id + "-" + textoPregunta + "-" + categoria + "-" + respuesta;
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
