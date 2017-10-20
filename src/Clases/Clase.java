package Clases;

import java.util.ArrayList;
/**
 * @author Claudia Cortes
 */
public class Clase {

    private String nombre;
    private int seccion;
    private int Max_Alumnos;
    private String Maestro;
    private int UV;
    private ArrayList<String> Alumnos;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaestro() {
        return this.Maestro;
    }

    public void setMaestro(String Maestro) {
        this.Maestro = Maestro;
    }

    public int getseccion() {
        return this.seccion;
    }

    public void setseccion(int seccion) {
        this.seccion = seccion;
    }

    public int getUV() {
        return this.UV;
    }

    public void setedada(int UV) {
        this.UV = UV;
    }

    public int getMax_Alumnos() {
        return this.Max_Alumnos;
    }

    public void setMaz_Alumnos(int Max_Alumnos) {
        this.Max_Alumnos = Max_Alumnos;
    }

    public void setAlumnos(String Alumno) {
        Alumnos.add(Alumno);
    }

    public ArrayList GetAlumnos() {
        return this.Alumnos;
    }

    public String toString() {
        return "Seccion:    " + seccion + "Nombre: " + nombre + "    Maximo de Alumnos : " + Max_Alumnos + " Maestro:" + Maestro + "     Unidades Valorativas: " + UV + "    Alumnos" + Alumnos;
    }//Fin dle metodo de formateo.

}
