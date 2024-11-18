/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Carta;
import Dominio.Escalera;
import Dominio.EstadoJugador;
import Dominio.EstadoMano;
import Dominio.EventoFachada;
import Dominio.Fachada;
import Dominio.Figura;
import Dominio.Mano;
import Dominio.Mesa;
import Dominio.Par;
import Dominio.Pierna;
import Dominio.Poker;
import Dominio.UnaCarta;
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
    private Mano mano;
    
  private ArrayList<CartaPoker> cartasACambiar=new ArrayList<>();
    
   
    public PokerController(PokerView vista,Jugador jugador,Mesa mesa) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.jugador=jugador;
        this.mesa=mesa;
        this.mano = mesa.getManoActiva();
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
            
            if(mesa.ConseguirEstadoMano(EstadoMano.Esperando_apuesta)){
            mesa.setApuestaActual(apuesta);
           
            jugador.ActualizarSaldo(false, apuesta);
            jugador.setEstadoActual(EstadoJugador.Apuesta_iniciada);
            vista.mostrarMensaje("Apuesta realizada");
            mesa.ActualizarEstadoMano(2);
            mesa.apostar(apuesta);
        
            
            }else if(mesa.ConseguirEstadoMano(EstadoMano.Apuesta_iniciada)){
         
               PagarApuesta();
            
            }
   
        }
        
         if(mesa.ValidarEstadosJugador()){
             mesa.ActualizarEstadoMano(3);
             mesa.verificarYAvisarEstadosJugador();
         }
         
    }
    
    
    public void PagarApuesta(){
     mesa.ActualizarPozo(true, mesa.getApuestaActual());
            jugador.ActualizarSaldo(false, mesa.getApuestaActual());
             jugador.setEstadoActual(EstadoJugador.Apuesta_pagada);
            vista.mostrarMensaje("Pago realizada");
    
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
    int cartasCambiadas =cartasACambiar.size();
       cartasACambiar.clear();
    
           vista.cargarCartas(jugador.getCartasMano());
       
      vista.mostrarMensaje("Pediste "+cartasCambiadas+" cartas nuevas.");
      
      jugador.setEstadoActual(EstadoJugador.Ya_Pidio_Cartas);
  
      
      String figuraJugador = jugador.DeterminarFigura();
      if(figuraJugador.equals("Poker")){
          jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Poker()));
      }
      if(figuraJugador.equals("Escalera")){
         jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Escalera()));
      }
      if(figuraJugador.equals("Par")){
   jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Par()));
      }
      if(figuraJugador.equals("Pierna")){
        jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Pierna()));
      }if(figuraJugador.equals("UnaCarta")){
        jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new UnaCarta()));
      }
   
      fachada.avisar(EventoFachada.NUEVAS_CARTAS);
  
  }}
  
  /*
  public boolean TodosPidiendoCartas(){
      
      for(Jugador j : mesa.getManoActiva().getJugadoresEnMano()){
          if(!j.isPidiendoCartas()){
              return false;
          }
      }
      return true;
          
  }*/
  
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
            vista.CargarFiguraActual();
        }
        
        if (evento.equals(EventoFachada.NUEVA_APUESTA)) {
            vista.cambiarVistaPagar(mesa.getApuestaActual());
            vista.cargarInfo(jugador, mesa);
            vista.CargarFiguraActual();
            this.VerSiTodosPasaron();
        }
         if (evento.equals(EventoFachada.HABILITAR_BOTON)) {
            vista.HabilitarBoton();
        }
         
          if (evento.equals(EventoFachada.NUEVAS_CARTAS)) {
            vista.CargarFiguraActual();
            VerSiTodosPasaron();
            
        }
            if (evento.equals(EventoFachada.ACCION_MANO)) {
            this.VerSiTodosPasaron();
        }
    }
      
    public void pasar(){
        
     vista.mostrarMensaje("Se ha pasado");
      mesa.EliminarJugadorMano( jugador);
      
    }
    
    
    public void VerSiTodosPasaron(){
     
     if((TodosPasaron() || mano.getEstadoActual() == EstadoMano.Terminada) && mano.getJugadorGanador() == null){
            
            mesa.PagarLuz(jugador);
            mano.setEstadoActual(EstadoMano.Terminada);
          agregarMano(mesa); 
          repartirCartas(mesa,mesa.getMazo().getCartasMazo());
      }
     else if(UnoSoloAposto() || mano.getEstadoActual() == EstadoMano.Terminada || TodosPidieronCartas()){
         if(jugador.equals(mano.getJugadorGanador())){
         mano.getJugadorGanador().ActualizarSaldo(true,pagoPozo());
          mesa.setPozo(mesa.getApuestaBase());
          mesa.PagarLuz(jugador);
         }
         mano.setEstadoActual(EstadoMano.Terminada);
         vista.mostrarMensaje("Gano el jugador: "+mano.getJugadorGanador().getNombreCompleto());
         vista.cambiarVistaApostar();
         agregarMano(mesa);    
         repartirCartas(mesa,mesa.getMazo().getCartasMazo());
         vista.cargarInfo(jugador, mesa);
     }
   
    }
    
    public boolean TodosPidieronCartas(){
        ArrayList<Jugador> jugadoresEnMano = new ArrayList<Jugador>();
        int contadorPidieronCartas = 0;
        int contadorNoAposto = 0;
        
        for(Jugador j:mesa.getJugadores()){
            if(j.getEstadoActual() == EstadoJugador.Ya_Pidio_Cartas){
            contadorPidieronCartas++;
            jugadoresEnMano.add(j);
            }else if(j.getEstadoActual() == EstadoJugador.No_pago_apuesta){
                        contadorNoAposto++;
            }
        }
        
        if(contadorPidieronCartas+contadorNoAposto == mesa.getCantidadJugadores()){
            Jugador jugadorGanador = fachada.DeterminarFiguraGanadora(jugadoresEnMano);
            mano.setJugadorGanador(jugadorGanador);
            return true;
        
        }
        return false;
    
   
    }
    
    
    public boolean UnoSoloAposto(){
          
        int contadorPagados = 0;
        int contadorNoPagados = 0;
        Jugador jAux = null;
         for(Jugador j :mesa.getJugadores()){
            if(j.ConseguirEstado(EstadoJugador.Apuesta_iniciada)){
              contadorPagados++;
              jAux = j;
            }else if(j.ConseguirEstado(EstadoJugador.No_pago_apuesta)){
             contadorNoPagados++;
            }
          }
        
        if(contadorPagados == 1 && (contadorPagados+contadorNoPagados) == mesa.getCantidadJugadores()){
            mano.setJugadorGanador(jAux);
            return true;
        }else{
            return false;
        }
    }
    
    
     
    public String FiguraActual(){
            return jugador.DeterminarFigura();
    }
    
    public void procesarMano(){

      if(mesa.CantidadJugadoresEnMano()<2){
      mesa.ActualizarEstadoMano(1);
      Jugador jugadorEnMano = mesa.UnicoJugadorEnMesa();
      mesa.SetearJugadorGanadorMano(jugadorEnMano);
      jugadorEnMano.ActualizarSaldo(true,pagoPozo());
      if(jugadorEnMano.equals(jugador)){
      vista.mostrarMensaje("GANASTE $" +pagoPozo()+"!!!" );
      }
      agregarMano(mesa);
      
      
      }/*else if(SePagaApuesta()){
        GanadorMano();
      }*/
      }
      
 
    public void GanadorMano() {
 
    // Obtén la lista de jugadores activos en la mano
    ArrayList<Jugador> jugadores = mesa.getManoActiva().getJugadoresEnMano();

    Jugador jugadorGanador = fachada.DeterminarFiguraGanadora(jugadores);

    // Mostrar el ganador en la vista
    if (jugadorGanador != null) {
        vista.mostrarMensaje("El ganador de la mano es: " + jugadorGanador.getNombreCompleto() +
                " con la figura " + jugadorGanador.getFiguraActual().getNombre());
        mesa.SetearJugadorGanadorMano(jugadorGanador);
    } else {
        vista.mostrarMensaje("No se pudo determinar un ganador.");
    }
}
    
   
    
    public boolean TodosPasaron(){
       boolean ret=true;
        for(Jugador j :mesa.getJugadores()){
              ret = ret && j.ConseguirEstado(EstadoJugador.No_pago_apuesta);
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
       
        
        if(mesa.getManoActiva()==null){
        Mano m = fachada.agregarMano( mesa);
        m.setJugadoresEnMano(mesa.getJugadores());
        InicializarEstadoJugador(mesa.getJugadores());
        mesa.getManoActiva().setEstadoActual(EstadoMano.Esperando_apuesta);
        this.mano =  mesa.getManoActiva();
        vista.mostrarMensaje("Mano numero"+m.getNumero());
      }else{
      
      if(mano.getEstadoActual() == EstadoMano.Terminada){
           Mano m;
          if(mesa.getManoActiva().getEstadoActual() == EstadoMano.Terminada){
          m = fachada.agregarMano(mesa);
          m.setJugadoresEnMano(mesa.getJugadores());
          }else{
           m = mesa.getManoActiva();
          }
       
         
        
        m.setEstadoActual(EstadoMano.Esperando_apuesta);
         this.mano = m;
        vista.mostrarMensaje("Mano numero"+m.getNumero());
       
      }
}jugador.setEstadoActual(EstadoJugador.Accion_pendiente);
        vista.CargarMano(mesa);
          String figuraJugador = jugador.DeterminarFigura();
      if(figuraJugador.equals("Poker")){
          jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Poker()));
      }
      if(figuraJugador.equals("Escalera")){
         jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Escalera()));
      }
      if(figuraJugador.equals("Par")){
   jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Par()));
      }
      if(figuraJugador.equals("Pierna")){
        jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Pierna()));
      }if(figuraJugador.equals("UnaCarta")){
        jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new UnaCarta()));
      }
        
    }
    
    
    public int getNumMano(){
    return mesa.getManoActiva().getNumero();
    
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
        
              mesa.EliminarCartasMazoAux(c);
            }
        
           jugador.setCartasMano(cartas);     
           
           
           String figuraJugador = jugador.DeterminarFigura();
      if(figuraJugador.equals("Poker")){
          jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Poker()));
      }
      if(figuraJugador.equals("Escalera")){
         jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Escalera()));
      }
      if(figuraJugador.equals("Par")){
   jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Par()));
      }
      if(figuraJugador.equals("Pierna")){
        jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new Pierna()));
      }if(figuraJugador.equals("UnaCarta")){
        jugador.setFiguraActual(new Figura(figuraJugador, jugador.getCartasMano(),new UnaCarta()));
      }
           
          vista.cargarCartas(cartas);
          
     }
          
    }
    
    
    
    