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

    public String getNombre() {
        return nombre;
    }

    public Figura getFigura() {
        return figura;
    }
    
    public abstract boolean esFigura(ArrayList<Carta> cartas);
    // Devuelve el valor principal de la figura (para desempate)
    public abstract int valorFigura(ArrayList<Carta> cartas);
 
public int comparar(ArrayList<Carta> cartasJugador1, ArrayList<Carta> cartasJugador2) {
        int valorJugador1 = valorFigura(cartasJugador1);
        int valorJugador2 = valorFigura(cartasJugador2);

        if (valorJugador1 != valorJugador2) {
            return Integer.compare(valorJugador1, valorJugador2); // Mayor valor gana
        } else {
            // Desempate: buscar la carta más alta considerando el palo
            Carta cartaAltaJugador1 = cartaMasAlta(cartasJugador1);
            Carta cartaAltaJugador2 = cartaMasAlta(cartasJugador2);

            // Compara por valor de carta primero
            if (cartaAltaJugador1.getValorCarta() == cartaAltaJugador2.getValorCarta()) {
                // Si los valores son iguales, desempatar por el palo
                return Integer.compare(obtenerValorPalo(cartaAltaJugador1), obtenerValorPalo(cartaAltaJugador2));
            } else {
                return Integer.compare(cartaAltaJugador1.getValorCarta(), cartaAltaJugador2.getValorCarta());
            }
        }
    }
  

    protected Carta cartaMasAlta(ArrayList<Carta> cartas) {
        Carta cartaAlta = cartas.get(0);
        for (Carta carta : cartas) {
            if (carta.getValorCarta() > cartaAlta.getValorCarta() ||
                (carta.getValorCarta() == cartaAlta.getValorCarta() &&
                 obtenerValorPalo(carta) > obtenerValorPalo(cartaAlta))) {
                cartaAlta = carta;
            }
        }
        return cartaAlta;
    }

    // Método que asigna un valor a cada palo
    private int obtenerValorPalo(Carta carta) {
        switch (carta.getPaloCarta()) {
            case "corazon":
                return 4;  // Corazón tiene mayor valor
            case "diamante":
                return 3;
            case "trebol":
                return 2;
            case "pica":
                return 1;  // Pica tiene menor valor
            default:
                throw new IllegalArgumentException("Palo no reconocido: " + carta.getPaloCarta());
        }
    }
}



