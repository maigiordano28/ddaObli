/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author HOLA
 */
public class Mazo {
    
    ArrayList<Carta> cartasMazo;

    public Mazo() {
        this.cartasMazo = AgregarCartasAMazo();
        
        
      
    }

    public ArrayList<Carta> getCartasMazo() {
        return cartasMazo;
    }
       
    public ArrayList<Carta> barajarMazo(ArrayList<Carta> cartas) {
        Random random = new Random();
        for (int i = 0; i < cartas.size(); i++) {
            // Elige un índice al azar para intercambiar con el índice actual
            int randomIndex = random.nextInt(cartas.size());
            
            // Intercambia cartas
            Carta temp = cartas.get(i);
            cartas.set(i, cartas.get(randomIndex));
            cartas.set(randomIndex, temp);
        }
        return cartas;
    }
    
    public ArrayList<Carta> AgregarCartasAMazo(){
        ArrayList<Carta>cartas =new ArrayList<Carta>();
        cartas.add(new Carta(1, Carta.CORAZON));
cartas.add(new Carta(2, Carta.CORAZON));
cartas.add(new Carta(3, Carta.CORAZON));
cartas.add(new Carta(4, Carta.CORAZON));
cartas.add(new Carta(5, Carta.CORAZON));
cartas.add(new Carta(6, Carta.CORAZON));
cartas.add(new Carta(7, Carta.CORAZON));
cartas.add(new Carta(8, Carta.CORAZON));
cartas.add(new Carta(9, Carta.CORAZON));
cartas.add(new Carta(10, Carta.CORAZON));
cartas.add(new Carta(11, Carta.CORAZON));
cartas.add(new Carta(12, Carta.CORAZON));
cartas.add(new Carta(13, Carta.CORAZON));

// Diamantes
cartas.add(new Carta(1, Carta.DIAMANTE));
cartas.add(new Carta(2, Carta.DIAMANTE));
cartas.add(new Carta(3, Carta.DIAMANTE));
cartas.add(new Carta(4, Carta.DIAMANTE));
cartas.add(new Carta(5, Carta.DIAMANTE));
cartas.add(new Carta(6, Carta.DIAMANTE));
cartas.add(new Carta(7, Carta.DIAMANTE));
cartas.add(new Carta(8, Carta.DIAMANTE));
cartas.add(new Carta(9, Carta.DIAMANTE));
cartas.add(new Carta(10, Carta.DIAMANTE));
cartas.add(new Carta(11, Carta.DIAMANTE));
cartas.add(new Carta(12, Carta.DIAMANTE));
cartas.add(new Carta(13, Carta.DIAMANTE));

// Treboles
cartas.add(new Carta(2, Carta.TREBOL));
cartas.add(new Carta(3, Carta.TREBOL));
cartas.add(new Carta(4, Carta.TREBOL));
cartas.add(new Carta(5, Carta.TREBOL));
cartas.add(new Carta(6, Carta.TREBOL));
cartas.add(new Carta(7, Carta.TREBOL));
cartas.add(new Carta(8, Carta.TREBOL));
cartas.add(new Carta(9, Carta.TREBOL));
cartas.add(new Carta(10, Carta.TREBOL));
cartas.add(new Carta(11, Carta.TREBOL));
cartas.add(new Carta(12, Carta.TREBOL));
cartas.add(new Carta(13, Carta.TREBOL));

// Picas
cartas.add(new Carta(1, Carta.PIQUE));
cartas.add(new Carta(2, Carta.PIQUE));
cartas.add(new Carta(3, Carta.PIQUE));
cartas.add(new Carta(4, Carta.PIQUE));
cartas.add(new Carta(5, Carta.PIQUE));
cartas.add(new Carta(6, Carta.PIQUE));
cartas.add(new Carta(7, Carta.PIQUE));
cartas.add(new Carta(8, Carta.PIQUE));
cartas.add(new Carta(9, Carta.PIQUE));
cartas.add(new Carta(10, Carta.PIQUE));
cartas.add(new Carta(11, Carta.PIQUE));
cartas.add(new Carta(12, Carta.PIQUE));
cartas.add(new Carta(13, Carta.PIQUE));
return cartas;
    }
    
}
