
package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaSeleccionMultiple extends PreguntaCuatroOpciones {
   
    public PreguntaSeleccionMultiple(String textoPregunta, String categoria, int id, Respuesta respuesta1, Respuesta respuesta2, 
            Respuesta respuesta3, Respuesta respuesta4) {
        super(textoPregunta, categoria, id);
        this.setTipoPregunta(this.getSELECCION_MULTIPLE());
        this.setRespuesta1(respuesta1); 
        this.setRespuesta2(respuesta2);
        this.setRespuesta3(respuesta3);
        this.setRespuesta4(respuesta4);
    }
    
    @Override
    public void toFileString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
