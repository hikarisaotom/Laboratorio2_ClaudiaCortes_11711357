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

    private static ArrayList Clases = new ArrayList();
    private static ArrayList Maestros = new ArrayList();
    private static ArrayList Alumnos = new ArrayList();

    public static void main(String[] args) {
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
                    if (Clases.size() != 0) {
                        Opcion2 = JOptionPane.showInputDialog("Ingrese que desea crear:  \n"
                                + "A-Clase\n"
                                + "B-Maestro\n");
                        Opcion2 = "" + Opcion2.charAt(0);
                        Opcion2 = Opcion2.toUpperCase();
                        switch (Opcion2) {
                            case "A":
                                Crear_Clase();
                                break;
                            case "B":
                                Crear_Maestro();
                                break;
                            default:
                                System.out.println("INVALIDO");
                                break;
                        }

                    } else {
                        /*HACER VALIDACIONES DE LOS TIPOS*/
                        Crear_Clase();
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

    public static void Crear_Clase() {
        int Num = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Clases Desea Matricular:  \n"));;
        while (Num > 0) {
            //VALIDAR CADA DATO.
            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre de la clase:  \n");
            String seccion = JOptionPane.showInputDialog("Ingrese la seccion de la clase:  \n");
            int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de alumnos:  \n"));
            int uv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese La cantidad de Unidades Valorativas en la clase:  \n"));
            Clases.add(new Clase(nombre, seccion, max, uv));
            Num--;
        }
    }

    public static void Crear_Maestro() {
        String S = "";
        String SEC = "";
        int Num_Maestros = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Clases Desea Matricular:  \n"));
        while (Num_Maestros > 0) {
            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del maestro:  \n");
            String Titulo = JOptionPane.showInputDialog("Ingrese el Titulo que posee el Maestro:  \n");
            double Salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del maestro:  \n"));
            String usuario = JOptionPane.showInputDialog("Ingrese el Usuario:  \n");
            String contra = JOptionPane.showInputDialog("Ingrese la contraseña del maestro:  \n");
            int Max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el maximo de clases que va a impartir:  \n"));
            for (Object T : Clases) {
                S += "" + Clases.indexOf(T) + "-" + T + "\n";
            }
            Maestro M = new Maestro(nombre, Titulo, Salario, usuario, contra, Max);
            while (Max > 0) {
                int Pos = Integer.parseInt(JOptionPane.showInputDialog("Clases Disponibles: \n" + S + "\n Ingrese el Numero de la clase: "));

                String Seccion = ((Clase) Clases.get(Pos)).getseccion();
                System.out.println("LA SECCION" + Seccion);
                SEC = Seccion;

                ((Clase) Clases.get(Pos)).setMaestro(nombre);
                Max--;
            }//Fin de agregar las clases
            Maestros.add(M);
            ((Maestro) Maestros.get(Maestros.size() - 1)).setclases(SEC);
            Num_Maestros--;

        }//Fin del while del maestro.
    }//Fin del metodo que rea Maestros 
}//Fin de la clase.
