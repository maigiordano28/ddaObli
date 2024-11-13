/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Usuario;

import Dominio.Usuario.Usuario;

/**
 *
 * @author bsout
 */
public class Jugador extends Usuario{
    
    private Double SaldoInicial;
    private String estadoActual;

    public Jugador(String nombreCompleto, String cedula, String password,Double saldoInicial) {
        super(nombreCompleto, cedula, password);
        this.SaldoInicial=saldoInicial;
    }
     public Jugador(String nombreCompleto, String password) {
        super(nombreCompleto, password);
    }
 
   
     public double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(Double SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    
    
    public void ActualizarSaldo(boolean operacion, Double num){
        if(operacion){
            SaldoInicial=SaldoInicial+num;
        }else{
            SaldoInicial=SaldoInicial-num;
        }
        
        
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
