/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Carta;
import Dominio.Figura;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HOLA
 */
public interface PokerView {
       public void mostrarJugadoresEnMesa(List<Jugador> nombresJugadores);
      public void mostrarMensaje(String msg);
    public void cargarSiguientePantalla();
    public void cargarInfo(Jugador jugador,Mesa mesa);
    public void cargarCartas(ArrayList<Carta> carta);
    public void cambiarVistaPagar(Double apuesta);
 public void mostrarFiguras(List<Figura> figuras);
 public void HabilitarBoton();
 //public void cambiarCartas();

    
}
