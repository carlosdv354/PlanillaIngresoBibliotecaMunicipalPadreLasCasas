package Controller;


import Model.Personas;
import Model.PersonasDAO;
import Model.Programas;
import Model.ProgramasDAO;
import View.RegistroView;
import java.awt.Color;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


 public class RegistroController implements MouseListener {
    
    //DEFINIR METODOS PARA EL DAO Y LA VISTA
    private final RegistroView view;
    private final PersonasDAO dao;


    public RegistroController(RegistroView view) {
        this.view = view;
        this.dao = new PersonasDAO();
        this.view.getJpanAgregar().addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == view.getJpanAgregar()) {
            view.getJpanAgregar().setBackground(new Color(208,158,0));//cambiar color
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == view.getJpanAgregar()) {
            view.getJpanAgregar().setBackground(new Color(255,192,0));//retornar a color original
             agregarDatos();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {  
    } 
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == view.getJpanAgregar()) {
            view.getJpanAgregar().setBackground(new Color(255,192,0));//retornar a color original
        }
    }

    // ---METODOS---
    public void agregarDatos(){
        String nombre = view.getTxtNombre().getText();
        String rut = view.getTxtRut().getText();
        String telefono = view.getTxtFono().getText();
        Programas programaSeleccionado = (Programas) view.getComboProgramas().getSelectedItem(); // Objeto completo

        // Validación de campos vacíos
        if (nombre.isEmpty() || rut.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos los campos deben estar llenos.");
            return;
        }

        String idPrograma = programaSeleccionado.getId(); // ID directo desde el objeto seleccionado
        // Crear persona y registrar
        Personas persona = new Personas(nombre, rut, telefono, idPrograma);
        boolean success = dao.registerPersonas(persona);

        if (success) {
            view.cargarTablaPersonas();      // Recarga la tabla
            view.limpiarCampos();       // Limpia los campos del formulario
        } else {
            JOptionPane.showMessageDialog(view, "Error al registrar persona.");
        }
    }
    public void cargarComboProgramas() {
    ProgramasDAO dao = new ProgramasDAO();
    List<Programas> lista = dao.listProgramas();

    view.getComboProgramas().removeAllItems(); // Limpia los items anteriores

    for (Programas programa : lista) {
        view.getComboProgramas().addItem(programa); // Aquí se usa "programa" del for
        }
    }
}
