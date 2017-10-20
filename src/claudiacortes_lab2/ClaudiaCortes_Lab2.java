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
        while (!Opcion.equals("D")) {
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
                    if ((Maestros.size() != 0 && Clases.size() != 0)) {
                        JOptionPane.showMessageDialog(null, "No hay clases ni maestros registrados");
                    } else {

                        if (Alumnos.size() != 0) {
                            Opcion2 = JOptionPane.showInputDialog("Ingrese su opcion:  \n"
                                    + "A-Crear un nuevo alumno\n"
                                    + "B-Matricular\n");
                            Opcion2 = "" + Opcion2.charAt(0);
                            Opcion2 = Opcion2.toUpperCase();
                            switch (Opcion2) {
                                case "A":
                                    Crear_Alumno();
                                    break;
                                case "B":
                                    Matricular();
                                    break;
                                default:
                                    System.out.println("INVALIDO");
                                    break;
                            }

                        } else {
                            /*HACER VALIDACIONES DE LOS TIPOS*/
                            Crear_Alumno();
                        }
                    }
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
        int Num = 0;
        while (Num <= 0) {
            Num = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Clases Desea Matricular:  \n"));
        }
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

    public static void Matricular() {

    }

    public static void Crear_Maestro() {
        String S = "";
        String SEC = "";
        int Num_Maestros = 0;
        while (Num_Maestros <= 0) {
            Num_Maestros = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Maestros desea Ingresar:  \n"));
        }
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
                if (Pos > Clases.size() - 1 || Pos < 0) {
                    System.out.println("ERROR");
                } else {
                    String Seccion = ((Clase) Clases.get(Pos)).getseccion();
                    System.out.println("LA SECCION" + Seccion);
                    SEC = Seccion;
                    M.setclases(SEC);
                    ((Clase) Clases.get(Pos)).setMaestro(nombre);
                    Max--;
                }
            }//Fin de agregar las clases
            Maestros.add(M);

            Num_Maestros--;

        }//Fin del while del maestro.
    }//Fin del metodo que rea Maestros 

    public static void Crear_Alumno() {
        String S = "";
        String SEC = "";
        /*que poseen un nombre, número
de cuenta, carrera, edad, dinero disponible, usuario, contraseña, clases que está cursando (solo contara
con las secciones de la clase) y un buzón. */
        int Num_Alumnos = 0;
        while (Num_Alumnos <= 0) {
            Num_Alumnos = Integer.parseInt(JOptionPane.showInputDialog("Cuantas Alumnos desea Ingresar:  \n"));
        }
        while (Num_Alumnos > 0) {
            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Alumno:  \n");
            int Edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del maestro:  \n"));
            double Dinero_Disponible = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dinero que posee el alumno:  \n"));
            String usuario = JOptionPane.showInputDialog("Ingrese el Usuario:  \n");
            String contra = JOptionPane.showInputDialog("Ingrese la contraseña del alumno:  \n");
            int Max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el maximo de clases que va matricular:  \n"));
            for (Object T : Clases) {
                S += "" + Clases.indexOf(T) + "-" + T + "\n";
            }

            Alumno M = new Alumno(nombre, usuario, contra, Edad, Dinero_Disponible);
            while (Max > 0) {
                int Pos = Integer.parseInt(JOptionPane.showInputDialog("Clases Disponibles: \n" + S + "\n Ingrese el Numero de la clase: "));

                if (Pos > Clases.size() - 1 || Pos < 0) {
                    System.out.println("ERROR");
                } else {
                    String Seccion = ((Clase) Clases.get(Pos)).getseccion();
                    SEC = Seccion;
                    M.setclases(SEC);
                    ((Clase) Clases.get(Pos)).setMaestro(nombre);
                    Max--;
                }
            }//Fin de agregar las clases
            Alumnos.add(M);

            Num_Alumnos--;

        }//Fin del while del maestro.
    }//Fin del metodo que rea Maestros 
}//Fin de la clase.
