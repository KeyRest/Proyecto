package modelo;

/**
 * Esta clase consiste en el objeto PreguntaSeleccionMultiple
 * Estas preguntas tienen cuatro opciones dentro de las cuales se pueden escoger varias combinaciones de ellas
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */
public class PreguntaSeleccionMultiple extends PreguntaCuatroOpciones {

    private boolean valorRespuesta1;
    private boolean valorRespuesta2;
    private boolean valorRespuesta3;
    private boolean valorRespuesta4;
    private int contador;

    /**
     * Construye una pregunta de selección múltiple
     *
     */
    public PreguntaSeleccionMultiple(){
        
    }
    
    /**
     * Construye una pregunta de selección múltiple
     *
     * 
     * @param textoPregunta El texto de la pregunta
     * @param categoria La categoría de la pregunta
     * @param respuesta1 La respuesta 1 de la pregunta
     * @param valorRespuesta1 El valro de la respuesta 1 de la pregunta
     * @param respuesta2 La respuesta 2 de la pregunta
     * @param valorRespuesta2 El valor de la respuesta 2 de la pregunta
     * @param respuesta3 La respuesta 3 de la pregunta
     * @param valorRespuesta3 El valor de la respuesta 3 de la pregunta
     * @param respuesta4 La respuesta 4 de la pregunta
     * @param valorRespuesta4 El valor de la respuesta 4 de la pregunta
     * @param contador El contador  de la pregunta
     */
    public PreguntaSeleccionMultiple(String textoPregunta, String categoria, String respuesta1, boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2, String respuesta3, boolean valorRespuesta3, String respuesta4, boolean valorRespuesta4,int contador) {
        super("SM", textoPregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4);
        this.valorRespuesta1 = valorRespuesta1;
        this.valorRespuesta2 = valorRespuesta2;
        this.valorRespuesta3 = valorRespuesta3;
        this.valorRespuesta4 = valorRespuesta4;
        this.id = contador+1;      
    }

    /**
     * Retorna el valor de la respuesta 1
     *
     * @return El valor de la respuesta 1
     */
    public boolean getValorRespuesta1() {
        return valorRespuesta1;
    }

    /**
     * Asigna el valor de la respuesta 1 de la pregunta
     *
     * @param valorRespuesta1 El valor a asignar
     */
    public void setValorRespuesta1(boolean valorRespuesta1) {
        this.valorRespuesta1 = valorRespuesta1;
    }

    /**
     * Retorna el valor de la respuesta 2
     *
     * @return El valor de la respuesta 2
     */
    public boolean getValorRespuesta2() {
        return valorRespuesta2;
    }

    /**
     * Asigna el valor de la respuesta 2 de la pregunta
     *
     * @param valorRespuesta2 El valor a asignar
     */
    public void setValorRespuesta2(boolean valorRespuesta2) {
        this.valorRespuesta2 = valorRespuesta2;
    }

    /**
     * Retorna el valor de la respuesta 3
     *
     * @return El valor de la respuesta 3
     */
    public boolean getValorRespuesta3() {
        return valorRespuesta3;
    }

    /**
     * Asigna el valor de la respuesta 3 de la pregunta
     *
     * @param valorRespuesta3 El valor a asignar
     */
    public void setValorRespuesta3(boolean valorRespuesta3) {
        this.valorRespuesta3 = valorRespuesta3;
    }

    /**
     * Retorna el valor de la respuesta 4
     *
     * @return El valor de la respuesta 4
     */
    public boolean getValorRespuesta4() {
        return valorRespuesta4;
    }

    /**
     * Asigna el valor de la respuesta 4 de la pregunta
     *
     * @param valorRespuesta4 El valor a asignar
     */
    public void setValorRespuesta4(boolean valorRespuesta4) {
        this.valorRespuesta4 = valorRespuesta4;
    }

    /**
     * Retorna el contador de la pregunta
     *
     * @return El contador de la pregunta
     */
    public int getContador() {
        return contador;
    }
    
