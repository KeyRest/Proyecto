package controlador;

import archivos.EscritorArchivos;
import archivos.LectorArchivos;
import estructuras.ListaPreguntas;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import modelo.Pregunta;
import vistas.terminal.InterfazMenu;

/**
 * VERSION 1.0
 *
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 */
public class Controlador {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        EscritorArchivos escritor = new EscritorArchivos();
        LectorArchivos lector = new LectorArchivos();
        InterfazMenu interfaz = new InterfazMenu();

        String rutaAbsoluta;

        lector.open("file.txt");
        rutaAbsoluta = lector.readRuta();
        lector.close();

        escritor.open(rutaAbsoluta);
        escritor.close();

        int contadorVF = 0;
        int contadorSU = 0;
        int contadorSM = 0;
        int contador = 0;
        boolean activo = true;

        File f = new File(rutaAbsoluta);

        while (activo) {
            if (f.length() < 1) {
                contadorSM = 0;
                contadorSU = 0;
                contadorVF = 0;
            } else {
                contador = 0;
                while (lector.getLector().readLine() != null) {
                    contador++;
                }
                String datos[];
                for (int i = 0; i <= contador; i++) {

                    String line = lector.getLector().readLine();
                    if (line != null) {
                        datos = line.split("-");
                        if ("VF".equals(datos[0])) {
                            contadorVF++;
                        } else if ("SM".equals(datos[0])) {
                            contadorSM++;
                        } else if ("SU".equals(datos[0])) {
                            contadorSU++;
                        }
                    }
                }
            }

            ListaPreguntas lista = new ListaPreguntas(contadorSU, contadorSM, contadorVF);
            for (int i = 0; i < contador; i++) {
                lista.agregar(lector.readPregunta());
            }
            interfaz.iniciarMenu(lista, contadorVF, contadorSU, contadorSM);
            activo = false;
        }
    }
}
