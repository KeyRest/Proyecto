
package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaCuatroOpciones extends Pregunta{

    private Respuesta respuesta1;
    private Respuesta respuesta2;
    private Respuesta respuesta3;
    private Respuesta respuesta4;

    public PreguntaCuatroOpciones(String textoPregunta, String categoria, int id) {
        super(textoPregunta, categoria, id);
    }

    public Respuesta getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(Respuesta respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public Respuesta getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(Respuesta respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public Respuesta getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(Respuesta respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public Respuesta getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(Respuesta respuesta4) {
        this.respuesta4 = respuesta4;
    }
    
    
    
    @Override
    public void toFileString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
