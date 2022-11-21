package controlador;

import archivos.EscritorArchivos;
import archivos.LectorArchivos;
import estructuras.ListaPreguntas;
import java.io.IOException;
import vistas.InterfazMenu;

/**
 * Esta clase consiste en el controlador del programa, que contiene el main
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740,
 * Jeaustin Castro López C21912
 */
public class Controlador {

    /**
     * Método main
     *
     * @param args argumento del main
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static int contadorVF = 0;
    public static int contadorSU = 0;
    public static int contadorSM = 0;
    public static int contador = 0;

    public static ListaPreguntas lista;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        EscritorArchivos escritor = new EscritorArchivos();
        LectorArchivos lector = new LectorArchivos();

        lector.open("file.txt");
        String rutaAbsoluta = lector.readRuta();
        lector.close();

        lector.open(rutaAbsoluta);
        int cantidadLineas = lector.contarLineas();
        lector.close();

        //System.out.println(cantidadLineas);
        boolean activo = true;
        while (activo) {
            contadorVF = 0;
            contadorSU = 0;
            contadorSM = 0;
            contador = 0;
            if (cantidadLineas < 1) { //SI EL ARCHIVO ESTA VACIO

                lista.agregar(null);

                /*
                lector.open(rutaAbsoluta);
                lista.setLista(lector.readListaPreguntas(contador));
                lector.close();
                 */
            } else { //SI EL ARCHIVO TIENE LINEAS
                lector.open(rutaAbsoluta);
                String line = lector.getLector().readLine();

                while (line != null) {

                    String datos[];
                    datos = line.split("-");

                    switch (datos[0]) {
                        case "VF" ->
                            contadorVF = Integer.parseInt(datos[1]);
                        case "SM" ->
                            contadorSM = Integer.parseInt(datos[1]);
                        case "SU" ->
                            contadorSU = Integer.parseInt(datos[1]);
                    }

                    line = lector.getLector().readLine();
                    contador++;
                }
                lector.close();
                lista = new ListaPreguntas(contadorSU, contadorSM, contadorVF);

                lector.open(rutaAbsoluta);
                lista.setLista(lector.readListaPreguntas(contador));
                lector.close();
            }

            InterfazMenu interfaz = new InterfazMenu();
            ControladorMenu controlador = new ControladorMenu(interfaz, lista);

            escritor.open(rutaAbsoluta);
            escritor.escribir(lista.getLista());
            escritor.close();

            activo = false;

        }

    }

}
