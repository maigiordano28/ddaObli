/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Usuario;

import Dominio.Carta;
import Dominio.EstadoJugador;
import Dominio.EventoFachada;
import Dominio.Fachada;
import Dominio.Figura;
import Dominio.Usuario.Usuario;
import Dominio.tipoFigura;
import java.util.ArrayList;
import panelCartasPoker.CartaPoker;


/**
 *
 * @author bsout
 */
public class Jugador extends Usuario{
    
    private Double SaldoInicial;
    private EstadoJugador estadoActual;
    private ArrayList<Carta> cartasMano; 
    private Figura figuraActual;

    public Jugador(String nombreCompleto, String cedula, String password,Double saldoInicial) {
        super(nombreCompleto, cedula, password);
        this.SaldoInicial=saldoInicial;
        this.cartasMano = new ArrayList<Carta>();
        this.figuraActual=new Figura("Sin figura");
    }
     public Jugador(String nombreCompleto, String password) {
        super(nombreCompleto, password);
    }

  public ArrayList<Carta> getCartasMano() {
    
    return cartasMano;
    }
    public void setCartasMano(ArrayList<Carta> cartasMano) {
        this.cartasMano = cartasMano;
    }

    public Figura getFiguraActual() {
        return figuraActual;
    }

    public void setFiguraActual(Figura figuraActual) {
        this.figuraActual = figuraActual;
    }
 
   
     public double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(Double SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    public EstadoJugador getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoJugador estadoActual) {
        this.estadoActual = estadoActual;
    }
    

    
    public void ActualizarSaldo(boolean operacion, Double num){
        if(operacion){
            SaldoInicial=SaldoInicial+num;
        }else{
            SaldoInicial=SaldoInicial-num;
        }
           Fachada.getInstancia().avisar(EventoFachada.NUEVA_INFO);
        
}public void ActualizarFigura(){
    this.setFiguraActual(figuraActual);
    
}
    public void EliminarCartasDelMazo(CartaPoker carta){
    this.getCartasMano().remove(carta);
    Fachada.getInstancia().avisar(EventoFachada.NUEVAS_CARTAS);
    }
    
    
    public void AgregarCartasAlMazo(Carta carta){
        
        this.cartasMano.add(carta);
    
    
    
    }
    
    public void RegistrarApuesta(){
        
    }

   
    public void IngresarMesa(){
        
    }
    public void PedirCartas(){
             
    }
    public void RetirarseDelJuego(){
    }  
    
}
