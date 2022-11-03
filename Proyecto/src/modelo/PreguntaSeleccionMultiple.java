package modelo;

/**
 * @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin
 * Castro López C21912
 * @version 1/11/2022
 */
public class PreguntaSeleccionMultiple extends PreguntaCuatroOpciones {

    private boolean valorRespuesta1;
    private boolean valorRespuesta2;
    private boolean valorRespuesta3;
    private boolean valorRespuesta4;
    public int contador;

    public PreguntaSeleccionMultiple(String textoPregunta, String categoria, String respuesta1, boolean valorRespuesta1, String respuesta2, boolean valorRespuesta2, String respuesta3, boolean valorRespuesta3, String respuesta4, boolean valorRespuesta4,int contador) {
        super("SM", textoPregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4);
        this.valorRespuesta1 = valorRespuesta1;
        this.valorRespuesta2 = valorRespuesta2;
        this.valorRespuesta3 = valorRespuesta3;
        this.valorRespuesta4 = valorRespuesta4;
        this.id = contador+1;      
    }

    public boolean getValorRespuesta1() {
        return valorRespuesta1;
    }

    public void setValorRespuesta1(boolean valorRespuesta1) {
        this.valorRespuesta1 = valorRespuesta1;
    }

    public boolean getValorRespuesta2() {
        return valorRespuesta2;
    }

    public void setValorRespuesta2(boolean valorRespuesta2) {
        this.valorRespuesta2 = valorRespuesta2;
    }

    public boolean getValorRespuesta3() {
        return valorRespuesta3;
    }

    public void setValorRespuesta3(boolean valorRespuesta3) {
        this.valorRespuesta3 = valorRespuesta3;
    }

    public boolean getValorRespuesta4() {
        return valorRespuesta4;
    }

    public void setValorRespuesta4(boolean valorRespuesta4) {
        this.valorRespuesta4 = valorRespuesta4;
    }

    public int getContador() {
        return contador;
    }
    
    

    @Override
    public String toFileString() {
        return tipo + "-" + id + "-" + textoPregunta + "-" + categoria + "-" + respuesta1 + "-" + valorRespuesta1 + "-" + respuesta2 + "-" + valorRespuesta2 + respuesta3 + "-" + valorRespuesta3 + "-" + respuesta4 + "-" + valorRespuesta4;
    }

    @Override
    public boolean evaluarRespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

}
