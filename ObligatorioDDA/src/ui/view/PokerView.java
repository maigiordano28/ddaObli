/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import java.util.ArrayList;
import java.util.List;
import panelCartasPoker.CartaPoker;

/**
 *
 * @author HOLA
 */
public interface PokerView {
       public void mostrarJugadoresEnMesa(List<Jugador> nombresJugadores);
      public void mostrarMensaje(String msg);
    public void cargarSiguientePantalla();
    public void cargarInfo(Jugador jugador,Mesa mesa);
    public void cargarCartas(ArrayList<CartaPoker> carta);
}
