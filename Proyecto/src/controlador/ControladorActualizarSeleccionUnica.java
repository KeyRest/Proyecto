/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Pregunta;
import vistas.interfazG.InterfazActualizarSeleccionUnica;

public class ControladorActualizarSeleccionUnica implements ActionListener {

    private InterfazActualizarSeleccionUnica vista;
    private final ListaPreguntas lista;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String pregunta;
    private int index;
    private String categoria;

    public ControladorActualizarSeleccionUnica(int index, InterfazActualizarSeleccionUnica vista, ListaPreguntas lista) {
        this.index = index;
        this.vista = vista;
        this.lista = lista;
        this.vista.volverButtom.addActionListener(this);
        this.vista.jlistButtom.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.jlistButtom) {

            String pregunta = vista.jTextField1.getText();
            String respuesta1 = vista.jTextField2.getText();
            String respuesta2 = vista.jTextField3.getText();
            String respuesta3 = vista.jTextField4.getText();
            String respuesta4 = vista.jTextField5.getText();
            String seleccionado = (String) vista.categoria.getSelectedItem();

            switch (seleccionado) {
                case "Entretenimiento":
                    this.categoria = "1";
                    break;
                case "Deporte":
                    this.categoria = "2";
                    break;
                case "Historia":
                    this.categoria = "3";
                    break;
                default:
                    throw new AssertionError();
            }

            if (validarLength(pregunta, 4, 50)
                    && validarLength(respuesta1, 1, 20)
                    && validarLength(respuesta2, 1, 20)
                    && validarLength(respuesta3, 1, 20)
                    && validarLength(respuesta4, 1, 20)) {
                lista.actualizarPregunta(index, pregunta, categoria, respuesta1, respuesta2, respuesta3, respuesta4, 1);
            } else {
                JOptionPane.showMessageDialog(vista, "Las preguntas deben tener como minimo 4 y como maximo 50 caracteres /n Las respuestas deben tener como minimo 1 y como maximo 20 caracteres");
            }
        }

        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }

    }

    public boolean validarLength(String texto, int min, int max) {
        boolean temp = false;
        if (texto.length() < min && texto.length() > max) {
            temp = true;
        }
        return temp;
    }

}
