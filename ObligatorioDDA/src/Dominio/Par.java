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
public class Par extends tipoFigura{

    public Par() {
        super("Par");
    }

   @Override
public boolean esFigura(ArrayList<Carta> cartas) {
    for (int i = 0; i < cartas.size(); i++) {
        int contador = 0;
        for (int j = 0; j < cartas.size(); j++) {
            if (i != j && cartas.get(i).getValorCarta() == cartas.get(j).getValorCarta()) {
                contador++;
            }
        }
        if (contador >= 1) { // Hay al menos un par
            return true;
        }
    }
    return false; // No hay pares
}
    
    @Override
public int valorFigura(ArrayList<Carta> cartas) {
    int parMasGrande = -1; // Indica que no hay par

    for (int i = 0; i < cartas.size(); i++) {
        int contador = 0;
        for (int j = 0; j < cartas.size(); j++) {
            if (i != j && cartas.get(i).getValorCarta() == cartas.get(j).getValorCarta()) {
                contador++;
            }
        }
        if (contador >= 1) { // Hay un par
            parMasGrande = Math.max(parMasGrande, cartas.get(i).getValorCarta());
        }
    }

    return parMasGrande; // Retorna el valor del par más grande o -1 si no hay par
}
    
    
    
}
