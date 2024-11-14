/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

/**
 *
 * @author bsout
 */
public class Carta implements CartaPoker{
     
    private int numero;
    private String palo;
    private boolean visible = true;

    public Carta(int num, String palo) {
        this.numero = num;
        this.palo = palo;
    }
    
    @Override
    public int getValorCarta() {
        return numero;
    }

    @Override
    public String getPaloCarta() {
        return palo;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Carta Ejemplo{" + "numero=" + numero + ", palo=" + palo + ", visible=" + visible + '}';
    }
    
    
    
    public ArrayList<CartaPoker> agregarCartaAArray(ArrayList<CartaPoker> cartas){
   
 cartas.add(new Carta(1, CartaPoker.CORAZON));
cartas.add(new Carta(2, CartaPoker.CORAZON));
cartas.add(new Carta(3, CartaPoker.CORAZON));
cartas.add(new Carta(4, CartaPoker.CORAZON));
cartas.add(new Carta(5, CartaPoker.CORAZON));
cartas.add(new Carta(6, CartaPoker.CORAZON));
cartas.add(new Carta(7, CartaPoker.CORAZON));
cartas.add(new Carta(8, CartaPoker.CORAZON));
cartas.add(new Carta(9, CartaPoker.CORAZON));
cartas.add(new Carta(10, CartaPoker.CORAZON));
cartas.add(new Carta(11, CartaPoker.CORAZON));
cartas.add(new Carta(12, CartaPoker.CORAZON));
cartas.add(new Carta(13, CartaPoker.CORAZON));

// Diamantes
cartas.add(new Carta(1, CartaPoker.DIAMANTE));
cartas.add(new Carta(2, CartaPoker.DIAMANTE));
cartas.add(new Carta(3, CartaPoker.DIAMANTE));
cartas.add(new Carta(4, CartaPoker.DIAMANTE));
cartas.add(new Carta(5, CartaPoker.DIAMANTE));
cartas.add(new Carta(6, CartaPoker.DIAMANTE));
cartas.add(new Carta(7, CartaPoker.DIAMANTE));
cartas.add(new Carta(8, CartaPoker.DIAMANTE));
cartas.add(new Carta(9, CartaPoker.DIAMANTE));
cartas.add(new Carta(10, CartaPoker.DIAMANTE));
cartas.add(new Carta(11, CartaPoker.DIAMANTE));
cartas.add(new Carta(12, CartaPoker.DIAMANTE));
cartas.add(new Carta(13, CartaPoker.DIAMANTE));

// Tréboles
cartas.add(new Carta(2, CartaPoker.TREBOL));
cartas.add(new Carta(3, CartaPoker.TREBOL));
cartas.add(new Carta(4, CartaPoker.TREBOL));
cartas.add(new Carta(5, CartaPoker.TREBOL));
cartas.add(new Carta(6, CartaPoker.TREBOL));
cartas.add(new Carta(7, CartaPoker.TREBOL));
cartas.add(new Carta(8, CartaPoker.TREBOL));
cartas.add(new Carta(9, CartaPoker.TREBOL));
cartas.add(new Carta(10, CartaPoker.TREBOL));
cartas.add(new Carta(11, CartaPoker.TREBOL));
cartas.add(new Carta(12, CartaPoker.TREBOL));
cartas.add(new Carta(13, CartaPoker.TREBOL));

// Picas
cartas.add(new Carta(1, CartaPoker.PIQUE));
cartas.add(new Carta(2, CartaPoker.PIQUE));
cartas.add(new Carta(3, CartaPoker.PIQUE));
cartas.add(new Carta(4, CartaPoker.PIQUE));
cartas.add(new Carta(5, CartaPoker.PIQUE));
cartas.add(new Carta(6, CartaPoker.PIQUE));
cartas.add(new Carta(7, CartaPoker.PIQUE));
cartas.add(new Carta(8, CartaPoker.PIQUE));
cartas.add(new Carta(9, CartaPoker.PIQUE));
cartas.add(new Carta(10, CartaPoker.PIQUE));
cartas.add(new Carta(11, CartaPoker.PIQUE));
cartas.add(new Carta(12, CartaPoker.PIQUE));
cartas.add(new Carta(13, CartaPoker.PIQUE));
    
    
    
    
    
    return cartas;
    
    }
    
    
}


