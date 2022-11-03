/**
 *
 * @author Keiron Garro  C23212
 */
package vistas.terminal;

import estructuras.ListaPreguntas;
import modelo.*;

public class InterfazMenu {

    Escritor escritor;
    Lector lector;
    private final ListaPreguntas lista;

    public InterfazMenu(ListaPreguntas lista) {
        this.lista = lista;
        this.escritor = new Escritor();
        this.lector = new Lector();
    }

    public boolean iniciarMenu() {
        int opcion;
        boolean activo = true;

        escritor.escribir("Bienvenido al CRUD");
        escritor.escribir("""
                              Seleccione una opcion: 
                              1-Insertar 
                              2-Mostrar 
                              3-Actualizar 
                              4-Eliminar 
                              5-Salir""");
        opcion = lector.leerEntero();

        switch (opcion) {
            case 1 -> //INSERTAR PREGUNTA
                insertarPregunta();
            case 2 -> //MOSTRAR PREGUNTA
                mostrarPregunta();
            case 3 -> //ACTUALIZAR PREGUNTA
                actualizarPregunta();
            case 4 ->
                eliminarPregunta();

            case 5 ->
                activo = false;
            default ->
                throw new AssertionError();
        }
        return activo;
    }

    private void insertarPregunta() {

        String pregunta = "";
        String categoria;

        String resp1;
        String resp2;
        String resp3;
        String resp4;

        boolean valorResp1;
        boolean valorResp2;
        boolean valorResp3;
        boolean valorResp4;

        boolean minMax = false;
        int opcion;
        int opcionCorrecta = 1;
        boolean preguntaTrueOrFalse;

        while (minMax == false) {
            escritor.escribir("Ingrese el texto de la pregunta");
            lector.leerString();
            pregunta = lector.leerString();
            minMax = validarLength(pregunta, 4, 50);
            if (minMax == false) {
                escritor.escribir("La pregunta deber de ser mayor "
                        + " de 4 caracteres y menor que 50 caracteres");
            }
        }

        escritor.escribir("""
                          De que categoria es la pregunta?: 
                          1-Deporte 
                          2-Entretenimiento 
                          3-Historia""");
        categoria = lector.leerString();

        escritor.escribir("""
                          De que tipo es la pregunta?: 
                          1-Falso/Verdadero 
                          2-Selecci\u00f3n Unica 
                          3-Selecci\u00f3n M\u00faltiple""");
        opcion = lector.leerEntero();

        switch (opcion) {
            case 1 -> {
                //Pregunta verdadero o falso
                escritor.escribir("""
                                  La pregunta es: 
                                  1-Falsa/ 
                                  2-Verdadera""");
                opcion = lector.leerEntero();
                switch (opcion) {
                    case 1 ->
                        preguntaTrueOrFalse = false;
                    case 2 ->
                        preguntaTrueOrFalse = true;
                    default ->
                        throw new AssertionError();
                }
                lista.insertarPregunta(pregunta, categoria, preguntaTrueOrFalse, lista.getContadorVF());
            }
            case 2 -> {
                //Pregunta Seleccion Unica
                lector.leerString();
                resp1 = IntroducirRespDeOpcionMultiple(1);
                resp2 = IntroducirRespDeOpcionMultiple(2);
                resp3 = IntroducirRespDeOpcionMultiple(3);
                resp4 = IntroducirRespDeOpcionMultiple(4);

                boolean opcionEntre1y4 = false;
                while (opcionEntre1y4 == false) {
                    escritor.escribir("Digite cual es la respuesta correcta | 1 ,2 ,3 o 4 |");
                    opcionCorrecta = lector.leerEntero();
                    if ((opcionCorrecta <= 0) || (opcionCorrecta >= 5)) {
                        escritor.escribir("Debe ingresar un numero entre 1 y 4");
                    } else {
                        opcionEntre1y4 = true;
                    }
                }

                lista.insertarPregunta(pregunta, categoria, resp1, resp2, resp3, resp4, opcionCorrecta, lista.getContadorSU());
            }

            case 3 -> {
                //Pregunta Seleccion Multiple
                
                lector.leerString();
                resp1 = IntroducirRespDeOpcionMultiple(1);
                valorResp1 = IntroducirValorRespDeOpcionMultiple(1);
                
                lector.leerString();
                resp2 = IntroducirRespDeOpcionMultiple(2);
                valorResp2 = IntroducirValorRespDeOpcionMultiple(2);
                
                lector.leerString();
                resp3 = IntroducirRespDeOpcionMultiple(3);
                valorResp3 = IntroducirValorRespDeOpcionMultiple(3);

                lector.leerString();
                resp4 = IntroducirRespDeOpcionMultiple(4);
                valorResp4 = IntroducirValorRespDeOpcionMultiple(4);

                lista.insertarPregunta(pregunta, categoria, resp1, valorResp1, resp2, valorResp2, resp3, valorResp3, resp4, valorResp4, lista.getContadorSM());
            }
            default ->
                escritor.escribir("Debe ingresar 1 , 2 o 3 segun corresponda");
        }
    }

