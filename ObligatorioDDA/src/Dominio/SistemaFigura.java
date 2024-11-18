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
public class SistemaFigura {
    
     private ArrayList<Figura> figuras=new ArrayList();

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }
    
    
    public void agregarFigura(String palo){
    this.figuras.add(new Figura(palo));
    }
    
    
       public Jugador DeterminarFiguraGanadora(ArrayList<Jugador> jugadores) {
    int jerarquiaMaxima = -1;
    Jugador jugadorGanador = null;

    for (Jugador jugadorActual : jugadores) {
        Figura figuraActual = jugadorActual.getFiguraActual();
        if (figuraActual == null) {
            // Si un jugador no tiene figura, lo omitimos de la comparación
            continue;
        }

        int jerarquiaJugador = figuraActual.getTipoFigura().getJerarquia();

        // Determinar si este jugador es el nuevo ganador provisional
        if (jerarquiaJugador > jerarquiaMaxima) {
            jerarquiaMaxima = jerarquiaJugador;
            jugadorGanador = jugadorActual;
        } else if (jerarquiaJugador == jerarquiaMaxima && jugadorGanador != null) {
            // Si hay empate en jerarquía, desempatar con el método comparar
            tipoFigura tipoFiguraGanador = jugadorGanador.getFiguraActual().getTipoFigura();
            if (tipoFiguraGanador.comparar(jugadorGanador.getCartasMano(), jugadorActual.getCartasMano()) < 0) {
                jugadorGanador = jugadorActual;
            }
        }
    }

    return jugadorGanador;

}
    
    
    
}
