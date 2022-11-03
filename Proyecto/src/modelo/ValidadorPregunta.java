package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class ValidadorPregunta {

    private final String ENTRETENIMIENTO = "Entretenimiento";
    private final String DEPORTE = "Deporte";
    private final String HISTORIA = "Historia";
    private int decision;

    public boolean validarTextoPregunta(String textoPregunta) {
        if (textoPregunta.length() > 4 && textoPregunta.length() < 50) {
            return true;
        }
        return false;
    }

    public Boolean validarIngresoDeRespuestasCorrectoSeleccionMultiple(Respuesta respuesta1, Respuesta respuesta2, 
            Respuesta respuesta3, Respuesta respuesta4) {
        int contadorCorrectas = 0;

        if (respuesta1.getEsCorrecta()) {
            contadorCorrectas++;
        }
        if (respuesta2.getEsCorrecta()) {
            contadorCorrectas++;
        }
        if (respuesta3.getEsCorrecta()) {
            contadorCorrectas++;
        }
        if (respuesta4.getEsCorrecta()) {
            contadorCorrectas++;
        }

        if (contadorCorrectas == 0) {
            return false; // retorna falso porque en seleccion multiple pueden haber varias correctas pero no puede no haber correctas
        }

        return true;
    }

    public Boolean validarIngresoDeRespuestasCorrectoSeleccionUnica(Respuesta respuesta1, Respuesta respuesta2, Respuesta respuesta3,
            Respuesta respuesta4) {
        int contadorCorrectas = 0;

        if (respuesta1.getEsCorrecta()) {
            contadorCorrectas++;
        }
        if (respuesta2.getEsCorrecta()) {
            contadorCorrectas++;
        }
        if (respuesta3.getEsCorrecta()) {
            contadorCorrectas++;
        }
        if (respuesta4.getEsCorrecta()) {
            contadorCorrectas++;
        }

        if (contadorCorrectas == 1) {
            return true; // en seleccion unica solo debe haber una correcta
        }

        return false;
    }

    public Boolean validarIngresoDeRespuestasCorrectoVerdaderoFalso(Respuesta respuesta1, Respuesta respuesta2) {
        return respuesta1.getEsCorrecta() != respuesta2.getEsCorrecta();
    }

    public boolean validarCategoriaPregunta(String categoria) {
        if (categoria == ENTRETENIMIENTO || categoria == DEPORTE || categoria == HISTORIA) {
            return true;
        }
        return false;
    }

}
