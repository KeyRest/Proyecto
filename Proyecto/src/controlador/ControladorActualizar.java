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
import vistas.interfazG.InterfazActualizar;
import vistas.interfazG.InterfazMenu;
import vistas.interfazG.InterfazActualizarTrueFalse;

public class ControladorActualizar implements ActionListener {

    private InterfazActualizar vista;
    private final ListaPreguntas lista;
    private int tipo;
    private InterfazMenu parent;

    public ControladorActualizar(InterfazMenu parent,InterfazActualizar vista, ListaPreguntas lista) {
        this.vista = vista;
        this.parent = parent;
        this.lista = lista;
        this.vista.tipoPregunta.addActionListener(this);
        this.vista.tipoPregunta.addItem("Verdadero o Falso");
        this.vista.tipoPregunta.addItem("Seleccion Unica");
        this.vista.tipoPregunta.addItem("Seleccion Multiple");
        this.vista.volverButtom.addActionListener(this);
        this.vista.jlistButtom.addActionListener(this);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.tipoPregunta) {
            String seleccionado = (String) vista.tipoPregunta.getSelectedItem();

            switch (seleccionado) {
                case "Verdadero o Falso":
                    insertarPreguntasJList(1);
                    this.tipo = 1;
                    break;
                case "Seleccion Unica":
                    this.tipo = 2;
                    insertarPreguntasJList(2);
                    break;
                case "Seleccion Multiple":
                    this.tipo = 3;
                    insertarPreguntasJList(3);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        if (e.getSource() == vista.jlistButtom) {
            int index = this.vista.preguntasList.getSelectedIndex();
            if (index != -1) {
                InterfazActualizarTrueFalse interfaz = new InterfazActualizarTrueFalse(parent, true);
                ControladorActualizarTrueFalse controlador = new ControladorActualizarTrueFalse(index, interfaz, lista);
            }
        }
        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }

    }

    private void insertarPreguntasJList(int tipo) {

        Pregunta[] array2 = lista.mostrarPregunta(tipo);
        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < array2.length; i++) {
            if (array2[i] != null) {
                model.addElement(array2[i].getTexto());
            }
        }
        this.vista.preguntasList.setModel(model);
    }

}
