/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Usuario;

/**
 *
 * @author bsout
 */
public class Usuario {
     private String nombreCompleto;
     private String cedula;
     private String password;

    public Usuario(String nombreCompleto, String cedula, String password) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.password = password;
    }
    
    public Usuario(String nombreCompleto, String password) {
        this.nombreCompleto = nombreCompleto;
        this.password = password;
    }

     
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
       public boolean equals(Object o){
        Usuario u = (Usuario)o;
        return nombreCompleto.equalsIgnoreCase(u.getNombreCompleto()) &&
               password.equals(u.getPassword());
    }



}

