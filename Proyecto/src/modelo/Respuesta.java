
package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class Respuesta {
    
    private String textoRespuesta;
    private Boolean esCorrecta;

    public Respuesta(String textoRespuesta, Boolean esCorrecta) {
        this.textoRespuesta = textoRespuesta;
        this.esCorrecta = esCorrecta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
    
    

}
