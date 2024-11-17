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

    public Par(Figura figura) {
        super("Par");
    }

    @Override
    public boolean esFigura(ArrayList<Carta> cartas){
        for(int i=0;i<cartas.size();i++){
            int contador=0;
            
            for(int j=i+1;j<cartas.size();j++){
                if(cartas.get(i).getValorCarta()==(cartas.get(j).getValorCarta())){
                    contador++;
                
                }
            }
            if(contador==1){
            return true;
            }
        
        }
    return false;
    }
    
    @Override
public int valorFigura(ArrayList<Carta> cartas) {
    for (Carta carta : cartas) {
        int count = 0;
        for (Carta otraCarta : cartas) {
            if (carta.getValorCarta()== otraCarta.getValorCarta()) {
                count++;
            }
        }
        if (count == 2) {
            return carta.getValorCarta(); // Valor del par
        }
    }
    return 0; // No hay Par
}
    
    
    
}
