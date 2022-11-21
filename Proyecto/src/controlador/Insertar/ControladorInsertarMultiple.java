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
import vistas.InterfazInsertarSeleccionMultiple;

public class ControladorInsertarMultiple implements ActionListener {

    private InterfazInsertarSeleccionMultiple vista;
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
    private String categoria;

    public ControladorInsertarMultiple(InterfazInsertarSeleccionMultiple vista, ListaPreguntas lista, String pregunta, String categoria) {
        this.vista = vista;
        this.lista = lista;
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.vista.trueOrFalse.addActionListener(this);
        this.vista.trueOrFalse.addActionListener(this);
        this.vista.volverButtom.addActionListener(this);
        this.vista.jlistButtom.addActionListener(this);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.jlistButtom) {
            texto1 = vista.jTextField2.getText();
            texto2 = vista.jTextField3.getText();
            texto3 = vista.jTextField4.getText();
            texto4 = vista.jTextField5.getText();
            if (validarLength(texto1, 1, 20) && validarLength(texto2, 1, 20) && validarLength(texto3, 1, 20) && validarLength(texto4, 1, 20)) {

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
                        this.respuesta2 = true;
                        break;
                    case "False":
                        this.respuesta2 = false;
                        break;
                    default:
                        throw new AssertionError();
                }

                String seleccionado3 = (String) vista.jComboBox2.getSelectedItem();

                switch (seleccionado3) {
                    case "True":
                        this.respuesta3 = true;
                        break;
                    case "False":
                        this.respuesta3 = false;
                        break;
                    default:
                        throw new AssertionError();
                }

                String seleccionado4 = (String) vista.jComboBox3.getSelectedItem();

                switch (seleccionado4) {
                    case "True":
                        this.respuesta4 = true;
                        break;
                    case "False":
                        this.respuesta4 = false;
                        break;
                    default:
                        throw new AssertionError();
                }

                System.out.println(respuesta1 + "" + respuesta2 + "" + respuesta3 + "" + respuesta4);
                if (respuesta1 || respuesta2 || respuesta3 || respuesta4) {
                    Controlador.lista.insertarPregunta(pregunta, categoria, texto1, respuesta1, texto2, respuesta2, texto3, respuesta3, texto4, respuesta4, lista.getContadorSM() + 1);
                    vista.dispose();
                    JOptionPane.showMessageDialog(vista, "Se ha actualizado");
                } else {
                    JOptionPane.showMessageDialog(vista, "Debe seleccion al menos una correcta");
                }

                if (e.getSource() == vista.volverButtom) {
                    vista.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(vista, "Las respuestas deben tener como minimo 4 y como maximo 20 caracteres");
            }

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
