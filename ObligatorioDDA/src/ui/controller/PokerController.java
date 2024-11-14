/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Carta;
import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Exceptions.ManoException;
import Dominio.Fachada;
import Dominio.Mano;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import iuswing.Poker;
import java.util.ArrayList;
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
   
    

    public PokerController(PokerView vista) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        
        Fachada.getInstancia().agregar(this);
    }

 
    
    @Override
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoFachada.NUEVO_MESA_INICIADA)) {
            vista.mostrarJugadoresEnMesa();
        }
        
          if (evento.equals(EventoFachada.NUEVA_INFO)) {
            vista.cargarInfo();
        }
     
    }

    public void agregarMano(Mesa mesa) {
      
        Mano mano = fachada.agregarMano( mesa);
        vista.mostrarMensaje("Mano numero"+mano.getNumero());
    
       
        
    }
     
      public void cargarCartas(){
          ArrayList<CartaPoker> cartas = new ArrayList();
        cartas.add(new Carta(1,CartaPoker.CORAZON));
        cartas.add(new Carta(1,CartaPoker.DIAMANTE));
        cartas.add(new Carta(1,CartaPoker.TREBOL));
        cartas.add(new Carta(1,CartaPoker.PIQUE));
        cartas.add(new Carta(11,CartaPoker.PIQUE));
        
        Poker dialogo = new Poker(null, false);
        dialogo.setVisible(true);  
       
        dialogo.cargarCartas(cartas);
        
     
        cartas.set(0, new Carta(10,CartaPoker.PIQUE));
        dialogo.cargarCartas(cartas);
        cartas.set(0, new Carta(9,CartaPoker.PIQUE));
        dialogo.cargarCartas(cartas);

      }
    }
    
    
    
    