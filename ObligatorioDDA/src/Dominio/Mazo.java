/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.Random;
import panelCartasPoker.CartaPoker;


/**
 *
 * @author HOLA
 */
public class Mazo {
    
    ArrayList<Carta> cartasMazo;

    public Mazo() {
        this.cartasMazo = new ArrayList<>();
        AgregarCartasAMazo();
        
      
    }

    public ArrayList<Carta> getCartasMazo() {
        return cartasMazo;
    }

    public void setCartasMazo(ArrayList<Carta> cartasMazo) {
        this.cartasMazo = cartasMazo;
    }
       
    public ArrayList<Carta> barajarMazo(ArrayList<Carta> cartas) {
        Random random = new Random();
        for (int i = 0; i < cartas.size(); i++) {
            // Elige un índice al azar para intercambiar con el índice actual
            int randomIndex = random.nextInt(cartas.size());
            
            // Intercambia cartas
            Carta temp = (Carta)cartas.get(i);
            cartas.set(i, cartas.get(randomIndex));
            cartas.set(randomIndex, temp);
        }
        return cartas;
    }
    
    public void AgregarCartasAMazo(){
      
        cartasMazo.add(new Carta(1, Carta.CORAZON));
        cartasMazo.add(new Carta(2, Carta.CORAZON));
        cartasMazo.add(new Carta(3, Carta.CORAZON));
        cartasMazo.add(new Carta(4, Carta.CORAZON));
        cartasMazo.add(new Carta(5, Carta.CORAZON));
        cartasMazo.add(new Carta(6, Carta.CORAZON));
cartasMazo.add(new Carta(7, Carta.CORAZON));
cartasMazo.add(new Carta(8, Carta.CORAZON));
cartasMazo.add(new Carta(9, Carta.CORAZON));
cartasMazo.add(new Carta(10, Carta.CORAZON));
cartasMazo.add(new Carta(11, Carta.CORAZON));
cartasMazo.add(new Carta(12, Carta.CORAZON));
cartasMazo.add(new Carta(13, Carta.CORAZON));

// Diamantes
cartasMazo.add(new Carta(1, Carta.DIAMANTE));
cartasMazo.add(new Carta(2, Carta.DIAMANTE));
cartasMazo.add(new Carta(3, Carta.DIAMANTE));
cartasMazo.add(new Carta(4, Carta.DIAMANTE));
cartasMazo.add(new Carta(5, Carta.DIAMANTE));
cartasMazo.add(new Carta(6, Carta.DIAMANTE));
cartasMazo.add(new Carta(7, Carta.DIAMANTE));
cartasMazo.add(new Carta(8, Carta.DIAMANTE));
cartasMazo.add(new Carta(9, Carta.DIAMANTE));
cartasMazo.add(new Carta(10, Carta.DIAMANTE));
cartasMazo.add(new Carta(11, Carta.DIAMANTE));
cartasMazo.add(new Carta(12, Carta.DIAMANTE));
cartasMazo.add(new Carta(13, Carta.DIAMANTE));

// Treboles
cartasMazo.add(new Carta(2, Carta.TREBOL));
cartasMazo.add(new Carta(3, Carta.TREBOL));
cartasMazo.add(new Carta(4, Carta.TREBOL));
cartasMazo.add(new Carta(5, Carta.TREBOL));
cartasMazo.add(new Carta(6, Carta.TREBOL));
cartasMazo.add(new Carta(7, Carta.TREBOL));
cartasMazo.add(new Carta(8, Carta.TREBOL));
cartasMazo.add(new Carta(9, Carta.TREBOL));
cartasMazo.add(new Carta(10, Carta.TREBOL));
cartasMazo.add(new Carta(11, Carta.TREBOL));
cartasMazo.add(new Carta(12, Carta.TREBOL));
cartasMazo.add(new Carta(13, Carta.TREBOL));

// Picas
cartasMazo.add(new Carta(1, Carta.PIQUE));
cartasMazo.add(new Carta(2, Carta.PIQUE));
cartasMazo.add(new Carta(3, Carta.PIQUE));
cartasMazo.add(new Carta(4, Carta.PIQUE));
cartasMazo.add(new Carta(5, Carta.PIQUE));
cartasMazo.add(new Carta(6, Carta.PIQUE));
cartasMazo.add(new Carta(7, Carta.PIQUE));
cartasMazo.add(new Carta(8, Carta.PIQUE));
cartasMazo.add(new Carta(9, Carta.PIQUE));
cartasMazo.add(new Carta(10, Carta.PIQUE));
cartasMazo.add(new Carta(11, Carta.PIQUE));
cartasMazo.add(new Carta(12, Carta.PIQUE));
cartasMazo.add(new Carta(13, Carta.PIQUE));
    

    
    
}
}