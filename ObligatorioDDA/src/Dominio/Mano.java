/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Usuario.Jugador;
import java.util.ArrayList;

/**
 *
 * @author bsout
 */
public class Mano {
    private static int s_ultNumero=1;
    private int numero;
    private int totalApostado;
    private EstadoMano estadoActual;
    private String jugadorGanador;
    private Figura figuraGanadora;
    ArrayList<Jugador> jugadoresEnMano;

    public ArrayList<Jugador> getJugadoresEnMano() {
        return jugadoresEnMano;
    }

    public void setJugadoresEnMano(ArrayList<Jugador> jugadoresEnMano) {
        this.jugadoresEnMano = jugadoresEnMano;
    }

    public Mano() {
        
        this.numero = s_ultNumero++;
        this.jugadoresEnMano = new ArrayList();
    }

    public String getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(String jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(int totalApostado) {
        this.totalApostado = totalApostado;
    }

    public EstadoMano getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoMano EstadoMano) {
        this.estadoActual = EstadoMano;
    }

     public void ActualizarEstado(int i){
        if(i==1){
        this.estadoActual=EstadoMano.Terminada;
        }
        
    }
     
     public void EliminarJugador(Jugador jugador){
        
        this.jugadoresEnMano.remove(jugador);
            
        
    }
     @Override
    public String toString() {
        return "Mano: " +numero + " Jugadores Actuales: "+ /*jugadores.size()+*/" - Total Apostado: "+totalApostado+ " - Estado: "+ estadoActual+" - Jugador Ganador: "+jugadorGanador +" - Figura Ganadaora: "+ figuraGanadora ;
    }
    
    
}
