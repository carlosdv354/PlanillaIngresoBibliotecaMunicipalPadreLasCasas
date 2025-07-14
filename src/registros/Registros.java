package registros;

import View.RegistroView;
import Controller.RegistroController;

public class Registros {

    public static void main(String[] args) {
            RegistroView vista = new RegistroView();
            RegistroController controlador = new RegistroController(vista);
            vista.cargarTablaPersonas();
            controlador.cargarComboProgramas();
            vista.setVisible(true);  
    }
}
