package claudiacortes_lab2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clases.Alumno;
import Clases.Clase;
import Clases.Maestro;
import javax.swing.text.StyledEditorKit;

/**
 * @author Claudia Cortes
 */
public class ClaudiaCortes_Lab2 {
    private static int Indice=0;
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
                    if ((Maestros.size() == 0 && Clases.size() == 0)) {
                        JOptionPane.showMessageDialog(null, "No hay clases ni maestros registrados");
                    } else {

                        if (Alumnos.size() != 0) {
                            Opcion2 = JOptionPane.showInputDialog("Ingrese su opcion:  \n"
                                    + "A-Crear un nuevo alumno\n");
                            Opcion2 = "" + Opcion2.charAt(0);
                            Opcion2 = Opcion2.toUpperCase();
                            switch (Opcion2) {
                                case "A":
                                    Crear_Alumno();
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
                    String Opcion3 = JOptionPane.showInputDialog("Seleccione el tipo de usuario:\n"
                            + "a-Maestro\n"
                            + "b-Alumno");
                    Opcion3 = "" + Opcion3.charAt(0);
                    Opcion3 = Opcion3.toUpperCase();
                    System.out.println("Opcion3" + Opcion3);
                    switch (Opcion3) {
                        case "A":
                            LogMaestro();
                            break;
                        case "B":
                            LogAlumno();
                            break;
                    }

                    break;
                default: //Opcion no valida
                    String S = "";
                    for (Object T : Clases) {
                        S += "" + Clases.indexOf(T) + "-" + T + "\n";
                    }
                    for (Object T : Maestros) {
                        S += "" + Maestros.indexOf(T) + "-" + T + "\n";
                    }
                    for (Object T : Alumnos) {
                        S += "" + Alumnos.indexOf(T) + "-" + T + "\n";
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
            int Val1=0;
            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre de la clase:  \n");
            /*while (Val1 == 0) {
                Val1=1;
                for (Object T : Clases) {
                    if (((Clase)T).getNombre().equals(nombre)) {
                        Val1=0;
                    }
                }
                nombre = JOptionPane.showInputDialog("Ingrese el Nombre de la clase:  \n");
            }*/
            String seccion = JOptionPane.showInputDialog("Ingrese la seccion de la clase:  \n");
             int Val2=0;
            
            /*while (Val2== 0) {
                Val2=1;
                for (Object T : Clases) {
                    if (((Clase)T).getseccion().equals(seccion)) {
                        Val2=0;
                    }
                }
                seccion = JOptionPane.showInputDialog("Ingrese la seccion de la clase:  \n");
            }*/
            int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de alumnos:  \n"));
            int uv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese La cantidad de Unidades Valorativas en la clase:  \n"));
            Clases.add(new Clase(nombre, seccion, max, uv));
            Num--;
        }
    }

    public static void Matricular(int indice ) {//Alumnos.
        
        String Respuesta=JOptionPane.showInputDialog("Ingrese la opcion que desea hacer: \n"
                + "A-Cambiar Nombre"
                + "B-Usuario"
                + "C-Contraseña"
                + "D-Ver secciones"
                + "E-Matricular"
                + "F-Saldo Disponible");
        String S="";
         for (Object T : Alumnos) {
                        S += "" + Alumnos.indexOf(T) + "-" + T + "\n";
                    }
        switch(Respuesta){
            case "A":
                Respuesta=JOptionPane.showInputDialog("Ingrese El nuevo dato");
               ((Alumno)Alumnos.get(indice)).setNombre(Respuesta);
                break;
            case "B":
                 Respuesta=JOptionPane.showInputDialog("Ingrese El nuevo dato");
               ((Alumno)Alumnos.get(indice)).setUsuario(Respuesta);
                break;
            case "C":
                 Respuesta=JOptionPane.showInputDialog("Ingrese El nuevo dato");
             ((Alumno)Alumnos.get(indice)).setcontrasena(Respuesta);
                break;
            case "D":
              
                JOptionPane.showMessageDialog(null,"Sus Clases: \n"+((Alumno)Alumnos.get(indice)).Getclases());
                break;
            case "E":
                 Respuesta=JOptionPane.showInputDialog("Ingrese El nuevo dato");
                JOptionPane.showInputDialog(null,"Ingrese la seccion que desea cambiar"+S);
                break;
            case "F":
                 Respuesta=JOptionPane.showInputDialog("Ingrese El nuevo dato");
                ((Alumno)Alumnos.get(indice)).setdinero(Double.parseDouble(Respuesta));
                break;
        }
        
    }

    public static void LogMaestro() {
        String Usuario = JOptionPane.showInputDialog("Bienvenido Maestro\n Ingrese su Nombre de usuario:");
        String Contra = JOptionPane.showInputDialog("Ingrese su contraseña:");
        for (int i = 0; i < Maestros.size(); i++) {
            if (((Maestro) Maestros.get(i)).getcontra().equals(Contra) && ((Maestro) Maestros.get(i)).getUsuario().equals(Usuario)) {
                JOptionPane.showInputDialog("Acceso Permitido: \n");
                Indice=i;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");
            }
        }

    }

    public static void LogAlumno() {
        String Usuario = JOptionPane.showInputDialog("Bienvenido Alumno\n Ingrese su Nombre de usuario:");
        String Contra = JOptionPane.showInputDialog("Ingrese su contraseña:");
        String S="";
            for (Object T : Clases) {
                        S += "" + Clases.indexOf(T) + "-" + T + "\n";
                    }
        for (int i = 0; i < Alumnos.size(); i++) {
            if (((Alumno) Alumnos.get(i)).getcontra().equals(Contra) && ((Maestro) Maestros.get(i)).getUsuario().equals(Usuario)) {
                JOptionPane.showMessageDialog(null,"Acceso Permitido: \n Las clases disponibles son: \n");
                Indice=i;
                Matricular(i);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");
            }
        }
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
            String carrera = JOptionPane.showInputDialog("Ingrese el Nombre de la carrera:  \n");
            int Edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del maestro:  \n"));
            double Dinero_Disponible = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dinero que posee el alumno:  \n"));
            String usuario = JOptionPane.showInputDialog("Ingrese el Usuario:  \n");
            String contra = JOptionPane.showInputDialog("Ingrese la contraseña del alumno:  \n");
            int Max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el maximo de clases que va matricular:  \n"));
            for (Object T : Alumnos) {
                S += "" + Alumnos.indexOf(T) + "-" + T + "\n";
            }

            Alumno M = new Alumno(nombre, usuario, contra, Edad, Dinero_Disponible, carrera);
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
