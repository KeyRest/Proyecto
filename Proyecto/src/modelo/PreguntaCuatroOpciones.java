package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public abstract class PreguntaCuatroOpciones extends Pregunta {

    protected String respuesta1;
    protected String respuesta2;
    protected String respuesta3;
    protected String respuesta4;

    public PreguntaCuatroOpciones(String tipo,String textoPregunta, String categoria, String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
        super(tipo,textoPregunta, categoria);
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    @Override
    public abstract String toFileString();

    @Override
    public abstract boolean evaluarRespuesta();
}
