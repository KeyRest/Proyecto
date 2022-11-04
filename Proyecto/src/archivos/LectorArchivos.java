package archivos;
import modelo.Pregunta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import modelo.PreguntaSeleccionMultiple;
import modelo.PreguntaSeleccionUnica;
import modelo.PreguntaVerdaderoFalso;

/**
 * Esta clase consiste en el lector de archivos de texto
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740,
 * Jeaustin Castro López C21912
 */
public class LectorArchivos {

    private BufferedReader lector;

    /**
     * Abre un flujo de datos para el archivo enviado por el parámetro
     *
     * @param fileName ruta del archivo cuyo flujo de datos ha de ser abierto
     * @throws java.io.IOException
     */
    public void open(String fileName) throws IOException {
        lector = new BufferedReader(new FileReader(fileName));
    }

    /**
     * Lee una línea de un archivo de texto y la retorna como String
     *
     * @return line Retorna la línea que contiene la ruta
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public String readRuta() throws IOException, ClassNotFoundException {
        String line = lector.readLine();
        return line;
    }

    /**
     * Retorna la cantidad de líneas del archivo de texto cuyo flujo de datos
     * está abierto
     *
     * @return lineas La cantidad de líneas del archivo de texto
     * @throws java.io.IOException
     */
    public int contarLineas() throws IOException {

        int lineas = 0;

        String line = lector.readLine();

        while (line != null) {
            lineas++;
            line = lector.readLine();
        }

        return lineas;

    }

    /**
     * Crea una lista de preguntas del archivo del flujo de datos abierto
     *
     * @param tamano El tamaño específico con el que debe ser creada la lista
     * @return listaLeida La lista de preguntas que se leyó del archivo
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
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

    /**
     * Cierra el flujo de datos que esté abierto
     *
     * @throws java.io.IOException
     */
    public void close() throws IOException {
        lector.close();
    }

    /**
     * Abre un flujo de datos para el archivo enviado por el parámetro
     *
     * @return lector Retorna el buffered reader
     */
    public BufferedReader getLector() {
        return lector;
    }

}