    private void mostrarPregunta() {
        boolean entradaValida = false;
        int opcion = 0;
        int indicePreguntaSeleccionada;

        while (entradaValida == false) {
            escritor.escribir("""
                              Ingrese el tipo de preguntas a mostrar: 
                              1-Falso/Verdadero 
                              2-Selecci\u00f3n Unica 
                              3-Selecci\u00f3n M\u00faltiple""");
            opcion = lector.leerEntero();
            if ((opcion >= 1) && (opcion <= 3)) {
                entradaValida = true;
            } else {
                escritor.escribir("Solo puede ingresar 1 , 2 o 3");
            }
        }

        Pregunta tempArray[] = lista.mostrarPregunta(opcion);

        int max = tempArray.length;

        
        for (int i = 0; i < max; i++) {
            if(tempArray[i]!= null){
                escritor.escribir(String.valueOf((i + 1) + ": " + tempArray[i].getTexto()));
            }
        }
        
        escritor.escribir("Seleccione la pregunta de la cual desea mas informacion");
        
        indicePreguntaSeleccionada = lector.leerEntero() - 1;
        
        try{
            escritor.escribir(lista.mostrarPregunta(opcion)[indicePreguntaSeleccionada].toString());
        } catch(ArrayIndexOutOfBoundsException exception){
            escritor.escribir("No se encontro la pregunta");
        }
        
        
        escritor.escribir("\nPresione cualquier tecla para continuar");
        lector.leerString();
        lector.leerString();
        
    }

    private void actualizarPregunta() {

        String pregunta = "";
        String categoria;

        String resp1 = "";
        String resp2 = "";
        String resp3 = "";
        String resp4 = "";

        boolean valorResp1 = false;
        boolean valorResp2 = false;
        boolean valorResp3 = false;
        boolean valorResp4 = false;

        boolean minMax = false;
        int opcion = 0;
        int opcion2;
        int opcionCorrecta = 1;
        boolean preguntaTrueOrFalse;

        boolean opcionValida = false;
        while (opcionValida == false) {
            escritor.escribir("""
                              Ingrese el tipo de preguntas a actualizar: 
                              1-Falso/Verdadero 
                              2-Selecci\u00f3n Unica 
                              3-Selecci\u00f3n M\u00faltiple""");
            opcion = lector.leerEntero();
            if (opcion >= 1 && opcion <= 3) {
                opcionValida = true;
            } else {
                escritor.escribir("Solo puede ingresar 1 , 2 o 3");
            }
        }

        for (int i = 0; i < lista.mostrarPregunta(opcion).length; i++) {
            escritor.escribir(String.valueOf((i + 1) + ": " + lista.mostrarPregunta(opcion)[i]) + "\n");
        }
        escritor.escribir("Seleccione la pregunta a actualizar");
        opcion2 = lector.leerEntero() - 1;
        
        /*
        System.out.println("EL tamano de mostrar es " + lista.mostrarPregunta(opcion).length);
        System.out.println("El indice a usar es" + opcion2);
        */
        

        lista.mostrarPregunta(opcion)[opcion2].toString();

        while (minMax == false) {
            escritor.escribir("Ingrese el nuevo texto de la pregunta");
            lector.leerString();
            pregunta = lector.leerString();
            minMax = validarLength(pregunta, 4, 50);
            if (minMax == false) {
                escritor.escribir("La pregunta deber de ser mayor "
                        + " de 4 caracteres y menor que 50 caracteres");
            }
        }
        escritor.escribir("""
                          Ingrese la categoria nueva de la pregunta: 
                          1-Deporte 
                          2-Entretenimiento 
                          3-Historia""");
        categoria = lector.leerString();

        switch (opcion) {
            case 1 -> {
                //Pregunta verdadero o falso
                escritor.escribir("""
                                  La pregunta es: 
                                  1-Falsa/ 
                                  2-Verdadera""");
                int opcionTrueFalse = lector.leerEntero();
                switch (opcion) {
                    case 1 ->
                        preguntaTrueOrFalse = false;
                    case 2 ->
                        preguntaTrueOrFalse = true;
                    default ->
                        throw new AssertionError();
                }
                lista.actualizarPregunta(
                        lista.mostrarPregunta(opcion)[opcion2].getId(), pregunta, categoria, preguntaTrueOrFalse);
            }

            case 2 -> {
                //Pregunta seleccion unica
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 1");
                    resp1 = lector.leerString();
                    minMax = validarLength(resp1, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }
                minMax = false;
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 2");
                    resp2 = lector.leerString();
                    minMax = validarLength(resp2, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }

                minMax = false;
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 3");
                    resp3 = lector.leerString();
                    minMax = validarLength(resp3, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }

                minMax = false;
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 4");
                    resp4 = lector.leerString();
                    minMax = validarLength(resp4, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }
                while (opcionCorrecta >= 1 && opcionCorrecta <= 4) {
                    escritor.escribir("Digite cual es la nueva respuesta correcta | 1 ,2 ,3 o 4 |");
                    opcionCorrecta = lector.leerEntero();

                    if (opcionCorrecta < 1 && opcionCorrecta > 4) {
                        escritor.escribir("La respuesta correcta de ser 1 ,2 ,3 o 4");
                    }
                }
                lista.actualizarPregunta(lista.mostrarPregunta(opcion)[opcion2].getId(), pregunta, categoria, resp1, resp2, resp3, resp4, opcionCorrecta);
            }
            case 3 -> {
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 1");
                    resp1 = lector.leerString();
                    minMax = validarLength(resp1, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }
                while (valorResp1 == false) {
                    escritor.escribir("""
                                      La nueva respuesta 1 es: 
                                      1-Falsa/ 
                                      2-Verdadera""");
                    opcion = lector.leerEntero();
                    switch (opcion) {
                        case 1 ->
                            valorResp1 = false;
                        case 2 ->
                            valorResp1 = true;
                        default ->
                            escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                    }
                }

                minMax = false;
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 2");
                    resp2 = lector.leerString();
                    minMax = validarLength(resp2, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }

                while (valorResp2 == false) {
                    escritor.escribir("""
                                      La respuesta 2 nueva es: 
                                      1-Falsa/ 
                                      2-Verdadera""");
                    opcion = lector.leerEntero();
                    switch (opcion) {
                        case 1 ->
                            valorResp2 = false;
                        case 2 ->
                            valorResp2 = true;
                        default ->
                            escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                    }
                }

                minMax = false;
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 3");
                    resp3 = lector.leerString();
                    minMax = validarLength(resp3, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }

                while (valorResp3 == false) {
                    escritor.escribir("""
                                      La nueva respuesta 3 es: 
                                      1-Falsa/ 
                                      2-Verdadera""");
                    opcion = lector.leerEntero();
                    switch (opcion) {
                        case 1 ->
                            valorResp3 = false;
                        case 2 ->
                            valorResp3 = true;
                        default ->
                            escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                    }
                }

                minMax = false;
                while (minMax == false) {
                    escritor.escribir("Digite la nueva respuesta 4");
                    resp4 = lector.leerString();
                    minMax = validarLength(resp4, 1, 20);
                    if (minMax == false) {
                        escritor.escribir("La respuesta deber de ser mayor "
                                + " que 1 caracter y menor que 20 caracteres");
                    }
                }

                while (valorResp4 == false) {
                    escritor.escribir("""
                                      La nueva respuesta 4 es: 
                                      1-Falsa/ 
                                      2-Verdadera""");
                    opcion = lector.leerEntero();
                    switch (opcion) {
                        case 1 ->
                            valorResp4 = false;
                        case 2 ->
                            valorResp4 = true;
                        default ->
                            escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
                    }
                }
                lista.actualizarPregunta(lista.mostrarPregunta(opcion)[opcion2].getId(), pregunta, categoria, resp1, valorResp1, resp2, valorResp2, resp3, valorResp3, resp4, valorResp4);
            }
            default ->
                System.out.println("Ingrese un valor correcto");

        }
    }

