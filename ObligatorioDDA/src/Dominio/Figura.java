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
public class Figura {
    
    private String nombre;
    private ArrayList<Carta> cartas;
    private tipoFigura tipoFigura;

    public Figura(String nombre, ArrayList<Carta> cartas, tipoFigura tipoFigura) {
        this.nombre = nombre;
        this.cartas = cartas;
        this.tipoFigura = tipoFigura;
    }

    public Figura(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Figura(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public tipoFigura getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(tipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    
    
      public String determinarFigura(ArrayList<Carta> cartas ,Jugador jugador) {
        ArrayList<tipoFigura> tiposFigura = new ArrayList<>();
    
    // Agrega los diferentes tipos de figuras posibles
    tiposFigura.add(new Par());  
    tiposFigura.add(new Pierna());      
    tiposFigura.add(new Escalera()); 
    tiposFigura.add(new Poker()); 
    
        for (tipoFigura tipo : tiposFigura) {
            if (tipo.esFigura(cartas)) {
                return tipo.getNombre();
            }
        }
       
        return jugador.getNombreFigura();
    }

    
    public boolean determinarFiguraGanadora(){
    return tipoFigura.esFigura(cartas);
    }
    
    /*public Jugador DeterminarFiguraGanadora(ArrayList<Jugador> jugadores){
        int jerarquia = 0;
        Jugador jugadorGanador = null;
        for(Jugador j:jugadores){
         int jerarquiaJugador = j.GetJerarquiaFigura();

        if (jerarquiaJugador > jerarquia) {
            jerarquia = jerarquiaJugador;
            jugadorGanador = j;
        }else if(j.GetJerarquiaFigura() == jerarquia){
         /*if (compararFiguras(jugadorGanador.getCartasMano(), j.getCartasMano()) < 0) {
                jugadorGanador = j;
            }
        }
        }
        return jugadorGanador;
    }*/
    
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
    
    @Override
    public String toString() {
      return this.getNombre();
    }
}
