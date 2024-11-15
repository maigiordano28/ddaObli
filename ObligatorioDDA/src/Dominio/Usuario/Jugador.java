/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Usuario;

import Dominio.Carta;
import Dominio.Usuario.Usuario;
import java.util.ArrayList;


/**
 *
 * @author bsout
 */
public class Jugador extends Usuario{
    
    private Double SaldoInicial;
    private String estadoActual;
    private ArrayList<Carta> cartasMano; 

    public Jugador(String nombreCompleto, String cedula, String password,Double saldoInicial) {
        super(nombreCompleto, cedula, password);
        this.SaldoInicial=saldoInicial;
        this.cartasMano = new ArrayList<Carta>();
    }
     public Jugador(String nombreCompleto, String password) {
        super(nombreCompleto, password);
    }

    public ArrayList<Carta> getCartasMano() {
        return cartasMano;
    }

    public void setCartasMano(ArrayList<Carta> cartasMano) {
        this.cartasMano = cartasMano;
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
    
    public void RepartirCartas(){
        
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
