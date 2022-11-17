package controlador;

import estructuras.ListaPreguntas;
import vistas.interfazG.InterfazMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.interfazG.InterfazMostrar;

/**
 *
 * @author Administrator
 */
public class ControladorMenu implements ActionListener {

    private InterfazMenu vista;
    private ListaPreguntas lista;

    public ControladorMenu(InterfazMenu vista, ListaPreguntas lista) {
        this.vista = vista;
        this.lista = lista;
        vista.actualizarButtom.addActionListener(this);
        vista.eliminarButtom.addActionListener(this);
        vista.salirButtom.addActionListener(this);
        vista.mostrarButtom.addActionListener(this);
        vista.insertarButtom.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.actualizarButtom) {

        }
        if (e.getSource() == vista.eliminarButtom) {

        }
        if (e.getSource() == vista.mostrarButtom) {
            InterfazMostrar mostrar = new InterfazMostrar(vista, true);
            ControladorMostrar controlador = new ControladorMostrar(mostrar, lista);
        }
        if (e.getSource() == vista.insertarButtom) {

        }
        if (e.getSource() == vista.salirButtom) {
            System.exit(0);
        }

    }

}
