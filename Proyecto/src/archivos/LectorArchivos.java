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

    public int contarLineas() throws IOException {

        int lineas = 0;

        String line = lector.readLine();

        while (line != null) {
            lineas++;
            line = lector.readLine();
        }

        return lineas;

    }

    public Pregunta[] readListaPreguntas(int tamano) throws IOException, ClassNotFoundException {

        Pregunta[] listaLeida = new Pregunta[1];

        if (tamano > 0) {
            listaLeida = new Pregunta[tamano];
            int indiceLista = 0;

            try {
                String line = lector.readLine();
                while (line != null) {
                    Pregunta pregunta = null;
                    String datos[];
                    datos = line.split("-");
                    if (!"null".equals(line)) {
                        switch (datos[0]) {
                            case "VF" -> {
                                pregunta = new PreguntaVerdaderoFalso(datos[2], datos[3], Boolean.parseBoolean(datos[4]), Integer.parseInt(datos[1]) - 1);
                                listaLeida[indiceLista] = pregunta;
                                indiceLista++;
                            }
                            case "SU" -> {
                                pregunta = new PreguntaSeleccionUnica(datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], Integer.parseInt(datos[8]), Integer.parseInt(datos[1]) - 1);
                                listaLeida[indiceLista] = pregunta;
                                indiceLista++;
                            }
                            case "SM" -> {
                                pregunta = new PreguntaSeleccionMultiple(datos[2], datos[3], datos[4], Boolean.parseBoolean(datos[5]), datos[6], Boolean.parseBoolean(datos[7]), datos[8], Boolean.parseBoolean(datos[9]), datos[10], Boolean.parseBoolean(datos[11]), Integer.parseInt(datos[1]) - 1);
                                listaLeida[indiceLista] = pregunta;
                                indiceLista++;
                            }
                        }
                    } else {
                        listaLeida[indiceLista] = pregunta;
                        indiceLista++;
                    }

                    // LEER SIGUIENTE LÍNEA
                    line = lector.readLine();
                }
                //lector.close();
            } catch (IOException e) {
                System.out.println("Error");
            }

            /*
        if (listaLeida[0] != null) {
            System.out.println(listaLeida[0].toFileString());
        } else {
            System.out.println("es null");
        }
             */
        }

        return listaLeida;
    }

    public void close() throws IOException {
        lector.close();
    }

    public BufferedReader getLector() {
        return lector;
    }

}
