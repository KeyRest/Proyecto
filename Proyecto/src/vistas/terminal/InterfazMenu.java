package vistas.terminal;

import estructuras.ListaPreguntas;
import modelo.Pregunta;

/**
 *
 * @author Keiron Garro Matamoros C23212
 */
public class InterfazMenu {

    private int opcion;
    private int opcion2;
    private String pregunta = "";
    private String categoria;
    private boolean minMax = false;
    private boolean preguntaTrueOrFalse;
    private String resp1 = "";
    private String resp2 = "";
    private String resp3 = "";
    private String resp4 = "";
    private int opcionCorrecta = 0;
    private boolean opcionValida = false;
    private boolean valorResp1 = false;
    private boolean valorResp2 = false;
    private boolean valorResp3 = false;
    private boolean valorResp4 = false;

    private boolean validarLength(String texto, int min, int max) {
        boolean minMax;
        if (texto.length() < min || texto.length() > max) {
            minMax = true;
        } else {
            minMax = false;
        }

        return minMax;
    }

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
        minMax = false;
        switch (opcion) {
            case 1:
                while (minMax == false) {
                    escritor.escribir("Ingrese el texto de la pregunta");
                    pregunta = lector.leerString();
                    minMax = validarLength(pregunta, 4, 50);
                    if (minMax == false) {
                        escritor.escribir("La pregunta deber de ser mayor "
                                + " de 4 caracteres y menor que 50 caracteres");
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
                    case 1: //Pregunta verdadero o falso
                        escritor.escribir("La pregunta es: \n"
                                + "1-Falsa/ \n"
                                + "2-Verdadera");
                        opcion = lector.leerEntero();
                        switch (opcion) {
                            case 1:
                                preguntaTrueOrFalse = false;
                                break;
                            case 2:
                                preguntaTrueOrFalse = true;
                                break;
                            default:
                                throw new AssertionError();
                        }
                        lista.insertarPregunta(pregunta, categoria, preguntaTrueOrFalse);
                        break;
                    case 2: //Pregunta Seleccion Unica
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 1");
                            resp1 = lector.leerString();
                            minMax = validarLength(resp1, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }
                        minMax = false;
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 2");
                            resp2 = lector.leerString();
                            minMax = validarLength(resp2, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }

                        minMax = false;
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 3");
                            resp3 = lector.leerString();
                            minMax = validarLength(resp3, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }

                        minMax = false;
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 4");
                            resp4 = lector.leerString();
                            minMax = validarLength(resp4, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }
                        while (opcionCorrecta >= 1 && opcionCorrecta <= 4) {
                            escritor.escribir("Digite cual es la respuesta correcta | 1 ,2 ,3 o 4 |");
                            opcionCorrecta = lector.leerEntero();

                            if (opcionCorrecta < 1 && opcionCorrecta > 4) {
                                escritor.escribir("La respuesta correcta de ser 1 ,2 ,3 o 4");
                            }
                        }
                        lista.insertarPregunta(pregunta, categoria, resp1, resp2, resp3, resp4, opcionCorrecta);
                        break;
                    case 3: //Pregunta Seleccion Multiple
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 1");
                            resp1 = lector.leerString();
                            minMax = validarLength(resp1, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }
                        while (valorResp1 == false) {
                            escritor.escribir("La respuesta 1 es: \n"
                                    + "1-Falsa/ \n"
                                    + "2-Verdadera");
                            opcion = lector.leerEntero();
                            switch (opcion) {
                                case 1:
                                    valorResp1 = false;
                                    break;
                                case 2:
                                    valorResp1 = true;
                                    break;
                                default:
                                    escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                            }
                        }

                        minMax = false;
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 2");
                            resp2 = lector.leerString();
                            minMax = validarLength(resp2, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }

                        while (valorResp2 == false) {
                            escritor.escribir("La respuesta 2 es: \n"
                                    + "1-Falsa/ \n"
                                    + "2-Verdadera");
                            opcion = lector.leerEntero();
                            switch (opcion) {
                                case 1:
                                    valorResp2 = false;
                                    break;
                                case 2:
                                    valorResp2 = true;
                                    break;
                                default:
                                    escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                            }
                        }

                        minMax = false;
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 3");
                            resp3 = lector.leerString();
                            minMax = validarLength(resp3, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }

                        while (valorResp3 == false) {
                            escritor.escribir("La respuesta 3 es: \n"
                                    + "1-Falsa/ \n"
                                    + "2-Verdadera");
                            opcion = lector.leerEntero();
                            switch (opcion) {
                                case 1:
                                    valorResp3 = false;
                                    break;
                                case 2:
                                    valorResp3 = true;
                                    break;
                                default:
                                    escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                            }
                        }

                        minMax = false;
                        while (minMax == false) {
                            escritor.escribir("Digite la respuesta 4");
                            resp4 = lector.leerString();
                            minMax = validarLength(resp4, 1, 20);
                            if (minMax == false) {
                                escritor.escribir("La respuesta deber de ser mayor "
                                        + " que 1 caracter y menor que 20 caracteres");
                            }
                        }

                        while (valorResp4 == false) {
                            escritor.escribir("La respuesta 4 es: \n"
                                    + "1-Falsa/ \n"
                                    + "2-Verdadera");
                            opcion = lector.leerEntero();
                            switch (opcion) {
                                case 1:
                                    valorResp4 = false;
                                    break;
                                case 2:
                                    valorResp4 = true;
                                    break;
                                default:
                                    escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                            }
                        }
                        lista.insertarPregunta(pregunta, categoria, resp1, valorResp1, resp2, valorResp2, resp3, valorResp3, resp4, valorResp4);
                        break;
                    default:
                        escritor.escribir("Debe ingresar 1 , 2 o 3 segun corresponda");
                }
                break;

            case 2:
                while (opcionValida == false) {
                    escritor.escribir("Ingrese el tipo de preguntas a mostrar: \n"
                            + "1-Falso/Verdadero \n"
                            + "2-Selección Unica \n"
                            + "3-Selección Múltiple");
                    opcion = lector.leerEntero();
                    if (opcion >= 1 && opcion <= 3) {
                        opcionValida = true;
                    } else {
                        escritor.escribir("Solo puede ingresar 1 , 2 o 3");
                    }
                }
                for (int i = 0; i < lista.mostrarPregunta(opcion).length; i++) {
                    escritor.escribir(String.valueOf((i + 1) + ": " + lista.mostrarPregunta(opcion)[i]));
                }
                escritor.escribir("Seleccione la pregunta de la cual desea mas informacion");
                opcion2 = lector.leerEntero() - 1;
                lista.mostrarPregunta(opcion)[opcion2].toString();
                break;

            case 3:
                while (opcionValida == false) {
                    escritor.escribir("Ingrese el tipo de preguntas a actualizar: \n"
                            + "1-Falso/Verdadero \n"
                            + "2-Selección Unica \n"
                            + "3-Selección Múltiple");
                    if (opcion >= 1 && opcion <= 3) {
                        opcionValida = true;
                    } else {
                        escritor.escribir("Solo puede ingresar 1 , 2 o 3");
                    }
                }
                opcion = lector.leerEntero();
                for (int i = 0; i < lista.mostrarPregunta(opcion).length; i++) {
                    escritor.escribir(String.valueOf((i + 1) + ": " + lista.mostrarPregunta(opcion)[i]));
                }
                escritor.escribir("Seleccione la pregunta de la cual desea mas informacion");
                opcion2 = lector.leerEntero() - 1;
                lista.mostrarPregunta(opcion)[opcion2].toString();

                switch (opcion) {
                    case 1:
                        
                        break;
                    default:
                        throw new AssertionError();
                }

                break;
            case 4:

                break;
            default:
                throw new AssertionError();
        }

    }
}
