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
public class UnaCarta extends tipoFigura {
    
      int jerarquia = 0;
    public UnaCarta() {
        super("UnaCarta");}

   

    @Override
    public int getJerarquia() {
 return this.jerarquia;    }

    @Override
    public boolean esFigura(ArrayList<Carta> cartas) {
 for(int i=0;i<cartas.size();i++){
            int contador=0;
            
            for(int j=0;j<cartas.size();j++){
                if(cartas.get(i).getValorCarta()==(cartas.get(j).getValorCarta())){
                    contador++;
                
                }
            }
            if(contador==0){
            return true;
            }
        
        }
    return false;    }

    @Override
    public int valorFigura(ArrayList<Carta> cartas) {
        
        Carta cartaMayor = cartas.getFirst();
 for (Carta carta : cartas) {
        
     if(carta.getValorCarta() > cartaMayor.getValorCarta()){
         cartaMayor = carta;
     }
        
    }
    return cartaMayor.getValorCarta(); // No hay Poker
}    }
    



