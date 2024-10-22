/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Usuario.Jugador;
import Dominio.Usuario.SistemaUsuario;
import Dominio.Usuario.Admin;
import Dominio.Exceptions.MesaException;
import Dominio.Exceptions.UsuarioException;
import java.util.ArrayList;

/**
 *
 * @author bsout
 */
public class Fachada {
    
    private SistemaUsuario sUsuario = new SistemaUsuario();
    private SistemaFigura sFigura = new SistemaFigura();
    private SistemaMesa sMesa = new SistemaMesa();
    private static Fachada instancia = new Fachada();
    
    public static Fachada getInstancia(){
        return instancia;
    }
    
    public Jugador LoginJugador(String nombreCompleto,String password) throws UsuarioException{
        return sUsuario.LoginJugador(nombreCompleto,password);
    }
    public Admin LoginAdmin(String nombreCompleto,String password) throws UsuarioException{
        return sUsuario.LoginAdmin(nombreCompleto,password);
    }

    public void agregarJugador(String cedula, String password, String nombre, int saldo) {
        sUsuario.agregarJugador(nombre,cedula,password,saldo);
       
    }
        public void agregarAdmin(String cedula, String password, String nombre) {
        sUsuario.agregarAdmin(nombre,cedula,password);
       
    }
        
        public Mesa AgregarMesa(int cantJugadores, double apuestaBase, double porcentajeComision) throws MesaException{
            
          return sMesa.AgregarMesa(cantJugadores, apuestaBase, porcentajeComision);
          
        }
          public ArrayList<Mesa> GetMesas(){
            
          return sMesa.mesas;
          
        }
        
        public double TotalApostado(){
        return sMesa.TotalApostado();
        }
        
     
}
