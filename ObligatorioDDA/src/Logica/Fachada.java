/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Logica.Exceptions.MesaException;
import Logica.Exceptions.UsuarioException;

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
    
    public Usuario LoginJugador(String nombreCompleto,String password) throws UsuarioException{
        return sUsuario.LoginJugador(nombreCompleto,password);
    }
    public Usuario LoginAdmin(String nombreCompleto,String password) throws UsuarioException{
        return sUsuario.LoginAdmin(nombreCompleto,password);
    }

    public void agregarJugador(String cedula, String password, String nombre, int saldo) {
        sUsuario.agregarJugador(cedula,password,nombre,saldo);
       
    }
        public void agregarAdmin(String cedula, String password, String nombre) {
        sUsuario.agregarAdmin(cedula,password,nombre);
       
    }
        
        public void AgregarMesa(int cantJugadores, double apuestaBase, double porcentajeComision) throws MesaException{
          sMesa.AgregarMesa(cantJugadores, apuestaBase, porcentajeComision);
        }
}
