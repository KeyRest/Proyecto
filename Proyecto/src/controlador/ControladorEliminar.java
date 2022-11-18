package controlador;

import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import modelo.Pregunta;
import vistas.interfazG.InterfazConfirmarEliminar;
import vistas.interfazG.InterfazEliminar;
import vistas.interfazG.InterfazMenu;

public class ControladorEliminar implements ActionListener {

    private InterfazEliminar vista;
    private InterfazMenu vista2;
    private final ListaPreguntas lista;
    private static int tipo;
    private static int index;

    public ControladorEliminar(InterfazEliminar vista, ListaPreguntas lista) {
        this.vista = vista;
        this.lista = lista;
        this.vista.tipoPregunta.addActionListener(this);
        this.vista.tipoPregunta.addItem("Verdadero o Falso");
        this.vista.tipoPregunta.addItem("Seleccion Unica");
        this.vista.tipoPregunta.addItem("Seleccion Multiple");
        this.vista.jlistButtom.addActionListener(this);
        this.vista.volverButtom.addActionListener(this);
        vista.setVisible(true);
        insertarPreguntasJList(1);

    }

    public ControladorEliminar(ListaPreguntas lista) {
        this.lista = lista;
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
            this.index = this.vista.preguntasList.getSelectedIndex();
            if (this.index != -1) {

                InterfazConfirmarEliminar mostrar = new InterfazConfirmarEliminar(vista2, true);
                ControladorConfirmarEliminar controlador = new ControladorConfirmarEliminar(mostrar, lista);
                vista.dispose();
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

    public int getTipo() {
        return tipo;
    }

    public int getIndex() {
        return index;
    }
}
