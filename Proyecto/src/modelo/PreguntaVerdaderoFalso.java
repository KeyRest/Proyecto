
package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaVerdaderoFalso extends Pregunta{

    private Respuesta respuesta1;
    private Respuesta respuesta2;
  
    
    public PreguntaVerdaderoFalso(){
        this.setTipoPregunta(this.getSELECCION_UNICA());
        
    }

    public PreguntaVerdaderoFalso(String textoPregunta, String categoria, int id, Respuesta respuesta1, Respuesta respuesta2) {
        super(textoPregunta, categoria, id);
        this.setTipoPregunta(this.getVERDADERO_FALSO());
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
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
    
    
    @Override
    public void toFileString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
