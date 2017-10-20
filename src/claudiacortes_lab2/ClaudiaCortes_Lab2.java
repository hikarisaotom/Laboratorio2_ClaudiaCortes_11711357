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
        ArrayList Clases = new ArrayList();
        ArrayList Maestros = new ArrayList();
        ArrayList Alumnos = new ArrayList();
        String Opcion = "";
        String Opcion2 = "";
        while (!Opcion.equals("d")) {
            int Num_Clases = 100;
            Opcion = JOptionPane.showInputDialog("Bienvenido al Sistema de Matricula de Harvad, seleccione a continuacion lo que desea hacer \n"
                    + "A-Administración\n"
                    + "b-Matricula\n"
                    + "c-Log-In\n"
                    + "d-Salir\n");
            Opcion = "" + Opcion.charAt(0);
            Opcion = Opcion.toUpperCase();
            switch (Opcion) {
                case "A"://Administrar (Crear Clases y Maestros)
                    //Crear Clases;
                    if (Clases.size() > 1) {
                        Opcion2 = JOptionPane.showInputDialog("Ingrese que desea crear:  \n"
                                + "A-Clase\n"
                                + "b-Maestro\n");
                    } else {
                        /*HACER VALIDACIONES DE LOS TIPOS*/
                        int Num = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Clases Desea Matricular:  \n"));;
                        while (Num > 0) {
                            //VALIDAR CADA DATO.
                            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre de la clase:  \n");
                            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la seccion de la clase:  \n"));
                            int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de alumnos:  \n"));
                            int uv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese La cantidad de Unidades Valorativas en la clase:  \n"));
                            Clases.add(new Clase(nombre, seccion, max, uv));
                            Num--;
                        }
                    }

                    /*Entramos a la opcion de crear*/
                    switch (Opcion2) {
                        case "A": //Clase;
                            int Num = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Clases Desea Matricular:  \n"));
                            while (Num > 0) {
                                //VALIDAR CADA DATO.
                                String nombre = JOptionPane.showInputDialog("Ingrese el Nombre de la clase:  \n");
                                int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la seccion de la clase:  \n"));
                                int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de alumnos:  \n"));
                                int uv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese La cantidad de Unidades Valorativas en la clase:  \n"));
                                Clases.add(new Clase(nombre, seccion, max, uv));
                                Num--;
                            }
                            break;
                        case "B":
                            int Num_Maestros = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Clases Desea Matricular:  \n"));
                            while (Num_Maestros > 0) {
                                String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del maestro:  \n");
                                String Titulo = JOptionPane.showInputDialog("Ingrese el Titulo que posee el Maestro:  \n");
                                double Salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del maestro:  \n"));
                                String usuario = JOptionPane.showInputDialog("Ingrese el Usuario:  \n");
                                String contra = JOptionPane.showInputDialog("Ingrese la contraseña del maestro:  \n");
                                int Max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el maximo de clases que va a impartir:  \n"));
                                Maestros.add(new Maestro(nombre, Titulo, Salario, usuario, contra, Max));
                                Num_Maestros--;
                            }
                            break;
                        default:
                            JOptionPane.showInternalMessageDialog(null, "Error, Opcion no Valida");
                            break;

                    }

                    break;
                case "B"://Crear Alumnos.
                    break;
                case "C"://Brindar Acceso.
                    break;
                default: //Opcion no valida
                    String S = "";
                    for (Object T : Clases) {
                        S += "" + Clases.indexOf(T) + "-" + T + "\n";
                    }
                    for (Object T : Maestros) {
                        S += "" + Clases.indexOf(T) + "-" + T + "\n";
                    }
                    System.out.println(S);
                    break;

            }
        }//Fin del while respuesta de usuario.
    }//Fin del Main.

}//Fin de la clase.
