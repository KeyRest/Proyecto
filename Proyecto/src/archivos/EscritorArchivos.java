/**
 *
 * @author Usuario
 */
package archivos;

import java.io.*;
import modelo.*;

public class EscritorArchivos {

    private BufferedWriter escritor;

    public void open(String fileName) throws IOException {
        escritor = new BufferedWriter(new FileWriter(fileName));
    }

    public void escribir(Pregunta[] lista) throws IOException {
        if (lista != null) {
            for (Pregunta pregunta : lista) {
                if(pregunta!=null){
                    escritor.write(pregunta.toFileString() + "\n");
                }
            }
        }

    }

    public void close() throws IOException {
        escritor.close();
    }

}
