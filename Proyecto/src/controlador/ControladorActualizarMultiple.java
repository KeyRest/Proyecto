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
import vistas.interfazG.InterfazActualizarMultiple;

public class ControladorActualizarMultiple implements ActionListener {

    private InterfazActualizarMultiple vista;
    private final ListaPreguntas lista;
    private boolean respuesta1;
    private boolean respuesta2;
    private boolean respuesta3;
    private boolean respuesta4;
    private String pregunta;
    private String texto1;
    private String texto2;
    private String texto3;
    private String texto4;
    private int index;
    private String categoria = "0000";

    public ControladorActualizarMultiple(int index, InterfazActualizarMultiple vista, ListaPreguntas lista) {
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
            pregunta = vista.jTextField1.getText();
            texto1 = vista.jTextField2.getText();
            texto2 = vista.jTextField3.getText();
            texto3 = vista.jTextField4.getText();
            texto4 = vista.jTextField5.getText();
            if (pregunta.length() > 4 && pregunta.length() < 50) {

                String seleccionado = (String) vista.trueOrFalse.getSelectedItem();

                switch (seleccionado) {
                    case "True":
                        this.respuesta1 = true;
                        break;
                    case "False":
                        this.respuesta1 = false;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                String seleccionado2 = (String) vista.jComboBox1.getSelectedItem();

                switch (seleccionado2) {
                    case "True":
                        this.respuesta1 = true;
                        break;
                    case "False":
                        this.respuesta1 = false;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                String seleccionado3 = (String) vista.jComboBox2.getSelectedItem();

                switch (seleccionado3) {
                    case "True":
                        this.respuesta1 = true;
                        break;
                    case "False":
                        this.respuesta1 = false;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                String seleccionado4 = (String) vista.jComboBox3.getSelectedItem();

                switch (seleccionado4) {
                    case "True":
                        this.respuesta1 = true;
                        break;
                    case "False":
                        this.respuesta1 = false;
                        break;
                    default:
                        throw new AssertionError();
                }

                String seleccionado5 = (String) vista.categoria.getSelectedItem();

                switch (seleccionado5) {
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
                Controlador.lista.actualizarPregunta(index + 1, pregunta, categoria, texto1, respuesta1, texto2, respuesta2, texto3, respuesta3, texto4, respuesta4);
                vista.dispose();
                JOptionPane.showMessageDialog(vista, "Se ha actualizado");                
            }
        }

        if (e.getSource() == vista.volverButtom) {
            vista.dispose();
        }

    }

}
