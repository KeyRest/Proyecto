/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Controlador;
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
    private String texto;
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

        if (e.getSource() == vista.jlistButtom) {
            texto = vista.jTextField1.getText();
            if (texto.length() > 4 && texto.length() < 50) {

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

                String seleccionado2 = (String) vista.categoria.getSelectedItem();

                switch (seleccionado2) {
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
                Controlador.lista.actualizarPregunta(index + 1, texto, categoria, respuesta);
                vista.dispose();
                JOptionPane.showMessageDialog(vista, "Se ha actualizado");                
            }
        }

        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }

    }

}
