/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo;

import panelCartasPoker.CartaPoker;

/**
 *
 * @author PC
 */

//NOTA: Esta clase es solo un ejemplo, no es buena practica utilizarla en su obligatorio

public class CartaEjemplo implements CartaPoker{

    private int numero;
    private String palo;
    private boolean visible = true;

    public CartaEjemplo(int num, String palo) {
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
    
    
}
