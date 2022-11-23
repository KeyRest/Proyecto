package controlador;

import controlador.Actualizar.ControladorActualizar;
import controlador.Insertar.ControladorInsertar;
import estructuras.ListaPreguntas;
import vistas.InterfazMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.InterfazEliminar;
import vistas.InterfazMostrar;
import vistas.InterfazActualizar;
import vistas.InterfazInsertar;

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
            InterfazActualizar interfaz = new InterfazActualizar(vista, true);
            ControladorActualizar controlador = new ControladorActualizar(vista, interfaz, lista);
        }
        if (e.getSource() == vista.eliminarButtom) {
            InterfazEliminar interfaz = new InterfazEliminar(vista, true);
            ControladorEliminar controlador = new ControladorEliminar(interfaz, lista);
        }
        if (e.getSource() == vista.mostrarButtom) {
            InterfazMostrar interfaz = new InterfazMostrar(vista, true);
            ControladorMostrar controlador = new ControladorMostrar(interfaz, lista);
        }
        if (e.getSource() == vista.insertarButtom) {
            InterfazInsertar insertar = new InterfazInsertar();
            ControladorInsertar controlador = new ControladorInsertar(vista, insertar, lista);
        }
        if (e.getSource() == vista.salirButtom) {
            vista.dispose();
        }

    }

}
