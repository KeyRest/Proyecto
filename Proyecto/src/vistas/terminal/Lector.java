/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas.terminal;

/**
 *
 * @author maris
 */
import java.util.Scanner;

public class Lector {

  public Scanner leer;

  public Lector() {
    this.leer = new Scanner(System.in);
  }

  public int leerEntero() {
    return leer.nextInt();
  }

  public double leerDouble() {
    return leer.nextDouble();
  }

  public String leerString() {
    return leer.nextLine();
  }

  public boolean leerBoolean() {
    return leer.nextBoolean();
  }

}
