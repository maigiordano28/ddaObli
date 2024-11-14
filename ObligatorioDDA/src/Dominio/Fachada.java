/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Usuario.Jugador;
import Dominio.Usuario.Usuario;
import Dominio.Usuario.SistemaUsuario;
import Dominio.Usuario.Admin;
import Dominio.Exceptions.MesaException;
import Dominio.Exceptions.UsuarioException;
import Observador.observable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bsout
 */
public class Fachada extends observable {
    
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

    public void agregarJugador(String cedula, String password, String nombre, Double saldo) {
        sUsuario.agregarJugador(nombre,cedula,password,saldo);
       
    }
        public void agregarAdmin(String cedula, String password, String nombre) {
        sUsuario.agregarAdmin(nombre,cedula,password);
       
    }
        
        public Mesa AgregarMesa(int cantJugadores, double apuestaBase, double porcentajeComision) throws MesaException{
            Mesa ret=sMesa.AgregarMesa(cantJugadores, apuestaBase, porcentajeComision);
            this.avisar(EventoMesa.NUEVA_MESA);
           
          return ret;
         
          
        }
        
        public Mesa ActualizarMesa(Mesa m){
            Mesa ret= sMesa.ActualizarMesa(m);
             return ret;
        }
             
            public void actualizarCantidadJugadores(Mesa m, Jugador j){
                     this.avisar(EventoFachada.NUEVO_JUGADOR_MESA);
            sMesa.actualizarCantidadJugadores(m,j);
   
            
            }
            
        public Mano agregarMano(Mesa mesa) {
             return sMesa.AgregarMano(mesa);
        }
             
        public ArrayList<Mesa> getMesas(){
            
          return sMesa.mesas;
          
        }
            public ArrayList<Jugador> getJugadores(){
            
          return sUsuario.getJugadores();
            }
        
        public double TotalApostado(){
        return sMesa.TotalApostado();
        }
        
        public void CerrarSesion(Usuario usuario)throws UsuarioException{
            sUsuario.Logout(usuario);
            
        }

    
        
     
}
