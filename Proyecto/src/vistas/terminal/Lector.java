
package vistas.terminal;
import java.util.Scanner;

/**
 * Esta clase consiste en el lector de la consola
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740, Jeaustin Castro López C21912
 */
public class Lector {
    private Scanner leer;

    /** Construye el lector
     *
     */
    public Lector() {
    this.leer = new Scanner(System.in);
  }

    /** Lee un entero
     *
     * @return Retorna el entero leído
     */
    public int leerEntero() {
    return leer.nextInt();
  }

    /** Lee un double
     *
     * @return Retorna el double leído
     */
    public double leerDouble() {
    return leer.nextDouble();
  }

    /** Lee una cadena de texto
     *
     * @return Retorna la cadena de texto leída
     */
    public String leerString() {
    return leer.nextLine();
  }

    /** Lee un boolean
     *
     * @return Retorna el boolean leído
     */
    public boolean leerBoolean() {
    return leer.nextBoolean();
  }

}
