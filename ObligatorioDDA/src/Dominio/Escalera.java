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
public class Escalera extends tipoFigura{

    public Escalera() {
        super("Escalera");
    }

   @Override
    public boolean esFigura(ArrayList<Carta> cartas) {
       
        cartas.sort(null);

        
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getValorCarta()+ 1 != cartas.get(i + 1).getValorCarta()) {
                return false; 
            }
        }
        return true; 
    }
    
    @Override
public int valorFigura(ArrayList<Carta> cartas) {
    return cartas.get(cartas.size() - 1).getValorCarta();
    
}
}
