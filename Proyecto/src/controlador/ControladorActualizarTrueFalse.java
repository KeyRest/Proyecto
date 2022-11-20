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
import vistas.interfazG.InterfazActualizarTrueFalse;

public class ControladorActualizarTrueFalse implements ActionListener {

    private InterfazActualizarTrueFalse vista;
    private final ListaPreguntas lista;
    private boolean respuesta;
    private int index;
    private String categoria;

    public ControladorActualizarTrueFalse(int index, InterfazActualizarTrueFalse vista, ListaPreguntas lista) {
        this.index = index;
        this.vista = vista;
        this.lista = lista;
        this.vista.trueOrFalse.addActionListener(this);
        this.vista.trueOrFalse.addActionListener(this);
        this.vista.volverButtom.addActionListener(this);
        this.vista.jlistButtom.addActionListener(this);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.trueOrFalse) {
            String seleccionado = (String) vista.trueOrFalse.getSelectedItem();

            switch (seleccionado) {
                case "True":
                    this.respuesta = true;
                    break;
                case "False":
                    this.respuesta = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        if (e.getSource() == vista.trueOrFalse) {
            String seleccionado = (String) vista.trueOrFalse.getSelectedItem();

            switch (seleccionado) {
                case "Entretenimiento":
                    this.categoria = "Entretenimiento";
                    break;
                case "Deporte":
                    this.categoria = "Deporte";
                    break;
                case "Historia":
                    this.categoria = "Historia";
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }

    }

}
