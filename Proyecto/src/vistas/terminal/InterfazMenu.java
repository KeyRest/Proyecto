package vistas.terminal;

/**
 *
 * @author Keiron Garro Matamoros C23212
 */
public class InterfazMenu {

    private int opcion;

    public void iniciarMenu() {

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