    private void eliminarPregunta() {

        int opcion = 1;
        int opcion2;

        boolean opcionValida = false;
        while (opcionValida == false) {
            escritor.escribir("""
                              Ingrese el tipo de preguntas a eliminar: 
                              1-Falso/Verdadero 
                              2-Selecci\u00f3n Unica 
                              3-Selecci\u00f3n M\u00faltiple""");
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
        escritor.escribir("Seleccione la pregunta a eliminar");
        opcion2 = lector.leerEntero() - 1;
        lista.eliminarPregunta(opcion, lista.mostrarPregunta(opcion)[opcion2].getId());
    }

    private boolean IntroducirValorRespDeOpcionMultiple(int numeroRespuesta) {
        boolean respuesta = false;
        boolean respValida = false;

        while (respValida == false) {
            escritor.escribir("La respuesta " + numeroRespuesta + " es: \n"
                    + "1-Falsa/ \n"
                    + "2-Verdadera");
            int opcion = lector.leerEntero();

            switch (opcion) {
                case 1 -> {
                    respuesta = false;
                    respValida = true;
                }
                case 2 -> {
                    respuesta = true;
                    respValida = true;
                }
                default ->
                    escritor.escribir("Debe ingresar 1 o 2 segun corresponda");
            }
        }

        return respuesta;
    }

    private String IntroducirRespDeOpcionMultiple(int numeroRespuesta) {
        String textoRespuesta = "";
        boolean minMax = false;

        while (minMax == false) {
            escritor.escribir("Digite el texto de la respuesta " + numeroRespuesta);
            textoRespuesta = lector.leerString();

            minMax = validarLength(textoRespuesta, 1, 20);
            if (minMax == false) {
                escritor.escribir("La respuesta deber de ser mayor "
                        + " que 1 caracter y menor que 20 caracteres");
            }
        }

        return textoRespuesta;
    }

    private boolean validarLength(String texto, int min, int max) {
        boolean minMax = true;

        if (texto.length() < min) {
            minMax = false;
        } else if (texto.length() > max) {
            minMax = false;
        }

        return minMax;
    }

}
