/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Carta;
import Dominio.EstadoJugador;
import Dominio.EstadoMano;
import Dominio.EventoFachada;
import Dominio.Fachada;
import Dominio.Figura;
import Dominio.Mano;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import java.util.ArrayList;
import java.util.List;
import panelCartasPoker.CartaPoker;
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
    
  private ArrayList<CartaPoker> cartasACambiar=new ArrayList<>();
    
   
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
        jugador.setEstadoActual(EstadoJugador.Apuesta_iniciada);
        vista.mostrarMensaje("Apuesta realizada");
        mesa.getManoActiva().setEstadoActual(EstadoMano.Apuesta_iniciada);
        
            
            }else if(mesa.getManoActiva().getEstadoActual().equals(EstadoMano.Apuesta_iniciada)){
         
            mesa.ActualizarPozo(true, mesa.getApuestaActual());
            jugador.ActualizarSaldo(false, mesa.getApuestaActual());
             jugador.setEstadoActual(EstadoJugador.Apuesta_pagada);
            vista.mostrarMensaje("Pago realizada");
            
            }
          
            
          
        }
         mesa.ValidarEstadosJugador();
    }
    
    
  public void descartarYRepartirCartas(){
    
      if(cartasACambiar.size()<1){
          vista.mostrarMensaje("No ha seleccionado ninguna carta");
      
      }else{
      
      for(CartaPoker carta:cartasACambiar){
        if(jugador.getCartasMano().contains(carta)){
              jugador.EliminarCartasDelMazo(carta);
          }
      }
       
      ArrayList<Carta> nuevasCartas = mesa.repartirCartas( mesa.getMazoAux().getCartasMazo(), cartasACambiar.size());
        
    for (Carta nueva : nuevasCartas) {
        jugador.AgregarCartasAlMazo(nueva);
    }
       cartasACambiar.clear();
    vista.cargarCartas(jugador.getCartasMano());
    vista.mostrarMensaje("Se han cambiado las cartas seleccionadas.");
  
  }}
  
  

  
  public void conseguirCartas(CartaPoker carta){
  cartasACambiar.add(carta);
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
         if (evento.equals(EventoFachada.HABILITAR_BOTON)) {
            vista.HabilitarBoton();
        }
         
          if (evento.equals(EventoFachada.NUEVAS_CARTAS)) {
            vista.CargarFiguraActual();
        }
    }
      
    public void pasar(){

      if(mesa.getApuestaActual()!=null){
      mesa.getManoActiva().EliminarJugador(jugador);
     
      }
    }
    
    
    
    
     
    public String FiguraActual(){
            return jugador.getFiguraActual().determinarFigura(jugador.getCartasMano(),jugador);


    
    }
    
    public void procesarMano(){

      if(mesa.getManoActiva().getJugadoresEnMano().size()<2){
      mesa.getManoActiva().ActualizarEstado(1);
      Jugador jugadorEnMano = mesa.getManoActiva().getJugadoresEnMano().getFirst();
      mesa.getManoActiva().setJugadorGanador(jugadorEnMano);
      jugadorEnMano.ActualizarSaldo(true,pagoPozo());
      if(jugadorEnMano.equals(jugador)){
      vista.mostrarMensaje("GANASTE " +pagoPozo()+"!!!" );
      }
      agregarMano(mesa);
      }else if(TodosPasaron()){
          agregarMano(mesa);
      }else if(SePagaApuesta()){
          Jugador jugadorGanador = GanadorDeMano(mesa.getManoActiva().getJugadoresEnMano());
      }
      }
      
    
    public Jugador GanadorDeMano(ArrayList<Jugador> jugadores){
       Jugador ganador = 
    }
    
    public boolean SePagaApuesta(){
        boolean ret = false;
        int contador = 0;
         for(Jugador j :mesa.getJugadores()){
            if(j.getEstadoActual().equals(EstadoJugador.Apuesta_pagada)){
              contador++;
            }else if(j.getEstadoActual().equals(EstadoJugador.No_pago_apuesta)){
              mesa.getManoActiva().getJugadoresEnMano().remove(j);
            }
          }
         if(contador>0){
             ret=true;
         }
        return ret;
    }
    
    public boolean TodosPasaron(){
        boolean ret = false;
        for(Jugador j :mesa.getJugadores()){
            if(j.getEstadoActual().equals(EstadoJugador.No_pago_apuesta)){
              ret = true;
            }
          }
        return ret;
    }
      public Double pagoPozo(){
          
          return mesa.pagarPozo();
      }

      public void InicializarEstadoJugador(ArrayList<Jugador> jugadores){
          for(Jugador j :jugadores){
              j.setEstadoActual(EstadoJugador.Accion_pendiente);
          }
      }
      
    public void agregarMano(Mesa mesa) {
        //mesa.setPozo(0.0);
        jugador.setEstadoActual(EstadoJugador.Accion_pendiente);
        if(mesa.getManoActiva()==null){
        Mano m = fachada.agregarMano( mesa);
        m.setJugadoresEnMano(mesa.getJugadores());
        InicializarEstadoJugador(mesa.getJugadores());
        mesa.getManoActiva().setEstadoActual(EstadoMano.Esperando_apuesta);
        vista.mostrarMensaje("Mano numero"+m.getNumero());
      }else{
      
      if(mesa.getManoActiva().getEstadoActual().equals(EstadoMano.Terminada)){
        Mano m = fachada.agregarMano( mesa);
         m.setJugadoresEnMano(mesa.getJugadores());
        
        mesa.getManoActiva().setEstadoActual(EstadoMano.Esperando_apuesta);
        vista.mostrarMensaje("Mano numero"+m.getNumero());
      
      }
}
        
    }
    
    
    
    
    
    
    
     public void conseguirFiguras(){
     
     List<Figura> figuras= fachada.getFiguras();
     vista.mostrarFiguras(figuras);
     
     }
   
      public void repartirCartas(Mesa mesa,ArrayList<Carta> carta){
          ArrayList<Carta> cartasBarajadas= mesa.getMazo().barajarMazo(carta);
          ArrayList<Carta> cartas =mesa.repartirCartas(cartasBarajadas,5);
            
            mesa.getMazoAux().setCartasMazo(cartasBarajadas);
            for (Carta c : cartas) {
        
              mesa.getMazoAux().getCartasMazo().remove(c);// Usando el constructor de CartaPoker
            }
        
           jugador.setCartasMano(cartas);      
           
          vista.cargarCartas(cartas);
          
     }
          
    }
    
    
    
    