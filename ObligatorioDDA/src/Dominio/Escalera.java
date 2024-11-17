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
       
        for (int i = 0; i < cartas.size() - 1; i++) {
            for (int j = 0; j < cartas.size() - i - 1; j++) {
                if (cartas.get(j).getValorCarta()> cartas.get(j + 1).getValorCarta()) {
                    
                    Carta temp = cartas.get(j);
                    cartas.set(j, cartas.get(j + 1));
                    cartas.set(j + 1, temp);
                }
            }
        }

        
        for (int i = 0; i < cartas.size() - 1; i++) {
            if (cartas.get(i).getValorCarta()+ 1 != cartas.get(i + 1).getValorCarta()) {
                return false; 
            }
        }
        return true; 
    }
    
    @Override
public int valorFigura(ArrayList<Carta> cartas) {
    int maxValor = cartas.get(0).getValorCarta(); // Iniciar con el primer valor
    for (Carta carta : cartas) {
        if (carta.getValorCarta()> maxValor) {
            maxValor = carta.getValorCarta();
        }
    }
    return maxValor; // Retorna el valor más alto
}
    
}
