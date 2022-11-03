/**
 *
 * @author Usuario
 */
package archivos;

import estructuras.ListaPreguntas;
import modelo.Pregunta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import modelo.PreguntaCuatroOpciones;
import modelo.PreguntaSeleccionMultiple;
import modelo.PreguntaSeleccionUnica;
import modelo.PreguntaVerdaderoFalso;

public class LectorArchivos {

    private BufferedReader lector;

    public void open(String fileName) throws IOException {
        lector = new BufferedReader(new FileReader(fileName));
    }

    public String readRuta() throws IOException, ClassNotFoundException {
        String line = lector.readLine();
        return line;
    }

    public Pregunta readPregunta() throws IOException {
        Pregunta pregunta = null;
        String line = lector.readLine();
        String datos[];
        if (line != null) {
            datos = line.split("-");

            switch (datos[0]) {
                case "VF":
                    pregunta = new PreguntaVerdaderoFalso(datos[2], datos[3], Boolean.parseBoolean(datos[4]), Integer.parseInt(datos[1]) - 1);
                    break;
                case "SU":
                    pregunta = new PreguntaSeleccionUnica(datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], Integer.parseInt(datos[8]), Integer.parseInt(datos[1]) - 1);
                    break;
                case "SM":
                    pregunta = new PreguntaSeleccionMultiple(datos[2], datos[3], datos[4], Boolean.parseBoolean(datos[5]), datos[6], Boolean.parseBoolean(datos[7]), datos[8], Boolean.parseBoolean(datos[9]), datos[10], Boolean.parseBoolean(datos[11]), Integer.parseInt(datos[1]) - 1);
                    break;
            }
        }
        return pregunta;
    }

    public void close() throws IOException {
        lector.close();
    }

    public BufferedReader getLector() {
        return lector;
    }

}
