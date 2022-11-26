/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Insertar;

import controlador.Controlador;
import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.InterfazActualizarSeleccionUnica;
import vistas.InterfazInsertarSeleccionUnica;

public class ControladorInsertarSeleccionUnica implements ActionListener {

    private InterfazInsertarSeleccionUnica vista;
    private final ListaPreguntas lista;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String pregunta;
    private String categoria;
    private int opcion;

    public ControladorInsertarSeleccionUnica(InterfazInsertarSeleccionUnica vista, ListaPreguntas lista, String pregunta, String categoria) {
        this.vista = vista;
        this.lista = lista;
        this.pregunta = pregunta;
        this.categoria = categoria;
        this.vista.volverButtom.addActionListener(this);
        this.vista.jlistButtom.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.jlistButtom) {

            String respuesta1 = vista.jTextField2.getText();
            String respuesta2 = vista.jTextField3.getText();
            String respuesta3 = vista.jTextField4.getText();
            String respuesta4 = vista.jTextField5.getText();

            if (validarLength(respuesta1, 1, 20)
                    && validarLength(respuesta2, 1, 20)
                    && validarLength(respuesta3, 1, 20)
                    && validarLength(respuesta4, 1, 20)) {
                opcion = vista.opc.getSelectedIndex() + 1;
                try {
                    Controlador.lista.insertarPregunta(pregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4, opcion, Controlador.contadorSU);
                } catch (ClassNotFoundException | IOException ex) {
                    Logger.getLogger(ControladorInsertarSeleccionUnica.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(vista, "La pregunta a sido actualizada");
                vista.dispose();

            } else {
                JOptionPane.showMessageDialog(vista, "Las respuestas deben tener como minimo 4 y como maximo 20 caracteres");
            }
        }

        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }

    }

    public boolean validarLength(String texto, int min, int max) {
        boolean temp = false;
        if (texto.length() >= min && texto.length() <= max) {
            temp = true;
        }
        return temp;
    }

}
