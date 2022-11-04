package archivos;
import java.io.*;
import modelo.*;

/**
 * Esta clase consiste en el escritor de archivos de texto
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740,
 * Jeaustin Castro López C21912
 */
public class EscritorArchivos {

    //Atributos
    private BufferedWriter escritor;

    /**
     * Abre un flujo de datos para el archivo enviado por el parámetro
     *
     * @param fileName ruta del archivo cuyo flujo de datos ha de ser abierto
     * @throws java.io.IOException
     */
    public void open(String fileName) throws IOException {
        escritor = new BufferedWriter(new FileWriter(fileName));
    }

    /**
     * Escribe los datos de un arreglo de preguntas en el archivo del flujo de
     * datos
     *
     * @param lista Arreglo de preguntas que ha de ser escrito en el archivo
     * @throws java.io.IOException
     */
    public void escribir(Pregunta[] lista) throws IOException {
        if (lista != null) {
            for (Pregunta pregunta : lista) {
                if (pregunta != null) {
                    escritor.write(pregunta.toFileString() + "\n");
                }
            }
        }

    }

    /**
     * Cierra el flujo de datos que esté abierto para el buffer
     *
     * @throws java.io.IOException
     */
    public void close() throws IOException {
        escritor.close();
    }

}
