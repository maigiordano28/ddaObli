/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import java.util.List;

/**
 *
 * @author HOLA
 */
public interface InicioJugadorView {
     public void mostrarMesasCreadas(List<Mesa> mesas);
      public void mostrarMensaje(String msg);
    public void cargarSiguientePantalla(Mesa mesaSeleccionada,Jugador jugador);
    public void cargarSaldo(Jugador jugador);
    public void salir();
}
