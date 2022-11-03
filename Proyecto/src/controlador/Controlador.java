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
        int contadorVF = 0;
        int contadorSU = 0;
        int contadorSM = 0;
        int contador = 0;
        
        lector.open("file.txt");
        String rutaAbsoluta = lector.readRuta();
        lector.close();
        
        lector.open(rutaAbsoluta);
        int cantidadLineas = lector.contarLineas();
        lector.close();
        
        //System.out.println(cantidadLineas);
        
        
        boolean activo = true;
        while (activo) {
            if (cantidadLineas < 1) { //SI EL ARCHIVO ESTA VACIO
                contadorSM = 0;
                contadorSU = 0;
                contadorVF = 0;
            } else { //SI EL ARCHIVO TIENE LINEAS
                lector.open(rutaAbsoluta);
                String line = lector.getLector().readLine();
                
                while (line != null) {
                    
                    String datos[];
                    datos = line.split("-");
                    
                    switch(datos[0]){
                        case "VF" -> contadorVF++;
                        case "SM" -> contadorSM++;
                        case "SU" -> contadorSU++;
                    }
                    
                    line = lector.getLector().readLine();
                    contador++;
                }
                
                lector.close();
            }

            ListaPreguntas lista = new ListaPreguntas(contadorSU, contadorSM, contadorVF);

            lector.open(rutaAbsoluta);
            
            lista.setLista(lector.readListaPreguntas(contador));
            
            lector.close();

            InterfazMenu interfaz = new InterfazMenu(lista, contadorVF, contadorSU, contadorSM);

            interfaz.iniciarMenu();

            escritor.open(rutaAbsoluta);
            escritor.escribir(lista.getLista());
            escritor.close();

            activo = false;
        }
        
    }
}
