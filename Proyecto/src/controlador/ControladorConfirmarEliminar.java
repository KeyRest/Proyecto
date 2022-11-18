/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.interfazG.InterfazConfirmarEliminar;
import vistas.interfazG.InterfazEliminar;

public class ControladorConfirmarEliminar implements ActionListener {

    private final InterfazConfirmarEliminar vista;
    private ControladorEliminar controlador;
    private final ListaPreguntas lista;

    public ControladorConfirmarEliminar(InterfazConfirmarEliminar vista, ListaPreguntas lista) {
        this.vista = vista;
        this.lista = lista;
        controlador = new ControladorEliminar(lista);
        this.vista.confirmButton.addActionListener(this);
        this.vista.volverButton.addActionListener(this);
        this.vista.jTextArea1.setText(lista.mostrarPregunta(this.controlador.getTipo())[this.controlador.getIndex()].toString());
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.confirmButton) {

            lista.eliminarPregunta(this.controlador.getTipo(), this.controlador.getIndex() + 1);
            vista.dispose();
            JOptionPane.showMessageDialog(vista, "Pregunta Eliminada Correctamente");
        }

        if (e.getSource() == vista.volverButton) {
            vista.dispose();
        }

    }

}
