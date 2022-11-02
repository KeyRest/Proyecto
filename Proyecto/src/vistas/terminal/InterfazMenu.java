package vistas.terminal;

import estructuras.ListaPreguntas;

/**
 *
 * @author Keiron Garro Matamoros C23212
 */
public class InterfazMenu {

    private int opcion;
    private boolean minMax = false;
    private String pregunta;
    private String categoria;

    public void iniciarMenu(ListaPreguntas lista) {

        Escritor escritor = new Escritor();
        Lector lector = new Lector();

        escritor.escribir("Bienvenido al CRUD");
        escritor.escribir("Seleccione una opcion: \n"
                + "1-Insertar \n"
                + "2-Mostrar \n"
                + "3-Eliminar \n"
                + "4-Salir");
        opcion = lector.leerEntero();
        switch (opcion) {
            case 1:
                while (mixMax == false) {
                    escritor.escribir("Ingrese el texto de la pregunta");
                    pregunta = lector.leerString();
                    if (pregunta.length() < 4) {
                        escritor.escribir("La pregunta debe ser mayor a 4 caracteres");
                    }
                    if (pregunta.length() > 50) {
                        escritor.escribir("La pregunta debe ser menor a  caracteres");
                    } else {
                        minMax = true;
                    }
                }
                escritor.escribir("De que categoria es la pregunta?: \n"
                        + "1-Deporte \n"
                        + "2-Entretenimiento \n"
                        + "3-Historia");
                categoria = lector.leerString();

                escritor.escribir("De que tipo es la pregunta?: \n"
                        + "1-Falso/Verdadero \n"
                        + "2-Selección Unica \n"
                        + "3-Selección Múltiple");
                opcion = lector.leerEntero();
                switch (opcion) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        throw new AssertionError();
                }

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                throw new AssertionError();
        }

    }
}
