/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Usuario.Usuario;

/**
 *
 * @author bsout
 */
public class Jugador extends Usuario{
    
    private double SaldoInicial;
    private String estadoActual;

    public Jugador(String nombreCompleto, String cedula, String password,double saldoInicial) {
        super(nombreCompleto, cedula, password);
        this.SaldoInicial=saldoInicial;
    }
     public Jugador(String nombreCompleto, String password) {
        super(nombreCompleto, password);
    }
 
   
     public double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(double SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    
    
    public void ActualizarSaldo(){
}
    
    public void RegistrarApuesta(){
        
    }

   
    public void IngresarMesa(){
        
    }
    public void PedirCartas(){
             
    }
    public void RetirarseDelJuego(){
    }  
    
}