    /**
     * Método que convierte los datos de la pregunta en una hilera de texto
     * para ser leída y escrita en archivos de texto
     *
     * @return La hilera de texto con los datos de la pregunta
     */
    @Override
    public String toFileString() {
        return tipo + "-" + id + "-" + textoPregunta + "-" + categoria + "-" + respuesta1 + "-" + valorRespuesta1 + "-" + respuesta2 + "-" + valorRespuesta2 + "-" + respuesta3 + "-" + valorRespuesta3 + "-" + respuesta4 + "-" + valorRespuesta4;
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @return True o False, dependiendo si fue respuesta correcta
     */
    @Override
    public boolean evaluarRespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @param opcionUsuario La opcion del usuario
     * @return True o False, dependiendo si fue respuesta correcta
     */
    public boolean evaluarRespuesta(int opcionUsuario) {
        boolean valido = false;

        switch (opcionUsuario) {
            case 1:
                if (valorRespuesta1) {
                    valido = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido = true;
                }
                break;
        }
        return valido;
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @param opcionUsuario1 La opcion1
     * @param opcionUsuario2 La opcion2
     * @return True o False, dependiendo si fue respuesta correcta
     */
    public boolean evaluarRespuesta(int opcionUsuario1, int opcionUsuario2) {
        boolean valido1 = false;
        boolean valido2 = false;
        boolean validoFinal = false;

        switch (opcionUsuario1) {
            case 1:
                if (valorRespuesta1) {
                    valido1 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido1 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido1 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido1 = true;
                }
                break;
        }

        switch (opcionUsuario2) {
            case 1:
                if (valorRespuesta1) {
                    valido2 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido2 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido2 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido2 = true;
                }
                break;
        }
        if (valido1 && valido2) {
            validoFinal = true;
        }

        return validoFinal;
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @param opcionUsuario1 La opcion1
     * @param opcionUsuario2 La opcion2
     * @param opcionUsuario3 La opcion3
     * @return True o False, dependiendo si fue respuesta correcta
     */
    public boolean evaluarRespuesta(int opcionUsuario1, int opcionUsuario2, int opcionUsuario3) {
        boolean valido1 = false;
        boolean valido2 = false;
        boolean valido3 = false;
        boolean validoFinal = false;

        switch (opcionUsuario1) {
            case 1:
                if (valorRespuesta1) {
                    valido1 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido1 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido1 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido1 = true;
                }
                break;
        }

        switch (opcionUsuario2) {
            case 1:
                if (valorRespuesta1) {
                    valido2 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido2 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido2 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido2 = true;
                }
                break;
        }
        switch (opcionUsuario3) {
            case 1:
                if (valorRespuesta1) {
                    valido3 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido3 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido3 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido3 = true;
                }
                break;
        }
        if (valido1 && valido2 && valido3) {
            validoFinal = true;
        }

        return validoFinal;
    }

    /**
     * Método que evalúa si la respuesta es correcta
     *
     * @param opcionUsuario1 La opcion1
     * @param opcionUsuario2 La opcion2
     * @param opcionUsuario3 La opcion3
     * @param opcionUsuario4 La opcion4
     * @return True o False, dependiendo si fue respuesta correcta
     */
    public boolean evaluarRespuesta(int opcionUsuario1, int opcionUsuario2, int opcionUsuario3, int opcionUsuario4) {
        boolean valido1 = false;
        boolean valido2 = false;
        boolean valido3 = false;
        boolean valido4 = false;
        boolean validoFinal = false;

        switch (opcionUsuario1) {
            case 1:
                if (valorRespuesta1) {
                    valido1 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido1 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido1 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido1 = true;
                }
                break;
        }

        switch (opcionUsuario2) {
            case 1:
                if (valorRespuesta1) {
                    valido2 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido2 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido2 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido2 = true;
                }
                break;
        }
        switch (opcionUsuario3) {
            case 1:
                if (valorRespuesta1) {
                    valido3 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido3 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido3 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido3 = true;
                }
                break;
        }
        switch (opcionUsuario4) {
            case 1:
                if (valorRespuesta1) {
                    valido4 = true;
                }
                break;
            case 2:
                if (valorRespuesta2) {
                    valido4 = true;
                }
                break;
            case 3:
                if (valorRespuesta3) {
                    valido4 = true;
                }
                break;
            case 4:
                if (valorRespuesta4) {
                    valido4 = true;
                }
                break;
        }
        if (valido1 && valido2 && valido3 && valido4) {
            validoFinal = true;
        }

        return validoFinal;
    }
    
    /**
     * Método que imprime datos cuando se imprime el objeto
     *
     * @return Un cuerpo de texto con los datos de la pregunta
     */
    @Override
    public String toString() {
        String categoriaEnTexto = "";
        
        switch(this.categoria){
            case "1" -> categoriaEnTexto = "Deporte";
            case "2" -> categoriaEnTexto = "Entrenamiento";
            case "3" -> categoriaEnTexto = "Historia";
        }
        
        return "TEXTO PREGUNTA = " + this.textoPregunta + "\nCATEGORÍA = " + categoriaEnTexto + "\n"
                + "OPCION 1 = " + this.respuesta1 + ", " + this.valorRespuesta1 +
                "\nOPCION 2 = " + this.respuesta2 + ", " + this.valorRespuesta2 +
                "\nOPCION 3 = " + this.respuesta3 + ", " + this.valorRespuesta3 +
                "\nOPCION 4 = " + this.respuesta4 + ", " + this.valorRespuesta4;
    }

}
