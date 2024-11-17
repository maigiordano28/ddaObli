/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Carta;
import Dominio.EstadoMano;
import Dominio.EstadoMesa;
import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Exceptions.ManoException;
import Dominio.Exceptions.PokerException;
import Dominio.Fachada;
import Dominio.Mano;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import iuswing.Poker;
import java.util.ArrayList;
import java.util.List;
import panelCartasPoker.CartaPoker;
import ui.view.InicioJugadorView;
import ui.view.PokerView;

/**
 *
 * @author HOLA
 */
public class PokerController implements observador{
    Fachada fachada;
    PokerView vista;
    private Jugador jugador;
    private Mesa mesa;
    //private Mano mano;
    
   
    public PokerController(PokerView vista,Jugador jugador,Mesa mesa) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.jugador=jugador;
        this.mesa=mesa;
        Fachada.getInstancia().agregar(this);
      
    }

   
    public void DescontarLuz(){
        mesa.PagarLuz(jugador);
        
    }
    
    public Mano getMano(){
        return mesa.getManoActiva();
    }
    public void apostar(Double apuesta){
        if(jugador.getSaldoInicial()<apuesta){
        vista.mostrarMensaje("Saldo Insuficiente");
        }else{
            
            if(mesa.getManoActiva().getEstadoActual().equals(EstadoMano.Esperando_apuesta)){
            mesa.setApuestaActual(apuesta);
            mesa.apostar(apuesta);
        jugador.ActualizarSaldo(false, apuesta);
        vista.mostrarMensaje("Apuesta realizada");
        mesa.getManoActiva().setEstadoActual(EstadoMano.Apuesta_iniciada);
            
            }else if(mesa.getManoActiva().getEstadoActual().equals(EstadoMano.Apuesta_iniciada)){
         
            mesa.ActualizarPozo(true, mesa.getApuestaActual());
            jugador.ActualizarSaldo(false, mesa.getApuestaActual());
            vista.mostrarMensaje("Pago realizada");
            
            }
        
        }
    }
  
    
    @Override
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoFachada.NUEVO_MESA_INICIADA)) {
            vista.mostrarJugadoresEnMesa(mesa.getJugadores());
        }
        
        if (evento.equals(EventoFachada.NUEVA_INFO)) {
            vista.cargarInfo(jugador, mesa);
        }
        
        if (evento.equals(EventoFachada.NUEVA_APUESTA)) {
            vista.cambiarVistaPagar(mesa.getApuestaActual());
        }
     
    }

    public void agregarMano(Mesa mesa) {
      
        Mano m = fachada.agregarMano( mesa);
        
        mesa.getManoActiva().setEstadoActual(EstadoMano.Esperando_apuesta);
        vista.mostrarMensaje("Mano numero"+m.getNumero());
    
       
        
    }
     
   
      public void repartirCartas(Mesa mesa,ArrayList<CartaPoker> carta){
          ArrayList<CartaPoker> cartasBarajadas= mesa.getMazo().barajarMazo(carta);
           ArrayList<CartaPoker> cartas =mesa.repartirCartas(cartasBarajadas);
        
          vista.cargarCartas(cartas);
          
     }
          
    }
    
    
    
    