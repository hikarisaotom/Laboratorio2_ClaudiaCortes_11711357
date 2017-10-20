package Clases;

import java.util.ArrayList;

/**
 *
 * @author Claudia Cortes
 */
public class Alumno {

    private String nombre;
    private int num_Cuenta;
    private String carrera;
    private int edad;
    private double dinero_disp;
    private String usuario;
    private String contrasena;
    private ArrayList<String> clases;
    private ArrayList<String> buzon;
    
    public String getNombre (){
        return this.nombre;
    }
    
    public void  setNombre(String nombre){
          this.nombre=nombre;
    }
    
    public int getCuenta (){
        return this.num_Cuenta;
    }
    
    public void  setCuenta(int  Cuenta){
          this.num_Cuenta=Cuenta;
    }
   
     public String getcarrera (){
        return this.carrera;
    }
    
    public void  setcarrera(String Carrera ){
          this.carrera=Carrera;
    }
    
   
    
     public int getedad (){
        return this.edad;
    }
    
    public void  setedada(int edad ){
          this.edad=edad;
    }
    
      public double getdinero_disp (){
        return this.dinero_disp;
    }
    
    public void  setdinero(double dinero_disp ){
          this.dinero_disp=dinero_disp;
    }
    
     public String getUsuario (){
        return this.usuario;
    }
      public void  setUsuario(String usuario){
          this.usuario=usuario;
    }
    
    public void  setcontrasena(String contrasena){
          this.contrasena=contrasena;
    }
    
     public String getcontra (){
        return this.contrasena;
    }
     
     
     public void  setclases(String clase){
         clases.add(clase);
    }
    
     public ArrayList Getclases (){
        return this.clases;
    }
     
      public void  setbuzon(String mensaje){
         buzon.add(mensaje);
    }
    
     public ArrayList getbuzon (){
        return this.buzon;
    }
    public String toString() {
        return "Nombre:    " + nombre + "Numero de Cuenta: " + num_Cuenta + "      Carrera: " + carrera + "    Edad: " + edad + "  Dinero Disponible:" + dinero_disp + " Usuario:  " + usuario + " Contraseña: " + contrasena + " Clases: " + clases + "   Buzon: " + buzon;
    }//Fin dle metodo de formateo.
    
}
