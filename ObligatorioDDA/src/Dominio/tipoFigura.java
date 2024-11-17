/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public abstract class tipoFigura {
    private String nombre;
    private Figura figura;

    public tipoFigura(String Nombre) {
        this.nombre = Nombre;
    }
    
    public abstract boolean esFigura(ArrayList<Carta> cartas);
    // Devuelve el valor principal de la figura (para desempate)
    public abstract int valorFigura(ArrayList<Carta> cartas);
 
public int comparard(ArrayList<Carta> cartasJugador1, ArrayList<Carta> cartasJugador2) {
    int valorJugador1 = valorFigura(cartasJugador1);
    int valorJugador2 = valorFigura(cartasJugador2);

    if (valorJugador1 != valorJugador2) {
        return Integer.compare(valorJugador1, valorJugador2); // Mayor valor gana
    } else {
        // Desempate: buscar la carta más alta considerando el palo
        Carta cartaAltaJugador1 = cartaMasAlta(cartasJugador1);
        Carta cartaAltaJugador2 = cartaMasAlta(cartasJugador2);

        if (cartaAltaJugador1.getValorCarta()== cartaAltaJugador2.getValorCarta()) {
            return Integer.compare(cartaAltaJugador1.getPaloCarta(), cartaAltaJugador2.getPaloCarta());
        } else {
            return Integer.compare(cartaAltaJugador1.getValorCarta(), cartaAltaJugador2.getValorCarta());
        }
    }
}
  

    protected Carta cartaMasAlta(ArrayList<Carta> cartas) {
    Carta cartaAlta = cartas.get(0);
    for (Carta carta : cartas) {
        if (carta.getValorCarta()> cartaAlta.getValorCarta()||
            (carta.getValorCarta()== cartaAlta.getValorCarta()&&
             carta.getPaloCarta()> cartaAlta.getPaloCarta())) {
            cartaAlta = carta;
        }
    }
    return cartaAlta;
}


}
