/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Insertar;

import controlador.Actualizar.*;
import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Pregunta;
import vistas.InterfazInsertar;
//import vistas.InterfazInsertarSeleccionMultiple;
//import vistas.InterfazInsertarSeleccionUnica;
import vistas.InterfazMenu;
import vistas.InterfazActualizarTrueFalse;
import vistas.InterfazInsertarSeleccionMultiple;
import vistas.InterfazInsertarSeleccionUnica;
import vistas.InterfazInsertarTrueFalse;

public class ControladorInsertar implements ActionListener {

    private InterfazInsertar vista;
    private final ListaPreguntas lista;
    private int tipo;
    private String categoria;
    private InterfazMenu parent;

    public ControladorInsertar(InterfazMenu parent, InterfazInsertar vista, ListaPreguntas lista) {
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

        if (e.getSource() == vista.jlistButtom) {

            String texto = vista.jTextField1.getText();
            String seleccionado = (String) vista.tipoPregunta.getSelectedItem();

            switch (seleccionado) {
                case "Verdadero o Falso":
                    this.tipo = 1;
                    break;
                case "Seleccion Unica":
                    this.tipo = 2;
                    break;
                case "Seleccion Multiple":
                    this.tipo = 3;
                    break;
                default:
                    throw new AssertionError();
            }

            seleccionado = (String) vista.categoria.getSelectedItem();

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

            switch (tipo) {
                case 1:
                    InterfazInsertarTrueFalse interfazTF = new InterfazInsertarTrueFalse(parent, true);
                    ControladorInsertarTrueFalse controladorTF = new ControladorInsertarTrueFalse(interfazTF, lista, categoria, texto);
                    vista.dispose();
                    break;
                case 2:
                    InterfazInsertarSeleccionUnica interfazSU = new InterfazInsertarSeleccionUnica(parent, true);
                    ControladorInsertarSeleccionUnica controladorSU = new ControladorInsertarSeleccionUnica(interfazSU, lista, texto, categoria);
                    vista.dispose();
                    break;
                case 3:
                    InterfazInsertarSeleccionMultiple interfazSM = new InterfazInsertarSeleccionMultiple(parent, true);
                    ControladorInsertarMultiple controladorSM = new ControladorInsertarMultiple(interfazSM, lista,texto,categoria);
                    vista.dispose();
                    break;
                default:
                    throw new AssertionError();
            }

        }
        if (e.getSource() == this.vista.volverButtom) {
            vista.dispose();
        }
    }

}
