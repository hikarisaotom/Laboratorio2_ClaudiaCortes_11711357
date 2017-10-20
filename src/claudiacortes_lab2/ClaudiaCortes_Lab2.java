package claudiacortes_lab2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clases.Alumno;
import Clases.Clase;
import Clases.Maestro;

/**
 * @author Claudia Cortes
 */
public class ClaudiaCortes_Lab2 {

    public static void main(String[] args) {
        ArrayList Lista = new ArrayList();
        String Opcion = "";
        String Opcion2 = "";
        while (!Opcion.equals("e")) {
            Opcion = JOptionPane.showInputDialog("a-Agregar\n"
                    + "b-Listar\n"
                    + "c-Modificar\n"
                    + "d-Eliminar\n"
                    + "e-Salir\n");
            if (Opcion.equals("a")) {

            }

        }//Fin del while respuesta de usuario.
    }//Fin del Main.

}//Fin de la clase.
