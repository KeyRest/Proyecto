/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Insertar;

import controlador.Controlador;
import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.InterfazActualizarTrueFalse;
import vistas.InterfazInsertarTrueFalse;

public class ControladorInsertarTrueFalse implements ActionListener {

    private InterfazInsertarTrueFalse vista;
    private final ListaPreguntas lista;
    private boolean respuesta;
    private String texto;
    private String categoria;

    public ControladorInsertarTrueFalse(InterfazInsertarTrueFalse vista, ListaPreguntas lista, String categoria, String texto) {
        this.vista = vista;
        this.lista = lista;
        this.categoria = categoria;
        this.texto = texto;
        this.vista.trueOrFalse.addActionListener(this);
        this.vista.trueOrFalse.addActionListener(this);
        this.vista.volverButtom.addActionListener(this);
        this.vista.jlistButtom.addActionListener(this);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.jlistButtom) {
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

            Controlador.lista.insertarPregunta(texto, categoria, respuesta, lista.getContadorVF() + 1);
            vista.dispose();
            JOptionPane.showMessageDialog(vista, "Se ha ingresado correctamente");
        }

        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }
    }

}
