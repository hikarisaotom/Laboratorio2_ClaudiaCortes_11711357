package Clases;

import java.util.ArrayList;

/**
 *
 * @author Claudia Cortes
 */
public class Maestro {

    private String nombre;
    private String titulo;
    private double salario;
    private String usuario;
    private String contrasena;
    private int Max_Clases;
    private ArrayList<String> Clases_Impartidas= new ArrayList();
public Maestro(String nombre,String Titulo,double Salario,String usuario,String contra,int Max){
    this.nombre=nombre;
    this.titulo=Titulo;
    this.salario=Salario;
    this.usuario=usuario;
    this.contrasena=contra;
    this.Max_Clases=Max;
    
}
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String gettitulo() {
        return this.titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getsiueldo() {
        return this.salario;
    }

    public void setsueldo(double salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getcontra() {
        return this.contrasena;
    }

    public void setclases(String clasei) {
         Clases_Impartidas.add(clasei);
    }

    public ArrayList Getclases() {
        return this.Clases_Impartidas;
    }

    public void setMax_Clases(int Max_Clases) {
        this.Max_Clases = Max_Clases;
    }

    public int getMax_Clases() {
        return this.Max_Clases;
    }

    public String toString() {
        return "Nombre:    " + nombre + "Titulo: " + titulo + "      Salario: " + salario + " Usuario:  " + usuario + " Contraseña: " + contrasena + " Maximo de Clases: " + Max_Clases + "  Clases Impartidas: " + Clases_Impartidas;
    }//Fin dle metodo de formateo.
}
