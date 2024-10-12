/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import Logica.Exceptions.UsuarioException;
import java.util.Date;
/**
 *
 * @author bsout
 */
public class SistemaUsuario {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Admin> administradores = new ArrayList<Admin>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Sesion> sesiones = new ArrayList<Sesion>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(ArrayList<Sesion> sesiones) {
        this.sesiones = sesiones;
    }

    public ArrayList<Admin> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Admin> administradores) {
        this.administradores = administradores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

   
    
    
    public Jugador LoginJugador(String nombreCompleto,String password) throws UsuarioException{
       
       Jugador jugadorAValidar = new Jugador(nombreCompleto, password);
            if(password == null||password.equals("") || nombreCompleto == null||nombreCompleto.equals("")){
            
                throw new UsuarioException("Ingrese todos los campos");
            }
           
            if(getSesion(jugadorAValidar)!= null){
                throw new UsuarioException("Acceso denegado. El usuario ya esta logueado");
            }
          
            
           /* for(Jugador j:jugadores){
                if(j.equals(jugadorAValidar)){
                   sesiones.add(new Sesion(j, new Date()));
                   return j;
                }
            }*/
            if(jugadores.contains(jugadorAValidar)){
                sesiones.add(new Sesion(jugadorAValidar, new Date()));
                   return jugadorAValidar;
            }else{
            throw new UsuarioException("Credenciales incorrectas"); 
  
    }}
    
     public Admin LoginAdmin(String nombreCompleto,String password) throws UsuarioException{
       
       Admin adminAValidar = new Admin(nombreCompleto, password);
            if(password == null||password.equals("") || nombreCompleto == null||nombreCompleto.equals("")){
            
                throw new UsuarioException("Ingrese todos los campos");
            }
           
            if(getSesion(adminAValidar)!= null){
                throw new UsuarioException("Acceso denegado. El usuario ya esta logueado");
            }
            
           if(administradores.contains(adminAValidar)){
                sesiones.add(new Sesion(adminAValidar, new Date()));
                   return adminAValidar;
            }else{
            throw new UsuarioException("Credenciales incorrectas"); 
  
    }
     }
    
    
    public void Logout(Usuario usuario) throws UsuarioException{
        
        Sesion s = getSesion(usuario);
        if(s==null){
            throw new UsuarioException("No se encontro el usuario");
        }
        sesiones.remove(s);
    }
    
 public Sesion getSesion(Usuario user){
     
        for(Sesion s : sesiones){
            if(s.getUsuario().equals(user)){
                return s;
            }
        }
        return null;
    }

    void agregarJugador(String nombre, String cedula, String password, int saldo) {
        jugadores.add(new Jugador(nombre,cedula,password,saldo));
    }
     void agregarAdmin(String nombre, String cedula, String password) {
        administradores.add(new Admin(nombre,cedula,password));
    }
}
   
